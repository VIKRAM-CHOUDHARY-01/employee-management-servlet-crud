# Employee CRUD Project (Servlet + JDBC + Layered Architecture)

This project is a **CRUD (Create, Read, Update, Delete) Web Application** built using:

* **Java Servlets (Jakarta/Javax Servlet API)**
* **JSP + JSTL** (View layer)
* **JDBC (MySQL Driver)**
* **Layered Architecture (Controller → Service → DAO → Model)**
* **HTML + CSS** for UI

The purpose of this application is to demonstrate best practices in Java EE/Servlet-based web apps using a clean layered architecture.

---

## 📁 Project Structure

```
src/main/java/com/project/employee/
│
├── controller/      → Contains Servlets (web layer)
├── service/         → Business Logic Layer
├── dao/             → DB Interaction using JDBC
└── model/           → POJO (Employee.java)

src/main/webapp/
│
├── allemployees.jsp → List of employees
├── editemployee.jsp → Edit form
├── registrationform.html → Add employee
└── WEB-INF/web.xml  → Deployment Descriptor
```

---

## 🚀 Features

✅ Add new employee
✅ View list of employees
✅ Edit employee data
✅ Delete employee
✅ Form validation (basic)
✅ No scriptlets, uses JSP + JSTL
✅ Layered architecture (follows MVC pattern)

---

## 🧰 Technologies Used

| Component  | Technology                         |
| ---------- | ---------------------------------- |
| Backend    | Java Servlet / JSP / JDBC          |
| Database   | MySQL                              |
| Build Tool | Manual (can be converted to Maven) |
| Server     | Apache Tomcat 9/10                 |
| UI         | HTML, CSS                          |

---

## 🗄 Database Setup

Run the following script in MySQL:

```sql
CREATE DATABASE employeesdatabase;

USE employeesdatabase;

CREATE TABLE employeesdata (
  id INT PRIMARY KEY AUTO_INCREMENT,
  fullname VARCHAR(100),
  email VARCHAR(100),
  address VARCHAR(255),
  department VARCHAR(50),
  salary VARCHAR(50)
);
```

---

## ⚙ Configuration

Open `DBConnection.java` (or properties loader if added) and update:

```java
String url = "jdbc:mysql://localhost:3306/employeesdatabase";
String username = "root";
String password = "root";
```



---

## ▶️ Running the Project

1. Clone the repo:

   ```sh
   git clone https://github.com/your-username/employee-crud-servlet.git
   ```

2. Import into **Eclipse / IntelliJ** as a *Dynamic Web Project*.

3. Add required JARs to `WEB-INF/lib`:

   * mysql-connector-java
   * jstl.jar

4. Configure Apache Tomcat (9 or 10).

5. Start Tomcat and open:

   ```
   http://localhost:8080/01ServletEmployeeCrudProject/Home.html
   ```

---

## 🔄 Endpoints

| URL                    | Description              |
| ---------------------- | ------------------------ |
| `/EmployeeServlet`     | Registers a new employee |
| `/allemployeesservlet` | Shows list of employees  |
| `/editemployeeservlet` | Load edit form           |
| `/saveeditedchanges`   | Save edited employee     |
| `/deleteemployee`      | Delete employee          |

---

## 📦 Future Improvements 

* Convert to **Maven Project** (`pom.xml`)
* Add **Pagination + Search**
* Add validation using **Jakarta Bean Validation (Hibernate Validator)**

---

## ✨ Credits

Developed by **Vikram Kumar Choudhary**

---

If you like this project, ⭐ star the repo and contribute!
