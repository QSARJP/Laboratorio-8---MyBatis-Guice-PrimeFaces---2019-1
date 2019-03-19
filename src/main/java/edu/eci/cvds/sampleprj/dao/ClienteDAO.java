package edu.eci.cvds.sampleprj.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ClienteDAO {
	
	public List<ItemRentado> loadItemsClientes() throws PersistenceException ;

   public void saveCliente(Cliente cli) throws PersistenceException;

   public Cliente loadCliente(int documento) throws PersistenceException;
   
   public List<Cliente> loadClientes() throws PersistenceException;
   
   public void agregarItemRentadoACliente(int documento,int idit,Date fechainicio,Date fechafin) throws PersistenceException;
   

}