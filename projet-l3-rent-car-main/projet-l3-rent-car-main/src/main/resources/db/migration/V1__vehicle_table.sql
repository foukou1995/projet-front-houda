-- noinspection SqlResolveForFile

CREATE TABLE vehicle (
                         id SERIAL PRIMARY KEY,
                         brand VARCHAR(255),
                         model VARCHAR(255),
                         year INT,
                         rental_cost_per_day FLOAT,
                         available BOOLEAN,
                         location VARCHAR(255)
);