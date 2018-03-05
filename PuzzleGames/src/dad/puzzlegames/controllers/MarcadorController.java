package dad.puzzlegames.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.puzzlegames.models.Dificultad;
import dad.puzzlegames.models.Modo;
import dad.puzzlegames.models.Partida;
import javafx.beans.property.ListProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class MarcadorController implements Initializable {

	@FXML
	private BorderPane vista;

	@FXML
	private Label tituloLabel;

	@FXML
	private Label subTituloLabel;

	@FXML
	private ComboBox<Dificultad> dificultadCombo;

	@FXML
	private ComboBox<Modo> juegoCombo;

	@FXML
	private Button consultarButton;

	@FXML
	private Button generarInformeButton;

	@FXML
	private Button volverButton;

	@FXML
	private TableView<Partida> tableScores;

	@FXML
	private TableColumn<Partida, Number> idColumn;

	@FXML
	private TableColumn<Partida, String> nombreColumn;

	@FXML
	private TableColumn<Partida, Number> rondasColumn;

	@FXML
	private TableColumn<Partida, String> tiempoColumn;

	@FXML
	private TableColumn<Partida, String> dificultadColumn;

	private ListProperty<Partida> listaPartidas;

	public MarcadorController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlegames/views/MarcadorView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		juegoCombo.getItems().setAll(Modo.values());
		juegoCombo.setValue(Modo.PUZZLE_PIECES);

		dificultadCombo.getItems().setAll(Dificultad.values());
		dificultadCombo.setValue(Dificultad.FACIL);

	}

	public ListProperty<Partida> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(ListProperty<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

	public ComboBox<Dificultad> getDificultadCombo() {
		return dificultadCombo;
	}

	public void setDificultadCombo(ComboBox<Dificultad> dificultadCombo) {
		this.dificultadCombo = dificultadCombo;
	}

	public ComboBox<Modo> getJuegoCombo() {
		return juegoCombo;
	}

	public void setJuegoCombo(ComboBox<Modo> juegoCombo) {
		this.juegoCombo = juegoCombo;
	}

	public Label getTituloLabel() {
		return tituloLabel;
	}

	public void setTituloLabel(Label tituloLabel) {
		this.tituloLabel = tituloLabel;
	}

	public Label getSubTituloLabel() {
		return subTituloLabel;
	}

	public void setSubTituloLabel(Label subTituloLabel) {
		this.subTituloLabel = subTituloLabel;
	}

	public Button getConsultarButton() {
		return consultarButton;
	}

	public void setConsultarButton(Button consultarButton) {
		this.consultarButton = consultarButton;
	}

	public Button getGenerarInformeButton() {
		return generarInformeButton;
	}

	public void setGenerarInformeButton(Button generarInformeButton) {
		this.generarInformeButton = generarInformeButton;
	}

	public Button getVolverButton() {
		return volverButton;
	}

	public void setVolverButton(Button volverButton) {
		this.volverButton = volverButton;
	}

	public TableView<Partida> getTableScores() {
		return tableScores;
	}

	public void setTableScores(TableView<Partida> tableScores) {
		this.tableScores = tableScores;
	}

	public TableColumn<Partida, Number> getIdColumn() {
		return idColumn;
	}

	public void setIdColumn(TableColumn<Partida, Number> idColumn) {
		this.idColumn = idColumn;
	}

	public TableColumn<Partida, String> getNombreColumn() {
		return nombreColumn;
	}

	public void setNombreColumn(TableColumn<Partida, String> nombreColumn) {
		this.nombreColumn = nombreColumn;
	}

	public TableColumn<Partida, Number> getRondasColumn() {
		return rondasColumn;
	}

	public void setRondasColumn(TableColumn<Partida, Number> rondasColumn) {
		this.rondasColumn = rondasColumn;
	}

	public TableColumn<Partida, String> getTiempoColumn() {
		return tiempoColumn;
	}

	public void setTiempoColumn(TableColumn<Partida, String> tiempoColumn) {
		this.tiempoColumn = tiempoColumn;
	}

	public TableColumn<Partida, String> getDificultadColumn() {
		return dificultadColumn;
	}

	public void setDificultadColumn(TableColumn<Partida, String> dificultadColumn) {
		this.dificultadColumn = dificultadColumn;
	}

}
