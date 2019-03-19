package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samples.services.ServiciosAlquiler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   private ClienteDAO clienteDAO;
   private TipoItemDAO tipoItemDAO;

   @Override
   public int valorMultaRetrasoxDia(int itemId) {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.loadCliente((int)docu);
	   
	   }catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar la persona con el documento "+docu,ex);
       }
   }

   @Override 
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.loadItemsClientes();
	   
	   }catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar los items de los clientes",ex);
       }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.loadClientes();
	   
	   }catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar los clientes",ex);
       }
   }
   

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
	   try {
		   return itemDAO.loadItem(id);
	   
	   }catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item con el id"+id,ex);
       }
   }
   //no hacer
   @Override
   public List<Item> consultarItemsDisponibles(){
	   try {
		   return itemDAO.loadItemsDisponibles();
	   
	   }catch (PersistenceException ex) {
           throw new UnsupportedOperationException("Error al consultar los items disponibles",ex);
       }
   }
   
   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
	   try {
		   return tipoItemDAO.loadTipoItem(id);
	   
	   }catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el tipo item con el id"+id,ex);
       }
   }
   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
	   try {
		   return tipoItemDAO.loadTiposItems();
	   }catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el tipo item",ex);
       }
   }
   
   
   
   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }
   //no hacer
   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }
   //no hacer
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   //no hacer
   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}