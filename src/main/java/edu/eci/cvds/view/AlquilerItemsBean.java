package edu.eci.cvds.view;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

@ManagedBean(name = "AlquilerItems")
@ApplicationScoped
public class AlquilerItemsBean extends BasePageBean {
	
	@Inject
	private ServiciosAlquiler serviciosAlquiler;
	
    private Cliente nuevoCliente;
    private Cliente selecCliente;
    private int codigoBarras;
    private int dias;
    private long Costo;
   
    
    public AlquilerItemsBean() {
       
        nuevoCliente =new Cliente();
        selecCliente =null;
        codigoBarras=0;
        Costo=0;
        dias=0;
    }
    
    public List<Cliente> getConsultarClientes() throws ExcepcionServiciosAlquiler {
        return  serviciosAlquiler.consultarClientes();
    }

    public Cliente getSelecCliente() {
        return selecCliente;
    }

    public long getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
    
    public void setSelecCliente(Cliente selecCliente) {
        this.selecCliente = selecCliente;
    }
    public Cliente getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(Cliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }
    
    public void registrarNuevoCliente() throws ExcepcionServiciosAlquiler {
    	serviciosAlquiler.registrarCliente(nuevoCliente);
        
    }
    
    public List<ItemRentado> getConsultarItemsCliente() throws ExcepcionServiciosAlquiler {
        return serviciosAlquiler.consultarItemsCliente(selecCliente.getDocumento());
    }
    public List<Item> getConsultarItemsDisponibles() throws ExcepcionServiciosAlquiler{
        List<Item> s =serviciosAlquiler.consultarItemsDisponibles();
        return s;
    }
    public long getConsultarMultaAlquiler() throws ExcepcionServiciosAlquiler{
        long total=0;
        List<ItemRentado> lista = getConsultarItemsCliente();
        
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size()  ; i++) {
                total += serviciosAlquiler.consultarMultaAlquiler(lista.get(i), java.sql.Date.valueOf(LocalDate.now()));
            }
        }
        return total;
    }
    
    public int getDias() {
        return dias;
    }


    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public void consultarCostoAlquiler() throws ExcepcionServiciosAlquiler {
        if (codigoBarras > 0) {
            Costo = serviciosAlquiler.consultarCostoAlquiler(codigoBarras, dias);
        }
    }

    public void registrarAlquiler() throws ExcepcionServiciosAlquiler{
        if (codigoBarras > 0) {
            Item nuevoItem = serviciosAlquiler.consultarItem(codigoBarras);
            serviciosAlquiler.registrarAlquilerCliente(java.sql.Date.valueOf(LocalDate.now()), selecCliente.getDocumento(), nuevoItem, dias);
            dias=0;
            Costo=0;
            codigoBarras=0;
        }

    }

	
	
	

}
