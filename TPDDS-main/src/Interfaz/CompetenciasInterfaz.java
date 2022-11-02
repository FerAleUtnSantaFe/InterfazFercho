package Interfaz;

import javafx.scene.control.CheckBox;

public class CompetenciasInterfaz {
	private String nombreComp;
	private Double puntComp;
	private Boolean selComp;
	private CheckBox checkSelComp = new CheckBox();
	private Double puntDeseada;
	


	public CompetenciasInterfaz(){
		this.nombreComp = "";
		this.puntComp = 0.0;
		this.puntDeseada = 0.0;
		this.selComp = false;
		this.checkSelComp.setSelected(false);
	}
	
	public CompetenciasInterfaz(String nom, Double punt, Boolean sel) {
		this.nombreComp = nom;
		this.puntComp = punt;
		this.selComp = sel;
		this.checkSelComp.setSelected(sel);
	}

	public String getNombreComp() {
		return nombreComp;
	}

	public void setNombreComp(String nombreComp) {
		this.nombreComp = nombreComp;
	}

	public Double getPuntComp() {
		return puntComp;
	}

	public void setPuntComp(Double puntComp) {
		this.puntComp = puntComp;
	}

	public Boolean getSelComp() {
		return selComp;
	}

	public void setSelComp(Boolean selComp) {
		this.selComp = selComp;
		this.setCheckSelComp(selComp);
	}

	public CheckBox getCheckSelComp() {
		return checkSelComp;
	}

	public void setCheckSelComp(Boolean checkSelComp) {
		this.checkSelComp.setSelected(checkSelComp);
	}
	
	public void setCheckSelComp(CheckBox checkSelComp) {
		this.checkSelComp = checkSelComp;
	}
	
	public Double getPuntDeseada() {
		return puntDeseada;
	}

	public void setPuntDeseada(Double puntDeseada) {
		this.puntDeseada = puntDeseada;
	}
	
}
