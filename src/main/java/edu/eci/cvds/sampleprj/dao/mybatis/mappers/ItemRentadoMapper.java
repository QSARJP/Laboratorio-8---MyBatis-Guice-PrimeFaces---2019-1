package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.ItemRentado;

/**
 *
 * @author 2106913
 */
public interface ItemRentadoMapper {
    

    public List<ItemRentado> getItemsRentados();
    
    
   
}