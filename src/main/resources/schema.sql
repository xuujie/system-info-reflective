CREATE TABLE CLIENT_INFO (
  CLIENT_INFO_ID char(32),
  CLIENT_NAME varchar(100),
  CLIENT_IP varchar(50),
  ACCESS_TIME timestamp,
  constraint pk_ciid primary key (CLIENT_INFO_ID)
);