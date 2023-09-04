CREATE TABLE attributes (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  strenght INTEGER NOT NULL,
  dexterity INTEGER NOT NULL,
  constitution INTEGER NOT NULL,
  intelligence INTEGER NOT NULL,
  wisdom INTEGER NOT NULL,
  charisma INTEGER NOT NULL,
  sheet_id TEXT NOT NULL,
  CONSTRAINT fk_sheet FOREIGN KEY (sheet_id) REFERENCES sheets(id) ON DELETE CASCADE
)