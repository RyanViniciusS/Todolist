# 📝 Todolist API
Projeto de gerenciador de tarefas desenvolvido em **Java 24** com **Spring Boot 3.5.5**, usando **H2** como banco de dados em memória e **Docker** para containerização. Inclui coleções do **Postman** para testes rápidos.
---
## 🚀 Rodando o Projeto
### 1. Com Maven local
Compilar o projeto:
```bash
./mvnw clean install
```
Rodar a aplicação:
```bash
./mvnw spring-boot:run
```
### 2. Com Docker
Veja o [Dockerfile](Dockerfile) para instruções de build da imagem.
Build da imagem:
```bash
docker build -t todolist-app .
```
Rodar o container:
```bash
docker run -p 8080:8080 todolist-app
```
> A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).
### 3. Com Docker Compose
Crie um arquivo `docker-compose.yml` na raiz do projeto com o seguinte conteúdo:
```yaml
version: '3.8'
services:
  todolist:
    build: .
    container_name: todolist-app
    ports:
      - "8080:8080"
    restart: unless-stopped
```
Para subir o projeto com Docker Compose:
```bash
docker-compose up --build
```
---
## 📬 Testando a API
1. Abra o **Postman**.
2. [Importar coleção Postman](postman/TodoList.postman_collection.json)
3. Teste os endpoints da aplicação:
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
