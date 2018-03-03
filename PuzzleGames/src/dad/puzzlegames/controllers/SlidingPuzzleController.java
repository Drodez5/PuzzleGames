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
import javafx.scene.layout.GridPane;

public class SlidingPuzzleController  implements Initializable{
	
	 @FXML
	    private BorderPane vista;

	    @FXML
	    private GridPane tableroSliding;

	    @FXML
	    private ImageView imagen1Tab;

	    @FXML
	    private ImageView imagen2Tab;

	    @FXML
	    private ImageView imagen3Tab;

	    @FXML
	    private ImageView imagen4Tab;

	    @FXML
	    private ImageView imagen5Tab;

	    @FXML
	    private ImageView imagen6Tab;

	    @FXML
	    private ImageView imagen7Tab;

	    @FXML
	    private ImageView imagen8Tab;

	    @FXML
	    private ImageView imagen9Tab;

	    @FXML
	    private Label jugadorLabel;

	    @FXML
	    private Label tiempoLabel;

	    @FXML
	    private Label rondasLabel;

	    @FXML
	    private Button siguienteButton;

	    @FXML
	    private Button abandonarButton;
	
	public  SlidingPuzzleController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlegames/views/SlidingPuzzleView.fxml"));
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

	public GridPane getTableroSliding() {
		return tableroSliding;
	}

	public void setTableroSliding(GridPane tableroSliding) {
		this.tableroSliding = tableroSliding;
	}

	public ImageView getImagen1Tab() {
		return imagen1Tab;
	}

	public void setImagen1Tab(ImageView imagen1Tab) {
		this.imagen1Tab = imagen1Tab;
	}

	public ImageView getImagen2Tab() {
		return imagen2Tab;
	}

	public void setImagen2Tab(ImageView imagen2Tab) {
		this.imagen2Tab = imagen2Tab;
	}

	public ImageView getImagen3Tab() {
		return imagen3Tab;
	}

	public void setImagen3Tab(ImageView imagen3Tab) {
		this.imagen3Tab = imagen3Tab;
	}

	public ImageView getImagen4Tab() {
		return imagen4Tab;
	}

	public void setImagen4Tab(ImageView imagen4Tab) {
		this.imagen4Tab = imagen4Tab;
	}

	public ImageView getImagen5Tab() {
		return imagen5Tab;
	}

	public void setImagen5Tab(ImageView imagen5Tab) {
		this.imagen5Tab = imagen5Tab;
	}

	public ImageView getImagen6Tab() {
		return imagen6Tab;
	}

	public void setImagen6Tab(ImageView imagen6Tab) {
		this.imagen6Tab = imagen6Tab;
	}

	public ImageView getImagen7Tab() {
		return imagen7Tab;
	}

	public void setImagen7Tab(ImageView imagen7Tab) {
		this.imagen7Tab = imagen7Tab;
	}

	public ImageView getImagen8Tab() {
		return imagen8Tab;
	}

	public void setImagen8Tab(ImageView imagen8Tab) {
		this.imagen8Tab = imagen8Tab;
	}

	public ImageView getImagen9Tab() {
		return imagen9Tab;
	}

	public void setImagen9Tab(ImageView imagen9Tab) {
		this.imagen9Tab = imagen9Tab;
	}

	public Label getJugadorLabel() {
		return jugadorLabel;
	}

	public void setJugadorLabel(Label jugadorLabel) {
		this.jugadorLabel = jugadorLabel;
	}

	public Label getTiempoLabel() {
		return tiempoLabel;
	}

	public void setTiempoLabel(Label tiempoLabel) {
		this.tiempoLabel = tiempoLabel;
	}

	public Label getRondasLabel() {
		return rondasLabel;
	}

	public void setRondasLabel(Label rondasLabel) {
		this.rondasLabel = rondasLabel;
	}

	public Button getSiguienteButton() {
		return siguienteButton;
	}

	public void setSiguienteButton(Button siguienteButton) {
		this.siguienteButton = siguienteButton;
	}

	public Button getAbandonarButton() {
		return abandonarButton;
	}

	public void setAbandonarButton(Button abandonarButton) {
		this.abandonarButton = abandonarButton;
	}
	
	

}
