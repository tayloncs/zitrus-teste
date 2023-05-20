--liquibase formatted sql
--changeset taylon.castro:1
CREATE TABLE Procedimento (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    num_procedimento INT UNIQUE,
    descricao varchar(255),
    data_inclusao DATETIME NOT NULL,
    data_atualizacao DATETIME,
    CONSTRAINT PK_Procedimento PRIMARY KEY (id)
);

CREATE TABLE Autorizacao (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_procedimento BIGINT UNSIGNED NOT NULL,
    idade INT,
    sexo CHAR(1),
    permitido BOOL,
    data_inclusao DATETIME NOT NULL,
    data_atualizacao DATETIME,
    FOREIGN KEY (id_procedimento) REFERENCES Procedimento(id)
);