-- noinspection SqlResolveForFile

-- Table Invoice
CREATE TABLE invoice (
                         id SERIAL PRIMARY KEY,
                         rental_record_id INT,
                         amount FLOAT,
                         issued_date DATE,
                         FOREIGN KEY (rental_record_id) REFERENCES rental_record(id)
);