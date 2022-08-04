# ExercicioCRUDJava

Tabela Livro
create table livro(
id serial primary key,
titulo varchar(50),
autor varchar(50),
anoPublicacao int,
editora varchar(50),
volume int
)

select * from livro
