Create database Mventas;
use Mventas;
-- drop database Mventas;
Create table usuarios(
id int auto_increment primary key,
nombre varchar(25) not null,
apellido varchar (25) not null,
email varchar (25) not null,
clave varchar(20) not null
);

create table tiendas(
id int auto_increment primary key,
cuit varchar (13) not null,
razon_social varchar (30) not null,
direccion varchar (25) not null,
email varchar (25) ,
clave varchar(20) ,
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
stock int,
prec_venta int,
descripcion varchar (50)
);

create table almacen(
id int auto_increment primary key,
nombre varchar (25) not null,
direccion varchar (25) not null,
fech_pago date,
itemProducto int not null,
descripcion varchar (255)
);

create table ventas(
id int auto_increment primary key ,
idusuario int not null,
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


