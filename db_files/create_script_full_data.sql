-- Table: public.full_data

-- DROP TABLE IF EXISTS public.full_data;

CREATE TABLE IF NOT EXISTS public.full_data
(
    _id bigint NOT NULL,
    "timestamp" bigint NOT NULL,
    asset_id bigint NOT NULL,
    asset_name character varying(100) COLLATE pg_catalog."default",
    weight double precision,
    count double precision,
    open double precision,
    high double precision,
    low double precision,
    close double precision,
    volume double precision,
    vwap double precision,
    target double precision,
    CONSTRAINT full_data_pkey PRIMARY KEY (_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.full_data
    OWNER to postgres;
