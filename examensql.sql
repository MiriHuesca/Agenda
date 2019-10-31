use examenCel;
delimiter //
create procedure insertarDatos(
in modelop varchar(45), in colorp varchar(10),
in camarasp varchar(45), in procesadorp double, in memoriap int,
in capacidadp double, in internap double,
in compañiap varchar(45),in tamañop double,
in dimensionesp varchar(45), in preciop double,in descripcionp varchar(45))
begin
insert into productos(modelo,color,camaras,procesador,memoria,
capacidad,interna,
compañia,tamaño,dimensiones,precio,descripcion)
values (modelop,colorp,camarasp,procesadorp,memoriap,capacidadp,
internap,
compañiap,tamañop,dimensionesp,preciop,descripcionp);
end //
delimiter ;
drop procedure insertarDatos;

delimiter //
create procedure select_all_productos()
begin 
SELECT * FROM productos order by modelo desc;
end //
delimiter ;
call select_all_productos;

delimiter //
create procedure select_a_producto(in id int)
begin 
SELECT * FROM productos where idproductos=id;
end //
delimiter ;



