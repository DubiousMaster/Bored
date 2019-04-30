DROP TABLE IF EXISTS `Activity`;
DROP TABLE IF EXISTS `ActivityType`;

CREATE TABLE `ActivityType` (
`ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`Name` VARCHAR(16) UNIQUE NOT NULL
);

CREATE TABLE `Activity` (
`ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`Activity` VARCHAR(64) UNIQUE NOT NULL,
`Accessibility` DECIMAL(3,2) NOT NULL DEFAULT 0.00,
`Type` INT NOT NULL REFERENCES `ActivityType`(`Id`),
`Participants` INT NOT NULL DEFAULT 1,
`Price` DECIMAL(5,2) NOT NULL,
`Link` VARCHAR(256) NOT NULL,
`ActivityKey` INT(7) UNIQUE NOT NULL
);
