package com.proyecto.controller;

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

import com.proyecto.entidad.Marca;
import com.proyecto.service.MarcaService;
import com.proyecto.util.AppSettings;


@RestController
@RequestMapping("/url/crudMarca")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class CrudMarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/listaClientePorNombreLike/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Marca>> consulta(@PathVariable("filtro")String filtro){
		List<Marca> salida = null;
		try {
			if (filtro.equals("todos")) {
				salida = marcaService.listaMarcaPorNombreLike("%");
			}else {
				salida = marcaService.listaMarcaPorNombreLike("%"+filtro+"%");
			}
			
		}catch (Exception e) {

			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
	@PostMapping("/registraMarca")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMarca(@RequestBody Marca obj){
		Map<String, Object>salida= new HashMap<>();
		try {
			obj.setIdMarca(0);
			Marca objSalida = marcaService.insertaActualizaMarca(obj);
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
	
	@PutMapping("/actualizaMarca")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaCliente(@RequestBody Marca obj){
		Map<String, Object>salida= new HashMap<>();
		try {
			Marca objSalida = marcaService.insertaActualizaMarca(obj);
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
	

	@DeleteMapping("/eliminaMarca/{idMarca}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaCliente(@PathVariable("idMarca")int idMarca){
		Map<String, Object>salida= new HashMap<>();
		try {
			marcaService.eliminaMarca(idMarca);
			Optional<Marca> optCliente = marcaService.buscaMarca(idMarca);
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
