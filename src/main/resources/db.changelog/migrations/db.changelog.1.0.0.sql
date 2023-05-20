--liquibase formatted sql
--changeset taylon.castro:1
CREATE TABLE Procedimento (
    num_procedimento BIGINT PRIMARY KEY,
    descricao varchar(255),
    data_inclusao DATETIME NOT NULL,
    data_atualizacao DATETIME
);

CREATE TABLE Autorizacao (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_procedimento BIGINT  NOT NULL,
    idade INT NOT NULL,
    sexo CHAR(1),
    permitido BOOLEAN NOT NULL,
    data_inclusao DATETIME NOT NULL,
    data_atualizacao DATETIME,
    FOREIGN KEY (id_procedimento) REFERENCES Procedimento(num_procedimento)
);