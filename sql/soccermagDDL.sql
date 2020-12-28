DROP TABLE players CASCADE CONSTRAINTS;

DROP TABLE team CASCADE CONSTRAINTS;

DROP TABLE managers CASCADE CONSTRAINTS;

DROP TABLE medical_staff CASCADE CONSTRAINTS;

DROP TABLE trainers CASCADE CONSTRAINTS;

DROP TABLE logins CASCADE CONSTRAINTS;


CREATE TABLE team(
	t_name	         varchar2(25)    NOT NULL,
	user_id	         varchar2(50)	NOT NULL
);


CREATE TABLE  players (
	p_number           number(20)		NOT NULL,
	t_name             varchar2(25)		NOT NULL,
	p_name 	           varchar2(50)		NOT NULL,
	p_age	           number(20)		NOT NULL,
    p_position         varchar2(50)		NOT NULL
);


CREATE TABLE  managers (
	 m_number	 number(20)		    NOT NULL,
	 t_name	     varchar2(25)		NOT NULL,
	 m_name  	 varchar2(50)		NOT NULL,
	 m_age	     number(20)		    NOT NULL,
	 m_position	 varchar2(50)		NOT NULL
);



CREATE TABLE medical_staff (
	d_number	      number(20)		    NOT NULL,
	t_name	          varchar2(25)		NOT NULL,
	d_name	          varchar2(50)		NOT NULL,
	d_age	          number(20)		    NOT NULL,
	d_position	      varchar2(50)		    NOT NULL
);



CREATE TABLE trainers (
	tr_number	 number(20)		    NOT NULL,
	t_name	     varchar2(25)		NOT NULL,
	tr_name	     varchar2(50)		NOT NULL,
	tr_age	     number(20)		    NOT NULL,
	tr_position	 varchar2(50)		    NOT NULL
);



CREATE TABLE logins (
	user_id	           varchar2(50)	      NOT NULL,
	user_pw	           varchar2(50)	      NOT NULL
);


ALTER TABLE logins ADD CONSTRAINT PK_LOGINS PRIMARY KEY (userid);

ALTER TABLE players ADD CONSTRAINT PK_PLAYERS PRIMARY KEY (p_number);

ALTER TABLE team ADD CONSTRAINT PK_TEAM PRIMARY KEY (t_name);

ALTER TABLE team ADD CONSTRAINT FK_logins_TO_team_1 FOREIGN KEY (userid)
REFERENCES logins (userid);

ALTER TABLE managers ADD CONSTRAINT PK_MANAGERS PRIMARY KEY (m_number);

ALTER TABLE medical_staff ADD CONSTRAINT PK_MEDICAL_STAFF PRIMARY KEY (d_number);

ALTER TABLE trainers ADD CONSTRAINT PK_TRAINERS PRIMARY KEY (tr_number);

ALTER TABLE players ADD CONSTRAINT FK_team_TO_players_1 FOREIGN KEY (t_name)
REFERENCES team (t_name);

ALTER TABLE managers ADD CONSTRAINT FK_team_TO_managers_1 FOREIGN KEY (t_name)
REFERENCES team (t_name);

ALTER TABLE medical_staff ADD CONSTRAINT FK_team_TO_medical_staff_1 FOREIGN KEY (t_name)
REFERENCES team (t_name);

ALTER TABLE trainers ADD CONSTRAINT FK_team_TO_trainers_1 FOREIGN KEY (t_name)
REFERENCES team (t_name);




