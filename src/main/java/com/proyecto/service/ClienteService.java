package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entidad.Cliente;

public interface ClienteService{

	public abstract List<Cliente> listaCliente();
	
	public abstract Cliente insertaActualizarDocente(Cliente obj);
	
	public abstract List<Cliente> listaClienteNombreDniUbigeo(String nombres, String apellidos, String fecInicio, String fecFin, String dni,String correo,String direccion,int estado,int ubigeo  );
	
	public abstract Cliente insertaActualizaCliente(Cliente obj);
	
	public abstract List<Cliente> listaClientePorNombreLike(String nombres);
    
	public abstract void eliminaCliente(int idCliente);
	
	public abstract Optional<Cliente> buscaCliente(int idCliente);
}
