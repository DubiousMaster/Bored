DROP TABLE IF EXISTS `Activity`;
DROP TABLE IF EXISTS `ActivityType`;

CREATE TABLE `ActivityType` (
`Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`Name` VARCHAR(16) UNIQUE NOT NULL
);

CREATE TABLE `Activity` (
`Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`Name` VARCHAR(64) UNIQUE NOT NULL,
`Accessibility` DECIMAL(3,2) NOT NULL DEFAULT 0.00,
`ActivityTypeId` INT NOT NULL REFERENCES `ActivityType`(`Id`),
`Participants` INT NOT NULL DEFAULT 1,
`Price` DECIMAL(5,2) NOT NULL,
`Link` VARCHAR(256) NOT NULL,
`ActivityKey` INT(7) UNIQUE NOT NULL
);

INSERT INTO `ActivityType`
(`Name`)
VALUES 
('Playground'),
('Night out');

INSERT INTO `Activity`
(`Name`, `Accessibility`, `ActivityTypeId`, `Participants`, `Price`, `Link`, `ActivityKey`)
VALUES
('Go down a slide 20 times.', 0.01, 1, 1, 0.00, '', 5425672),
('Go clubbing.', 0.23, 2, 3, 25.00, 'http://thisisalink.com', 2651632);