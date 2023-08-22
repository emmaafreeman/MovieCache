CREATE TABLE `movies` (
    `title` varchar(255) DEFAULT NULL,
    `year` varchar(255) DEFAULT NULL,
    `genre` varchar(255) DEFAULT NULL,
    `director` varchar(255) DEFAULT NULL,
    `plot` varchar(255) DEFAULT NULL,
    `id` int NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;