Create database Mventas;
use Mventas;
-- drop database Mventas;
Create table usuarios(
id int auto_increment primary key,
nombre varchar(25) not null,
apellido varchar (25) not null,
email varchar (45) not null,
clave varchar(150) not null
);

create table tiendas(
id int auto_increment primary key,
cuit varchar (13) not null,
razon_social varchar (30) not null,
direccion varchar (25) not null,
email varchar (45) ,
clave varchar(150) ,
idalmacen int not null

);

create table proveedores(
id int auto_increment primary key,
cuit varchar (13) not null,
razon_social varchar (30) not null,
nombre varchar (125) not null,
telefono varchar (11)
);

create table categorias(
id int auto_increment primary key,
nombre varchar (25) not null
);
create table productos(
item int primary key,
idproveedor int not null,
nombre varchar(25) not null,
idcategoria int not null,
marca varchar (255),
stock int,
prec_compra int,
prec_venta int,
descripcion varchar (50)
);

create table almacen(
id int auto_increment primary key,
nombre varchar (25) not null,
direccion varchar (25) not null,
fech_pago char(15),
itemProducto int not null,
descripcion varchar (255)
);

create table ventas(
id int auto_increment primary key ,
idusuario int not null,
fecha_venta datetime,
idcliente int,
itemProducto int,
cantidad int not null,
descuento int null,
total decimal not null,
descripcion varchar(150)null
);

create table clientes(
id int auto_increment primary key,
datos varchar (150),
telefono char (13),
lugar varchar (255)
);

-- Agregando  foreign key a la tabla productos
alter table productos add constraint fk_productosIdCategoria
foreign key(idcategoria) references categorias(id)
on delete cascade;

-- Agregando  foreign key a la tabla productos
alter table productos add constraint fk_productosIdProveedor
foreign key(idproveedor) references proveedores(id)
on delete cascade;

-- Agregando  foreign key a la tabla ventas
alter table ventas add constraint fk_ventasItemProducto
foreign key(itemProducto) references productos(item)
on delete cascade;

-- Agregando  foreign key a la tabla ventas
alter table ventas add constraint fk_ventasIdUsuario
foreign key(idusuario) references usuarios(id)
on delete cascade;

-- Agregando FK a
alter table ventas add constraint fk_ventasIdCliente
foreign key (idcliente) references clientes(id);

-- Agregando  foreign key a la tabla almacen/productos
alter table almacen add constraint fk_almacenIdProducto
foreign key(itemProducto) references productos(item)
on delete cascade;

-- Agregando  foreign key a la tabla tiendas/Almacen
alter table tiendas add constraint fk_TiendasIdAlmacen
foreign key(idalmacen) references almacen(id)
on delete cascade;

-- USUARIOS
insert into usuarios (nombre,apellido,email,clave) values
('Pepito','Perez','pp_admin@gmail.com',sha('12345')),
('Jaimito','Gonzalez','jg_ventas@gmail.com',sha('123')),
('Laura','Perez','lp_ventas@gmail.com',sha('321')),
('Rosa','Diaz','rd_ventas@gmail.com',sha('456'));
select *from usuarios;

-- PROVEEDORES
insert into proveedores (cuit,razon_social,nombre,telefono) values
('30-95792073-1','THC Electronics','Juan Diaz','1150021716'),
('30-40125014-2','Noga','Carlos cruz','1120058746'),
('30-50212141-1','Inova','Adriano','1140025471');
select *from proveedores;

-- CATEGORIAS
insert into categorias (nombre) values
('Auriculares'),
('Parlantes'),
('Cargadores');
select *from categorias;

-- PRODUCTOS
insert into productos (item,idproveedor,nombre,idcategoria,marca,stock,prec_compra,prec_venta,descripcion) values
(55085,1,'Auricular Samsung HS-330',1,'Samsung',1000,37,55,'Blanco y negro'),
(32045,1,'Auricular LG ',1,'LG',1500,32,45,'Blanco y negro, Manos libres'),
(55080,1,'Auricular Motorola ',1,'Motorola',500,38,55,'Blanco y negro, Manos libres'),
(80051,2,'Parlante PC 2.1  Noga',2,'Noga',10,800,1500,'Negro'),
(15081,3,'Parlante mini P/PC',2,'Inova',100,95,150,'Azul y rosa'),
(115041,1,'Cargador Time 3.1',3,'Time',200,95,115,'Blanco y negro'),
(65090,1,'Cargador Samsung 2.1',3,'Samsung',1000,35,65,'Blanco y negro, 15W'),
(115140,3,'Cargador Inova 3.1',3,'Inova',600,95,115,'Blanco y negro'),
(15091,3,'Cargador Inova 5.1',3,'Inova',300,105,150,'Blanco , negro , azul ,rojo');
select *from productos;

-- ALMACEN
insert into almacen (nombre,direccion,fech_pago,itemProducto,descripcion) values
('Almacen MT','Pasteur 273','01 de cada mes',55085,'Sin descripcion');
select *from almacen;

-- TIENDA
insert into tiendas (cuit,razon_social,direccion,email,clave,idalmacen) values
('30-95178975-3','Center One','Pasteur 273','center_one@mercadoventas.com',sha('COP273'),1);
select *from tiendas;

-- CLIENTES
insert into clientes (datos,telefono,lugar) values
('Elmer curio','1150023719','La plata'),
('Elba lazo','1120023015','Flores'),
('Esteban dido','1130023684','Liniers'),
('Esteban Quito','1125023724','Moreno'),
('Alan brito','1125023790','Santiago del Estero'),
('Armando Iglesias','1196023720','Mendoza'),
('Piter Pan','1170023723','Corrientes');
select *from clientes;

-- VENTAS
insert into ventas (idusuario,fecha_venta,idcliente,itemProducto,cantidad,descuento,total,descripcion) values
(4,'2019-05-15',1,55085,10,0,550,'Garantia de 1 mes'),
(4,'2019-05-15',1,32045,10,0,450,'Garantia de 1 mes'),
(4,'2019-05-15',1,55080,10,0,550,'Garantia de 1 mes'),
(4,'2019-05-15',1,65090,10,0,650,'Garantia de 1 mes'),

(3,'2019-05-30',2,55085,10,0,550,'Garantia de 1 mes'),
(3,'2019-05-30',2,32045,10,0,450,'Garantia de 1 mes'),
(3,'2019-05-30',3,55080,10,0,550,'Garantia de 1 mes'),
(3,'2019-05-30',3,15091,10,0,1500,'Garantia de 1 mes'),

(2,'2019-06-01',4,55085,5,0,275,'Garantia 1 mes'),
(2,'2019-06-01',4,32045,6,0,270,'Garantia 15 dias'),
(2,'2019-06-01',4,55080,5,0,275,'Garantia 15 dias'),
(2,'2019-06-02',5,80051,2,0,3000,'Garantia 15 dias'),
(2,'2019-06-03',6,15081,6,0,900,'Garantia 1 mes'),
(2,'2019-06-03',6,115041,2,0,230,'Garantia 1 mes'),
(2,'2019-06-05',7,65090,20,0,1300,'Garantia 1 mes'),
(2,'2019-06-05',7,115140,6,0,690,'garantia 1 mes'),
(2,'2019-06-05',7,15091,4,0,600,'Garantia 1 mes');
select *from ventas;

-- QUERYS
-- 1. Ordenar productos por precio, de mayora menor
select *
from productos
order by prec_venta desc, nombre asc;

-- 2. Ordenar productos por nombre de A-Z
select *
from productos
order by nombre asc;

-- 3. Ordenar productos por marca
select *
from productos
order by marca asc;

-- 4.  Lista de Proveedores y productos ordenados por categorias
select prov.nombre Proveedores,
       prov.razon_social Razon_Social,
       p.nombre Productos,
	   c.nombre Categoria
from productos p
inner join categorias c
on     p.idcategoria = c.id  
inner join proveedores prov
on     p.idproveedor = prov.id
order by c.nombre ;  

-- 5. Detallado de Ventas por Usuario
select v.id,concat(u.nombre,' ',u.apellido) Usuario, 
			c.datos Cliente,
			p.nombre Producto,
            p.prec_venta Precio,
            v.cantidad Cantidad,
            v.total Total,
            v.fecha_venta Fecha_de_Venta
from 	usuarios u
inner join ventas v on u.id = v.idusuario
inner join productos p on p.item = v.itemProducto
inner join clientes c on c.id= v.idcliente ;

-- 6. Cantidad de Ventas por  usuario
SELECT concat(u.nombre,' ',u.apellido)  Usuario, count(*) 'Cantidad de ventas'
FROM usuarios u  
inner join ventas v on u.id=v.idusuario
group by u.id;

-- 7. Usuario que vendio mas
select concat(u.nombre,' ',u.apellido)  Usuario, count(*) as Total_ventas
from usuarios u
inner join ventas v on u.id = v.idusuario
group by u.id 
limit 1;

-- 7. Cantidad de cada productos vendidos
Select  p.nombre Producto
       ,SUM(v.Cantidad) AS Vendidos
FROM ventas v
inner join productos p on v.itemProducto=p.item
GROUP BY v.itemProducto
Order by SUM(v.Cantidad) desc;

-- 8. Productos que se vendieron mas de 10
Select  p.nombre Producto
       ,SUM(v.Cantidad)  Vendidos
FROM ventas v
inner join productos p on v.itemProducto=p.item
where v.cantidad >=10
GROUP BY v.itemProducto
Order by sum(v.Cantidad) desc ;


-- 9. Producto vendidos menos de 10 
Select  v.itemProducto Item,
		p.nombre Producto		
       ,sum(v.Cantidad)  Vendidos
FROM ventas v
inner join productos p on v.itemProducto=p.item
where v.cantidad<10
GROUP BY v.itemProducto
Order by sum(v.Cantidad) ;

select *from clientes;
select *from productos;
select *from categorias;
select * from proveedores;
select *from ventas;
select *from usuarios

