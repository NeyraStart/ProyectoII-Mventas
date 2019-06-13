drop database if exists Mventas;
create database Mventas;
use Mventas;

Create table usuarios(
id int auto_increment primary key,
nombre varchar(25) not null,
apellido varchar (25) not null,
email varchar (45) not null,
clave varchar(150) not null
);

create table almacen(
id int auto_increment primary key,
nombre varchar (25) not null,
direccion varchar (25) not null,
fech_pago char(15),
descripcion varchar (255)
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
idalmacen int not null,
idproveedor int not null,
nombre varchar(50) not null,
idcategoria int not null,
marca varchar (255),
stock int,
prec_compra int,
prec_venta int,
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
descripcion varchar(255)null
);

create table clientes(
id int auto_increment primary key,
datos varchar (150) not null,
telefono char (13) not null,
localidad varchar (255) not null
);

-- Agregando  foreign key a la tabla productos
alter table productos add constraint fk_productosIdCategoria
foreign key(idcategoria) references categorias(id)
on delete cascade;

-- Agregando  foreign key a la tabla productos
alter table productos add constraint fk_productosIdProveedor
foreign key(idproveedor) references proveedores(id)
on delete cascade;

-- Agregando  foreign key a la tabla productos
alter table productos add constraint fk_productosIdAlmacen
foreign key(idalmacen) references almacen(id)
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

