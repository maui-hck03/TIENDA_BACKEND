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

import com.proyecto.entidad.Producto;
import com.proyecto.service.ProductoService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/producto")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	

	
	@GetMapping("/listaProductoPorNombreLike/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProductoPorNombreLike(	@PathVariable("filtro")
	String filtro) {
		List<Producto> salida = null;

		try {
			if (filtro.equals("todos")) {
				salida = productoService.listaProductoPorNombreLike("%");
			}else {
				salida = productoService.listaProductoPorNombreLike("%"+filtro+"%");
			}
			
		}catch (Exception e) {

			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
	@PostMapping("/registraProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaCliente(@RequestBody Producto obj){
		Map<String, Object>salida= new HashMap<>();
		try {
			obj.setIdProducto(0);
			Producto objSalida = productoService.insertaActualizaProducto(obj);
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
	
	@PutMapping("/actualizaProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProducto(@RequestBody Producto obj){
		Map<String, Object>salida= new HashMap<>();
		try {
			Producto objSalida = productoService.insertaActualizaProducto(obj);
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
	
	
	@DeleteMapping("/eliminaProducto/{idProducto}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaProducto(@PathVariable("idProducto")int idProducto){
		Map<String, Object>salida= new HashMap<>();
		try {
			productoService.eliminarProducto(idProducto);
			Optional<Producto> optProducto = productoService.buscaProducto(idProducto);
			if(optProducto.isEmpty()) {
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
