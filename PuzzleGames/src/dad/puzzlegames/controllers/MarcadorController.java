package dad.puzzlegames.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.puzzlegames.models.Dificultad;
import dad.puzzlegames.models.Modo;
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
	private Button volverButton;

	@FXML
	private TableView<?> tableScores;

	@FXML
	private TableColumn<?, ?> puestoColumn;

	@FXML
	private TableColumn<?, ?> idColumn;
	
	@FXML
    private Button generarInformeButton;

	@FXML
	private TableColumn<?, ?> nombreColumn;

	@FXML
	private TableColumn<?, ?> modoColumn;

	@FXML
	private TableColumn<?, ?> tiempoColumn;

	@FXML
	private TableColumn<?, ?> puntuacionColumn;

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

	public TableView<?> getTableScores() {
		return tableScores;
	}

	public void setTableScores(TableView<?> tableScores) {
		this.tableScores = tableScores;
	}

	public TableColumn<?, ?> getPuestoColumn() {
		return puestoColumn;
	}

	public void setPuestoColumn(TableColumn<?, ?> puestoColumn) {
		this.puestoColumn = puestoColumn;
	}

	public TableColumn<?, ?> getIdColumn() {
		return idColumn;
	}

	public void setIdColumn(TableColumn<?, ?> idColumn) {
		this.idColumn = idColumn;
	}
	
	

	public Button getGenerarInformeButton() {
		return generarInformeButton;
	}

	public void setGenerarInformeButton(Button generarInformeButton) {
		this.generarInformeButton = generarInformeButton;
	}

	public TableColumn<?, ?> getNombreColumn() {
		return nombreColumn;
	}

	public void setNombreColumn(TableColumn<?, ?> nombreColumn) {
		this.nombreColumn = nombreColumn;
	}

	public TableColumn<?, ?> getModoColumn() {
		return modoColumn;
	}

	public void setModoColumn(TableColumn<?, ?> modoColumn) {
		this.modoColumn = modoColumn;
	}

	public TableColumn<?, ?> getTiempoColumn() {
		return tiempoColumn;
	}

	public void setTiempoColumn(TableColumn<?, ?> tiempoColumn) {
		this.tiempoColumn = tiempoColumn;
	}

	public TableColumn<?, ?> getPuntuacionColumn() {
		return puntuacionColumn;
	}

	public void setPuntuacionColumn(TableColumn<?, ?> puntuacionColumn) {
		this.puntuacionColumn = puntuacionColumn;
	}

	public void setConsultarButton(Button consultarButton) {
		this.consultarButton = consultarButton;
	}

	public void setVolverButton(Button volverButton) {
		this.volverButton = volverButton;
	}

	public Button getConsultarButton() {
		return consultarButton;
	}

	public Button getVolverButton() {
		return volverButton;
	}

}
