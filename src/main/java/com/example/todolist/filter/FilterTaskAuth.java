package com.example.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.todolist.user.IUserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        // Aplica autenticação para todas as rotas /tasks/*
        if (servletPath.startsWith("/tasks")) {

            String authorization = request.getHeader("Authorization");

            if (authorization == null || !authorization.startsWith("Basic ")) {
                response.sendError(401, "Authorization header missing or invalid");
                return;
            }

            String base64Credentials = authorization.substring("Basic".length()).trim();
            byte[] decoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decoded);
            String[] parts = credentials.split(":", 2);

            if (parts.length != 2) {
                response.sendError(401, "Invalid authentication format");
                return;
            }

            String username = parts[0];
            String password = parts[1];

            var user = this.userRepository.findByUsername(username);

            if (user == null) {
                response.sendError(401, "User not found");
                return;
            }

            var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            if (!passwordVerify.verified) {
                response.sendError(401, "Invalid password");
                return;
            }

            // Setando idUser no request para o controller
            request.setAttribute("idUser", user.getId());
        }

        filterChain.doFilter(request, response);
    }
}
