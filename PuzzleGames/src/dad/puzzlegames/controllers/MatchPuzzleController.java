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

public class MatchPuzzleController implements Initializable {

	 @FXML
	    private BorderPane vista;

	    @FXML
	    private Label puzzlePicLabel;

	    @FXML
	    private Label namePlayerLabel;

	    @FXML
	    private Label timeLabel;

	    @FXML
	    private Label roundLabel;

	    @FXML
	    private ImageView imagen1;

	    @FXML
	    private ImageView imagen2;

	    @FXML
	    private ImageView imagen3;

	    @FXML
	    private ImageView imagen4;

	    @FXML
	    private ImageView imagen5;

	    @FXML
	    private ImageView imagen6;

	    @FXML
	    private ImageView imagen7;

	    @FXML
	    private ImageView imagen8;

	    @FXML
	    private ImageView imagen9;

	    @FXML
	    private ImageView imagen10;

	    @FXML
	    private ImageView imagen11;

	    @FXML
	    private ImageView imagen12;

	    @FXML
	    private ImageView imagen13;

	    @FXML
	    private ImageView imagen14;

	    @FXML
	    private ImageView imagen15;

	    @FXML
	    private ImageView imagen16;

	    @FXML
	    private Button siguienteButton;

	    @FXML
	    private Button abandonarButton;
	    
	    public  MatchPuzzleController() {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlegames/views/MatchPuzzleView.fxml"));
			loader.setController(this);
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
			
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	

	}
	 
	 
	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

	public Label getPuzzlePicLabel() {
		return puzzlePicLabel;
	}

	public void setPuzzlePicLabel(Label puzzlePicLabel) {
		this.puzzlePicLabel = puzzlePicLabel;
	}

	public Label getNamePlayerLabel() {
		return namePlayerLabel;
	}

	public void setNamePlayerLabel(Label namePlayerLabel) {
		this.namePlayerLabel = namePlayerLabel;
	}

	public Label getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(Label timeLabel) {
		this.timeLabel = timeLabel;
	}

	public Label getRoundLabel() {
		return roundLabel;
	}

	public void setRoundLabel(Label roundLabel) {
		this.roundLabel = roundLabel;
	}

	public ImageView getImagen1() {
		return imagen1;
	}

	public void setImagen1(ImageView imagen1) {
		this.imagen1 = imagen1;
	}

	public ImageView getImagen2() {
		return imagen2;
	}

	public void setImagen2(ImageView imagen2) {
		this.imagen2 = imagen2;
	}

	public ImageView getImagen3() {
		return imagen3;
	}

	public void setImagen3(ImageView imagen3) {
		this.imagen3 = imagen3;
	}

	public ImageView getImagen4() {
		return imagen4;
	}

	public void setImagen4(ImageView imagen4) {
		this.imagen4 = imagen4;
	}

	public ImageView getImagen5() {
		return imagen5;
	}

	public void setImagen5(ImageView imagen5) {
		this.imagen5 = imagen5;
	}

	public ImageView getImagen6() {
		return imagen6;
	}

	public void setImagen6(ImageView imagen6) {
		this.imagen6 = imagen6;
	}

	public ImageView getImagen7() {
		return imagen7;
	}

	public void setImagen7(ImageView imagen7) {
		this.imagen7 = imagen7;
	}

	public ImageView getImagen8() {
		return imagen8;
	}

	public void setImagen8(ImageView imagen8) {
		this.imagen8 = imagen8;
	}

	public ImageView getImagen9() {
		return imagen9;
	}

	public void setImagen9(ImageView imagen9) {
		this.imagen9 = imagen9;
	}

	public ImageView getImagen10() {
		return imagen10;
	}

	public void setImagen10(ImageView imagen10) {
		this.imagen10 = imagen10;
	}

	public ImageView getImagen11() {
		return imagen11;
	}

	public void setImagen11(ImageView imagen11) {
		this.imagen11 = imagen11;
	}

	public ImageView getImagen12() {
		return imagen12;
	}

	public void setImagen12(ImageView imagen12) {
		this.imagen12 = imagen12;
	}

	public ImageView getImagen13() {
		return imagen13;
	}

	public void setImagen13(ImageView imagen13) {
		this.imagen13 = imagen13;
	}

	public ImageView getImagen14() {
		return imagen14;
	}

	public void setImagen14(ImageView imagen14) {
		this.imagen14 = imagen14;
	}

	public ImageView getImagen15() {
		return imagen15;
	}

	public void setImagen15(ImageView imagen15) {
		this.imagen15 = imagen15;
	}

	public ImageView getImagen16() {
		return imagen16;
	}

	public void setImagen16(ImageView imagen16) {
		this.imagen16 = imagen16;
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
