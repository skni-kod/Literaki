ALTER TABLE logs.mail_attempts
    ADD title TEXT;

ALTER TABLE logs.mail_attempts
    ALTER COLUMN title SET NOT NULL;

ALTER TABLE logs.mail_attempts
DROP
COLUMN body;