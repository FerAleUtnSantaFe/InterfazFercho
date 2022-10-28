package Interfaz;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.util.Callback;

public class Controlador implements Initializable{
	
	@FXML
	private Label codigoLabel;
	@FXML
	private Label codigoErrorLabel;
	@FXML
	private TextField codigoTextField;
	
	@FXML
	private Label puestoLabel;
	@FXML
	private Label puestoErrorLabel;
	@FXML
	private TextField puestoTextField;
	
	@FXML
	private Label empresaLabel;
	@FXML
	private Label empresaErrorLabel;
	@FXML
	private TextField empresaTextField;
	
	@FXML
	private Label descripcionLabel;
	@FXML
	private Label descripcionErrorLabel;
	@FXML
	private TextArea descripcionTextArea;
	
	@FXML
	private Label caractLabel;

	@FXML
	private Label tipoCompErrorLabel;
	
	public int codigo = 0;
	public String puesto, empresa, descripcion, seleccion, tipoCompetencia;
	
	@FXML
	private TableView<CompetenciasInterfaz> listaCompetencias;
	
	@FXML
	private ChoiceBox<String> caractChoiceBox;
	
	@FXML
	private Button aceptarButton;
	
	@FXML
	private Button cancelarButton;
	
	private String[] caracteristicas = {"característica 1","característica 2", "característica 3"};
	
	private ArrayList<CompetenciasInterfaz> compInterfaz;
	
	public void setCompInterfaz(ArrayList<CompetenciasInterfaz> compInt) { compInterfaz = compInt; }

	public ArrayList<CompetenciasInterfaz> getCompInterfaz() { return compInterfaz; }

	@FXML
	private CheckBox actitudinalesCheckBox;
	
	@FXML
	private CheckBox tecnicasCheckBox;

	//  EJEMPLOS DE COMPETENCIAS
	
	@FXML
	private TreeTableView<CompetenciasInterfaz> tablaCompetencias;
	
	@FXML
	private TreeTableColumn<CompetenciasInterfaz, String> colNombre;
	
	@FXML
	private TreeTableColumn<CompetenciasInterfaz, Number> colPuntuacion;
	
	@FXML
	private TreeTableColumn<CompetenciasInterfaz, CheckBox> colSeleccionado;
	
	TreeItem<CompetenciasInterfaz> comp1 = new TreeItem<CompetenciasInterfaz>(new CompetenciasInterfaz("comp1", 60.0, false));
	TreeItem<CompetenciasInterfaz> comp2 = new TreeItem<CompetenciasInterfaz>(new CompetenciasInterfaz("comp2", 70.5, false));
	TreeItem<CompetenciasInterfaz> comp3 = new TreeItem<CompetenciasInterfaz>(new CompetenciasInterfaz("comp3", 78.6, false));
	TreeItem<CompetenciasInterfaz> comp4 = new TreeItem<CompetenciasInterfaz>(new CompetenciasInterfaz("comp4", 90.3, false));
	
	TreeItem<CompetenciasInterfaz> rootTabla = new TreeItem<CompetenciasInterfaz>(new CompetenciasInterfaz("Nombre", 0.0, false));
	
	
	
		
	
	@SuppressWarnings("unchecked")
	@Override
	// INICIALIZA LAS VARIABLES, OCULTA LOS LABEL DE ERROR Y CARGA EL  VECTOR CARACTERÍSTICAS
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		caractChoiceBox.getItems().addAll(caracteristicas); 
		caractChoiceBox.setOnAction(this::getSeleccion);
	
		codigoErrorLabel.setVisible(false);
		puestoErrorLabel.setVisible(false);
		empresaErrorLabel.setVisible(false);
		descripcionErrorLabel.setVisible(false);
		tipoCompErrorLabel.setVisible(false);
		tecnicasCheckBox.setDisable(false);
		actitudinalesCheckBox.setDisable(false);
		tablaCompetencias.setEditable(true);
		colNombre.setEditable(false);
		colPuntuacion.setEditable(true);
		colSeleccionado.setEditable(true);
	
		puesto = null; empresa = null; descripcion = null; seleccion = null; tipoCompetencia = null;
		

		rootTabla.getChildren().setAll(comp1,comp2,comp3,comp4);
		
		
		colNombre.setCellValueFactory(
					(TreeTableColumn.CellDataFeatures<CompetenciasInterfaz, String> param) -> param.getValue().getValue().getNombre());
		
	/*	colPuntuacion.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<CompetenciasInterfaz, Number> param) -> param.getValue().getValue().getPuntuacion());
	*/

		colPuntuacion.setCellFactory(new Callback<TreeTableColumn<CompetenciasInterfaz, Number>, TreeTableCell<CompetenciasInterfaz, Number>>(){
			 @Override
			 public TextFieldTreeTableCell<CompetenciasInterfaz, Number> call(TreeTableColumn<CompetenciasInterfaz, Number> param){
				 return new TextFieldTreeTableCell<>();
			 }
		});
	
	
		colSeleccionado.setCellFactory(new Callback<TreeTableColumn<CompetenciasInterfaz, CheckBox>, TreeTableCell<CompetenciasInterfaz, CheckBox>>(){
			 @Override
			 public TreeTableCell<CompetenciasInterfaz, CheckBox> call(TreeTableColumn<CompetenciasInterfaz, CheckBox> param){
				 return new CheckBoxTreeTableCell<>();
			 }
		});
	
		tablaCompetencias.setRoot(rootTabla);
		tablaCompetencias.setShowRoot(false);
	
	
	}
	
	// EXTRAE LA SELECCIÓN DE CARACTERÍSTICA
	public void getSeleccion(ActionEvent event) {
		
		seleccion = caractChoiceBox.getValue();

	}
	
	// AL ACTIVAR UN CHECKBOX BLOQUEA LA SELECCIÓN DEL OTRO TIPO DE COMPETENCIA Y CARGA LA SELECCIÓN EN tipoCompetencia
	/*public void seleccionarCheckBox(ActionEvent event) {
		
		if (actitudinalesCheckBox.isSelected()) {
			tecnicasCheckBox.setDisable(true);
			tipoCompetencia = "Actitudinales";
		} else tecnicasCheckBox.setDisable(false);
		
		if (tecnicasCheckBox.isSelected()) {
			actitudinalesCheckBox.setDisable(true);
			tipoCompetencia = "Técnicas";
		} else actitudinalesCheckBox.setDisable(false);
		
	}*/
	
	// DEJA SELECCIONAR UNO O AMBOS TIPO DE COMPETENCIA Y DESACTIVA EL MENSAJE DE ERROR EN CASO DE QUE AL MENOS UN CHECKBOX ESTÉ SELECCIONADO
	public void seleccionarCheckBox(ActionEvent event) {
		if (actitudinalesCheckBox.isSelected() && !tecnicasCheckBox.isSelected()) tipoCompetencia = "Actitudinales";
		if (tecnicasCheckBox.isSelected() && !actitudinalesCheckBox.isSelected()) tipoCompetencia = "Técnicas";
		if (tecnicasCheckBox.isSelected() && actitudinalesCheckBox.isSelected()) tipoCompetencia = "Actitudinales y técnicas";
		if (tecnicasCheckBox.isSelected() || actitudinalesCheckBox.isSelected()) tipoCompErrorLabel.setVisible(false);

	}
	
	public void aceptar(ActionEvent event) {
		
		// COMPRUEBA QUE CÓDIGO SEA DE TIPO NUMÉRICO
		try{
			codigo = Integer.parseInt(codigoTextField.getText());
		} catch (NumberFormatException e) {
			System.out.println("Ingrese números");
		}
		
		// EXTRAE LOS DATOS DE LOS CAMPOS
		puesto = puestoTextField.getText();
		empresa = empresaTextField.getText();
		descripcion = descripcionTextArea.getText();
		
		// COMPRUEBA SI NO ESTÁN VACIOS Y ACTIVA LABEL DE ERROR EN CASO DE ESTARLO
		if (codigo == 0) codigoErrorLabel.setVisible(true);
		else codigoErrorLabel.setVisible(false);
		
		if (puesto.isEmpty()) puestoErrorLabel.setVisible(true);
		else puestoErrorLabel.setVisible(false);
		
		if (empresa.isEmpty()) empresaErrorLabel.setVisible(true);
		else empresaErrorLabel.setVisible(false);
		
		if (descripcion.isEmpty()) descripcionErrorLabel.setVisible(true);
		else descripcionErrorLabel.setVisible(false);
		
		if (!actitudinalesCheckBox.isSelected() && !tecnicasCheckBox.isSelected()) tipoCompErrorLabel.setVisible(true);
		else tipoCompErrorLabel.setVisible(false);
		
		//System.out.println("codigo: " + codigo + " puesto: " +puesto + " empresa: " + empresa + " selecciónCaracterística: " + seleccion + " tipoCompetencia: " + tipoCompetencia);
	
		//cargarLista(codigo,puesto,empresa,descripcion);
	
	}
	
	/*
	 * @SuppressWarnings("unchecked")
	 
	public void cargarLista(int cod, String pto, String emp, String desc) {
		

		rootTabla.getChildren().setAll(comp1,comp2,comp3,comp4);
		
		
		colNombre.setCellValueFactory(
					(TreeTableColumn.CellDataFeatures<CompetenciasInterfaz, String> param) -> param.getValue().getValue().getNombre());
		
	/*	colPuntuacion.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<CompetenciasInterfaz, Number> param) -> param.getValue().getValue().getPuntuacion());
	

		colPuntuacion.setCellFactory(new Callback<TreeTableColumn<CompetenciasInterfaz, Number>, TreeTableCell<CompetenciasInterfaz, Number>>(){
			 @Override
			 public TextFieldTreeTableCell<CompetenciasInterfaz, Number> call(TreeTableColumn<CompetenciasInterfaz, Number> param){
				 return new TextFieldTreeTableCell<>();
			 }
		});
	
	
		colSeleccionado.setCellFactory(new Callback<TreeTableColumn<CompetenciasInterfaz, CheckBox>, TreeTableCell<CompetenciasInterfaz, CheckBox>>(){
			 @Override
			 public TreeTableCell<CompetenciasInterfaz, CheckBox> call(TreeTableColumn<CompetenciasInterfaz, CheckBox> param){
				 return new CheckBoxTreeTableCell<>();
			 }
		});
	
		tablaCompetencias.setRoot(rootTabla);
		tablaCompetencias.setShowRoot(false);
	
	}*/
	
	public void cancelar(ActionEvent event) {
		
	}
	
}
