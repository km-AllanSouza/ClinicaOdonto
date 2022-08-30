CREATE TABLE IF NOT EXISTS PACIENTES (
idPaciente int auto_increment primary key,
nome varchar(100) NOT NULL,
sobrenome varchar(100) NOT NULL,
endereco varchar(100) NOT NULL,
cpf varchar(100) NOT NULL,
dataCadastro date NOT NULL,

CONSTRAINT FK_idEndereco FOREIGN KEY (endereco) REFERENCES ENDERECOS (idEndereco)
);

CREATE TABLE IF NOT EXISTS DENTISTAS (
idDentista INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
sobrenome VARCHAR(100) NOT NULL,
matricula VARCHAR(10) NOT NULL);

CREATE TABLE IF NOT EXISTS ENDERECOS (
idEndereco INT AUTO_INCREMENT PRIMARY KEY,
estado VARCHAR(2),
cidade VARCHAR(50),
cep VARCHAR(8),
rua VARCHAR(50),
numero VARCHAR(10)
);

