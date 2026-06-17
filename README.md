# Serviço de Usuário
 
![Java](https://img.shields.io/badge/Java-17-blue?style=flat&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen?style=flat&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-latest-336791?style=flat&logo=postgresql)
![Gradle](https://img.shields.io/badge/Gradle-8.14-02303A?style=flat&logo=gradle)
![Docker](https://img.shields.io/badge/Docker-ready-2496ED?style=flat&logo=docker)
 
Microsserviço responsável pelo gerenciamento de usuários do sistema **Agendador de Tarefas**. Permite o cadastro, autenticação e gerenciamento de dados dos usuários, incluindo endereço e telefone.
 
---

 
## Funcionalidades
 
- Cadastro e autenticação de usuários com JWT
- Gerenciamento de endereço vinculado ao usuário
- Gerenciamento de telefone vinculado ao usuário
- Atualização de dados do usuário autenticado
---
 
## Estrutura do Projeto
 
```
src/
└── main/
    └── java/
        └── com.morcineck.usuario/
            ├── business/        # Regras de negócio e serviços
            ├── controller/      # Endpoints REST
            ├── infrastructure/  # Configurações, segurança e repositórios
            └── UsuarioApplication.java
```
 
---
 
## Endpoints
 
| Método | Endpoint | Descrição | Autenticação |
|--------|----------|-----------|--------------|
| POST | `/usuario` | Cadastra um novo usuário | Não |
| POST | `/usuario/login` | Autentica e retorna token JWT | Não |
| GET | `/usuario?email=` | Busca usuário por e-mail | Não |
| DELETE | `/usuario/{email}` | Remove usuário por e-mail | Não |
| PUT | `/usuario` | Atualiza dados do usuário | Token JWT |
| POST | `/usuario/endereco` | Cadastra endereço do usuário | Token JWT |
| PUT | `/usuario/endereco?id=` | Atualiza endereço por ID | Não |
| POST | `/usuario/telefone` | Cadastra telefone do usuário | Token JWT |
| PUT | `/usuario/telefone` | Atualiza telefone por ID | Header `id` |
 
---
 
## Variáveis de Ambiente
 
| Variável | Descrição |
|----------|-----------|
| `SPRING_DATASOURCE_URL` | URL de conexão com o PostgreSQL |
| `SPRING_DATASOURCE_USERNAME` | Usuário do banco de dados |
| `SPRING_DATASOURCE_PASSWORD` | Senha do banco de dados |
 
---
 
## Como Executar
 
### Com Docker Compose (recomendado)
 
Este serviço faz parte de um conjunto de microsserviços. Para subir todos os serviços juntos, utilize o `docker-compose.yml` disponível no repositório [bff-agendador-tarefas](https://github.com/Morcineck/bff-agendador-tarefas):
 
```bash
docker-compose up --build
```
 
### Individualmente
 
1. Configure as variáveis de ambiente ou um arquivo `application.properties` com as credenciais do banco
2. Execute:
```bash
./gradlew build -x test
java -jar build/libs/usuario.jar
```
 
---
 
## Banco de Dados
 
Utiliza **PostgreSQL**. As tabelas são criadas automaticamente pelo Hibernate na inicialização:
 
- `usuario` — dados do usuário (nome, email, senha)
- `endereco` — endereço vinculado ao usuário
- `telefone` — telefone vinculado ao usuário
---
 
## Relacionamento com outros serviços
 
```
bff-agendador-tarefas  →  usuario (autenticação e dados do usuário)
```
