package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Cliente;
import com.proyecto.service.ClienteService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/cliente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ClienteController {
	
	//Soy Revilla

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>> listaCliente(){
		List<Cliente> lista= clienteService.listaCliente();
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaCliente(@RequestBody Cliente obj){
		Map<String, Object>salida= new HashMap<>();
		try {
			obj.setEstado(1);
			obj.setFechaRegistro(new Date());
			Cliente objSalida =clienteService.insertaActualizarDocente(obj);
			if(objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
				}else {
					salida.put("mensaje", "Se registró correctamente.");
				}
		}
			catch (Exception e) {
				e.printStackTrace();
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/listaClienteConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaClienteNombreDniUbigeo(
			@RequestParam(name = "nombres", required = false, defaultValue = "") String nombres,
			@RequestParam(name = "apellidos", required = false, defaultValue = "") String apellidos,
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "") String fechaFin,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "correo", required = false, defaultValue = "") String correo,
			@RequestParam(name = "direccion", required = false, defaultValue = "") String direccion,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado ,
			@RequestParam(name = "idUbigeo", required = false, defaultValue = "-1") int idUbigeo)
			{
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Cliente> lista = clienteService.listaClienteNombreDniUbigeo("%"+nombres+"%", apellidos, fechaInicio, fechaFin, dni, correo, direccion, estado, idUbigeo);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se filtro, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
}
