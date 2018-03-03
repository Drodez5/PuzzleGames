package dad.puzzlegames.controllers;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;

import dad.puzzlegames.models.Dificultad;
import dad.puzzlegames.models.Modo;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class OpcionesPartidaController implements Initializable {

	@FXML
	private BorderPane vista;
	
	@FXML
	private Label tituloOpciones;

	@FXML
	private Label subTituloOpciones;

	@FXML
	private ComboBox<Integer> rondasCombo;

	@FXML
	private ComboBox<Dificultad> dificultadCombo;

	@FXML
	private TextField nombreText;


	@FXML
	private Button abrirButton;

	@FXML
	private Label directorioLabel;

	@FXML
	private ComboBox<Modo> juegoCombo;

	@FXML
	private Button atrasButton;

	@FXML
	private Button continuarButton;

	public OpcionesPartidaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlegames/views/OpcionesPartidaView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Dificultad combo
		dificultadCombo.getItems().setAll(Dificultad.values());
		dificultadCombo.setValue(Dificultad.FACIL);

		// juego combo
		juegoCombo.getItems().setAll(Modo.values());
		juegoCombo.setValue(Modo.PUZZLE_PIECES);

		// numero de rondas combo
		rondasCombo.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		rondasCombo.setValue(1);

	}

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

	public ComboBox<Integer> getRondasCombo() {
		return rondasCombo;
	}

	public void setRondasCombo(ComboBox<Integer> rondasCombo) {
		this.rondasCombo = rondasCombo;
	}

	public ComboBox<Dificultad> getDificultadCombo() {
		return dificultadCombo;
	}

	public void setDificultadCombo(ComboBox<Dificultad> dificultadCombo) {
		this.dificultadCombo = dificultadCombo;
	}

	public TextField getNombreText() {
		return nombreText;
	}

	public void setNombreText(TextField nombreText) {
		this.nombreText = nombreText;
	}



	public Button getAbrirButton() {
		return abrirButton;
	}

	public void setAbrirButton(Button abrirButton) {
		this.abrirButton = abrirButton;
	}

	public ComboBox<Modo> getJuegoCombo() {
		return juegoCombo;
	}

	public void setJuegoCombo(ComboBox<Modo> juegoCombo) {
		this.juegoCombo = juegoCombo;
	}

	public Button getAtrasButton() {
		return atrasButton;
	}

	public void setAtrasButton(Button atrasButton) {
		this.atrasButton = atrasButton;
	}

	public Button getContinuarButton() {
		return continuarButton;
	}

	public void setContinuarButton(Button continuarButton) {
		this.continuarButton = continuarButton;
	}

	public void setDirectorioLabel(Label directorioLabel) {
		this.directorioLabel = directorioLabel;
	}

	public Label getDirectorioLabel() {
		return directorioLabel;
	}

}
