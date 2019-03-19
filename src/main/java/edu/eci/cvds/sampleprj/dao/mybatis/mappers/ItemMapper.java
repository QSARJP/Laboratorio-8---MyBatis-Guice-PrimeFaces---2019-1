package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();  
    
    public List<Item> consultarItemsClientes();
    
    public List<Item> consultarItemsDisponibles();
    
    public Item consultarItem(@Param("iid")int id);
    
    public void insertarItem(@Param("iitem")Item it);

        
}
