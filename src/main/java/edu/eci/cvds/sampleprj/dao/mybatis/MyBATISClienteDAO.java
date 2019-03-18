package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.Date;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

public class MyBATISClienteDAO implements ClienteDAO{
	@Inject
	  private ClienteMapper clienteMapper;    
	
	  @Override
	  public void saveCliente(Cliente cli) throws PersistenceException{
	  try{
		  clienteMapper.agregarCliente(cli);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al registrar el cliente "+cli.toString(),e);
	  }        
	
	  }
	
	  @Override
	  public Cliente loadCliente(int documento) throws PersistenceException {
	  try{
	      return clienteMapper.consultarCliente(documento);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el cliente "+documento,e);
	  }
	
	
	  }
	  
	  @Override
	  public void agregarItemRentadoACliente(int documento,int idit,Date fechainicio,Date fechafin) throws PersistenceException {
	  try{
	       clienteMapper.agregarItemRentadoACliente(documento, idit, fechainicio, fechafin);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al agregar el cliente "+documento,e);
	  }
	
	
	  }
}
