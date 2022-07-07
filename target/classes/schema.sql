CREATE TABLE SPRINT(
  ID SERIAL NOT NULL,
  NAME VARCHAR(128),
  BEGIN_DATE TIMESTAMP,
  END_DATE TIMESTAMP,
  GOAL_DESCRIPTION TEXT,
  STATUS ENUM('Pending', 'In_progress', 'Finished','Canceled'),
  PRIMARY KEY (ID)
);

CREATE TABLE USER_STORY(
    ID SERIAL NOT NULL,
    NAME VARCHAR(128),
    DESCRIPTION TEXT,
    STORY_POINTS INTEGER,
    STATUS ENUM('To_do','In_progress','Review', 'Done'),
    PRIMARY KEY (ID)
);

CREATE TABLE ATTACHMENTS(
    ID SERIAL NOT NULL,
    USER_STORY_ID BIGINT NOT NULL,
    NAME BYTEA,
    PRIMARY KEY (ID),
    CONSTRAINT ATTACHMENTS_USER_STORY_FOREIGN_KEY
        FOREIGN KEY(USER_STORY_ID)
            REFERENCES USER_STORY(ID)
);

CREATE TABLE USER_STORY_SPRINT(
    USER_STORY_ID BIGINT NOT NULL,
    SPRINT_ID BIGINT NOT NULL,
    CONSTRAINT USER_STORY_SPRINT_USER_STORY_FOREIGN_KEY
        FOREIGN KEY(USER_STORY_ID)
            REFERENCES USER_STORY(ID),
    CONSTRAINT USER_STORY_SPRINT_SPRINT_FOREIGN_KEY
        FOREIGN KEY(SPRINT_ID)
            REFERENCES SPRINT(ID)
);
