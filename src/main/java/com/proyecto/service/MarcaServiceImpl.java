package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Marca;
import com.proyecto.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository repository;

	@Override
	public List<Marca> listaMarca() {
		return repository.findAll();
	}

	
	@Override
	public List<Marca> listaMarcaParametros(String nombre, String descripcion, String fechaVigencia,int estado, int idPais) {
		return repository.listaMarcaParametros(nombre, descripcion, fechaVigencia, estado, idPais);
	}



	

	@Override
	public Optional<Marca> buscaMarca(int id) {
		return repository.findById(id);
	}

	
	

	@Override
	public void eliminaMarca(int idMarca) {
		repository.deleteById(idMarca);
		
	}

	@Override
	public List<Marca> listaMarcaPorNombreLike(String nombre) {
		// TODO Auto-generated method stub
		return repository.listaMarcaPorNombreLike(nombre);
	}

	@Override
	public Marca insertaActualizaMarca(Marca obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}


	

	

}
