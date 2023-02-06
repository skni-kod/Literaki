DROP SCHEMA IF EXISTS logs CASCADE;
CREATE SCHEMA logs;

DROP TABLE IF EXISTS logs.mail_attempts CASCADE;
CREATE TABLE logs.mail_attempts
(
    id              BIGSERIAL  NOT NULL,
    attempt_date            TIMESTAMP WITH TIME ZONE NOT NULL,
    requesting_user         text NULL,
    body                    text NOT NULL,
    successful              boolean NOT NULL,
    CONSTRAINT pk_mail_attempt PRIMARY KEY (id)
);