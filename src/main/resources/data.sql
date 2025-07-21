DROP TABLE IF EXISTS person_kpis;
DROP TABLE IF EXISTS kpi_definitions;
DROP TABLE IF EXISTS persons;

CREATE TABLE IF NOT EXISTS persons (
    id CHAR(36) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT
);
CREATE TABLE kpi_definitions (kpi_key VARCHAR(10), description VARCHAR(255), PRIMARY KEY (kpi_key));
CREATE TABLE person_kpis (
    person_id INT,
    kpi_key VARCHAR(10),
    p_value FLOAT,
    s_value FLOAT,
    t_value FLOAT,
    PRIMARY KEY (person_id, kpi_key),
    FOREIGN KEY (person_id) REFERENCES persons(id),
    FOREIGN KEY (kpi_key) REFERENCES kpi_definitions(kpi_key)
);

-- Beispielpersonen
INSERT INTO persons (id, first_name, last_name, age) VALUES (1, 'Max', 'Mustermann', 35);
INSERT INTO persons (id, first_name, last_name, age) VALUES (2, 'Erika', 'Musterfrau', 42);

-- KPI-Definitionen A–D
INSERT INTO kpi_definitions (kpi_key, description) VALUES ('A', 'Liquidität A');
INSERT INTO kpi_definitions (kpi_key, description) VALUES ('B', 'Rentabilität B');
INSERT INTO kpi_definitions (kpi_key, description) VALUES ('C', 'Eigenkapitalquote C');
INSERT INTO kpi_definitions (kpi_key, description) VALUES ('D', 'Gesamtkapitalrendite D');

-- Kennzahlen für Max
INSERT INTO person_kpis (person_id, kpi_key, p_value, s_value, t_value) VALUES (1, 'A', 100.0, 95.0, 90.0);
INSERT INTO person_kpis (person_id, kpi_key, p_value, s_value, t_value) VALUES (1, 'B', 50.5, 49.0, 47.5);
INSERT INTO person_kpis (person_id, kpi_key, p_value, s_value, t_value) VALUES (1, 'D', 20.0, 19.5, 19.0);

-- Kennzahlen für Erika
INSERT INTO person_kpis (person_id, kpi_key, p_value, s_value, t_value) VALUES (2, 'A', 110.0, 109.0, 108.0);
INSERT INTO person_kpis (person_id, kpi_key, p_value, s_value, t_value) VALUES (2, 'C', 70.0, 68.0, 66.0);