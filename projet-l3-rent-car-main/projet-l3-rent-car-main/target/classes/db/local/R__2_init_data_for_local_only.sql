-- noinspection SqlResolveForFile
--Insert initial data into Vehicle table
INSERT INTO vehicle (brand, model, year, rental_cost_per_day, available, location) VALUES
                                                                                       ('Toyota', 'Corolla', 2020, 4500.0, TRUE, 'Alger'),
                                                                                       ('Ford', 'Fiesta', 2019, 3500.0, TRUE, 'Oran'),
                                                                                       ('BMW', 'X5', 2021, 7000.0, TRUE, 'Constantine'),
                                                                                       ('Renault', 'Clio', 2018, 3000.0, TRUE, 'Alger'),
                                                                                       ('Peugeot', '208', 2022, 4000.0, TRUE, 'Oran');

-- Insert initial data into Customer table
INSERT INTO customer (name, email, phone) VALUES
                                              ('Ahmed Benali', 'ahmed.benali@example.dz', '0550123456'),
                                              ('Fatima Zohra', 'fatima.zohra@example.dz', '0660789456'),
                                              ('Mohamed Boussouf', 'mohamed.boussouf@example.dz', '0770345678'),
                                              ('Yasmine Bouzid', 'yasmine.bouzid@example.dz', '0540987654');

-- Insert initial data into RentalRecord table
INSERT INTO rental_record (start_date, end_date, total_cost, vehicle_id, customer_id) VALUES
                                                                                          ('2024-05-01', '2024-05-10', 45000.0, 1, 1),
                                                                                          ('2024-06-15', '2024-06-20', 17500.0, 2, 2),
                                                                                          ('2024-07-01', '2024-07-05', 35000.0, 3, 3),
                                                                                          ('2024-08-01', '2024-08-07', 21000.0, 4, 4);

-- Insert initial data into Insurance table
INSERT INTO insurance (vehicle_id, provider, policy_number) VALUES
                                                                (1, 'Algerie Assurances', 'AA123456'),
                                                                (2, 'SAA', 'SAA789012'),
                                                                (3, 'GAM Assurances', 'GAM345678'),
                                                                (4, 'Alliance Assurances', 'ALL901234'),
                                                                (5, 'CAAR', 'CAAR567890');

-- Insert initial data into License table
INSERT INTO license (customer_id, number, expiry_date) VALUES
                                                           (1, 'DZA123456', '2025-12-31'),
                                                           (2, 'DZA654321', '2024-11-30'),
                                                           (3, 'DZA987654', '2026-10-15'),
                                                           (4, 'DZA456789', '2023-09-10');

-- Insert initial data into Invoice table
INSERT INTO invoice (rental_record_id, amount, issued_date) VALUES
                                                                (1, 45000.0, '2024-05-11'),
                                                                (2, 17500.0, '2024-06-21'),
                                                                (3, 35000.0, '2024-07-06'),
                                                                (4, 21000.0, '2024-08-08');