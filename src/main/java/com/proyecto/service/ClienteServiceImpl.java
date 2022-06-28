package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Cliente;
import com.proyecto.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
 
	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> listaCliente() {
		return repository.findAll();
	}

	@Override
	public Cliente insertaActualizarDocente(Cliente obj) {
		
		return repository.save(obj);
	}

	@Override
	public List<Cliente> listaClienteNombreDniUbigeo(String nombres, String apellidos, String fecInicio, String fecFin,
			String dni, String correo, String direccion, int estado, int ubigeo) {
		
		return repository.listaClientePorNombreDniUbigeo(nombres, apellidos, fecInicio, fecFin, dni, correo, direccion, estado, ubigeo);
	}

	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		return repository.save(obj);
	}

	@Override
	public List<Cliente> listaClientePorNombreLike(String nombres) {
		return repository.listaClientePorNombreLike(nombres);
	}

	@Override
	public void eliminaCliente(int idCliente) {
		repository.deleteById(idCliente);
		
	}

	@Override
	public Optional<Cliente> buscaCliente(int idCliente) {
		return repository.findById(idCliente);
		
	}

    
}
