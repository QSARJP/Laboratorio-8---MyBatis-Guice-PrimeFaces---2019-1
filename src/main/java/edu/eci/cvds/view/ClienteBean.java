package edu.eci.cvds.view;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

@SuppressWarnings("deprecation")
@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean extends BasePageBean {
	
	@Inject
	private ServiciosAlquiler serviciosAlquiler;
	
    private Cliente nuevoCliente;
    
   
    
    public ClienteBean() {
       
        nuevoCliente =new Cliente();
        
    }
    
    public List<Cliente> getClientes() throws ExcepcionServiciosAlquiler  {
        return  serviciosAlquiler.consultarClientes();
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
    
}

	
	
	
