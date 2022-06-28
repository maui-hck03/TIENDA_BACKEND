package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entidad.Producto;

public interface  ProductoService {
	
	 
	 
	 public abstract List<Producto> filterProducto(String nombre,int marca,int pais,int estado,String fecha ,int stock);
	 
	 public abstract void eliminarProducto(int idProducto);
	 public abstract Optional<Producto> buscaProducto(int idProducto);
	 public abstract Producto consultar(int id);
	 public abstract List<Producto> listaProductoPorNombreLike(String nombre);
	 public abstract Producto insertaActualizaProducto(Producto obj);
	 
}
