package com.formacionbdi.springboot.app.registroClientes.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.registroClientes.model.dao.ClienteDao;
import com.formacionbdi.springboot.app.registroClientes.model.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private ClienteDao clienteDao;
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	public Cliente findBayId(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
    public Cliente save(Cliente cliente) {
		 clienteDao.save(cliente);
		 return cliente;
    }
	
	@Override
    public Cliente update(Cliente cliente) {
		 clienteDao.save(cliente);
		 return cliente;
    }
	
	@Override
    public String delete(Long id) {
		clienteDao.deleteById(id);
		return "OK";
				
    }

}
