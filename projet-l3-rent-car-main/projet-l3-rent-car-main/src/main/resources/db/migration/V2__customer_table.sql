-- noinspection SqlResolveForFile

-- Table Customer
CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          email VARCHAR(255),
                          phone VARCHAR(20)
);