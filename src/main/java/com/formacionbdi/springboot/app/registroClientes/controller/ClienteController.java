package com.formacionbdi.springboot.app.registroClientes.controller;

import java.util.*;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.formacionbdi.springboot.app.registroClientes.dto.ClienteRequestDto;
import com.formacionbdi.springboot.app.registroClientes.dto.ClienteResponseDto;
import com.formacionbdi.springboot.app.registroClientes.model.entity.Cliente;
import com.formacionbdi.springboot.app.registroClientes.model.service.IClienteService;

@RestController
public class ClienteController {

	private Map<String, Object> response;

	private final IClienteService clienteService;

	public ClienteController(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/listall")
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
	
	@GetMapping("/viewClient/{id}")
	public ResponseEntity<?> detalle(@PathVariable Long id) { 
		response = new HashMap<>();
		Cliente cliente = clienteService.findBayId(id);

		if(cliente != null) {
			response.put("cliente",cliente);
		}else{	 
			response.put("Mesanje","No se encontro el empleado con Id: ".concat(id.toString()));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ClienteRequestDto clienteRequest) {
		response = new HashMap<>();
		try{		
			Long id = clienteService.save(clienteService.setterClient(clienteRequest)).getId();
			response.put("Mesanje","Creación exitosa de empleado con Id: ".concat(id.toString()));
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}catch (DataAccessException e){
			response.put("Mesanje","Ocurrio un error al crear al empleado ");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody ClienteRequestDto clienteRequest,@PathVariable Long id) {
		response = new HashMap<>();
		Cliente cliente = new Cliente();	
		try {
			
			if (clienteService.findBayId(id) != null) {
				cliente = clienteService.findBayId(id);
				Long idCliente = cliente.getId();
				
				cliente = clienteService.setterClient(clienteRequest);
				
				cliente.setId(idCliente);
				clienteService.save(cliente);
				response.put("Mesanje","Actualización exitosa de empleado con Id: ".concat(cliente.getId().toString()));
				return new ResponseEntity<>(response, HttpStatus.OK);

			}else {
				response.put("Mesanje","No se encontro el empleado con Id: ".concat(id.toString()));
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		}catch (DataAccessException e){
			response.put("Mesanje","Ocurrio un error al actualizar al empleado con Id: ".concat(id.toString()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
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
