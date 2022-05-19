package com.formacionbdi.springboot.app.registroClientes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.registroClientes.model.entity.Cliente;
import com.formacionbdi.springboot.app.registroClientes.model.service.IClienteService;

@RestController
public class ClienteController {

	Map<String, Object> response;
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listall")
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public ResponseEntity<?> detalle(@PathVariable Long id) { 
		response = new HashMap<>();
		Cliente cliente = new Cliente();
		cliente = clienteService.findBayId(id);
		
		if(cliente != null) {
			response.put("cliente",cliente);
		}else{	 
			response.put("Mesanje","No se encontro el empleado con Id: ".concat(id.toString()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {
		response = new HashMap<>();
		try{
			clienteService.save(cliente);
			response.put("Mesanje","Creación exitosa de empleado con Id: ".concat(cliente.getId().toString()));
			
		}catch (DataAccessException e){
			response.put("Mesanje","Ocurrio un error al crear al empleado ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Cliente cliente) {
		response = new HashMap<>();
		Cliente client = clienteService.findBayId(cliente.getId());	
		
		try {
			if (client != null) {
				clienteService.save(cliente);
				response.put("Mesanje","Actualización exitosa de empleado con Id: ".concat(cliente.getId().toString()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

			}else {
				response.put("Mesanje","No se encontro el empleado con Id: ".concat(cliente.getId().toString()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		}catch (DataAccessException e){
			response.put("Mesanje","Ocurrio un error al actualizar al empleado con Id: ".concat(cliente.getId().toString()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
    }
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> delete(@PathVariable Long id) { 
//		response = new HashMap<>();
//		try {
//			clienteService.delete(id);
//			response.put("Mesanje","Se elimino correctamente el empleado con Id: ".concat(id.toString()));
//		}catch (DataAccessException e){
//			response.put("Mesanje","Ocurrio un error al eliminar al empleado con Id: ".concat(id.toString()));
//			response.put("Error",e.getMostSpecificCause().getMessage());
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//		
//	}
}
