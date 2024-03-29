package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Control;

public class Controller {

	//Relations
	private Control cont;
	
		//cargar datos
	@FXML TextField txtCargarDatos;
	@FXML Label lblCargarDatos;
	
		//buscar espectador
	@FXML TextField txtBuscEspectador;
	@FXML Label lblTiempoEsp;
	@FXML Label lblBuscarEspectador;
	
		//buscar participante
	@FXML TextField txtBuscParticipante;
	@FXML Label lblTiempoPart;
	@FXML Label lblBuscarParticipante;
	
		//ver datos
	@FXML ImageView Avatar;
	@FXML TextField txtId;
	@FXML TextField txtName;
	@FXML TextField txtLastName;
	@FXML TextField txtEmail;
	@FXML TextField txtGender;
	@FXML TextField txtCountry;
	@FXML TextField txtBirthday;
	
	//dibujar
	@FXML AnchorPane pain;
	
	//Constructors
	
	//Getters and Setters
	
	//Methods
	public void explorarDatos(ActionEvent event) {
		
		txtCargarDatos.setText(cont.explorarDatos());
		
	}
	
	public void cargarDatos(ActionEvent event) {
		
		cont.cargarDatos(txtCargarDatos.getText());
		txtCargarDatos.setText("");
		
	}
	
	public void buscarEspectador(ActionEvent event) {
		
		long t1 = System.currentTimeMillis();
		
		String[] s = cont.buscarEspectador(txtBuscEspectador.getText());
		
		if(s == null) {
			lblBuscarEspectador.setText("espectador no encontrado");
		}else {
			txtId.setText(s[0]);
			txtName.setText(s[1]);
			txtLastName.setText(s[2]);
			txtEmail.setText(s[3]);
			txtGender.setText(s[4]);
			txtCountry.setText(s[5]);
			txtBirthday.setText(s[7]);
			
			Image avatar = new Image(s[6]);
			Avatar.setImage(avatar);
			
			lblBuscarEspectador.setText("espectador encontrado");
			
		}
		
		long t2 = System.currentTimeMillis();
		lblTiempoEsp.setText("Time: "+ Long.toString(t2-t1));
		
		txtBuscEspectador.setText("");
		
	}
	
	public void buscarParticipante(ActionEvent event) {
		
		long t1 = System.currentTimeMillis();
		
		String[] s = cont.buscarParticipante(txtBuscParticipante.getText());
		
		if(s == null) {
			lblBuscarParticipante.setText("participante no encontrado");
			txtId.setText("");
			txtName.setText("");
			txtLastName.setText("");
			txtEmail.setText("");
			txtGender.setText("");
			txtCountry.setText("");
			txtBirthday.setText("");
		}else {
			txtId.setText(s[0]);
			txtName.setText(s[1]);
			txtLastName.setText(s[2]);
			txtEmail.setText(s[3]);
			txtGender.setText(s[4]);
			txtCountry.setText(s[5]);
			txtBirthday.setText(s[7]);
			
			Image avatar = new Image(s[6]);
			Avatar.setImage(avatar);
			
			lblBuscarParticipante.setText("participante encontrado");
			
		}
		
		long t2 = System.currentTimeMillis();
		lblTiempoPart.setText("Time: "+ Long.toString(t2-t1));
		
		txtBuscParticipante.setText("");
		
	}
	
	public void dibujarParticipantes(ActionEvent event) {
		
		String pais = JOptionPane.showInputDialog("Elija el pais a conocer");
		
		String[] s = cont.traerParticipantes(pais);
		
		int x = 40;
		for(int i=0; i<s.length; i++) {
			Image im = new Image(s[i]);
			ImageView m = new ImageView(im);
			m.setX(x);
			m.setY(259);
			x += 101;
			pain.getChildren().add(m);
		}
		
	}
	
	public void dibujarEspectadores(ActionEvent event) {
		
		
		
	}
	
	public void initialize() {
		cont = new Control();
	}
	
}
