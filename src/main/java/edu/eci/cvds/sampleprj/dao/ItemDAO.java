package edu.eci.cvds.sampleprj.dao;



import java.util.List;

import edu.eci.cvds.samples.entities.Item;


public interface ItemDAO {
	
	public Item loadItem(int id) throws PersistenceException;
	
	public List<Item> loadItemsDisponibles() throws PersistenceException;

   public void save(Item it) throws PersistenceException;
   
   public int valorMultaRetrasoxDia(int id) throws PersistenceException;
   
   public long consultarCostoAlquiler(int iditem, int numdias) throws PersistenceException;

}