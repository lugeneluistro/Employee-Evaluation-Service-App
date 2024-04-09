INSERT INTO employees (employee_id, first_name, last_name, email, position, department, date_joined, status, supervisor_id) VALUES
(100023, 'Lugene', 'Luistro', 'lugene.luistro@example.com', 'Head of IT', 'IT', '2024-01-01', 'Active', NULL),
(100024, 'John', 'Paeldin', 'john.paeldin@example.com', 'Finance Director', 'Finance', '2024-01-02', 'Active', NULL),
(100025, 'Nathaniel', 'Matginas', 'nathaniel.matginas@example.com', 'Operations Manager', 'Operations', '2024-01-03', 'Active', NULL);


INSERT INTO employees (first_name, last_name, email, position, department, date_joined, status, supervisor_id) VALUES
('Jon', 'Snow', 'jon.snow@example.com', 'Developer', 'IT', '2024-03-01', 'Active', 100023),
('Sansa', 'Stark', 'sansa.stark@example.com', 'Developer', 'IT', '2024-03-02', 'Active', 100023),
('Arya', 'Stark', 'arya.stark@example.com', 'Developer', 'IT', '2024-03-03', 'Active', 100023),
('Bran', 'Stark', 'bran.stark@example.com', 'Developer', 'IT', '2024-03-04', 'Active', 100023),
('Tyrion', 'Lannister', 'tyrion.lannister@example.com', 'Developer', 'IT', '2024-03-05', 'Active', 100023),
('Jaime', 'Lannister', 'jaime.lannister@example.com', 'Developer', 'IT', '2024-03-06', 'Active', 100023),
('Cersei', 'Lannister', 'cersei.lannister@example.com', 'Developer', 'IT', '2024-03-07', 'Active', 100023),
('Daenerys', 'Targaryen', 'daenerys.targaryen@example.com', 'Developer', 'IT', '2024-03-08', 'Active', 100023),
('Jorah', 'Mormont', 'jorah.mormont@example.com', 'Developer', 'IT', '2024-03-09', 'Active', 100023),
('Samwell', 'Tarly', 'samwell.tarly@example.com', 'Developer', 'IT', '2024-03-10', 'Active', 100023);


INSERT INTO employees (first_name, last_name, email, position, department, date_joined, status, supervisor_id) VALUES
('Theon', 'Greyjoy', 'theon.greyjoy@example.com', 'Analyst', 'Finance', '2024-03-11', 'Active', 100024),
('Yara', 'Greyjoy', 'yara.greyjoy@example.com', 'Analyst', 'Finance', '2024-03-12', 'Active', 100024),
('Euron', 'Greyjoy', 'euron.greyjoy@example.com', 'Analyst', 'Finance', '2024-03-13', 'Active', 100024),
('Davos', 'Seaworth', 'davos.seaworth@example.com', 'Analyst', 'Finance', '2024-03-14', 'Active', 100024),
('Brienne', 'Of Tarth', 'brienne.oftarth@example.com', 'Analyst', 'Finance', '2024-03-15', 'Active', 100024),
('Tormund', 'Giantsbane', 'tormund.giantsbane@example.com', 'Analyst', 'Finance', '2024-03-16', 'Active', 100024),
('Bronn', 'of the Blackwater', 'bronn.blackwater@example.com', 'Analyst', 'Finance', '2024-03-17', 'Active', 100024),
('Podrick', 'Payne', 'podrick.payne@example.com', 'Analyst', 'Finance', '2024-03-18', 'Active', 100024);


INSERT INTO employees (first_name, last_name, email, position, department, date_joined, status, supervisor_id) VALUES
('Ted', 'Mosby', 'ted.mosby@example.com', 'Architect', 'Design', '2024-03-19', 'Active', 100025),
('Marshall', 'Eriksen', 'marshall.eriksen@example.com', 'Lawyer', 'Legal', '2024-03-20', 'Active', 100025),
('Lily', 'Aldrin', 'lily.aldrin@example.com', 'Art Consultant', 'Arts', '2024-03-21', 'Active', 100025),
('Robin', 'Scherbatsky', 'robin.scherbatsky@example.com', 'Journalist', 'Media', '2024-03-22', 'Active', 100025),
('Barney', 'Stinson', 'barney.stinson@example.com', 'PLEASE', 'Corporate', '2024-03-23', 'Active', 100025),
('Tracy', 'McConnell', 'tracy.mcconnell@example.com', 'Musician', 'Arts', '2024-03-24', 'Active', 100025),
('Ranjit', 'Singh', 'ranjit.singh@example.com', 'Driver', 'Logistics', '2024-03-25', 'Active', 100025);
