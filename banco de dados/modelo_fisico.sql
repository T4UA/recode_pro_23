CREATE DATABASE agencia_viagem;

USE agencia_viagem;

CREATE TABLE passagem 
( 
 id_passagem INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 dataIda DATE NOT NULL,
 dataVolta VARCHAR(10) NOT NULL, 
 origem VARCHAR(40) NOT NULL, 
 destino VARCHAR(50) NOT NULL,    
 assento VARCHAR(5) NOT NULL,  
 horario VARCHAR(10) NOT NULL,
 portao INT NOT NULL,
 idCliente INT,  
 idVoo INT); 

CREATE TABLE clientes 
( 
 id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,  
 nome VARCHAR(40) NOT NULL,  
 email VARCHAR(50) NOT NULL,  
 numeroCartao BIGINT NOT NULL  
); 

CREATE TABLE voo 
( 
 id_voo INT PRIMARY KEY AUTO_INCREMENT,  
 empresa VARCHAR(30) NOT NULL,  
 numeroAssentos INT NOT NULL 
); 

ALTER TABLE passagem ADD FOREIGN KEY(idCliente) REFERENCES clientes (id);
ALTER TABLE passagem ADD FOREIGN KEY(idVoo) REFERENCES voo (id_voo);
