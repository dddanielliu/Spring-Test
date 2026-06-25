CREATE TABLE address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255)
);

INSERT INTO address (street, city, state)
VALUES ('123 Main St', 'Cityville', 'CA');
