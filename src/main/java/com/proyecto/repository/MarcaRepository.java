package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{
	

    @Query("select x from Marca x where (?1 is '' or x.nombre like ?1) and (?2 is '' or x.descripcion like ?2) and "
    		+ "(?3 is '' or  x.fechaVigencia like ?3) and (x.estado = ?4) and (?5 is 0 or x.pais.idPais = ?5)")   
    public List<Marca> listaMarcaParametros(String nombre, String descripcion, String fechaVigencia, int estado, int idPais);
    
    

    
    @Query("select x from Marca x where (?1 is '' or x.nombre like ?1)")
    public List<Marca> listaMarcaPorNombreLike(String nombre);
    
    
}
