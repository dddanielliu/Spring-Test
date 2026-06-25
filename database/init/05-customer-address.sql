CREATE TABLE customer_address (
    customer_id BIGINT,
    address_id BIGINT,
    PRIMARY KEY (customer_id, address_id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (address_id) REFERENCES address(id)
);

INSERT INTO customer_address (customer_id, address_id)
SELECT customer_id, id AS address_id
FROM address;
