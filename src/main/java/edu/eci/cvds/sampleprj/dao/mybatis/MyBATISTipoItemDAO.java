package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;


public class MyBATISTipoItemDAO implements TipoItemDAO{
	 @Inject
	  private TipoItemMapper tipoItemMapper;    
	
	  @Override
	  public List<TipoItem> loadTiposItems() throws PersistenceException{
	  try{
		  return tipoItemMapper.getTiposItems();
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el tipo item",e);
	  }        
	
	  }
	  @Override
	  public TipoItem loadTipoItem(int id) throws PersistenceException{
	  try{
		  return tipoItemMapper.getTipoItem(id);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el tipo item con el id"+id,e);
	  }        
	
	  }
	
	  

 }

