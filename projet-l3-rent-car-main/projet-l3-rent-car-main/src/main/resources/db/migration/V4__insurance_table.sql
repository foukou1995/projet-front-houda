-- noinspection SqlResolveForFile
-- Table Insurance
CREATE TABLE Insurance (
                           id SERIAL PRIMARY KEY,
                           vehicle_id INT,
                           provider VARCHAR(255),
                           policy_number VARCHAR(255),
                           FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);