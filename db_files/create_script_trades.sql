CREATE TABLE IF NOT EXISTS trades AS
SELECT _id, timestamp, count, volume
FROM full_data;
