# 🏋️‍♀️ Fitness & Workout Tracker API

**Strong** is a full-featured RESTful workout tracking application designed for strength training and weightlifting enthusiasts. It enables users to:

- Log workouts and exercises 📝
- Track personal progress and 1RM 📈
- Plan custom routines 🗓
- View structured analytics reports 📊
- Securely access data with JWT authentication 🔐
- Explore API documentation with Swagger 🚀

---

## 📌 Features

- 🔐 **Authentication**
    - JWT-based secure login/register
- 🏋️ **Workout Logging**
    - Record exercises, sets, reps, weight, rest
- 📚 **Exercise Library**
    - Create and browse categorized exercises
- 🧩 **Routine Management**
    - Structured weekly training templates and plans
- 📈 **Progress Tracking**
    - Personal bests, 1RM, training summaries
- 📊 **Analytics**
    - Weekly/monthly volume, category-wise breakdown
- 🔍 **Swagger UI**
    - Live, interactive API documentation

---

## 🛠 Tech Stack

| Layer       | Technology              |
|-------------|--------------------------|
| Backend     | Spring Boot 3 (Java 17)  |
| API Docs    | Springdoc OpenAPI (Swagger UI) |
| Database    | H2 (in-memory, dev)      |
| Security    | Spring Security + JWT    |
| Build Tool  | Maven                    |

---

## 🚀 How to Run the App

### ✅ Prerequisites

- Java 17+
- Maven 3.x
- IDE: IntelliJ / VS Code / Eclipse (optional)
- `jq` CLI tool (for bash testing scripts)

---

### 🧱 Build and Run (Local Dev)

```bash
# Clone the repository
git clone https://github.com/your-org/strong-app.git
cd strong-app

# Build the project
./mvnw clean install

# Run the app
./mvnw spring-boot:run
