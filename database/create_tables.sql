CREATE TABLE users (
  user_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR2(100),
  email VARCHAR2(100) UNIQUE,
  role VARCHAR2(20),
  phone VARCHAR2(15)
);
CREATE TABLE events (
  event_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  event_name VARCHAR2(100),
  description CLOB,
  event_date DATE,
  location VARCHAR2(100),
  created_by NUMBER,
  CONSTRAINT fk_created_by FOREIGN KEY (created_by) REFERENCES users(user_id)
);
CREATE TABLE volunteer_assignments (
  assignment_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  user_id NUMBER,
  event_id NUMBER,
  task VARCHAR2(100),
  CONSTRAINT fk_vol_user FOREIGN KEY (user_id) REFERENCES users(user_id),
  CONSTRAINT fk_vol_event FOREIGN KEY (event_id) REFERENCES events(event_id)
);
CREATE TABLE budget_allocations (
  budget_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  event_id NUMBER,
  item VARCHAR2(100),
  amount NUMBER(10, 2),
  CONSTRAINT fk_budget_event FOREIGN KEY (event_id) REFERENCES events(event_id)
);
