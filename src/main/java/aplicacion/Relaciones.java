package aplicacion;

import dao.MascotaDAO;
import vistas.VistaConsultarLista;
import vistas.VistaConsultarMascota;
import vistas.VistaPrincipal;
import vistas.VistaRegistrarMascota;

public class Relaciones {
public Relaciones() {
	VistaPrincipal ventanaPrincipal=new VistaPrincipal();
	VistaRegistrarMascota ventanaRegistrar = new VistaRegistrarMascota();
	VistaConsultarLista ventanaconsultarLista = new VistaConsultarLista();
	VistaConsultarMascota ventanaConsultar = new VistaConsultarMascota();
	
	

	 MascotaDAO miMascotaDAO = new MascotaDAO();
     Coordinador miCoordinador = new Coordinador();
     
     
     
     ventanaPrincipal.setMiCoordinador(miCoordinador);
     ventanaRegistrar.setMiCoordinador(miCoordinador);
     ventanaConsultar.setMicoordinador(miCoordinador);
     ventanaconsultarLista.setMicoordinador(miCoordinador);
     
     miMascotaDAO.setMiCoordinador(miCoordinador);
     
     
     miCoordinador.setVistaPrincipal(ventanaPrincipal);
     miCoordinador.setVistaRegistrar(ventanaRegistrar);
     miCoordinador.setVistaConsultarLista(ventanaconsultarLista);
     miCoordinador.setVistaConsultarMascota(ventanaConsultar);
     
     
     miCoordinador.setMascotaDAO(miMascotaDAO);
     
     
     miCoordinador.mostrarVentanaPrincipal();;
}
}
