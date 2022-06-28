package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer>{
	
	@Query("select distinct x.nombre from Pais x")
	public abstract List<String> listaNombrePais();
	
	@Query("select d from Pais d where d.nombre like ?1" )
	public List<Pais> listaPaisPorNombreLike(String nombre);	
	
}
