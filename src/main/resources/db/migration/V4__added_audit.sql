CREATE TABLE IF NOT EXISTS public.audit
(
    id serial,
    date_action timestamp(6) without time zone,
    http_method character varying(255),
    uri character varying(255),
    username character varying(255),
    has_access boolean,
    CONSTRAINT audit_pkey PRIMARY KEY (id),
    CONSTRAINT audit_fkey FOREIGN KEY (username)
            REFERENCES public.client (username) MATCH SIMPLE
            ON UPDATE CASCADE
            ON DELETE NO ACTION
)