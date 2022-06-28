package com.proyecto.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Producto;
import com.proyecto.repository.ProductoRepository;

@Service
public class ProductoImpl implements ProductoService {

	@Autowired
	private ProductoRepository prod;

	

	@Override
	public List<Producto> filterProducto(String nombre, int marca, int pais, int estado, String fecha ,int stock) {
		
		return prod.listFilterProducto(nombre, marca, pais, estado, fecha,stock);
	}

	@Override
	public void eliminarProducto(int idProducto) {
	
		 prod.deleteById(idProducto);
	}

	@Override
	public Producto consultar(int idProducto) {
		
		return prod.findById(idProducto).orElse(null);
	}

	

	@Override
	public List<Producto> listaProductoPorNombreLike(String nombre) {
		// TODO Auto-generated method stub
		return prod.listaProductoPorNombreLike(nombre);
	}

	@Override
	public Producto insertaActualizaProducto(Producto obj) {
		// TODO Auto-generated method stub
		return prod.save(obj);
	}

	@Override
	public Optional<Producto> buscaProducto(int idProducto) {
		// TODO Auto-generated method stub
		return prod.findById(idProducto);
	}


}
