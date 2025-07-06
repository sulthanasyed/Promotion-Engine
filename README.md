# 🛒 Promotion Engine - Spring Boot

This project implements a **Promotion Engine** for a checkout system, built using **Java**, **Spring Boot**, and **TDD** principles. It calculates the total price of a cart after applying various pricing promotions.

---

## 🚀 Features

- Calculate total cart value with active promotions
- Modular promotion types:
    - Bulk promotions (e.g., 3 of A's for 130)
    - Combo promotions (e.g., C & D for 30)
- Clean OOP-based architecture
- Easily extensible for future promotions
- RESTful API support
- Unit tests using **JUnit** and **Mockito**

---

## 🧰 Tech Stack
* Java 17
* Spring Boot
* Maven
* JUnit 5
* Mockito

---

## 📁 Project Structure
```text
src/
   ├── main/
   │   ├── java/
   │   │   └── com.sulthana.promotionengine/
   │   │       ├── controller/
   │   │       ├── service/
   │   │       └── model/
   │   │           └──promotion
   │   └── resources/
   │       └── application.properties
   ├── test/
   │   └── java/
   │       └── com.sulthana.promotionengine/
   └── pom.xml
```

---

## ⚙️ How to Run

**1. Clone the project**
```
git clone https://github.com/your-username/promotion-engine.git
cd promotion-engine
```

**2. Run the app**
```
./mvnw spring-boot:run
```

**3. Send a request**

Use **Postman** or **cURL** to send a POST request:
```
POST http://localhost:8080/api/checkout
```
With the JSON body as shown below.

---

## 🧪 Sample Data

### Product Details

| SKU | Unit Price |
|-----|------------|
| A   | 50         |
| B   | 30         |
| C   | 20         |
| D   | 15         |

### Active Promotions

- 3 of A's for 130
- 2 of B's for 45
- C & D for 30 (combo)

---

## 📦 Sample Input

```json
[
  { "product": "A", "quantity": 3 },
  { "product": "B", "quantity": 5 },
  { "product": "C", "quantity": 1 },
  { "product": "D", "quantity": 1 }
]
```

---

## 📦 Sample Output

```json
280
```

---

## ✅ Tests

To run tests;
```text
./mvnw test
```

---

## 👩‍💻 Author

```text
Nageena Sulthana
Backend Developer | Java | Spring Boot
```
