CREATE TABLE backlog (
  id UUID PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255)
);
-- Create ProductID table
CREATE TABLE product_id (
  id VARCHAR(36) PRIMARY KEY
);

-- Create ReleaseID table
CREATE TABLE release_id (
  id VARCHAR(36) PRIMARY KEY
);

-- Create SprintID table
CREATE TABLE sprint_id (
  id VARCHAR(36) PRIMARY KEY
);

-- Create Backlog table
CREATE TABLE backlog (
  id UUID PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255)
);

-- Create BacklogItem table
CREATE TABLE backlog_item (
  id VARCHAR(36) PRIMARY KEY,
  status VARCHAR(255),
  story VARCHAR(255),
  story_points INTEGER,
  summary VARCHAR(255),
  type VARCHAR(255),
  product_id VARCHAR(36),
  release_id VARCHAR(36),
  sprint_id VARCHAR(36),
  FOREIGN KEY (product_id) REFERENCES product_id(id),
  FOREIGN KEY (release_id) REFERENCES release_id(id),
  FOREIGN KEY (sprint_id) REFERENCES sprint_id(id)
);

-- Create Task table
CREATE TABLE task (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255),
  hour_remaining INTEGER,
  volunteer VARCHAR(255)
);

-- Create EstimationLogEntry table
CREATE TABLE estimation_log_entry (
  id UUID PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255),
  hour_remaining INTEGER,
  volunteer VARCHAR(255),
  task_id VARCHAR(36),
  FOREIGN KEY (task_id) REFERENCES task(id)
);
