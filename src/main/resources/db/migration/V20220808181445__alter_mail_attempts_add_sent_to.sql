ALTER TABLE logs.mail_attempts
    ADD sent_to VARCHAR(255);

ALTER TABLE logs.mail_attempts
    ALTER COLUMN sent_to SET NOT NULL;

ALTER TABLE logs.mail_attempts
    ADD CONSTRAINT uc_mail_attempts_id UNIQUE (id);

ALTER TABLE logs.mail_attempts
    ALTER COLUMN body TYPE VARCHAR(255) USING (body::VARCHAR(255));

ALTER TABLE logs.mail_attempts
    ALTER COLUMN requesting_user TYPE VARCHAR(255) USING (requesting_user::VARCHAR(255));