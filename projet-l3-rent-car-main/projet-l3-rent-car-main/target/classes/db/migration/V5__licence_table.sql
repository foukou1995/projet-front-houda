-- noinspection SqlResolveForFile

-- Table License
CREATE TABLE license (
                         id SERIAL PRIMARY KEY,
                         customer_id INT,
                         number VARCHAR(255),
                         expiry_date DATE,
                         FOREIGN KEY (customer_id) REFERENCES customer(id)
);