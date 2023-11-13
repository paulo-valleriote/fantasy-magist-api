CREATE INDEX idx_sheet_id_attributes
ON attributes (sheet_id);

CREATE INDEX idx_sheet_id_bags
ON bags (sheet_id);

CREATE INDEX idx_bag_id_items
ON items (bag_id);

CREATE INDEX idx_user_id_sheets
ON sheets (user_id);

CREATE INDEX idx_sheet_id_skills
ON skills (sheet_id);

CREATE INDEX idx_sheet_id_spells
ON spells (sheet_id);
