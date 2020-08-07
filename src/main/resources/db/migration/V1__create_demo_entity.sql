SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', 'public', false);
SET check_function_bodies = false;
SET xmloption = content;
SET default_tablespace = '';

CREATE TABLE trace_flows (
    id integer NOT NULL,
    description character varying(255),
    error_msg character varying(255),
    creation_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    last_modified_by character varying(255)
);