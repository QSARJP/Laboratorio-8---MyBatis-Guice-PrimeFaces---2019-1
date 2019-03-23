package edu.eci.cvds.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

@SuppressWarnings("deprecation")
@ManagedBean(name = "alquilerBean")
@RequestScoped
public class AlquilerItemBean extends BasePageBean{
	
	@Inject
	private ServiciosAlquiler serviciosAlquiler;
	
	
    
    @ManagedProperty(value = "#{param.documento}")
	private Integer documento;
    
    
    private int codigoBarras = 0;



	public int getDias() {
		return dias;
	}


	public void setDias(int dias) {
		this.dias = dias;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public int getCodigoBarras() {
		return codigoBarras;
	}

	private int dias=0;
    private int costo=0;
    
    public Integer getDocumento() {
		return documento;
	}


	public void setDocumento(Integer documento) {
		this.documento = documento;
	}


	
    public List<ItemRentado> getItems() throws ExcepcionServiciosAlquiler {
        return serviciosAlquiler.consultarItemsCliente(documento);
    }
    public List<Item> getItemsd() throws ExcepcionServiciosAlquiler{
        List<Item> s =serviciosAlquiler.consultarItemsDisponibles();
        return s;
    }
    public long getConsultarMultaAlquiler() throws ExcepcionServiciosAlquiler{
        long total=0;
        List<ItemRentado> lista = getItems();
        
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size()  ; i++) {
                total += serviciosAlquiler.consultarMultaAlquiler(lista.get(i), java.sql.Date.valueOf(LocalDate.now()));
            }
        }
        return total;
    }
    

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public void consultarCostoAlquiler() throws ExcepcionServiciosAlquiler {
        if (codigoBarras > 0) {
            costo = (int)serviciosAlquiler.consultarCostoAlquiler(codigoBarras, dias);
        }
    }

    public void registrarAlquiler() throws ExcepcionServiciosAlquiler{
        if (codigoBarras > 0) {
            Item nuevoItem = serviciosAlquiler.consultarItem(codigoBarras);
            serviciosAlquiler.registrarAlquilerCliente(java.sql.Date.valueOf(LocalDate.now()), documento, nuevoItem, dias);
            dias=0;
            costo=0;
            codigoBarras=0;
        }

    

    }
}
