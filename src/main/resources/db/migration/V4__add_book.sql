CREATE TABLE books (
    id integer NOT NULL,
    title character varying(255),
    author character varying(255),
    description character varying(255),
    creation_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    last_modified_by character varying(255)
);

CREATE SEQUENCE books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE books_id_seq OWNED BY books.id;
ALTER TABLE ONLY books ALTER COLUMN id SET DEFAULT nextval('books_id_seq'::regclass);
ALTER TABLE ONLY books ADD CONSTRAINT books_pkey PRIMARY KEY (id);

CREATE TABLE employees (
    id integer NOT NULL,
    name character varying(255),
    role character varying(255),
    password character varying(255),
    email character varying(255),
    creation_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    last_modified_by character varying(255)
);

CREATE SEQUENCE employees_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE employees_id_seq OWNED BY employees.id;
ALTER TABLE ONLY employees ALTER COLUMN id SET DEFAULT nextval('employees_id_seq'::regclass);
ALTER TABLE ONLY employees ADD CONSTRAINT employees_pkey PRIMARY KEY (id);