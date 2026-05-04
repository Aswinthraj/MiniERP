


---

```markdown
# 🚀 MiniERP Backend System

A secure and scalable backend application built using **Spring Boot**, designed with real-world architecture, authentication, and deployment practices.

---

## 📌 Overview

MiniERP is a backend system that provides secure REST APIs for managing business operations.  
It implements **JWT-based authentication**, **role-based access control**, and follows a clean **layered MVC architecture**.

---

## 🔐 Features

- 🔑 JWT-based Authentication (Login & Registration)
- 🛡️ Role-Based Authorization (ADMIN & USER)
- 🧱 Layered MVC Architecture (Controller, Service, Repository)
- 📦 DTO-based Request/Response Handling
- ⚠️ Global Exception Handling
- 🗄️ MongoDB Atlas Cloud Database Integration
- 🌐 RESTful API Design
- 📄 Swagger UI for API Documentation
- 🐳 Dockerized Application
- ☁️ Deployed on Render (Cloud)

---

## 🧱 Architecture

This project follows a **layered architecture pattern**:

```

Controller → Service → Repository → Database

```

### 🔹 Layers Explained

- **Controller Layer**
  - Handles HTTP requests and responses  

- **Service Layer**
  - Contains business logic  

- **Repository Layer**
  - Interacts with MongoDB database  

- **Model Layer**
  - Defines entity structure  

- **DTO Layer**
  - Transfers data between client and server  

---

## ⚙️ Tech Stack

| Category        | Technology |
|----------------|----------|
| Backend        | Java, Spring Boot |
| Security       | Spring Security, JWT |
| Database       | MongoDB Atlas |
| API Docs       | Swagger (OpenAPI) |
| Deployment     | Render |
| Container      | Docker |

---

## 🌐 Live Links

- 🔗 **Live API:**  
  https://minierp-2ok2.onrender.com  

- 📄 **Swagger UI:**  
  https://minierp-2ok2.onrender.com/swagger-ui/index.html  

---

## 🧪 API Testing

### 🔹 Using Swagger UI
1. Open Swagger link  
2. Click **Authorize 🔐**  
3. Enter JWT token  
4. Test APIs directly  

### 🔹 Using Postman

#### Register
```

POST /register

```

#### Login
```

POST /login

```

#### Use Token
```

Authorization: Bearer <your_token>

```

---

## 🔑 Authentication Flow

1. User registers via `/register`  
2. User logs in via `/login`  
3. Server generates JWT token  
4. Token is sent in request headers  
5. Protected APIs validate token  

---

## 📁 Project Structure

```

com.raj.springweb
│
├── controller
├── service
├── repository
├── model
├── dto
├── config
├── exception
└── util

````

---

## 🚀 Getting Started (Local Setup)

### 1️⃣ Clone Repository

```bash
git clone https://github.com/Aswinthraj/MiniERP.git
cd MiniERP
````

### 2️⃣ Configure Database

Update your MongoDB URI in:

```
src/main/resources/application.properties
```

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

### 4️⃣ Access Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🐳 Docker Setup

### Build Image

```bash
docker build -t minierp .
```

### Run Container

```bash
docker run -p 8080:8080 minierp
```

---

## 🔒 Security

* JWT Token Validation
* Custom Authentication Filter
* Role-Based Access Control
* Secured API Endpoints

---

## 💡 Future Improvements

* Frontend Integration (React / HTML)
* Refresh Token Implementation
* Role-based annotations (`@PreAuthorize`)
* CI/CD Pipeline (GitHub Actions)
* Logging & Monitoring

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a new branch
3. Make your changes
4. Submit a pull request

---

## 📌 Author

**Raj**
B.Tech IT Student
Backend Developer

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!


