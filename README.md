# Library Management System

## Project Description

This **Library Management System** is a console-based application developed in Java, utilizing Object-Oriented Programming (OOP) principles and file handling. It facilitates the management of library operations, including:

- **Book Management**: Adding, updating, and removing books.
- **Member Management**: Registering new members and managing existing ones.
- **Borrowing and Returning Books**: Tracking which member has borrowed which book and managing returns.

## Features

- **Book Management**:
  - Add new books to the library collection.
  - Update details of existing books.
  - Remove books from the collection.

- **Member Management**:
  - Register new library members.
  - View and update member information.

- **Borrowing and Returning**:
  - Record when a member borrows a book.
  - Track due dates and manage book returns.

## File Structure

The project comprises the following Java classes:

- `Book.java`: Represents the book entity with attributes like title, author, and ISBN.
- `Member.java`: Represents library members with relevant details.
- `Manager.java`: Handles the core functionalities of the library system.
- `FileHandler.java`: Manages reading from and writing to files for data persistence.
- `LibrarySystem.java`: Contains the `main` method to run the application.

## How to Run

1. **Prerequisites**:
   - Ensure Java Development Kit (JDK) is installed on your system.

2. **Clone the Repository**:
   ```bash
   git clone https://github.com/MahiiBamba/library-management-system.git
   cd library-management-system
   ```

3. **Compile the Application**:
   ```bash
   javac *.java
   ```

4. **Run the Application**:
   ```bash
   java LibrarySystem
   ```

## Usage

Upon running the application, follow the on-screen prompts to navigate through the various functionalities, such as managing books and members, and processing borrow and return transactions.
