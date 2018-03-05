package dad.puzzlegames.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;

public class PuzzlePiecesController implements Initializable {

	@FXML
	private BorderPane vista;

	@FXML
	private Button siguienteButton;

	@FXML
	private Button abandonarButton;

	@FXML
	private Label tituloPartida;

	@FXML
	private Label nombreLabel;

	@FXML
	private Label tiempoLabel;

	@FXML
	private Label rondaLabel;

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
	private ImageView imagen1Ficha;

	@FXML
	private ImageView imagen2Ficha;

	@FXML
	private ImageView imagen3Ficha;

	@FXML
	private ImageView imagen4Ficha;

	@FXML
	private ImageView imagen5Ficha;

	@FXML
	private ImageView imagen6Ficha;

	@FXML
	private ImageView imagen7Ficha;

	@FXML
	private ImageView imagen8Ficha;

	@FXML
	private ImageView imagen9Ficha;

	Image img;

	String pieza1 = "", pieza2 = "", pieza3 = "", pieza4 = "", pieza5 = "", pieza6 = "", pieza7 = "", pieza8 = "",
			pieza9 = "";
	File prueba;

	public PuzzlePiecesController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlegames/views/PuzzlePiecesView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	// TABLERO
	@FXML
	private void handleDragOverTab(DragEvent event) {
		if (event.getDragboard().hasImage()) {
			event.acceptTransferModes(TransferMode.ANY);
		}

		event.consume();
	}

	@FXML
	private void handleDragDroppedImg1Tab(DragEvent event) throws FileNotFoundException {
		pieza1 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen1Tab.setImage(img);

		event.consume();
	}

	@FXML
	private void handleDragDroppedImg2Tab(DragEvent event) {
		pieza2 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen2Tab.setImage(img);

		event.consume();

	}

	@FXML
	private void handleDragDroppedImg3Tab(DragEvent event) {
		pieza3 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen3Tab.setImage(img);

		event.consume();

	}

	@FXML
	private void handleDragDroppedImg4Tab(DragEvent event) {
		pieza4 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen4Tab.setImage(img);
		event.consume();

	}

	@FXML
	private void handleDragDroppedImg5Tab(DragEvent event) {
		pieza5 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen5Tab.setImage(img);
		event.consume();

	}

	@FXML
	private void handleDragDroppedImg6Tab(DragEvent event) {
		pieza6 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen6Tab.setImage(img);
		event.consume();

	}

	@FXML
	private void handleDragDroppedImg7Tab(DragEvent event) {
		pieza7 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen7Tab.setImage(img);
		event.consume();

	}

	@FXML
	private void handleDragDroppedImg8Tab(DragEvent event) {
		pieza8 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen8Tab.setImage(img);
		event.consume();

	}

	@FXML
	private void handleDragDroppedImg9Tab(DragEvent event) {
		pieza9 = event.getDragboard().getString();
		img = event.getDragboard().getImage();
		imagen9Tab.setImage(img);
		event.consume();

	}

	// FICHAS
	@FXML
	private void handleDragDetectionImg1Ficha(MouseEvent event) {
		Dragboard db = imagen1Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img0.jpg");
		cb.putImage(imagen1Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	@FXML
	private void handleDragDetectionImg2Ficha(MouseEvent event) {
		Dragboard db = imagen2Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img1.jpg");
		cb.putImage(imagen2Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	@FXML
	private void handleDragDetectionImg3Ficha(MouseEvent event) {
		Dragboard db = imagen3Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img2.jpg");
		cb.putImage(imagen3Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	@FXML
	private void handleDragDetectionImg4Ficha(MouseEvent event) {
		Dragboard db = imagen4Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img3.jpg");
		cb.putImage(imagen4Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	@FXML
	private void handleDragDetectionImg5Ficha(MouseEvent event) {
		Dragboard db = imagen5Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img4.jpg");
		cb.putImage(imagen5Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	@FXML
	private void handleDragDetectionImg6Ficha(MouseEvent event) {
		Dragboard db = imagen6Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img5.jpg");
		cb.putImage(imagen6Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	@FXML
	private void handleDragDetectionImg7Ficha(MouseEvent event) {
		Dragboard db = imagen7Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img6.jpg");
		cb.putImage(imagen7Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	@FXML
	private void handleDragDetectionImg8Ficha(MouseEvent event) {
		Dragboard db = imagen8Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img7.jpg");
		cb.putImage(imagen8Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	@FXML
	private void handleDragDetectionImg9Ficha(MouseEvent event) {
		Dragboard db = imagen9Ficha.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putString("\\piezas\\img8.jpg");
		cb.putImage(imagen9Ficha.getImage());
		db.setContent(cb);
		event.consume();

	}

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
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

	public ImageView getImagen1Ficha() {
		return imagen1Ficha;
	}

	public void setImagen1Ficha(ImageView imagen1Ficha) {
		this.imagen1Ficha = imagen1Ficha;
	}

	public ImageView getImagen2Ficha() {
		return imagen2Ficha;
	}

	public void setImagen2Ficha(ImageView imagen2Ficha) {
		this.imagen2Ficha = imagen2Ficha;
	}

	public ImageView getImagen3Ficha() {
		return imagen3Ficha;
	}

	public void setImagen3Ficha(ImageView imagen3Ficha) {
		this.imagen3Ficha = imagen3Ficha;
	}

	public ImageView getImagen4Ficha() {
		return imagen4Ficha;
	}

	public void setImagen4Ficha(ImageView imagen4Ficha) {
		this.imagen4Ficha = imagen4Ficha;
	}

	public ImageView getImagen5Ficha() {
		return imagen5Ficha;
	}

	public void setImagen5Ficha(ImageView imagen5Ficha) {
		this.imagen5Ficha = imagen5Ficha;
	}

	public ImageView getImagen6Ficha() {
		return imagen6Ficha;
	}

	public void setImagen6Ficha(ImageView imagen6Ficha) {
		this.imagen6Ficha = imagen6Ficha;
	}

	public ImageView getImagen7Ficha() {
		return imagen7Ficha;
	}

	public void setImagen7Ficha(ImageView imagen7Ficha) {
		this.imagen7Ficha = imagen7Ficha;
	}

	public ImageView getImagen8Ficha() {
		return imagen8Ficha;
	}

	public void setImagen8Ficha(ImageView imagen8Ficha) {
		this.imagen8Ficha = imagen8Ficha;
	}

	public ImageView getImagen9Ficha() {
		return imagen9Ficha;
	}

	public void setImagen9Ficha(ImageView imagen9Ficha) {
		this.imagen9Ficha = imagen9Ficha;
	}

	public Label getTituloPartida() {
		return tituloPartida;
	}

	public void setTituloPartida(Label tituloPartida) {
		this.tituloPartida = tituloPartida;
	}

	public Label getNombreLabel() {
		return nombreLabel;
	}

	public void setNombreLabel(String contenidoLabel) {
		nombreLabel.setText(contenidoLabel);
	}

	public Label getTiempoLabel() {
		return tiempoLabel;
	}

	public void setTiempoLabel(String tiempoLabel) {
		this.tiempoLabel.setText(tiempoLabel);
	}

	public Label getRondaLabel() {
		return rondaLabel;
	}

	public void setRondaLabel(Label rondaLabel) {
		this.rondaLabel = rondaLabel;
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

	public void setNombreLabel(Label nombreLabel) {
		this.nombreLabel = nombreLabel;
	}

	public void setTiempoLabel(Label tiempoLabel) {
		this.tiempoLabel = tiempoLabel;
	}

	public String getPieza1() {
		return pieza1;
	}

	public void setPieza1(String pieza1) {
		this.pieza1 = pieza1;
	}

	public String getPieza2() {
		return pieza2;
	}

	public void setPieza2(String pieza2) {
		this.pieza2 = pieza2;
	}

	public String getPieza3() {
		return pieza3;
	}

	public void setPieza3(String pieza3) {
		this.pieza3 = pieza3;
	}

	public String getPieza4() {
		return pieza4;
	}

	public void setPieza4(String pieza4) {
		this.pieza4 = pieza4;
	}

	public String getPieza5() {
		return pieza5;
	}

	public void setPieza5(String pieza5) {
		this.pieza5 = pieza5;
	}

	public String getPieza6() {
		return pieza6;
	}

	public void setPieza6(String pieza6) {
		this.pieza6 = pieza6;
	}

	public String getPieza7() {
		return pieza7;
	}

	public void setPieza7(String pieza7) {
		this.pieza7 = pieza7;
	}

	public String getPieza8() {
		return pieza8;
	}

	public void setPieza8(String pieza8) {
		this.pieza8 = pieza8;
	}

	public String getPieza9() {
		return pieza9;
	}

	public void setPieza9(String pieza9) {
		this.pieza9 = pieza9;
	}

	public File getPrueba() {
		return prueba;
	}

	public void setPrueba(File prueba) {
		this.prueba = prueba;
	}

}
