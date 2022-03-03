create table market
(
    MarketId INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(60) NOT NULL,
    PRIMARY KEY (MarketId)
);

create table technology
(
    TechId int not null auto_increment,
    Name varchar(60) not null,
    primary key (TechId)
);

create table product
(
    ProductId   int     not null auto_increment,
    Name        varchar(60) not null,
    Description varchar(200),
    primary key (ProductId),
    MarketId    int references market (MarketId)
);

create table productTechRelation
(
    ProductId int not null,
    TechId    int not null,
    FOREIGN KEY (ProductId) references product (ProductId),
    FOREIGN KEY (TechId) references technology (TechId),
    unique (ProductId, TechId)
);

insert into technology (TechId, Name)
values (1, 'Java');

insert into technology (TechId, Name)
values (2, 'Angular');

insert into technology (TechId, Name)
values (3, 'Kotlin');

insert into technology (TechId, Name)
values (4, 'Redis');

insert into technology (TechId, Name)
values (5, 'Docker');

insert into market (MarketId, Name)
values (1, 'Imobiliário');

insert into market (MarketId, Name)
values (2, 'Móveis');

insert into market (MarketId, Name)
values (3, 'Materiais de Construção');

insert into market (MarketId, Name)
values (4, 'Marketplace');

insert into product (ProductId, Name, Description, MarketId)
values (1, 'MadeiraMadeira', 'integração com a MadeiraMadeira', 2);

insert into product (ProductId, Name, Description, MarketId)
values (2, 'Americanas', 'integração com a Americanas', 4);

insert into product (ProductId, Name, Description, MarketId)
values (3, 'Amazon', 'integração com a Amazon', 4);

insert into product (ProductId, Name, Description, MarketId)
values (4, 'Telhanorte', 'integração com a Telhanorte', 3);

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