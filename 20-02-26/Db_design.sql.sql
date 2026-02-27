use criminals


CREATE TABLE controlled_area (
    controlled_area_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(150)
);



CREATE TABLE officers (
    officer_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    rank VARCHAR(50),
    security_level INT NOT NULL,
    controlled_area_id INT,
    FOREIGN KEY (controlled_area_id) REFERENCES controlled_area(controlled_area_id)
);



CREATE TABLE incidents (
    incident_id INT PRIMARY KEY,
    title VARCHAR(200),
    description TEXT,
    controlled_area_id INT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    current_status VARCHAR(50) CHECK (current_status IN ('OPEN','UNDER_INVESTIGATION','CLOSED')),
    required_security_level INT NOT NULL,
    FOREIGN KEY (controlled_area_id) REFERENCES controlled_area(controlled_area_id)
);




CREATE TABLE incident_officers (
    incident_id INT,
    officer_id INT,
    assigned_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (incident_id, officer_id),
    FOREIGN KEY (incident_id) REFERENCES incidents(incident_id),
    FOREIGN KEY (officer_id) REFERENCES officers(officer_id)
);



CREATE TABLE suspects (
    suspect_id INT PRIMARY KEY,
    name VARCHAR(100),
    dob DATE
);



CREATE TABLE incident_suspects (
    incident_id INT,
    suspect_id INT,
    PRIMARY KEY (incident_id, suspect_id),
    FOREIGN KEY (incident_id) REFERENCES incidents(incident_id),
    FOREIGN KEY (suspect_id) REFERENCES suspects(suspect_id)
);




CREATE TABLE evidence (
    evidence_id INT PRIMARY KEY,
    incident_id INT NOT NULL,
    description TEXT,
    current_location VARCHAR(150),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    is_active BIT DEFAULT 1,  -- never delete, only mark inactive if needed
    FOREIGN KEY (incident_id) REFERENCES incidents(incident_id)
);




CREATE TABLE evidence_movements (
    movement_id INT PRIMARY KEY,
    evidence_id INT NOT NULL,
    moved_from VARCHAR(150),
    moved_to VARCHAR(150),
    moved_by_officer INT,
    moved_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (evidence_id) REFERENCES evidence(evidence_id),
    FOREIGN KEY (moved_by_officer) REFERENCES officers(officer_id)
);




CREATE TABLE incident_status_history (
    history_id INT PRIMARY KEY,
    incident_id INT NOT NULL,
    status VARCHAR(50) CHECK (status IN ('OPEN','UNDER_INVESTIGATION','CLOSED')),
    changed_by_officer INT,
    changed_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (incident_id) REFERENCES incidents(incident_id),
    FOREIGN KEY (changed_by_officer) REFERENCES officers(officer_id)
);




CREATE TABLE audit_logs (
    audit_id INT PRIMARY KEY,
    officer_id INT,
    incident_id INT,
    action_type VARCHAR(50), 
    action_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (officer_id) REFERENCES officers(officer_id),
    FOREIGN KEY (incident_id) REFERENCES incidents(incident_id)
);




INSERT INTO controlled_area VALUES
(1, 'Central Precinct', 'Downtown'),
(2, 'West Precinct', 'West City');



INSERT INTO officers VALUES
(101, 'Alice', 'Inspector', 5, 1),
(102, 'Bob', 'Sergeant', 3, 1),
(103, 'Charlie', 'Constable', 2, 1),
(104, 'David', 'Constable', 1, 2),
(105, 'Eve', 'Inspector', 4, 2);


INSERT INTO incidents VALUES
(201, 'Bank Robbery', 'Robbery at central bank', 1, CURRENT_TIMESTAMP, 'OPEN', 3),
(202, 'Cyber Fraud', 'Online scam case', 1, CURRENT_TIMESTAMP, 'UNDER_INVESTIGATION', 5),
(203, 'Car Theft', 'Vehicle stolen', 2, CURRENT_TIMESTAMP, 'OPEN', 2),
(204, 'Drug Case', 'Narcotics seizure', 2, CURRENT_TIMESTAMP, 'CLOSED', 4);




INSERT INTO incident_officers VALUES
(201, 101, CURRENT_TIMESTAMP),
(201, 102, CURRENT_TIMESTAMP),
(201, 103, CURRENT_TIMESTAMP),
(201, 104, CURRENT_TIMESTAMP);



INSERT INTO incident_officers VALUES
(202, 101, CURRENT_TIMESTAMP);



INSERT INTO incident_officers VALUES
(204, 105, CURRENT_TIMESTAMP),
(204, 102, CURRENT_TIMESTAMP);



INSERT INTO suspects VALUES
(301, 'Ravi', '1990-05-10'),
(302, 'Kiran', '1985-08-20'),
(303, 'Sameer', '1995-01-15');



INSERT INTO incident_suspects VALUES
(201, 301),
(201, 302);



INSERT INTO incident_suspects VALUES
(203, 303);



INSERT INTO evidence VALUES
(401, 201, 'Gun recovered', 'Locker A', CURRENT_TIMESTAMP, 1),
(402, 201, 'CCTV Harddisk', 'Locker B', CURRENT_TIMESTAMP, 1),
(403, 202, 'Laptop', 'Cyber Lab', CURRENT_TIMESTAMP, 1),
(404, 203, 'Car key', 'Locker C', CURRENT_TIMESTAMP, 1), 
(405, 204, 'Drug packet', 'Locker D', CURRENT_TIMESTAMP, 1);




INSERT INTO evidence_movements VALUES
(1, 401, 'Locker A', 'Forensic Lab', 101, CURRENT_TIMESTAMP),
(2, 401, 'Forensic Lab', 'Court', 101, CURRENT_TIMESTAMP),
(3, 401, 'Court', 'Locker A', 102, CURRENT_TIMESTAMP),
(4, 401, 'Locker A', 'Forensic Lab', 103, CURRENT_TIMESTAMP),
(5, 401, 'Forensic Lab', 'Court', 101, CURRENT_TIMESTAMP),
(6, 401, 'Court', 'Locker A', 102, CURRENT_TIMESTAMP);



INSERT INTO evidence_movements VALUES
(7, 402, 'Locker B', 'Cyber Lab', 101, CURRENT_TIMESTAMP),
(8, 402, 'Cyber Lab', 'Locker B', 101, CURRENT_TIMESTAMP);



INSERT INTO evidence_movements VALUES
(9, 403, 'Cyber Lab', 'Court', 101, CURRENT_TIMESTAMP);



INSERT INTO evidence_movements VALUES
(10, 405, 'Locker D', 'Forensic Lab', 105, CURRENT_TIMESTAMP),
(11, 405, 'Forensic Lab', 'Court', 105, CURRENT_TIMESTAMP),
(12, 405, 'Court', 'Locker D', 105, CURRENT_TIMESTAMP);



INSERT INTO incident_status_history VALUES
(1, 201, 'OPEN', 101, CURRENT_TIMESTAMP),
(2, 201, 'UNDER_INVESTIGATION', 101, CURRENT_TIMESTAMP),
(3, 202, 'OPEN', 101, CURRENT_TIMESTAMP),
(4, 202, 'UNDER_INVESTIGATION', 101, CURRENT_TIMESTAMP),
(5, 204, 'OPEN', 105, CURRENT_TIMESTAMP),
(6, 204, 'UNDER_INVESTIGATION', 105, CURRENT_TIMESTAMP),
(7, 204, 'CLOSED', 105, CURRENT_TIMESTAMP);


INSERT INTO audit_logs VALUES
(1, 101, 202, 'VIEW', CURRENT_TIMESTAMP), 
(2, 102, 201, 'VIEW', CURRENT_TIMESTAMP); 



INSERT INTO audit_logs VALUES
(3, 103, 202, 'VIEW', CURRENT_TIMESTAMP), 
(4, 104, 204, 'VIEW', CURRENT_TIMESTAMP); 



select * from  controlled_area;

select * from officers;

select * from incidents;

select * from incident_officers;

select * from suspects;

select * from incident_suspects;

select * from evidence;

SELECT  * from evidence_movements;

select * from incident_status_history;

select * from  audit_logs;



-- queries --

SELECT incident_id
FROM incident_officers
GROUP BY incident_id
HAVING COUNT(officer_id) > 3;


SELECT evidence_id
FROM evidence_movements
GROUP BY evidence_id
HAVING COUNT(*) > 5;


SELECT a.officer_id, a.incident_id
FROM audit_logs a
JOIN officers o ON a.officer_id = o.officer_id
JOIN incidents i ON a.incident_id = i.incident_id
WHERE o.security_level < i.required_security_level;


SELECT i.incident_id
FROM incidents i
JOIN incident_suspects s ON i.incident_id = s.incident_id
LEFT JOIN incident_officers o ON i.incident_id = o.incident_id
WHERE o.officer_id IS NULL;


SELECT e.evidence_id
FROM evidence e
LEFT JOIN evidence_movements m ON e.evidence_id = m.evidence_id
WHERE m.evidence_id IS NULL;


select  incident_id ,count(*) from incident_officers group by incident_id  having count(*)>3


























