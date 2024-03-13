CREATE TABLE IF NOT EXISTS public.role
(
    id integer NOT NULL,
    name character varying(255),
    CONSTRAINT roles_pkey PRIMARY KEY (id),
    CONSTRAINT role_name_key UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS public.clients_roles
(
    client_id integer NOT NULL,
    role_id integer NOT NULL,
    CONSTRAINT client_id_constraint FOREIGN KEY (client_id)
        REFERENCES public.client (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT role_id_constraint FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
