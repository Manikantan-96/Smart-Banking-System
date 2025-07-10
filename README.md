---

#💳 Smart Bank Management System (Java Console Application)

A feature-rich *console-based banking application* built using *Core Java*, designed to simulate basic banking operations such as account creation, login, deposits, withdrawals, transaction history, password recovery, and file-based data persistence.

---

##🛠 Features

- 🔐 *User Authentication* (Account number + password)
- 📝 *Create Account* (Savings or Fixed Deposit)
- 💰 *Deposit & Withdraw* (Savings only)
- 📜 *Transaction History*
- 🔄 *Password Reset* (Mobile number + Name verification)
- ☎ *Customer Support Menu* (Update mobile or name)
- 💾 *Persistent Storage* using Java Serialization
- ⚙ *Multithreading* for asynchronous file operations
- ✅ *Input Validation* for mobile numbers, passwords, and other fields

---

##🚀 Getting Started

###Prerequisites

- Java JDK 8 or above
- Any Java IDE (Eclipse, IntelliJ, VS Code) or command-line tools

### How to Run

1. *Clone or download* the repository.
2. Compile all .java files:
   ```bash
   javac *.java

3. Run the main class:

java Mani




---

🧾 Project Structure

.
├── Mani.java                    # Main entry point
├── Bank.java                   # Main logic and menu handling
├── Account.java                # Abstract class for common account features
├── SavingsAccount.java         # Savings account functionality
├── FD_Account.java             # Fixed Deposit account
├── AccountOperations.java      # Interface defining core operations
├── Input.java                  # Handles user input and file I/O
├── AccountType.java            # Enum for account types
├── InvalidPasswordException.java
├── InvalidAccountException.java
├── InsufficientBalanceException.java
├── storage.txt                 # File used to store serialized account data


---

🧠 Concepts Used

🔁 Loops and Control Statements

👨‍👩‍👧‍👦 OOP Concepts: Inheritance, Abstraction, Polymorphism, Encapsulation

🔒 Exception Handling

🧵 Multithreading with Runnable

🧠 Java Collections (HashMap)

📄 Serialization (ObjectInputStream, ObjectOutputStream)

🧹 Input Validation (Regex for password & mobile number)

🧪 Unit test-ready structure (future scope using JUnit)



---

🎯 Future Improvements

✅ JUnit test integration

🌐 Convert to Web App using Spring Boot + Thymeleaf or JSP

🗃 Use Database (MySQL/PostgreSQL) instead of file storage

🔐 OTP-based password recovery

📱 Add GUI using JavaFX or Swing


---

🙌 Author

Deevanooru Manikantan– Java Developer

💼 GitHub: Manikantan-96

📧 Email: manikantan1501@gmail.com



---

📄 License

This project is for educational purposes. Feel free to use and modify for learning or interviews. Commercial use is not permitted without permission.

---



