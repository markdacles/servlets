CREATE TABLE personnel (
    id bigint NOT NULL PRIMARY KEY,
    barangay character varying(255),
    city character varying(255),
    st_number character varying(255),
    zip_code character varying(255),
    birthday timestamp without time zone,
    date_hired timestamp without time zone,
    gwa double precision,
    first_name character varying(255),
    last_name character varying(255),
    middle_name character varying(255),
    suffix character varying(255),
    title character varying(255)
);

CREATE TABLE roles (
    role_id bigint NOT NULL PRIMARY KEY,
    role character varying(255)
);

CREATE TABLE contact (
    contact_id bigint NOT NULL PRIMARY KEY,
    email character varying(255),
    landline character varying(255),
    mobile character varying(255),
    personnel_id bigint REFERENCES personnel(id)
);

CREATE TABLE personnel_roles (
    id bigint NOT NULL REFERENCES personnel(id),
    role_id bigint NOT NULL REFERENCES roles(role_id),
    PRIMARY KEY (id, role_id)
);