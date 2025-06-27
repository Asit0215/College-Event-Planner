-- INSERT: USERS
INSERT INTO users (name, email, role, phone) VALUES ('Ananya Sharma', 'ananya@cog.edu.in', 'Organizer', '9876543210');
INSERT INTO users (name, email, role, phone) VALUES ('Ravi Kumar', 'ravi@cog.edu.in', 'Volunteer', '9876543211');
INSERT INTO users (name, email, role, phone) VALUES ('Priya Nair', 'priya@cog.edu.in', 'Volunteer', '9876543212');
INSERT INTO users (name, email, role, phone) VALUES ('Amit Verma', 'amit@cog.edu.in', 'Volunteer', '9876543213');
INSERT INTO users (name, email, role, phone) VALUES ('Sneha Iyer', 'sneha@cog.edu.in', 'Volunteer', '9876543214');
INSERT INTO users (name, email, role, phone) VALUES ('Rahul Mehta', 'rahul@cog.edu.in', 'Organizer', '9876543215');
INSERT INTO users (name, email, role, phone) VALUES ('Neha Singh', 'neha@cog.edu.in', 'Volunteer', '9876543216');
INSERT INTO users (name, email, role, phone) VALUES ('Karan Das', 'karan@cog.edu.in', 'Volunteer', '9876543217');
INSERT INTO users (name, email, role, phone) VALUES ('Meera Joshi', 'meera@cog.edu.in', 'Volunteer', '9876543218');
INSERT INTO users (name, email, role, phone) VALUES ('Arjun Reddy', 'arjun@cog.edu.in', 'Volunteer', '9876543219');


-- INSERT: EVENTS
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Blood Camp Delhi', 'Blood donation in Delhi', TO_DATE('2025-08-01','YYYY-MM-DD'), 'Delhi', 1);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Clean Drive Mumbai', 'Beach cleaning in Mumbai', TO_DATE('2025-08-02','YYYY-MM-DD'), 'Mumbai', 1);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Tree Plantation Pune', 'Tree planting event', TO_DATE('2025-08-03','YYYY-MM-DD'), 'Pune', 2);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Education Camp Bhopal', 'Literacy drive for slum children', TO_DATE('2025-08-04','YYYY-MM-DD'), 'Bhopal', 2);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Yoga Day Jaipur', 'Free yoga session', TO_DATE('2025-08-05','YYYY-MM-DD'), 'Jaipur', 3);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Blood Camp Chennai', 'Blood donation in Chennai', TO_DATE('2025-08-06','YYYY-MM-DD'), 'Chennai', 4);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Swachh Bharat Lucknow', 'Clean city initiative', TO_DATE('2025-08-07','YYYY-MM-DD'), 'Lucknow', 5);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Health Check Kolkata', 'Basic health screening', TO_DATE('2025-08-08','YYYY-MM-DD'), 'Kolkata', 6);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Awareness Rally Patna', 'Covid awareness rally', TO_DATE('2025-08-09','YYYY-MM-DD'), 'Patna', 7);
INSERT INTO events (event_name, description, event_date, location, created_by) VALUES ('Career Talk Surat', 'Motivational session for students', TO_DATE('2025-08-10','YYYY-MM-DD'), 'Surat', 8);


-- INSERT: VOLUNTEER ASSIGNMENTS
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (2, 1, 'Registration');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (3, 2, 'Photography');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (4, 3, 'Logistics');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (5, 4, 'Food Distribution');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (6, 5, 'Medical Assistance');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (7, 6, 'Crowd Management');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (8, 7, 'Cleaning');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (9, 8, 'First Aid');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (10, 9, 'Banner Holding');
INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (3, 10, 'Coordination');


-- INSERT: BUDGET ALLOCATIONS
INSERT INTO budget_allocations (event_id, item, amount) VALUES (1, 'Snacks', 500.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (2, 'Cleaning Kits', 750.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (3, 'Saplings', 600.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (4, 'Books and Stationery', 1200.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (5, 'Yoga Mats', 300.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (6, 'Medical Kits', 800.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (7, 'Dustbins', 400.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (8, 'Stethoscopes', 1000.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (9, 'Pamphlets', 250.00);
INSERT INTO budget_allocations (event_id, item, amount) VALUES (10, 'Projector', 1500.00);



-- VERIFICATION QUERIES

-- 1. Table Row Counts
SELECT 'Users' AS Table_Name, COUNT(*) AS Row_Count FROM users
UNION ALL
SELECT 'Events', COUNT(*) FROM events
UNION ALL
SELECT 'Volunteer Assignments', COUNT(*) FROM volunteer_assignments
UNION ALL
SELECT 'Budget Allocations', COUNT(*) FROM budget_allocations;

-- 2. Events with Organizer Names
SELECT 
  e.event_id, 
  e.event_name, 
  u.name AS organizer_name, 
  TO_CHAR(e.event_date, 'DD-MON-YYYY') AS event_date, 
  e.location
FROM events e
JOIN users u ON e.created_by = u.user_id
ORDER BY e.event_id;

-- 3. Volunteers Assigned to Events
SELECT 
  e.event_name, 
  u.name AS volunteer_name, 
  v.task
FROM volunteer_assignments v
JOIN events e ON v.event_id = e.event_id
JOIN users u ON v.user_id = u.user_id
ORDER BY e.event_name, u.name;

-- 4. Budget Allocations per Event
SELECT 
  e.event_name, 
  b.item, 
  b.amount
FROM budget_allocations b
JOIN events e ON b.event_id = e.event_id
ORDER BY e.event_name;

-- 5. Total Budget Per Event
SELECT 
  e.event_name, 
  SUM(b.amount) AS total_budget
FROM events e
JOIN budget_allocations b ON e.event_id = b.event_id
GROUP BY e.event_name
ORDER BY total_budget DESC;

-- 6.A Foreign Key Check: Invalid References Events with invalid user IDs
SELECT * FROM events 
WHERE created_by NOT IN (SELECT user_id FROM users);

-- 6.B Volunteer assignments with invalid user/event references
SELECT * FROM volunteer_assignments 
WHERE user_id NOT IN (SELECT user_id FROM users)
   OR event_id NOT IN (SELECT event_id FROM events);

-- 6.C Budget allocations with invalid events
SELECT * FROM budget_allocations 
WHERE event_id NOT IN (SELECT event_id FROM events);

-- 7. Summary Report
SELECT 
  (SELECT COUNT(*) FROM events) AS total_events,
  (SELECT COUNT(*) FROM volunteer_assignments) AS total_volunteers,
  (SELECT COUNT(*) FROM budget_allocations) AS total_budget_entries,
  (SELECT SUM(amount) FROM budget_allocations) AS total_budget_amount
FROM dual;

