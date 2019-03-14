package edu.eci.cvds.sampleprj.dao;


import edu.eci.cvds.samples.entities.Item;

public interface ClienteDAO {

   public void save(Item it) throws PersistenceException;

   public Item load(int id) throws PersistenceException;

}