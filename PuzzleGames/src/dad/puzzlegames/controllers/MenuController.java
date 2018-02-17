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

public class MenuController implements Initializable {

	@FXML
	private BorderPane vista;

	@FXML
	private Button jugarButton;

	@FXML
	private Button marcadorButton;

	@FXML
	private Button acercaDeButton;

	@FXML
	private Button salirButton;

	@FXML
	private Button temaButton;

	@FXML
	private Button sonidoButton;

	@FXML
	private ImageView sonidoImage;

	@FXML
	private Label tituloLabel;

	public MenuController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlegames/views/MenuView.fxml"));
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

	public Button getJugarButton() {
		return jugarButton;
	}

	public void setJugarButton(Button jugarButton) {
		this.jugarButton = jugarButton;
	}

	public Button getMarcadorButton() {
		return marcadorButton;
	}

	public void setMarcadorButton(Button marcadorButton) {
		this.marcadorButton = marcadorButton;
	}

	public Button getAcercaDeButton() {
		return acercaDeButton;
	}

	public void setAcercaDeButton(Button acercaDeButton) {
		this.acercaDeButton = acercaDeButton;
	}

	public Button getSalirButton() {
		return salirButton;
	}

	public void setSalirButton(Button salirButton) {
		this.salirButton = salirButton;
	}

	public Button getTemaButton() {
		return temaButton;
	}

	public void setTemaButton(Button temaButton) {
		this.temaButton = temaButton;
	}

	public Button getSonidoButton() {
		return sonidoButton;
	}

	public void setSonidoButton(Button sonidoButton) {
		this.sonidoButton = sonidoButton;
	}

	public ImageView getSonidoImage() {
		return sonidoImage;
	}

	public void setSonidoImage(ImageView sonidoImage) {
		this.sonidoImage = sonidoImage;
	}

	public Label getTituloLabel() {
		return tituloLabel;
	}

	public void setTituloLabel(Label tituloLabel) {
		this.tituloLabel = tituloLabel;
	}


}
