CREATE TABLE tb_user
(
    id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    email  VARCHAR(255) NOT NULL,
    source VARCHAR(50)  NOT NULL
);
