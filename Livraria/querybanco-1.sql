create database livraria;
use livraria;

create table Livro(
id_livro	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
titulo	varchar(200) not null,
autor	varchar(100) not null,
resumo	varchar(500),
sumario varchar(500),
editora	varchar(100) not null,
qtdpagina	integer not null,
formatolivro	varchar(100),
datapublicao	date,
ISBN	integer not null,
categoria	varchar(50),
precovenda	decimal(5,2) not null,
precocusto	decimal(5,2),
margelucro	decimal(5,2),
qtdestoque	integer
);

create table Carrinho(
id_carrinho int not null auto_increment,
id_carrinho_pessoa	int not null,
id_pessoa	int not null ,
id_livro	int not null,
preco_livro	decimal(5,2) not null,
preco_frete	decimal(5,2),
total_compra	decimal(5,2) not null,
quantidade_livros	int not null default 1,
primary key (id_carrinho, id_pessoa)
);

alter table Carrinho add constraint pessoa_carrinho_fk foreign key(id_pessoa) references Pessoa (id_pessoa);
alter table Carrinho add constraint livro_carrinho_fk foreign key(id_livro) references Livro (id_livro);

create table Pessoa(
id_pessoa	int auto_increment,
nome	varchar(200),
apelido	varchar(100),
primary key(id_pessoa)
);

insert into Pessoa(nome,apelido) values ('Luiz Miguel', 'Luiz');
insert into livro(titulo,autor,resumo,editora,qtdpagina,formatolivro,ISBN,categoria,precovenda,precocusto,margelucro,qtdestoque) values('Star Wars','George Lucas','A long time ago.. in a galaxy far far away..'
,'Darkside Books',400,'Capa Dura',12345678,'Ficção',50,30,20,10);
insert into livro(titulo,autor,resumo,editora,qtdpagina,formatolivro,ISBN,categoria,precovenda,precocusto,margelucro,qtdestoque) values('Star Wars II','George Lucas','A long time ago.. in a galaxy far far away..'
,'Darkside Books',500,'Capa Dura',87654321,'Ficção',50,30,20,10);
insert into carrinho(id_carrinho_pessoa,id_pessoa,id_livro,preco_livro,preco_frete,total_compra,quantidade_livros) values (1001,1,2,50,10,60,1);
insert into carrinho(id_carrinho_pessoa,id_pessoa,id_livro,preco_livro,preco_frete,total_compra,quantidade_livros) values (1001,1,1,50,10,60,1);

select * from livro;
select * from carrinho;

drop table pessoa;
drop table carrinho;
drop table livro;


