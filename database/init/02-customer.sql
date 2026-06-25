CREATE TABLE customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    address_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id)
);

INSERT INTO customer (first_name, last_name, address_id)
VALUES ('John', 'Doe', 1);
