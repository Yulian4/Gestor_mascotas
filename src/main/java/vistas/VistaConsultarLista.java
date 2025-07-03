package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import aplicacion.Coordinador;
import entidades.Mascota;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaConsultarLista extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel lblTitulo;
	private JButton btnConsultarLista, btnConsultarPorSexo;
	private JTable tablaMascotas;
	private JScrollPane scrollTabla;
	private DefaultTableModel modeloTabla;
	private Coordinador micoordinador;
	private JComboBox<String> comboSexo;

	public VistaConsultarLista() {
		setTitle("Consultar Lista de Mascotas");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		iniciarComponentes();
	}

	private void iniciarComponentes() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		lblTitulo = new JLabel("Consultar Listas");
		lblTitulo.setFont(new java.awt.Font("Montserrat", java.awt.Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(200, 10, 200, 30);
		panel.add(lblTitulo);

		btnConsultarLista = new JButton("Consultar Lista de Mascotas");
		btnConsultarLista.setBounds(50, 60, 220, 30);
		btnConsultarLista.addActionListener(this);
		panel.add(btnConsultarLista);
		btnConsultarLista.addActionListener(this);

		btnConsultarPorSexo = new JButton("Consultar Lista por Sexo");
		btnConsultarPorSexo.setBounds(320, 60, 220, 30);
		btnConsultarPorSexo.addActionListener(this);
		panel.add(btnConsultarPorSexo);
		btnConsultarPorSexo.addActionListener(this);

		comboSexo = new JComboBox<>(new String[] { "Hembra", "Macho" });
		comboSexo.setBounds(230, 20, 120, 25);
		panel.add(comboSexo);

		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(new String[] { "ID", "Nombre", "Raza", "Color", "Sexo" });

		tablaMascotas = new JTable(modeloTabla);
		tablaMascotas.setEnabled(false);

		scrollTabla = new JScrollPane(tablaMascotas);
		scrollTabla.setBounds(30, 110, 530, 230);
		panel.add(scrollTabla);

		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarLista) {
			consultarLista();
		}
		if (e.getSource() == btnConsultarPorSexo) {
			consultarListaPorSexo();
		}
	}

	public void setMicoordinador(Coordinador micoordinador) {
		this.micoordinador = micoordinador;
	}

	private void consultarListaPorSexo() {

		String sexoSeleccionado = comboSexo.getSelectedItem().toString();
		List<Mascota> listaMascotas = micoordinador.consultarListaMascotasSexo(sexoSeleccionado);
		if (listaMascotas.size() > 0) {
			llenarTabla(listaMascotas);
		} else {
			JOptionPane.showMessageDialog(null, "No hay mascotas con sexo " + sexoSeleccionado);
		}

	}

	private void consultarLista() {
		List<Mascota> listaMascotas = micoordinador.consultarListaMascotas(null);
		if (listaMascotas.size() > 0) {
			llenarTabla(listaMascotas);

		} else {
			JOptionPane.showMessageDialog(null, "No hay mascotas ");
		}

	}

	private void llenarTabla(List<Mascota> listaMascotas) {
		String titulos[] = { "ID", "Nombre", "Raza", "Color", "Sexo" };

		String info[][] = new String[listaMascotas.size()][5];

		for (int x = 0; x < listaMascotas.size(); x++) {
			info[x][0] = String.valueOf(listaMascotas.get(x).getIdMascota());
			info[x][1] = listaMascotas.get(x).getNombre();
			info[x][2] = listaMascotas.get(x).getRaza();
			info[x][3] = listaMascotas.get(x).getColorMascota();
			info[x][4] = listaMascotas.get(x).getSexo();
		}

		tablaMascotas = new JTable(info, titulos);
		scrollTabla.setViewportView(tablaMascotas);

		int[] anchos = { 50, 120, 120, 120, 80 };
		for (int i = 0; i < tablaMascotas.getColumnCount(); i++) {
			tablaMascotas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
	}

}
