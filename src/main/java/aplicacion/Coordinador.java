package aplicacion;

import java.util.List;

import dao.MascotaDAO;
import entidades.Mascota;
import vistas.VistaConsultarLista;
import vistas.VistaConsultarMascota;
import vistas.VistaPrincipal;
import vistas.VistaRegistrarMascota;

public class Coordinador {
	private VistaPrincipal vistaPrincipal;
	private VistaRegistrarMascota vistaRegistrar;
	private VistaConsultarMascota vistaConsultarMascota;
	private VistaConsultarLista vistaConsultarLista;
	private MascotaDAO mascotaDAO;

	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public void setVistaRegistrar(VistaRegistrarMascota vistaRegistrar) {
		this.vistaRegistrar = vistaRegistrar;
	}

	public void setVistaConsultarMascota(VistaConsultarMascota vistaConsultarMascota) {
		this.vistaConsultarMascota = vistaConsultarMascota;
	}

	public void setVistaConsultarLista(VistaConsultarLista vistaConsultarLista) {
		this.vistaConsultarLista = vistaConsultarLista;
	}

	public void setMascotaDAO(MascotaDAO mascotaDAO) {
		this.mascotaDAO = mascotaDAO;
	}

	public void mostrarVentanaRegistrar() {
		vistaRegistrar.setVisible(true);
	}

	public void mostrarVentanaConsultarLista() {
		vistaConsultarLista.setVisible(true);
	}

	public void mostrarVentanaConsultar() {
		vistaConsultarMascota.setVisible(true);
	}

	public void mostrarVentanaPrincipal() {
		vistaPrincipal.setVisible(true);
	}

	public String registrarMascota(Mascota mascota) {
		return mascotaDAO.registrarMascota(mascota);

	}
	public Mascota consultarMascota(Long idMascota) {
		return mascotaDAO.consultarMascota(idMascota);
	}
	public List<Mascota> consultarListaMascotas(Long idMascota) {
		return mascotaDAO.consultarListaMascotas();
	}
	public List<Mascota> consultarListaMascotasSexo(String sexo) {
		return mascotaDAO.consultarListaMascotasPorSexo(sexo);
	}
	public String eliminarMascota(Mascota mascota) {
		return mascotaDAO.eliminarMascota(mascota);
	}
	public String ActualizarMascota(Mascota mascota) {
		return mascotaDAO.actualizarMascota(mascota);
	}

	

}
