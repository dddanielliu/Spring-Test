ALTER TABLE address
DROP FOREIGN KEY fk_customer;

ALTER TABLE address
DROP COLUMN customer_id;
