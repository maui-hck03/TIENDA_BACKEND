package com.proyecto.repository;


import org.springframework.stereotype.Repository;

import com.proyecto.entidad.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query ;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{

 	@Query("select p from Producto p where ( ?1 is '' or p.nombre like ?1) and ( ?2 is -1 or p.marca.idMarca = ?2) and (?3 is -1 or p.pais.idPais = ?3) and (p.estado = ?4)  and (?5 is null or p.fechaVigencia = ?5)  and (?6 is -1 or p.stock = ?6)")
	 List<Producto> listFilterProducto(String nombre, int marca, int pais, int estado, String fecha,int stock);

	@Query("select p from Producto p where ( ?1 is '' or p.nombre like ?1)")
	 List<Producto> listaProductoPorNombreLike(String nombre);

	
}
