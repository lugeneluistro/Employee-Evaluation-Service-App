CREATE TABLE employees (
    employee_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    position VARCHAR(255),
    department VARCHAR(255),
    date_joined DATE,
    status VARCHAR(255),
    supervisor_id INTEGER REFERENCES employees(employee_id) ON DELETE SET NULL
);

CREATE TABLE evaluations (
    evaluation_id SERIAL PRIMARY KEY,
    employee_id INTEGER REFERENCES employees(employee_id),
    evaluator_id INTEGER REFERENCES employees(employee_id),
    evaluation_date DATE
);

CREATE TABLE evaluation_items (
    item_id SERIAL PRIMARY KEY,
	category VARCHAR(255),
    item_name VARCHAR(255),
    description TEXT,
    weight DECIMAL
);

CREATE TABLE evaluation_scores (
    evaluation_id INTEGER REFERENCES evaluations(evaluation_id),
    item_id INTEGER REFERENCES evaluation_items(item_id),
    score INTEGER,
    comments TEXT,
    PRIMARY KEY (evaluation_id, item_id)
);