DROP SCHEMA IF EXISTS games CASCADE ;
CREATE SCHEMA games;

DROP SCHEMA IF EXISTS players CASCADE ;
CREATE SCHEMA players;

CREATE TABLE games.game
(
    game_id              BIGINT  NOT NULL,
    player_one_player_id BIGINT  NOT NULL,
    player_two_player_id BIGINT  NOT NULL,
    points_player1       INTEGER NOT NULL,
    points_player2       INTEGER NOT NULL,
    state                BOOLEAN NOT NULL,
    CONSTRAINT pk_game PRIMARY KEY (game_id)
);

CREATE TABLE games.words
(
    words_id  BIGINT  NOT NULL,
    game_id   BIGINT  NOT NULL,
    player_id BIGINT  NOT NULL,
    points    INTEGER NOT NULL,
    CONSTRAINT pk_words PRIMARY KEY (words_id)
);

CREATE TABLE players.old_games
(
    old_game_id       BIGINT  NOT NULL,
    player1_player_id BIGINT  NOT NULL,
    player2_player_id BIGINT  NOT NULL,
    points_player1    INTEGER NOT NULL,
    points_player2    INTEGER NOT NULL,
    result            BIGINT  NOT NULL,
    CONSTRAINT pk_oldgames PRIMARY KEY (old_game_id)
);

CREATE TABLE players.profile
(
    player_id     BIGINT       NOT NULL,
    username      VARCHAR(255) NOT NULL,
    icon          SMALLINT     NULL ,
    ranking       INTEGER      NOT NULL,
    creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_profile PRIMARY KEY (player_id)
);

ALTER TABLE games.game
    ADD CONSTRAINT uc_game_gameid UNIQUE (game_id);

ALTER TABLE games.words
    ADD CONSTRAINT uc_words_wordsid UNIQUE (words_id);

ALTER TABLE players.old_games
    ADD CONSTRAINT uc_oldgames_oldgameid UNIQUE (old_game_id);

ALTER TABLE players.profile
    ADD CONSTRAINT uc_profile_playerid UNIQUE (player_id);

ALTER TABLE players.profile
    ADD CONSTRAINT uc_profile_username UNIQUE (username);

ALTER TABLE games.game
    ADD CONSTRAINT FK_GAME_ON_PLAYERONE_PLAYERID FOREIGN KEY (player_one_player_id) REFERENCES players.profile (player_id);

ALTER TABLE games.game
    ADD CONSTRAINT FK_GAME_ON_PLAYERTWO_PLAYERID FOREIGN KEY (player_two_player_id) REFERENCES players.profile (player_id);

ALTER TABLE players.old_games
    ADD CONSTRAINT FK_OLDGAMES_ON_PLAYER1_PLAYERID FOREIGN KEY (player1_player_id) REFERENCES players.profile (player_id);

ALTER TABLE players.old_games
    ADD CONSTRAINT FK_OLDGAMES_ON_PLAYER2_PLAYERID FOREIGN KEY (player2_player_id) REFERENCES players.profile (player_id);