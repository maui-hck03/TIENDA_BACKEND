package com.proyecto.controller;

//Soy Revilla
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Cliente;
import com.proyecto.service.ClienteService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/crudCliente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class CrudClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listaClientePorNombreLike/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Cliente>> consulta(@PathVariable("filtro")String filtro){
		List<Cliente> salida = null;
		try {
			if (filtro.equals("todos")) {
				salida = clienteService.listaClientePorNombreLike("%");
			}else {
				salida = clienteService.listaClientePorNombreLike("%"+filtro+"%");
			}
			
		}catch (Exception e) {

			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
	@PostMapping("/registraCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaCliente(@RequestBody Cliente obj){
		Map<String, Object>salida= new HashMap<>();
		try {
			obj.setIdCliente(0);
			Cliente objSalida = clienteService.insertaActualizaCliente(obj);
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
	
	@PutMapping("/actualizaCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaCliente(@RequestBody Cliente obj){
		Map<String, Object>salida= new HashMap<>();
		try {
			Cliente objSalida = clienteService.insertaActualizaCliente(obj);
			if(objSalida == null) {
				salida.put("mensaje", "No se actualizó , consulte con el administrador.");
				}else {
					salida.put("mensaje", "Se actualizó correctamente.");
				}
		}
			catch (Exception e) {
				e.printStackTrace();
				salida.put("mensaje", "No se actualizó, consulte con el administrador.");
			
		}
		return ResponseEntity.ok(salida);
	}
	

	@DeleteMapping("/eliminaCliente/{idCliente}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaCliente(@PathVariable("idCliente")int idCliente){
		Map<String, Object>salida= new HashMap<>();
		try {
			clienteService.eliminaCliente(idCliente);
			Optional<Cliente> optCliente = clienteService.buscaCliente(idCliente);
			if(optCliente.isEmpty()) {
				salida.put("mensaje", "Se elimino correctamente.");
				}else {
					salida.put("mensaje", "No se elimino correctamente.");
				}
		}
			catch (Exception e) {
				e.printStackTrace();
				salida.put("mensaje", "No se elimino, consulte con el administrador.");
			
		}
		return ResponseEntity.ok(salida);
	}
	
}
