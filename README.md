# 🚀 MiniERP Backend System

A secure and scalable **Enterprise Resource Planning (ERP) backend** built with **Java and Spring Boot**, featuring JWT authentication, role-based authorization, MongoDB Atlas integration, RESTful APIs, Swagger documentation, Docker containerization, and cloud deployment.

---

## 📌 Overview

**MiniERP** is a backend application designed to provide secure REST APIs for managing business operations.

The project follows a clean **layered architecture** to separate API handling, business logic, data access, and data models. It also implements **JWT-based authentication** and **role-based access control** for securing protected endpoints.

### 🎯 Key Highlights

* 🔐 JWT-based authentication
* 🛡️ Role-based authorization with `ADMIN` and `USER` roles
* 🧱 Layered architecture
* 📦 DTO-based request and response handling
* ⚠️ Global exception handling
* 🗄️ MongoDB Atlas integration
* 🌐 RESTful API design
* 📄 Swagger / OpenAPI documentation
* 🐳 Docker containerization
* ☁️ Cloud deployment using Render

---

## 🏗️ Architecture

MiniERP follows a layered architecture pattern:

```text
                    Client
                      │
                      ▼
               ┌─────────────┐
               │ Controller  │
               └──────┬──────┘
                      │
                      ▼
               ┌─────────────┐
               │   Service   │
               └──────┬──────┘
                      │
                      ▼
               ┌─────────────┐
               │ Repository  │
               └──────┬──────┘
                      │
                      ▼
               ┌─────────────┐
               │  MongoDB    │
               └─────────────┘
```

### 🔹 Architecture Layers

| Layer          | Responsibility                                  |
| -------------- | ----------------------------------------------- |
| **Controller** | Handles HTTP requests and API responses         |
| **Service**    | Contains application and business logic         |
| **Repository** | Handles database operations                     |
| **Model**      | Defines application data structures             |
| **DTO**        | Transfers data between client and server        |
| **Config**     | Contains application and security configuration |
| **Exception**  | Handles application errors and exceptions       |
| **Util**       | Contains reusable utility components            |

---

## 🛠️ Tech Stack

| Category              | Technology        |
| --------------------- | ----------------- |
| **Language**          | Java              |
| **Backend Framework** | Spring Boot       |
| **Security**          | Spring Security   |
| **Authentication**    | JWT               |
| **Database**          | MongoDB Atlas     |
| **API Architecture**  | REST              |
| **API Documentation** | Swagger / OpenAPI |
| **Containerization**  | Docker            |
| **Cloud Deployment**  | Render            |
| **Build Tool**        | Maven             |

---

## 🔐 Authentication & Authorization

MiniERP uses **JWT (JSON Web Token)** authentication to secure APIs.

### Authentication Flow

```text
User
 │
 ├── Register
 │      │
 │      ▼
 │   Account Created
 │
 └── Login
        │
        ▼
   JWT Token Generated
        │
        ▼
   Client Stores Token
        │
        ▼
   Sends Token with Requests
        │
        ▼
   JWT Authentication Filter
        │
        ▼
   Protected API
```

### 🔑 Security Features

* JWT token generation
* JWT token validation
* Custom authentication filter
* Protected REST endpoints
* Role-based authorization
* `ADMIN` and `USER` roles
* Unauthorized request handling

---

## 🌐 Live Deployment

### 🔗 Live API

https://minierp-2ok2.onrender.com

### 📄 Swagger API Documentation

https://minierp-2ok2.onrender.com/swagger-ui/index.html

Swagger UI can be used to explore and test the available REST APIs directly from the browser.

---

## 🧪 API Testing

### Swagger UI

1. Open the [Swagger UI](https://minierp-2ok2.onrender.com/swagger-ui/index.html).
2. Click **Authorize 🔐**.
3. Enter the generated JWT token.
4. Execute protected API endpoints.

### Postman

#### Register

```http
POST /register
```

#### Login

```http
POST /login
```

#### Authenticated Request

Include the JWT token in the request header:

```http
Authorization: Bearer <your_jwt_token>
```

---

## 📁 Project Structure

```text
MiniERP/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── raj/
│       │           └── springweb/
│       │               ├── controller/
│       │               ├── service/
│       │               ├── repository/
│       │               ├── model/
│       │               ├── dto/
│       │               ├── config/
│       │               ├── exception/
│       │               └── util/
│       │
│       └── resources/
│           └── application.properties
│
├── Dockerfile
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started

Follow these steps to run MiniERP locally.

### 1. Clone the Repository

```bash
git clone https://github.com/Aswinthraj/MiniERP.git
cd MiniERP
```

### 2. Configure MongoDB

Create or use a MongoDB Atlas cluster and configure the database connection in:

```text
src/main/resources/application.properties
```

Add your MongoDB connection details according to your local configuration.

> ⚠️ Do not commit passwords, secret keys, JWT secrets, or other sensitive credentials to GitHub.

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

### 5. Open Swagger

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 🐳 Docker

MiniERP can also be run as a Docker container.

### Build Docker Image

```bash
docker build -t minierp .
```

### Run Docker Container

```bash
docker run -p 8080:8080 minierp
```

The application will then be available at:

```text
http://localhost:8080
```

---

## 📡 API Workflow

A typical user workflow looks like this:

```text
        ┌──────────────┐
        │    Register  │
        └──────┬───────┘
               │
               ▼
        ┌──────────────┐
        │     Login    │
        └──────┬───────┘
               │
               ▼
        ┌──────────────┐
        │  JWT Token   │
        └──────┬───────┘
               │
               ▼
      ┌──────────────────┐
      │ Protected APIs   │
      └────────┬─────────┘
               │
               ▼
      ┌──────────────────┐
      │ Service Layer    │
      └────────┬─────────┘
               │
               ▼
      ┌──────────────────┐
      │ MongoDB Atlas    │
      └──────────────────┘
```

---

## 🔒 Security

Security is implemented using **Spring Security and JWT**.

The application includes:

* 🔐 JWT authentication
* 🛡️ Role-based access control
* 🔑 Custom authentication filter
* 🚫 Protected API endpoints
* ⚠️ Exception handling for invalid requests
* 👤 `ADMIN` and `USER` authorization levels

---

## ☁️ Deployment

The application is containerized using **Docker** and deployed to **Render**.

### Deployment Flow

```text
GitHub Repository
       │
       ▼
    Docker
       │
       ▼
    Render
       │
       ▼
  Live REST API
```

---

## 🔮 Future Improvements

The project can be extended with:

* [ ] React-based frontend
* [ ] Refresh token implementation
* [ ] `@PreAuthorize` method-level authorization
* [ ] GitHub Actions CI/CD pipeline
* [ ] Application logging
* [ ] Monitoring and health checks
* [ ] Automated unit and integration testing
* [ ] API rate limiting
* [ ] Production-ready environment configuration

---

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository
2. Create a new branch

```bash
git checkout -b feature/your-feature
```

3. Make your changes
4. Commit your changes

```bash
git commit -m "Add your feature"
```

5. Push the branch

```bash
git push origin feature/your-feature
```

6. Open a Pull Request

---

## 👨‍💻 Author

**Raj**
B.Tech Information Technology Student
Backend Developer

---

## ⭐ Support

If you found this project useful or interesting, consider giving the repository a **⭐ Star** on GitHub!

---

## 📄 License

This project is available for educational and development purposes.
