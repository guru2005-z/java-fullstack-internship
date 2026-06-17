# 🚀 Java Full Stack Web Development — Internship Task 1

A complete Full Stack web application built with **Spring Boot** (backend) and **HTML/CSS/JavaScript** (frontend) as part of a Java Full Stack Web Development Internship.

---

## 📋 Project Overview

This project demonstrates a modern contact form landing page where:
- The **frontend** collects Name, Email, and Message from the user
- The **backend** receives the data via a REST API and prints it to the console
- Communication happens via **JSON** using the browser's Fetch API

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Frontend | HTML5, CSS3, Vanilla JavaScript |
| Backend | Java 17, Spring Boot 3.2.5 |
| Server | Apache Tomcat (embedded) |
| Build Tool | Maven |
| IDE | IntelliJ IDEA |
| API Type | RESTful JSON API |
| Database | None (console output only) |

---

## 📁 Project Structure

```
demo/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/example/demo/
        │       ├── DemoApplication.java          ← Entry point
        │       ├── controller/
        │       │   └── ContactController.java    ← REST API
        │       └── model/
        │           └── ContactRequest.java       ← Data model
        └── resources/
            ├── application.properties            ← Config
            └── static/
                ├── index.html                    ← Frontend
                └── style.css                     ← Styles
```

---

## ✨ Features

- 🎨 Modern dark-themed responsive landing page
- 📱 Mobile-friendly layout (works on all screen sizes)
- 🦸 Hero section with animated gradient background
- 📖 About section with feature cards and architecture diagram
- 📬 Contact form with client-side validation
- ⚙️ Spring Boot REST API endpoint (`POST /api/contact`)
- 🩺 Health check endpoint (`GET /api/health`)
- 🖨️ Console output with formatted submission display

---

## 🚀 Getting Started

### Prerequisites

- Java 17 ([Download Temurin 17](https://adoptium.net))
- IntelliJ IDEA Community Edition
- Maven (bundled with IntelliJ)

### Setup & Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/java-fullstack-internship.git
   cd java-fullstack-internship
   ```

2. **Open in IntelliJ IDEA**
   - File → Open → select the `demo` folder

3. **Reload Maven**
   - Right-click `pom.xml` → Maven → Sync Project

4. **Run the application**
   - Open `DemoApplication.java`
   - Click the green ▶ Run button (or press `Shift + F10`)

5. **Open in browser**
   ```
   http://localhost:9090
   ```

---

## 📡 API Endpoints

### POST `/api/contact`
Accepts the contact form submission.

**Request Body:**
```json
{
  "name": "Arjun Sharma",
  "email": "arjun@example.com",
  "message": "Hello from my internship project!"
}
```

**Success Response (200 OK):**
```json
{
  "status": "success",
  "message": "Thank you, Arjun Sharma! Your message has been received."
}
```

**Error Response (400 Bad Request):**
```json
{
  "status": "error",
  "message": "All fields are required."
}
```

---

### GET `/api/health`
Health check endpoint.

**Response:**
```json
{
  "status": "UP",
  "service": "Contact Form API"
}
```

---

## 🖨️ Console Output

When a form is submitted, the following appears in the IntelliJ Run console:

```
╔══════════════════════════════════════╗
║      📬 New Contact Form Submission    ║
╠══════════════════════════════════════╣
║  Name    : Arjun Sharma
║  Email   : arjun@example.com
║  Message : Hello from my internship project!
╚══════════════════════════════════════╝
```

---

## 🔑 Key Spring Boot Annotations Used

| Annotation | Purpose |
|-----------|---------|
| `@SpringBootApplication` | Enables auto-configuration and component scanning |
| `@RestController` | Marks class as a REST API controller |
| `@RequestMapping` | Sets base URL prefix `/api` |
| `@PostMapping` | Maps POST requests to `/api/contact` |
| `@GetMapping` | Maps GET requests to `/api/health` |
| `@RequestBody` | Deserializes JSON body into Java object |
| `@CrossOrigin` | Enables CORS for all origins |

---

## 🌐 How It Works

```
User fills form
      ↓
JavaScript Fetch API (POST JSON)
      ↓
Spring Boot ContactController
      ↓
Validates input → Prints to console
      ↓
Returns JSON response
      ↓
Browser shows success message
```

---

## 📸 Screenshots

> Landing page running at `http://localhost:9090`

- Hero section with CTA buttons
- About section with tech stack cards
- Contact form with validation
- Console output after form submission

---

## 🐛 Common Issues & Fixes

| Issue | Fix |
|-------|-----|
| Port already in use | Change `server.port` in `application.properties` |
| Maven not syncing | Right-click `pom.xml` → Maven → Sync Project |
| Java version error | File → Project Structure → SDK → select Java 17 |
| White label error | Check `index.html` is in `src/main/resources/static/` |

---

## 👨‍💻 Author

**GURAVAIAH**
B.Tech CSE — Java Full Stack Web Development Internship
Task 1 — Spring Boot Contact Form

---

## 📄 License

This project is built for educational purposes as part of an internship program.
