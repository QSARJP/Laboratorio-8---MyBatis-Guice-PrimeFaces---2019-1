package edu.eci.cvds.sampleprj.dao;


import java.util.List;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {

	public TipoItem loadTipoItem(int id) throws PersistenceException;
	
	public List<TipoItem> loadTiposItems() throws PersistenceException;
	

}