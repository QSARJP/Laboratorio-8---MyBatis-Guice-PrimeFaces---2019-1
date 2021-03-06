/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();

       
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
//        System.out.println(cm.consultarClientes());
//        System.out.println(cm.consultarCliente(123456));
        
//        cm.agregarItemRentadoACliente(123456, 20, new Date(10022019), new Date(10032019));
        
        ItemMapper im=sqlss.getMapper(ItemMapper.class);
//        System.out.println(im.consultarItems());
//        System.out.println(im.consultarItem(1));
//        im.insertarItem(new Item(new TipoItem(1, "VideJuego"), 40, "insertprueba1", "The best of the best", new Date(10022019), 10000, "Digital", "prueba1"));
//        im.insertarItem(new Item(new TipoItem(1, "VideJuego"), 80, "insertprueba2", "The best of the best2", new Date(10022019), 20000, "Digital", "prueba2"));
       
        
        TipoItemMapper tm=sqlss.getMapper(TipoItemMapper.class);
//        System.out.println(tm.getTiposItems());
//        System.out.println(tm.getTipoItem(1));
////        
        
        ItemRentadoMapper irm=sqlss.getMapper(ItemRentadoMapper.class);
//        System.out.println(irm.getItemsRentados());
        
        
        sqlss.commit();
        
        
        sqlss.close();

        
        
    }



}