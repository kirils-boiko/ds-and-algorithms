CREATE TABLE IF NOT EXISTS prices AS
SELECT _id, timestamp, open, close, high, low
FROM full_data;
