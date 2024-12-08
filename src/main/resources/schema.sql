CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR,
    city VARCHAR,
    state VARCHAR(2),
    zipcode VARCHAR(5),
    country VARCHAR,
    customerId INT FOREIGN KEY REFERENCES customer(id)
);

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT NOT NULL FOREIGN KEY,
    productName VARCHAR(MAX) NOT NULL,
    saleAmount DECIMAL(10,2),
    saleDate DATE
);

