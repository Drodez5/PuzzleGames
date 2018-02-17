package dad.puzzlegames.controllers;

import java.io.File;
import java.io.IOException;

import java.util.Optional;


import dad.puzzlegames.views.PuzzleGamesApp;
import javafx.event.ActionEvent;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PuzzleGamesController {

	private MenuController controladorMenu;
	private OpcionesPartidaController controladorOpciones;
	private MarcadorController controladorMarcador;
	private PuzzlePiecesController controladorPuzzlePieces;
	private MatchPuzzleController controladorMatchPuzzle;
	private BorderPane vista;
	private Stage appStage;
	private String directorio=null;

	public PuzzleGamesController() throws IOException {
		appStage = PuzzleGamesApp.getPrimaryStage();
		
		controladorMenu = new MenuController();
		controladorOpciones = new OpcionesPartidaController();
		controladorMarcador = new MarcadorController();
		controladorPuzzlePieces = new PuzzlePiecesController();
		controladorMatchPuzzle = new MatchPuzzleController();
		vista = new BorderPane();
		vista.setCenter(controladorMenu.getVista());
		
		//CONTROLADOR MENU
		controladorMenu.getJugarButton().setOnAction(e -> onOpcionesPartidaButtonAction(e));
		controladorMenu.getMarcadorButton().setOnAction(e -> onMarcadorButtonAction(e));
		controladorMenu.getAcercaDeButton().setOnAction(e -> onAcercaDeButtonAction(e));
		controladorMenu.getSalirButton().setOnAction(e -> onSalirButtonAction(e));
		
		//CONTROLADOR OPCIONES
		controladorOpciones.getAtrasButton().setOnAction(e->onAtrasButtonAction(e));
		controladorOpciones.getAbrirButton().setOnAction(e->onAbrirButtonAction(e));
		controladorOpciones.getContinuarButton().setOnAction(e->onJugarButtonAction(e));
		
		//CONTROLADOR MARCADOR
		controladorMarcador.getVolverButton().setOnAction(e->onAtrasButtonAction(e));

	}

	private void onJugarButtonAction(ActionEvent e) {
		if (controladorOpciones.getNombreText().getText().equals("")
				|| controladorOpciones.getNombreText().getText() == null || directorio == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!");
			alert.setHeaderText("Algo ha fallado...");
			alert.setContentText("Por favor, revise los campos.");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.initOwner(appStage);
			alert.showAndWait();

		} else {

			
			switch (controladorOpciones.getDificultadCombo().getValue()) {
			case FACIL:
				System.out.println("FACIL");

				switch (controladorOpciones.getJuegoCombo().getValue()) {
				case PUZZLE_PIECES:
					System.out.println("PUZLE PIECES");
					controladorPuzzlePieces.setNombreLabel(controladorOpciones.getNombreText().getText());
					vista.setCenter(controladorPuzzlePieces.getVista());
					

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					
				
					vista.setCenter(controladorMatchPuzzle.getVista());
				
					break;

				case BEJEWELED:
					System.out.println("BEJEWELED");
					
					//vista.setCenter(value);
					break;

				default:
					break;
				}

				break;

			case MEDIA:
				System.out.println("MEDIA");
				switch (controladorOpciones.getJuegoCombo().getValue()) {
				case PUZZLE_PIECES:
					System.out.println("PUZLE PIECES");

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					break;

				case BEJEWELED:
					System.out.println("BEJEWELED");
					break;

				default:
					break;
				}

				break;

			case DIFICIL:
				System.out.println("DIFICIL");
				switch (controladorOpciones.getJuegoCombo().getValue()) {
				case PUZZLE_PIECES:
					System.out.println("PUZLE PIECES");

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					break;

				case BEJEWELED:
					System.out.println("BEJEWELED");
					break;

				default:
					break;
				}

				break;

			default:
				break;
			}

			

		}

		
	}

	private void onAbrirButtonAction(ActionEvent e) {
		 DirectoryChooser directoryChooser = new DirectoryChooser();
         File selectedDirectory =  directoryChooser.showDialog(appStage);
         
         if(selectedDirectory == null){
             controladorOpciones.getDirectorioLabel().setText("No hay directorio seleccionado.");
             this.directorio=null;
         }else{
             controladorOpciones.getDirectorioLabel().setText(selectedDirectory.getAbsolutePath());
             this.directorio=selectedDirectory.getAbsolutePath();
         }
	
	}

	private void onAtrasButtonAction(ActionEvent e) {
		volverAMenu();	
	}

	private void onMarcadorButtonAction(ActionEvent e) {
		vista.setCenter(controladorMarcador.getVista());

	}

	// METODO SALIR
	private void onSalirButtonAction(ActionEvent e) {
		Alert alertExit = new Alert(AlertType.CONFIRMATION);
		alertExit.setTitle("PuzzleGames");
		alertExit.setHeaderText("Saliendo de PuzzleGames");
		alertExit.initOwner(appStage);
		alertExit.initModality(Modality.APPLICATION_MODAL);
		alertExit.setContentText("�Seguro que quiere salir?");

		Optional<ButtonType> result = alertExit.showAndWait();
		if (result.get() == ButtonType.OK) {
			appStage.close();
		}

		

	}

	private void onAcercaDeButtonAction(ActionEvent e) {
		Dialog<Void> dialog = new Dialog<>();
		dialog.setTitle("About...");
		dialog.initOwner(appStage);
		dialog.setContentText("Desarrollador:\n" + "Domingo Rodr�guez");
		dialog.setGraphic(new ImageView(getClass().getResource("/dad/puzzlegames/resources/developer.png").toExternalForm()));
		ButtonType ok = new ButtonType("OK", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().add(ok);
		dialog.showAndWait();


	}

	private void onOpcionesPartidaButtonAction(ActionEvent e) {
		vista.setCenter(controladorOpciones.getVista());

	}
	
	private void volverAMenu() {
		vista.setCenter(controladorMenu.getVista());
	}

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

}
