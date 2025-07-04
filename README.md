# 🧠 Quizo – Backend

## 🖥️ [Frontend Repository (React)](https://github.com/ketan13089/quiz-frontend)


Quizo is a clean and scalable backend system for a quiz application built using **Spring Boot**. It provides RESTful APIs to manage quizzes, questions, results, and leaderboards. Designed to integrate easily with any frontend, including the official [React frontend](https://github.com/ketan13089/quiz-frontend).

---

## 🚀 Features

- 📚 **Quiz Management** – Create and manage multiple quizzes.
- ❓ **Dynamic Questions** – Add and fetch questions tied to specific quizzes.
- 🧠 **User Submissions** – Handle quiz attempts, scoring, and result saving.
- 🏆 **Leaderboard** – Track and rank users by quiz scores.
- 🔗 **REST APIs** – Modular endpoints ready for frontend integration.
- ⚙️ **Easy to Extend** – Flexible structure to add authentication, analytics, etc.

---

## 📦 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **H2 / PostgreSQL (Configurable)**
- **Lombok (Sometimes it doesn't work :[)**
- **Postman** (for testing)

---

## 🛠️ Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/ketan13089/Quizo.git
cd Quizo

```

## ⚙️ Application.properties
🔐 Create a `src/main/resources/application.properties` file based on `application-sample.properties` with your own DB credentials.

```bash
# application-sample.properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/quizo
spring.datasource.username=your_username
spring.datasource.password=your_password
```

