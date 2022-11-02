package Interfaz;

import java.util.ArrayList;

public class Caracteristicas {
	private String nombreCaracteristica;
	private ArrayList<CompetenciasInterfaz> comps;

	public Caracteristicas(ArrayList<CompetenciasInterfaz> comps, String nombre) {
		this.comps = comps;
		this.nombreCaracteristica = nombre;
	}
	
	public void setComps(ArrayList<CompetenciasInterfaz> comps) {
		this.comps = comps;
	}
	

	public ArrayList<CompetenciasInterfaz> getComps(){
		return this.comps;
	}
	
	public void setNombre(String nom) {
		this.nombreCaracteristica = nom;
	}
	
	public String getNombre() {
		return this.nombreCaracteristica;
	}
	
}
