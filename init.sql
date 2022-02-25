create database gubeeapi;
use gubeeapi;

create table market
(
    MarketId int(11)     not null auto_increment,
    Name     varchar(60) not null,
    primary key (MarketId)
);

create table technology
(
    TechId int(11)     not null auto_increment,
    Name   varchar(60) not null,
    primary key (TechId)
);

create table product
(
    ProductId   int(11)     not null auto_increment,
    Name        varchar(60) not null,
    Description varchar(200),
    primary key (ProductId),
    MarketId    int(11) references market (MarketId)
);

create table productTechRelation
(
    ProductId int(11) not null,
    TechId    int(11) not null,
    FOREIGN KEY (ProductId) references product (ProductId),
    FOREIGN KEY (TechId) references technology (TechId),
    unique (ProductId, TechId)
);

insert into technology (TechId, Name)
values (null, 'Java');

insert into technology (TechId, Name)
values (null, 'Angular');

insert into technology (TechId, Name)
values (null, 'Kotlin');

insert into technology (TechId, Name)
values (null, 'Redis');

insert into technology (TechId, Name)
values (null, 'Docker');

insert into market (MarketId, Name)
values (null, 'Imobiliário');

insert into market (MarketId, Name)
values (null, 'Móveis');

insert into market (MarketId, Name)
values (null, 'Materiais de Construção');

insert into market (MarketId, Name)
values (null, 'Marketplace');

insert into product (ProductId, Name, Description, MarketId)
values (null, 'MadeiraMadeira', 'integração com a MadeiraMadeira', 2);

insert into product (ProductId, Name, Description, MarketId)
values (null, 'Americanas', 'integração com a Americanas', 4);

insert into product (ProductId, Name, Description, MarketId)
values (null, 'Amazon', 'integração com a Amazon', 4);

insert into product (ProductId, Name, Description, MarketId)
values (null, 'Telhanorte', 'integração com a Telhanorte', 3);

insert into productTechRelation (ProductId, TechId)
values (1, 1);
insert into productTechRelation (ProductId, TechId)
values (1, 2);
insert into productTechRelation (ProductId, TechId)
values (2, 1);
insert into productTechRelation (ProductId, TechId)
values (2, 2);
insert into productTechRelation (ProductId, TechId)
values (2, 3);
insert into productTechRelation (ProductId, TechId)
values (2, 4);
insert into productTechRelation (ProductId, TechId)
values (2, 5);
insert into productTechRelation (ProductId, TechId)
values (3, 3);
insert into productTechRelation (ProductId, TechId)
values (3, 4);
insert into productTechRelation (ProductId, TechId)
values (3, 5);
insert into productTechRelation (ProductId, TechId)
values (4, 3);
insert into productTechRelation (ProductId, TechId)
values (4, 2);