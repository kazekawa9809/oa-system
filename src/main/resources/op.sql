DROP TABLE IF EXISTS user;
CREATE TABLE user(
                     userId BIGINT AUTO_INCREMENT PRIMARY KEY,
                     userName VARCHAR(20) ,
                     userTel VARCHAR(11),
                     userEmail VARCHAR(30) ,
                     userPassword VARCHAR(20) ,
                     userDepartId BIGINT ,
                     userPositionId BIGINT,
                     userUpperId BIGINT ,
                     userLevel BIGINT
);

DROP TABLE IF EXISTS admin;
CREATE TABLE admin(
                      adminId INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                      adminName VARCHAR(20) NOT NULL,
                      adminTel VARCHAR(11) NOT NULL,
                      adminEmail VARCHAR(30) NOT NULL,
                      adminPassword VARCHAR(20) DEFAULT 1111
);

DROP TABLE IF EXISTS announce;
CREATE TABLE announce(
                         announceId INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                         announceTitle VARCHAR(50) NOT NULL,
                         announceContent VARCHAR(150) NOT NULL,
                         announceCreateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS depart;
CREATE TABLE depart(
                       departId INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                       departName VARCHAR(20) NOT NULL,
                       departTel VARCHAR(11),
                       departDescription VARCHAR(150),
                       departLocation VARCHAR(50),
                       departUpperId INT UNSIGNED NOT NULL,
                       departManagerId INT UNSIGNED NOT NULL
);

DROP TABLE IF EXISTS meeting;
CREATE TABLE meeting(
                        meetingId INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                        meetingTitle VARCHAR(50) NOT NULL,
                        meetingDescription VARCHAR(150),
                        meetingCreateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
                        meetingStartTime TIMESTAMP NULL
);

DROP TABLE IF EXISTS post;
CREATE TABLE post(
                     postId INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                     postName VARCHAR(20) NOT NULL,
                     postDescription VARCHAR(150)
);


DROP TABLE IF EXISTS createAnnounce;
CREATE TABLE createAnnounce(
                               announceId INT UNSIGNED NOT NULL,
                               creatorId INT UNSIGNED NOT NULL
);

DROP TABLE IF EXISTS createMeeting;
CREATE TABLE createMeeting(
                              meetingId INT UNSIGNED NOT NULL,
                              creatorId INT UNSIGNED NOT NULL,
                              participantId INT UNSIGNED NOT NULL
);
