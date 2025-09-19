# 📝 Todolist API

Projeto de gerenciador de tarefas desenvolvido em **Java 24** com **Spring Boot 3.5.5**, usando **H2** como banco de dados em memória e Docker para containerização. Inclui coleções do **Postman** para testes rápidos.

---

## 🚀 Rodando o Projeto

### 1. Com Maven local

# Compilar o projeto
./mvnw clean install

# Rodar a aplicação
./mvnw spring-boot:run



## 📬 Testando a API

1. Abra o **Postman**.  
2. Importe a coleção:

postman/Todolist.postman_collection.json

3. Teste endpoints:

- `POST /user/create` → criar usuário
- `POST /task/create` → criar tarefa
- `GET /task/list` → listar tarefas
- `PUT /task/update` → atualizar tarefa


---

## 🔧 Observações

- Projeto usa **Lombok** para getters/setters.  
- Banco **H2** é em memória, todos os dados são perdidos ao reiniciar.  
- **Docker** garante que a aplicação rode isolada em qualquer máquina.  
- Se você quiser persistência real, troque para **PostgreSQL** ou **MySQL** e configure `application.properties`.
