package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Pais;

public interface PaisService {

	public abstract List<Pais> listaPais();
	public abstract List<String> listaNombrePais();
	public abstract List<Pais> listaPaisPorNombreLike(String nombre);

	
}
