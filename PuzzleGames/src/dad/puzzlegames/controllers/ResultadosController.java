package dad.puzzlegames.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


/**
 * @author Domingo Rodriguez
 * @version 1.0
 */
public class ResultadosController implements Initializable {

	@FXML
	private BorderPane vista;

	@FXML
	private Label resultadosLabel;

	@FXML
	private ImageView resultImagen1;

	@FXML
	private Label resultadoLabel;

	@FXML
	private ImageView resultadoImagen;

	@FXML
	private Button continuarButton;

	public ResultadosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlegames/views/ResultadosView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

	public Label getResultadosLabel() {
		return resultadosLabel;
	}

	public void setResultadosLabel(Label resultadosLabel) {
		this.resultadosLabel = resultadosLabel;
	}

	public ImageView getResultImagen1() {
		return resultImagen1;
	}

	public void setResultImagen1(ImageView resultImagen1) {
		this.resultImagen1 = resultImagen1;
	}

	public Label getResultadoLabel() {
		return resultadoLabel;
	}

	public void setResultadoLabel(Label resultadoLabel) {
		this.resultadoLabel = resultadoLabel;
	}

	public ImageView getResultadoImagen() {
		return resultadoImagen;
	}

	public void setResultadoImagen(ImageView resultadoImagen) {
		this.resultadoImagen = resultadoImagen;
	}

	public Button getContinuarButton() {
		return continuarButton;
	}

	public void setContinuarButton(Button continuarButton) {
		this.continuarButton = continuarButton;
	}
	
	

}
