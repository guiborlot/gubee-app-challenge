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

insert into market (MarketId, Name)
values (null, 'Imobiliário');

insert into market (MarketId, Name)
values (null, 'Móveis');

insert into product (ProductId, Name, Description, MarketId)
values (null, 'MadeiraMadeira', 'integração com a MadeiraMadeira', 2);

insert into productTechRelation (ProductId, TechId)
values (1, 1);
insert into productTechRelation (ProductId, TechId)
values (1, 2);

select product.ProductId, product.Name, product.Description, market.Name, technology.Name
from product
         left join productTechRelation on product.ProductId = productTechRelation.ProductId
         left join technology on productTechRelation.TechId = technology.TechId
         inner join market on product.MarketId = market.MarketId;