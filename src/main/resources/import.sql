CREATE DATABASE JEE;

use JEE;

/*Création tables*/
/*Compte utilisateur*/
CREATE TABLE USERS(
	id int(11) auto_increment not null,
	email varchar(256) not null,
    password varchar(256) not null,
    Active bit not null,
	User_Role varchar(20) not null,
	primary key(id)
);

/*Produits*/
create table Products (
	Code varchar(20) not null,
	Image longblob,
	Name varchar(255) not null,
	primary key (Code)
);

/*Inventaire*/
create table Inventories (
	id int(11) auto_increment not null,
	CreateDate datetime not null,
    creatorID int,
	Etat bit not null,
	primary key (id),
    CONSTRAINT FK_creatorID FOREIGN KEY (creatorID) REFERENCES Users(id)
);

/*Inventaire et produit*/
create table InventoryAndProduct (
	id int(11) auto_increment not null,
    InventoryID int,
	CodeID varchar(20) not null,
    Quantity integer not null,
	primary key (id),
    CONSTRAINT FK_CodeID FOREIGN KEY (CodeID) REFERENCES Products(Code),
    CONSTRAINT FK_InventoryID FOREIGN KEY (InventoryID) REFERENCES Inventories(id)
);

/*Insérer dans tables*/
INSERT INTO USERS(email, password, active, user_role) VALUES("user@test.fr", SHA2("password",256),1, "USER");
INSERT INTO USERS(email, password, active, user_role) VALUES('admin@test.fr', SHA2("admin",256),1, "ADMIN");

insert into products (CODE, NAME) values ('S001', 'crayon');
insert into products (CODE, NAME) values ('S002', 'trousse');
insert into products (CODE, NAME) values ('S003', 'mac');
insert into products (CODE, NAME) values ('S004', 'stylo');
 
insert into Inventories (CreateDate,creatorID,Etat) values (current_date(), 1, 0);
insert into Inventories (CreateDate,creatorID,Etat) values (current_date(), 1, 0);

insert into InventoryAndProduct (InventoryID,CodeID,Quantity) values (1, 'S001', 500);
insert into InventoryAndProduct (InventoryID,CodeID,Quantity) values (1, 'S002', 100);
insert into InventoryAndProduct (InventoryID,CodeID,Quantity) values (1, 'S003', 50);
insert into InventoryAndProduct (InventoryID,CodeID,Quantity) values (2, 'S004', 0);

/*Supprimer tables*/

drop table users;
drop table products;
drop table Inventories;
drop table InventoryAndProduct;

/*Afficher tables*/
select * from users;
select * from products;
select * from Inventories;
select * from InventoryAndProduct;