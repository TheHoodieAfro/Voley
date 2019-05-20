package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;

public class Control {
	
	//Constants
	
	//Attributes
	private Inscrito raiz;
	private Participante first;
	
	//Relations
	
	//Constructors
	public Control() {
		raiz = null;
		first = null;
	}
	
	//Getters and Setters
	public Inscrito getRaiz() {
		return raiz;
	}
	
	public Participante getFirst() {
		return first;
	}
	
	//Methods
	public String explorarDatos() {
		
		String ruta = "";
		
		JFileChooser jfc = new JFileChooser("C:/Users/Usuario/Documents/JavaProyects/Voley/ruta");

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			try {
				ruta = selectedFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return ruta;
		
	}
	
	public void cargarDatos(String r) {
		
		try {
			BufferedReader read = new BufferedReader(new FileReader(r));
			int turn = 1;
			boolean ent = false;
			String l = read.readLine();
			l = read.readLine();
			while(l != null) {
				String[] ll = l.split(",");
				
				String id = ll[0];
				String name = ll[1];
				String lastName = ll[2];
				String email = ll[3];
				String gender = ll[4];
				String country = ll[5];
				String photo = ll[6];
				String birthday = ll[7];
				
				Inscrito x = new Inscrito(id, name, lastName, email, gender, country, photo, birthday);
				Participante z = new Participante(id, name, lastName, email, gender, country, photo, birthday);
				
				if(raiz == null) {
					raiz = x;
				}else {
					raiz.insert(x);
				}
				
				if(turn == 1) {
					int n = (int) (Math.random() * 2) + 1;
					if(n == 1) {
						if(first == null) {
							first = z;
						}else {
							first.insert(z);
						}
						ent = true;
					}else {
						ent = false;
					}
					turn++;
				}else {
					if(!ent) {
						if(first == null) {
							first = z;
						}else {
							first.insert(z);
						}
					}
					turn = 1;
				}
				
				l = read.readLine();
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] buscarEspectador(String b) {
		
		String[] info = new String[8];
		
		Inscrito x = raiz.buscar(b);
		
		if(x != null) {
			info[0] = x.getId();
			info[1] = x.getName();
			info[2] = x.getLastName();
			info[3] = x.getEmail();
			info[4] = x.getGender();
			info[5] = x.getCountry();
			info[6] = x.getPhoto();
			info[7] = x.getBirthday();
			
			return info;
		}else {
			return null;
		}
		
	}
	
	public String[] buscarParticipante(String b) {
		
		String[] info = new String[8];
		
		Participante x = first.buscar(b);
		
		if(x != null) {
			info[0] = x.getId();
			info[1] = x.getName();
			info[2] = x.getLastName();
			info[3] = x.getEmail();
			info[4] = x.getGender();
			info[5] = x.getCountry();
			info[6] = x.getPhoto();
			info[7] = x.getBirthday();
			
			return info;
		}else {
			return null;
		}
		
	}
	
	public String[] traerParticipantes(String pais) {
		
		Participante x = first;
		ArrayList<String> d = new ArrayList<String>();
		
		while(x != null) {
			if(x.getCountry().equalsIgnoreCase(pais)) {
				d.add(x.getPhoto());
			}
			x = x.getNext();
		}
		
		String[] s = new String[d.size()];
		
		for(int i=0; i<s.length; i++) {
			s[i] = d.get(i);
		}
		
		return s;
		
	}
	
	public void dibujarEspectadores() {
		
		
		
	}
	
}
