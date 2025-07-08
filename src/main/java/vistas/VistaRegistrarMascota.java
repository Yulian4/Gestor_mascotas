package vistas;

import javax.swing.*;

import aplicacion.Coordinador;
import entidades.Mascota;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaRegistrarMascota extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel lblTitulo, lblNombre, lblRaza, lblColor, lblSexo;
    private JTextField txtNombre, txtRaza, txtColor;
    private JComboBox<String> comboSexo;
    private JButton btnGuardar, btnCancelar;
    private Coordinador miCoordinador;

    public VistaRegistrarMascota() {
        setTitle("Registrar Mascota");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setLayout(null); 
        panel.setBackground(Color.WHITE);

        lblTitulo = new JLabel("Registrar Mascota");
        lblTitulo.setFont(new Font("Montserrat", Font.BOLD, 18));
        lblTitulo.setBounds(100, 10, 200, 30);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTitulo);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 80, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 220, 25);
        panel.add(txtNombre);

        lblRaza = new JLabel("Raza:");
        lblRaza.setBounds(30, 100, 80, 25);
        panel.add(lblRaza);

        txtRaza = new JTextField();
        txtRaza.setBounds(120, 100, 220, 25);
        panel.add(txtRaza);

        lblColor = new JLabel("Color:");
        lblColor.setBounds(30, 140, 80, 25);
        panel.add(lblColor);

        txtColor = new JTextField();
        txtColor.setBounds(120, 140, 220, 25);
        panel.add(txtColor);

        lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(30, 180, 80, 25);
        panel.add(lblSexo);

        comboSexo = new JComboBox<>(new String[]{"", "Macho", "Hembra"});
        comboSexo.setBounds(120, 180, 220, 25);
        panel.add(comboSexo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(80, 230, 100, 30);
        btnGuardar.addActionListener(this);
        panel.add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 230, 100, 30);
        btnCancelar.addActionListener(this);
        panel.add(btnCancelar);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
           registrar(); 
        }
        if (e.getSource() == btnCancelar) {
          
        }
    }


	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	private void registrar() {
		Mascota mascota = new Mascota();
		
		mascota.setIdMascota(null);
		mascota.setNombre(txtNombre.getText());
		mascota.setColorMascota(txtColor.getText());
		mascota.setRaza(txtRaza.getText());
		mascota.setSexo(comboSexo.getSelectedItem().toString());

		String res = miCoordinador.registrarMascota(mascota);
			JOptionPane.showMessageDialog(null, res);
	

		
	}

}
