package com.formacionbdi.springboot.app.registroClientes.model.service;

import java.util.List;

import com.formacionbdi.springboot.app.registroClientes.dto.ClienteRequestDto;
import com.formacionbdi.springboot.app.registroClientes.model.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	public Cliente findBayId(Long id);
	public Cliente save( Cliente  cliente );
	public Cliente update( Cliente  cliente );
	public String delete(Long id);
	public Cliente setterClient (ClienteRequestDto clientedto);

}
