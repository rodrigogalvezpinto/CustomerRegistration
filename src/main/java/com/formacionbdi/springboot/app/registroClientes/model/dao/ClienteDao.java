package com.formacionbdi.springboot.app.registroClientes.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.formacionbdi.springboot.app.registroClientes.model.entity.Cliente;


public interface ClienteDao extends JpaRepository<Cliente, Long>{

}
