package edu.eci.cvds.sampleprj.dao;


import java.util.Date;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

public interface ClienteDAO {

   public void saveCliente(Cliente cli) throws PersistenceException;

   public Cliente loadCliente(int documento) throws PersistenceException;
   
   public void agregarItemRentadoACliente(int documento,int idit,Date fechainicio,Date fechafin) throws PersistenceException;
   

}