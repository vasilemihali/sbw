CREATE SEQUENCE demo_entity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE demo_entity_id_seq OWNED BY demo_entity.id;
ALTER TABLE ONLY demo_entity ALTER COLUMN id SET DEFAULT nextval('demo_entity_id_seq'::regclass);
ALTER TABLE ONLY demo_entity ADD CONSTRAINT demo_entity_pkey PRIMARY KEY (id);