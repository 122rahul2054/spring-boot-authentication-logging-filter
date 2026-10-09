# Spring Boot Authentication and Logging Filter

A Spring Boot project demonstrating custom Servlet Filters for token-based authentication and HTTP request-response logging. It validates incoming requests, blocks unauthorized access, logs request details and response status, and measures request processing time.

## 🚀 Features

- Custom Servlet Filter implementation
- Token-based authentication
- Blocks unauthorized requests with HTTP 401
- Logs HTTP request methods and URLs
- Tracks response status and processing time
- REST API for creating student details
- Controller, Service, and DTO architecture
- No database required

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Web MVC
- Jakarta Servlet API
- Maven
- Postman

## 📂 Project Structure

```text
FilterDemo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/jsp/FilterDemo/
│       │       ├── FilterDemoApplication.java
│       │       ├── controller/
│       │       │   └── StudentController.java
│       │       ├── dto/
│       │       │   └── Student.java
│       │       ├── service/
│       │       │   └── StudentService.java
│       │       └── filter/
│       │           └── AuthenticationFilter.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

## ⚙️ Prerequisites

- Java version compatible with the project's `pom.xml`
- Maven
- IntelliJ IDEA or another Java IDE
- Postman for API testing

## 📥 Setup and Installation

### 1. Clone the Repository

```bash
git clone https://github.com/122rahul2054/spring-boot-authentication-logging-filter.git
```

### 2. Use a Clean Project Directory

To avoid the `Parent directory contains leading or trailing whitespace` error, place the project in a directory without leading or trailing spaces.

Recommended Windows path:

```text
C:\JavaProjects\FilterDemo
```

Ensure that the folder names do not contain unnecessary spaces at their beginnings or ends.

### 3. Open the Project

1. Open IntelliJ IDEA.
2. Select **File → Open**.
3. Choose the `FilterDemo` folder containing `pom.xml`.
4. Allow IntelliJ IDEA to import and load Maven dependencies.

### 4. Run the Application

Run `FilterDemoApplication.java`.

The application will start at:

```text
http://localhost:8080
```

## 🔗 API Endpoint

**Create Student**

| Property | Value |
|---|---|
| HTTP Method | POST |
| Endpoint | `/api/students` |
| Content-Type | `application/json` |
| Required Header | `token: 12345` |

### Request Body

```json
{
  "id": 1,
  "name": "Rahul",
  "email": "rahul@gmail.com"
}
```

### Successful Response

```text
Student created successfully
```

### Unauthorized Request

If the token is missing or invalid, the filter returns HTTP `401 Unauthorized` and prevents the controller from processing the request.

## 🧪 Testing with Postman

1. Select the `POST` method.
2. Enter `http://localhost:8080/api/students`.
3. Under **Headers**, add `token` with the value `12345`.
4. Under **Body → raw → JSON**, enter the student details.
5. Click **Send**.

## 🧠 Key Concepts Learned

- Servlet Filter and the `Filter` interface
- `doFilter()` and `FilterChain`
- HTTP headers and status codes
- Basic token validation
- Request and response logging
-
