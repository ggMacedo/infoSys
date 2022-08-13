/* 

	GABRIEL GOMES MACEDO N6598A4 CC4P33 

	SCRIPT DO BANCO DE DADOS DO SISTEMA INFO SYS

*/

CREATE DATABASE InfoSysDB;

USE InfoSysDB;

CREATE TABLE Clientes(
	Cod INTEGER auto_increment,
	Nome varchar(40),
	CPF varchar(40),
    Fone varchar(60),
    Celular varchar(60),
    Email varchar(60),
	PRIMARY KEY (Cod)
);


CREATE TABLE Produtos(
	CodProd INTEGER auto_increment,
	Descr varchar(40),
	Estoque int,
    Ativo boolean,
    Custo double,
    Venda double,
	PRIMARY KEY (CodProd)
);

CREATE TABLE Tecnicos(
	Cod INTEGER auto_increment,
	Nome varchar(40),
	CPF varchar(40),
    Fone varchar(60),
    Celular varchar(60),
    Email varchar(60),
    Prof varchar(60),
    Setor varchar(60),
	PRIMARY KEY (Cod)
);

CREATE TABLE Servicos(
	CodServ INTEGER auto_increment,
    Nome varchar(40),
	Descr varchar(40),
    Tec varchar(40),
    Val double,
	PRIMARY KEY (CodServ)
);

SELECT * FROM Produtos;

SELECT * FROM Clientes;

SELECT * FROM Tecnicos;

SELECT * FROM Servicos;

TRUNCATE TABLE Clientes;
TRUNCATE TABLE Produtos;
TRUNCATE TABLE Tecnicos;
TRUNCATE TABLE Servicos;

