package vistas;

import javax.swing.*;

import aplicacion.Coordinador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPrincipal extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel lblTitulo;
    private JButton btnRegistrarMascota, btnConsultarLista, btnConsultarMascota;
    private Coordinador miCoordinador;

    public VistaPrincipal() {
        setTitle("Sistema de Mascotas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setLayout(null); 
        panel.setBackground(Color.WHITE);

        lblTitulo = new JLabel("Menú Principal");
        lblTitulo.setFont(new Font("Montserrat", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(80, 20, 240, 30);
        panel.add(lblTitulo);

        btnRegistrarMascota = new JButton("Registrar Mascota");
        btnRegistrarMascota.setBounds(100, 80, 200, 35);
        btnRegistrarMascota.addActionListener(this);
        panel.add(btnRegistrarMascota);
        btnRegistrarMascota.addActionListener(this);

        btnConsultarLista = new JButton("Consultar Lista de Mascotas");
        btnConsultarLista.setBounds(100, 130, 200, 35);
        btnConsultarLista.addActionListener(this);
        panel.add(btnConsultarLista);
        btnConsultarLista.addActionListener(this);

        btnConsultarMascota = new JButton("Consultar Mascota");
        btnConsultarMascota.setBounds(100, 180, 200, 35);
        btnConsultarMascota.addActionListener(this);
        panel.add(btnConsultarMascota);
        btnConsultarMascota.addActionListener(this);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrarMascota) {
        	miCoordinador.mostrarVentanaRegistrar();
        }
        if (e.getSource() == btnConsultarLista) {
           miCoordinador.mostrarVentanaConsultarLista();
        }
        if (e.getSource() == btnConsultarMascota) {
           miCoordinador.mostrarVentanaConsultar();
        }
    }
    

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

//	public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new VistaPrincipal());
//    }
}

