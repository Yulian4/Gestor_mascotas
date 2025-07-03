package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import aplicacion.Coordinador;
import entidades.Mascota;

public class VistaConsultarMascota extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel lblTitulo, lblId, lblNombre, lblRaza, lblColor, lblSexo;
	private JTextField txtId, txtNombre, txtRaza, txtColor, txtSexo;
	private JButton btnConsultar, btnActualizar, btnEliminar;
	private Coordinador miCoordinador;

	public VistaConsultarMascota() {
		setTitle("Consultar Mascota por ID");
		setSize(450, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		iniciarComponentes();
	}

	private void iniciarComponentes() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		lblTitulo = new JLabel("Consultar Mascota por ID");
		lblTitulo.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(80, 10, 300, 30);
		panel.add(lblTitulo);

		lblId = new JLabel("ID:");
		lblId.setBounds(30, 60, 80, 25);
		panel.add(lblId);

		txtId = new JTextField();
		txtId.setBounds(120, 60, 200, 25);
		panel.add(txtId);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(330, 60, 90, 25);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);
		btnConsultar.addActionListener(this);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 110, 80, 25);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(120, 110, 250, 25);
		txtNombre.setEditable(false);
		panel.add(txtNombre);

		lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(30, 150, 80, 25);
		panel.add(lblRaza);

		txtRaza = new JTextField();
		txtRaza.setBounds(120, 150, 250, 25);
		txtRaza.setEditable(false);
		panel.add(txtRaza);

		lblColor = new JLabel("Color:");
		lblColor.setBounds(30, 190, 80, 25);
		panel.add(lblColor);

		txtColor = new JTextField();
		txtColor.setBounds(120, 190, 250, 25);
		txtColor.setEditable(false);
		panel.add(txtColor);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(30, 230, 80, 25);
		panel.add(lblSexo);

		txtSexo = new JTextField();
		txtSexo.setBounds(120, 230, 250, 25);
		txtSexo.setEditable(false);
		panel.add(txtSexo);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(90, 300, 100, 30);
		btnActualizar.addActionListener(this);
		panel.add(btnActualizar);
		btnActualizar.addActionListener(this);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(250, 300, 100, 30);
		btnEliminar.addActionListener(this);
		panel.add(btnEliminar);
		btnEliminar.addActionListener(this);

		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			consultarMascotaPorId();
		}
		if (e.getSource() == btnActualizar) {
			actualizarMascota();
		}
		if (e.getSource() == btnEliminar) {
			eliminarMascota();
		}
	}

	private void eliminarMascota() {
		try {
			Long idMascota = Long.parseLong(txtId.getText().trim());
			Mascota mascota = new Mascota();
			mascota.setIdMascota(idMascota);

			String resp = miCoordinador.eliminarMascota(mascota);
			JOptionPane.showMessageDialog(null, resp);
			limpiarCampos();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "id no valido");
		}
	}

	private void actualizarMascota() {

		try {
			Long idMascota = Long.parseLong(txtId.getText().trim());
			Mascota mascota = new Mascota();
			mascota.setIdMascota(idMascota);
			mascota.setNombre(txtNombre.getText());
			mascota.setRaza(txtRaza.getText());
			mascota.setColorMascota(txtColor.getText());
			mascota.setSexo(txtSexo.getText());

			String resp = miCoordinador.ActualizarMascota(mascota);
			JOptionPane.showMessageDialog(null, resp);
			limpiarCampos();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Ingrese un ID válido");
		}
	}

	private void consultarMascotaPorId() {
		try {
			Long idMascota = Long.parseLong(txtId.getText().trim());
			Mascota mascota = miCoordinador.consultarMascota(idMascota);
			if (mascota != null) {
				txtNombre.setText(mascota.getNombre());
				txtRaza.setText(mascota.getRaza());
				txtColor.setText(mascota.getColorMascota());
				txtSexo.setText(mascota.getSexo());
				txtNombre.setEditable(true);
				txtRaza.setEditable(true);
				txtColor.setEditable(true);
				txtSexo.setEditable(true);
			} else {
				JOptionPane.showMessageDialog(this, "No existen mascotas con el id " + idMascota);
				limpiarCampos();
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "ingrese un dato valido");
		}
	}

	private void limpiarCampos() {
		txtNombre.setText("");
		txtRaza.setText("");
		txtColor.setText("");
		txtSexo.setText("");
	}

	public void setMicoordinador(Coordinador micoordinador) {
		this.miCoordinador = micoordinador;
	}
}
