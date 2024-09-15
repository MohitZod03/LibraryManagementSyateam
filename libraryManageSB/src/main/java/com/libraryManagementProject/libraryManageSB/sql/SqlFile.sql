-- Create database
CREATE DATABASE IF NOT EXISTS LibraryDB;
USE LibraryDB;

-- Create table for books
CREATE TABLE IF NOT EXISTS Book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    published_date DATE,
    available_copies INT NOT NULL
);

-- Create table for members
CREATE TABLE IF NOT EXISTS Member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15),
    address TEXT
);

-- Create table for transactions
CREATE TABLE IF NOT EXISTS Transaction (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    member_id INT NOT NULL,
    transaction_type ENUM('borrow', 'return') NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
);

-- Insert sample data into Book table
INSERT INTO Book (title, author, isbn, published_date, available_copies)
VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', '1925-04-10', 5),
('To Kill a Mockingbird', 'Harper Lee', '9780060935467', '1960-07-11', 3),
('1984', 'George Orwell', '9780451524935', '1949-06-08', 4);

-- Insert sample data into Member table
INSERT INTO Member (first_name, last_name, email, phone_number, address)
VALUES
('John', 'Doe', 'john.doe@example.com', '555-1234', '123 Elm St, Springfield'),
('Jane', 'Smith', 'jane.smith@example.com', '555-5678', '456 Oak St, Springfield');

-- Insert sample data into Transaction table
INSERT INTO Transaction (book_id, member_id, transaction_type, due_date)
VALUES
(1, 1, 'borrow', '2024-09-01'),
(2, 2, 'borrow', '2024-09-15');
