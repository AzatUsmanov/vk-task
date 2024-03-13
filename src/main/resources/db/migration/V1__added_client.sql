CREATE TABLE IF NOT EXISTS public.client
(
    id serial,
    username character varying(50) NOT NULL,
    password character varying(255) NOT NULL,
    CONSTRAINT client_pkey PRIMARY KEY (id),
    CONSTRAINT client_username_key UNIQUE (username)
);