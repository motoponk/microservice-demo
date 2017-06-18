CREATE TABLE IF NOT EXISTS profile (
  username          VARCHAR(32) NOT NULL,
  firstname         VARCHAR(16) NOT NULL,
  lastname          VARCHAR(16) NOT NULL,
  bio               VARCHAR(256) NOT NULL,
  PRIMARY KEY(username)) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS profile_avatar (
  id                INT(11) NOT NULL AUTO_INCREMENT,
  username          VARCHAR(32) UNIQUE NOT NULL,
  avatar            BINARY LARGE OBJECT(1M),
  mime              VARCHAR(16) NOT NULL,
  PRIMARY KEY(id)) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE profile_avatar
  ADD FOREIGN KEY (username)
  REFERENCES profile(username);