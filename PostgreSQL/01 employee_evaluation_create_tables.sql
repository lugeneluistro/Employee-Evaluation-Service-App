CREATE TABLE employees (
    employee_id BIGSERIAL CONSTRAINT pk_employee PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    position VARCHAR(255),
    department VARCHAR(255),
    date_joined DATE,
    status VARCHAR(255),
    supervisor_id BIGINT REFERENCES employees(employee_id) ON DELETE SET NULL
);

CREATE TABLE evaluations (
    evaluation_id SERIAL CONSTRAINT pk_evaluations PRIMARY KEY,
    employee_id BIGINT,
    evaluator_id INTEGER,
    evaluation_date DATE,
    CONSTRAINT fk_eval_employee FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    CONSTRAINT fk_eval_evaluator FOREIGN KEY (evaluator_id) REFERENCES employees(employee_id)
);

CREATE TABLE evaluation_items (
    item_id SERIAL CONSTRAINT pk_evaluation_items PRIMARY KEY,
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
    CONSTRAINT pk_evaluation_scores PRIMARY KEY (evaluation_id, item_id),
    CONSTRAINT fk_evaluation_scores_evaluation FOREIGN KEY (evaluation_id) REFERENCES evaluations(evaluation_id),
    CONSTRAINT fk_evaluation_scores_item FOREIGN KEY (item_id) REFERENCES evaluation_items(item_id)
);


CREATE SEQUENCE employee_id_seq START WITH 100001;
CREATE SEQUENCE evaluation_id_seq START WITH 2000001;
CREATE SEQUENCE item_id_seq START WITH 101;

ALTER TABLE employees ALTER COLUMN employee_id SET DEFAULT nextval('employee_id_seq'::regclass);
ALTER TABLE evaluations ALTER COLUMN evaluation_id SET DEFAULT nextval('evaluation_id_seq'::regclass);
ALTER TABLE evaluation_items ALTER COLUMN item_id SET DEFAULT nextval('item_id_seq'::regclass);

