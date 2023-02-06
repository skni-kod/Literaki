DROP TABLE IF EXISTS games.board CASCADE;
CREATE TABLE games.board
(
    board_id                        BIGINT           NOT NULL,
    board_word_bag_word_bag_id      BIGINT,
    player_one_word_bag_word_bag_id BIGINT,
    player_one_score                DOUBLE PRECISION NOT NULL,
    player_two_word_bag_word_bag_id BIGINT,
    player_two_score                DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_board PRIMARY KEY (board_id)
);

DROP TABLE IF EXISTS games.board_fields CASCADE;
CREATE TABLE games.board_fields
(
    board_board_id  BIGINT NOT NULL,
    fields_field_id BIGINT NOT NULL
);

DROP TABLE IF EXISTS games.game_fields CASCADE;
CREATE TABLE games.game_fields
(
    field_id         BIGINT           NOT NULL,
    letter_letter_id BIGINT           NOT NULL,
    score_multiplier DOUBLE PRECISION NOT NULL,
    player_player_id BIGINT           NOT NULL,
    board_board_id   BIGINT           NOT NULL,
    CONSTRAINT pk_game_fields PRIMARY KEY (field_id)
);

DROP TABLE IF EXISTS games.letter CASCADE;
CREATE TABLE games.letter
(
    letter_id BIGINT       NOT NULL,
    character VARCHAR(255) NOT NULL,
    score     INTEGER      NOT NULL,
    CONSTRAINT pk_letter PRIMARY KEY (letter_id)
);

DROP TABLE IF EXISTS games.word_bag CASCADE;
CREATE TABLE games.word_bag
(
    word_bag_id         BIGINT NOT NULL,
    player_id_player_id BIGINT NOT NULL,
    CONSTRAINT pk_word_bag PRIMARY KEY (word_bag_id)
);

DROP TABLE IF EXISTS games.word_bag_word_bag_letters CASCADE;
CREATE TABLE games.word_bag_word_bag_letters
(
    word_bag_word_bag_id       BIGINT NOT NULL,
    word_bag_letters_letter_id BIGINT NOT NULL
);

ALTER TABLE games.board_fields
    ADD CONSTRAINT uc_board_fields_bobofifi UNIQUE (board_board_id, fields_field_id);

ALTER TABLE games.word_bag_word_bag_letters
    ADD CONSTRAINT uc_word_bag_word_bag_letters_wowowole UNIQUE (word_bag_word_bag_id, word_bag_letters_letter_id);

ALTER TABLE games.board
    ADD CONSTRAINT FK_BOARD_ON_BOARD_WORD_BAG_WORD_BAG FOREIGN KEY (board_word_bag_word_bag_id) REFERENCES games.word_bag (word_bag_id);

ALTER TABLE games.board
    ADD CONSTRAINT FK_BOARD_ON_PLAYER_ONE_WORD_BAG_WORD_BAG FOREIGN KEY (player_one_word_bag_word_bag_id) REFERENCES games.word_bag (word_bag_id);

ALTER TABLE games.board
    ADD CONSTRAINT FK_BOARD_ON_PLAYER_TWO_WORD_BAG_WORD_BAG FOREIGN KEY (player_two_word_bag_word_bag_id) REFERENCES games.word_bag (word_bag_id);

ALTER TABLE games.game_fields
    ADD CONSTRAINT FK_GAME_FIELDS_ON_BOARD_BOARDID FOREIGN KEY (board_board_id) REFERENCES games.board (board_id);

ALTER TABLE games.game_fields
    ADD CONSTRAINT FK_GAME_FIELDS_ON_LETTER_LETTERID FOREIGN KEY (letter_letter_id) REFERENCES games.letter (letter_id);

ALTER TABLE games.game_fields
    ADD CONSTRAINT FK_GAME_FIELDS_ON_PLAYER_PLAYERID FOREIGN KEY (player_player_id) REFERENCES players.profile (player_id);

ALTER TABLE games.word_bag
    ADD CONSTRAINT FK_WORD_BAG_ON_PLAYERID_PLAYERID FOREIGN KEY (player_id_player_id) REFERENCES players.profile (player_id);

ALTER TABLE games.board_fields
    ADD CONSTRAINT fk_boafie_on_board FOREIGN KEY (board_board_id) REFERENCES games.board (board_id);

ALTER TABLE games.board_fields
    ADD CONSTRAINT fk_boafie_on_fields FOREIGN KEY (fields_field_id) REFERENCES games.game_fields (field_id);

ALTER TABLE games.word_bag_word_bag_letters
    ADD CONSTRAINT fk_worbagworbaglet_on_letter FOREIGN KEY (word_bag_letters_letter_id) REFERENCES games.letter (letter_id);

ALTER TABLE games.word_bag_word_bag_letters
    ADD CONSTRAINT fk_worbagworbaglet_on_word_bag FOREIGN KEY (word_bag_word_bag_id) REFERENCES games.word_bag (word_bag_id);