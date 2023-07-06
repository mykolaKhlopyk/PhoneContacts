CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    login    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);

CREATE TABLE contacts
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255) UNIQUE NOT NULL,
    user_id BIGINT REFERENCES users (id)
);

CREATE TABLE emails
(
    id    BIGSERIAL PRIMARY KEY,
    email_address VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE phones
(
    id           BIGSERIAL PRIMARY KEY,
    phone_number VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE contacts_emails
(
    contact_id BIGINT REFERENCES contacts (id),
    email_id   BIGINT REFERENCES emails (id),
    PRIMARY KEY (contact_id, email_id)
);

CREATE TABLE contacts_phones
(
    contact_id       BIGINT REFERENCES contacts (id),
    phone_id BIGINT REFERENCES phones (id),
    PRIMARY KEY (contact_id, phone_id)
);