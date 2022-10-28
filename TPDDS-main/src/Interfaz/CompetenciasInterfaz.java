package Interfaz;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;

public class CompetenciasInterfaz {
	private SimpleStringProperty nombre;
	private SimpleDoubleProperty puntuacion;
	private SimpleBooleanProperty seleccionado = new SimpleBooleanProperty(false);
	private CheckBox selCheckBox = new CheckBox();
	
	public CompetenciasInterfaz(String nom, Double punt, Boolean sel) {
		this.setNombre(nom);
		this.setPuntuacion(punt);
		this.setSeleccionado(sel);
	}
	
	public void setNombre(String nom) { this.nombre = new SimpleStringProperty(nom); }
	public SimpleStringProperty getNombre() { return this.nombre; }
	
	public void setPuntuacion(Double punt) { this.puntuacion = new SimpleDoubleProperty(punt); }
	public SimpleDoubleProperty getPuntuacion() { return this.puntuacion; }
	
	public void setSeleccionado(Boolean sel) { 
		 this.seleccionado = new SimpleBooleanProperty(sel);
		 this.selCheckBox.setSelected(sel);
	}
	
	public Boolean getSeleccionado() { return this.seleccionado.getValue(); }
	
	public ObservableValue<CheckBox> getCheckBox() { return (ObservableValue<CheckBox>) this.selCheckBox; }
	
	
}
