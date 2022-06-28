package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entidad.Cliente;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query("select x from Cliente x where (?1 is '' or x.nombres like ?1) and (?2 is '' or x.apellidos = ?2) and (?3 is '' or ?4 is '' or x.fechaNacimiento between ?3  and ?4) and (?5 is '' or x.dni = ?5) and (?6 is '' or x.correo = ?6) and (?7 is '' or x.direccion =?7) and (x.estado = ?8) and (?9 is -1 or x.ubigeo.idUbigeo = ?9)")         
	public List<Cliente> listaClientePorNombreDniUbigeo(String nombres,String apellidos, String fecInicio, String fecFin, String dni, String correo, String direccion, int estado,int idUbigeo );
	
	@Query("select d from Cliente d where d.nombres like ?1" )
	public List<Cliente> listaClientePorNombreLike(String nombres);
}
