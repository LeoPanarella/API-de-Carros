# 🚗 API de Carros

Bem-vindo à **API de Carros**, uma aplicação desenvolvida com **Spring Boot 3**, com foco em CRUD completo, boas práticas e documentação via **OpenAPI/Swagger**.

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)]()
[![Java](https://img.shields.io/badge/Java-17-blue.svg)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)]()
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

---

## 🧩 Visão Geral

Esta aplicação oferece uma interface RESTful para gerenciamento de carros, com operações completas de **CRUD**, utilizando **Spring Boot 3**, **Spring Data JPA** e banco de dados relacional.

A documentação da API é fornecida automaticamente com Swagger UI via `springdoc-openapi`.

---

## 🚀 Tecnologias

* Java 17
* Spring Boot 3.4.4
* Spring Web
* Spring Data JPA
* Spring Security (estrutura preparada)
* MySQL / SQL Server
* Lombok
* Swagger (springdoc-openapi)
* Maven

---

## ⚙️ Instalação

### Pré-requisitos

* Java 17
* Maven
* Banco de dados (MySQL ou SQL Server)

### Rodando localmente

```bash
git clone https://github.com/LeoPanarella/carros-api.git
cd carros-api
./mvnw spring-boot:run
```

Certifique-se de configurar corretamente o `application.properties` com as credenciais do banco de dados.

---

## 🔐 Autenticação

Atualmente, a API não possui autenticação implementada, mas a estrutura está pronta para adicionar JWT ou outro esquema de segurança.

---

## 📖 Endpoints

A documentação completa da API está disponível em:

📄 [Swagger UI](http://localhost:8080/swagger-ui.html)

---

### 🚘 `/api/carros`

CRUD completo de carros.

#### `GET /api/carros`

Lista todos os carros cadastrados.

#### `GET /api/carros/{id}`

Busca um carro específico pelo ID.

#### `POST /api/carros`

Cria um novo carro.

#### `PUT /api/carros/{id}`

Atualiza os dados de um carro existente.

#### `DELETE /api/carros/{id}`

Remove um carro do sistema.

Exemplos de requisição e resposta estão disponíveis na documentação Swagger.

---

## ❗ Dificuldades Enfrentadas

Durante o desenvolvimento, enfrentei diversos desafios importantes que contribuíram bastante para o aprendizado:

1. **Problemas com o Swagger (Springfox)**

   * Tentei usar a biblioteca `springfox-swagger2`, mas ela gerava erros de `NoSuchMethodError`, pois não era compatível com o Spring Boot 3. O erro mais comum era relacionado ao método `Assert.notNull(...)`.
   * Resolvi o problema substituindo por `springdoc-openapi`, que funcionou perfeitamente com Spring Boot 3.

2. **Conflitos com Versão do Java**

   * Algumas bibliotecas não funcionavam bem com o Java 17. Foi necessário ajustar dependências para garantir compatibilidade com a versão mais recente.

3. **application.properties**

   * Tive dificuldades na configuração inicial do `application.properties`. Pequenos erros, como um caractere errado na URL do banco ou nome incorreto do driver, causavam falhas no boot da aplicação.

4. **Estrutura do Projeto**

   * No início, enfrentei dificuldades com a separação adequada das camadas (Controller, Service, Repository, Model). A documentação oficial do Spring ajudou a entender melhor essa divisão.

5. **Swagger gerando documentação automaticamente**

   * Após resolver o problema com a dependência errada, o uso do `springdoc-openapi` facilitou muito, pois ele gerava toda a documentação da API com base nas anotações padrão.

---

## 🧪 Testes

Para rodar os testes automatizados:

```bash
./mvnw test
```

---

## 📦 Estrutura de Projeto

```
src
├── main
│   ├── java
│   │   └── com.carros
│   │       ├── api             # Controllers
│   │       ├── model           # Entidades JPA
│   │       ├── repository      # Repositórios JPA
│   │       ├── service         # Regras de negócio
│   │       └── config          # Configurações do OpenAPI
│   └── resources
│       └── application.properties
└── test
```

---

## 🎨 Logo do Projeto

Você pode adicionar um logo SVG personalizado no topo do README, por exemplo:

```html
<img src="https://raw.githubusercontent.com/LeoPanarella/carros-api/main/logo.svg" width="300"/>
```

Se quiser, posso gerar um logo estilizado com tema de carros para você.

---

## 👤 Autor

Desenvolvido por **Leonardo Panarella**

[![GitHub](https://img.shields.io/badge/GitHub-@LeoPanarella-181717?style=flat-square\&logo=github)](https://github.com/LeoPanarella)

---

## 📄 Licença

Este projeto está licenciado sob a [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).
