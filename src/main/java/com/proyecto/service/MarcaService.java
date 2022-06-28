package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entidad.Marca;

public interface MarcaService {

	public abstract List<Marca> listaMarca();
	
	// Insertar Marca

	public abstract void eliminaMarca(int idMarca);	
	public abstract List<Marca> listaMarcaParametros(String nombre, String descripcion, String fechaVigencia, int estado, int idPais);
	public abstract Optional<Marca> buscaMarca(int idMarca);
	
	public abstract List<Marca> listaMarcaPorNombreLike (String nombre);
	
	public abstract Marca insertaActualizaMarca(Marca obj);
	
	

}
