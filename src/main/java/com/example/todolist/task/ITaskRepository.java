package com.example.todolist.task;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    // Aqui você pode adicionar métodos customizados, ex:
    List<TaskModel> findByIdUser(UUID idUser);
}
