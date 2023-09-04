CREATE TABLE spells (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  description TEXT,
  level INTEGER NOT NULL,
  magic_school TEXT NOT NULL,
  sheet_id TEXT NOT NULL,
  CONSTRAINT fk_sheet FOREIGN KEY (sheet_id) REFERENCES sheets(id) ON DELETE CASCADE
)