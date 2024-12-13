CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(2),
    zipcode VARCHAR(5),
    country VARCHAR(255),
    customerId INT NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customer(id)
);

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT NOT NULL,
    productName VARCHAR(255) NOT NULL,
    saleAmount DECIMAL(10,2),
    saleDate DATE
);

