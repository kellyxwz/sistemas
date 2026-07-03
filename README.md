# Sistema de Vendas - API REST

API REST desenvolvida com **Java 21** e **Spring Boot** para gerenciamento de um sistema de vendas. O projeto foi desenvolvido com foco no aprendizado de arquitetura em camadas, persistência de dados utilizando Spring Data JPA e boas práticas no desenvolvimento de APIs REST.

---

## 📌 Tecnologias utilizadas

- Java 21
- Spring Boot 3.4
- Spring Web
- Spring Data JPA
- PostgreSQL
- H2 Database
- Maven
- Docker
- Docker Compose

---

## 🏗 Arquitetura

O projeto segue uma arquitetura em camadas:

```
Controller
     ↓
Service
     ↓
Repository
     ↓
Banco de Dados
```

---

## 📂 Estrutura do projeto

```
src
 ├── controller
 ├── service
 ├── repository
 ├── entities
 ├── config
 └── resources
```

---

## 📋 Funcionalidades

A API permite realizar operações de CRUD para:

- Usuários
- Produtos
- Categorias
- Pedidos
- Itens do Pedido
- Pagamentos

---

## 🗄 Modelo de Dados

O sistema possui as seguintes entidades:

- User
- Product
- Category
- Order
- OrderItem
- Payment

Relacionamentos implementados utilizando JPA/Hibernate.

---

## 🚀 Como executar o projeto

### Pré-requisitos

- Java 21
- Maven
- Docker (opcional)

### Clonar o projeto

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

Entre na pasta

```bash
cd sistemas-main
```

### Executando pelo Maven

Linux/macOS

```bash
./mvnw spring-boot:run
```

Windows

```bash
mvnw.cmd spring-boot:run
```

---

## 🐘 Banco de Dados

O projeto possui suporte para:

- H2 Database (desenvolvimento)
- PostgreSQL (produção)

Caso utilize PostgreSQL, configure as credenciais no arquivo:

```
application.properties
```

ou através do arquivo

```
.env
```

(se configurado no projeto).

---

## 🐳 Executando com Docker

```bash
docker compose up --build
```

---

## 📡 Endpoints

### Usuários

| Método | Endpoint |
|---------|----------|
| GET | /users |
| GET | /users/{id} |
| POST | /users |
| PUT | /users/{id} |
| DELETE | /users/{id} |

### Produtos

| Método | Endpoint |
|---------|----------|
| GET | /products |
| GET | /products/{id} |
| POST | /products |
| PUT | /products/{id} |
| DELETE | /products/{id} |

### Categorias

| Método | Endpoint |
|---------|----------|
| GET | /categories |
| GET | /categories/{id} |

### Pedidos

| Método | Endpoint |
|---------|----------|
| GET | /orders |
| GET | /orders/{id} |

---

## 🧪 Testes

O projeto utiliza:

- JUnit 5
- Spring Boot Test

Para executar os testes:

```bash
mvn test
```

---

## 🎯 Objetivos do projeto

Este projeto foi desenvolvido para praticar conceitos como:

- Desenvolvimento de APIs REST
- Spring Boot
- Spring Data JPA
- Hibernate
- Relacionamentos entre entidades
- Tratamento de exceções
- Arquitetura em camadas
- Persistência de dados
- Integração com PostgreSQL
- Docker

---

## 📚 Aprendizados

Durante o desenvolvimento foram aplicados conceitos importantes como:

- Injeção de Dependência
- Inversão de Controle (IoC)
- CRUD completo
- DTOs
- Services
- Repositories
- Controllers
- Relacionamentos OneToMany, ManyToOne e ManyToMany
- Chaves compostas
- Enum persistido no banco
- Tratamento global de exceções

---

## 👨‍💻 Autor

Desenvolvido por **Kelly Ramos de Oliveira**.
