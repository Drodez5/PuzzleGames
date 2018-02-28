package dad.puzzlegames.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.puzzlegames.models.Dificultad;
import dad.puzzlegames.models.Jugador;
import dad.puzzlegames.models.Modo;
import dad.puzzlegames.models.Utilidades;
import dad.puzzlegames.views.PuzzleGamesApp;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PuzzleGamesController implements Initializable {

	private MenuController controladorMenu;
	private OpcionesPartidaController controladorOpciones;
	private MarcadorController controladorMarcador;
	private PuzzlePiecesController controladorPuzzlePieces;
	private MatchPuzzleController controladorMatchPuzzle;
	private BorderPane vista;
	private Stage appStage;
	private String directorio = null;

	private Integer tiempoMedio = 60;
	private Integer tiempoFacil = 5; // 180
	private Integer tiempoDificil = 30;
	private Integer sec;
	private int rondas = 0;
	private int rondaActual = 1;
	private Jugador jugadorNuevo;
	private ArrayList<File> imagenes;
	private Timeline tiempo;
	private AudioClip audio;
	private boolean sonido=true;

	private Utilidades util;

	public static boolean cargaSplash = false;

	public PuzzleGamesController() throws IOException {

		appStage = PuzzleGamesApp.getPrimaryStage();

		controladorMenu = new MenuController();
		controladorOpciones = new OpcionesPartidaController();
		controladorMarcador = new MarcadorController();
		controladorPuzzlePieces = new PuzzlePiecesController();
		controladorMatchPuzzle = new MatchPuzzleController();

		vista = new BorderPane();
		vista.setCenter(new ImageView("/dad/puzzlegames/resources/splashimage.jpg"));
		if (cargaSplash == false) {
			loadSplashScreen();
		}
		

		// CONTROLADOR MENU
		controladorMenu.getJugarButton().setOnAction(e -> onOpcionesPartidaButtonAction(e));
		controladorMenu.getMarcadorButton().setOnAction(e -> onMarcadorButtonAction(e));
		controladorMenu.getAcercaDeButton().setOnAction(e -> onAcercaDeButtonAction(e));
		controladorMenu.getSalirButton().setOnAction(e -> onSalirButtonAction(e));
		controladorMenu.getTemaButton().setOnAction(e -> onTemaButtonAction(e));
		controladorMenu.getSonidoButton().setOnAction(e -> onSonidoButtonAction(e));

		// CONTROLADOR OPCIONES
		controladorOpciones.getNombreText().requestFocus();
		controladorOpciones.getAtrasButton().setOnAction(e -> onAtrasButtonAction(e));
		controladorOpciones.getAbrirButton().setOnAction(e -> onAbrirButtonAction(e));
		controladorOpciones.getContinuarButton().setOnAction(e -> onJugarButtonAction(e));

		// CONTROLADOR MARCADOR
		controladorMarcador.getVolverButton().setOnAction(e -> onAtrasButtonAction(e));

		// CONTROLADOR MATCH PUZZLE
		controladorMatchPuzzle.getAbandonarButton().setOnAction(e -> onAbandonarButtonAction(e));

		// CONTROLADOR PUZZLE PIECES
		controladorPuzzlePieces.getAbandonarButton().setOnAction(e -> onAbandonarButtonAction(e));

		
		initialize(null, null);
		

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		audio = new AudioClip(getClass().getResource("/dad/puzzlegames/resources/openingIntro.mp3").toExternalForm());
		audio.play();
		util = new Utilidades();
		imagenes = new ArrayList<>();
		
		controladorOpciones.getJuegoCombo().setOnAction(e->{
			if(controladorOpciones.getJuegoCombo().getValue()==Modo.BEJEWELED |controladorOpciones.getJuegoCombo().getValue()==Modo.MATCH_PUZZLE) {
				
				controladorOpciones.getAbrirButton().setDisable(true);
			} else {
				controladorOpciones.getAbrirButton().setDisable(false);
			}
		});
		
		
	}

	private void onSonidoButtonAction(ActionEvent e) {
		if (audio.isPlaying()) {
			audio.stop();
			controladorMenu.getSonidoImage().setImage(new Image("/dad/puzzlegames/resources/sound_off.png"));
			this.sonido=false;
			

		} else {
			audio.play();
			controladorMenu.getSonidoImage().setImage(new Image("/dad/puzzlegames/resources/sound_on.png"));
			this.sonido=true;

		}

	}
	


	private void onAbandonarButtonAction(ActionEvent e) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("¿Seguro que deseas abandonar?");
		alert.setHeaderText("Tu puntuación se verá afectada.");
		alert.setContentText("¿Estas seguro?");
		alert.initOwner(appStage);
		alert.initModality(Modality.APPLICATION_MODAL);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			audio.play();
			vista.setCenter(controladorMenu.getVista());

		}

	}

	private void onTemaButtonAction(ActionEvent e) {
		List<String> choices = new ArrayList<String>();
		choices.add("EMO");
		choices.add("ANIMADO");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("ANIMADO", choices);
		dialog.setTitle("Elige un tema");
		dialog.initOwner(appStage);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setHeaderText("Cambia la apariencia");
		dialog.setContentText("Elige una skin:");
		Optional<String> result = dialog.showAndWait();
		if (!result.get().isEmpty()) {

			switch (result.get()) {
			case "EMO":
				appStage.getScene().getStylesheets().clear();
				appStage.getScene().getStylesheets()
						.add(getClass().getResource("/dad/puzzlegames/resources/Minimalista.css").toExternalForm());
				break;
			case "ANIMADO":
				appStage.getScene().getStylesheets().clear();
				appStage.getScene().getStylesheets()
						.add(getClass().getResource("/dad/puzzlegames/resources/Animado.css").toExternalForm());
				break;

			case "DEFAULT":
				appStage.getScene().getStylesheets().clear();
				appStage.getScene().getStylesheets()
						.add(getClass().getResource("/dad/puzzlegames/resources/Animados.css").toExternalForm());
				break;
			}
		} else {

		}

	}

	private void loadSplashScreen() throws IOException {
		cargaSplash = true;

		FadeTransition transicionEntrada = new FadeTransition(Duration.seconds(2), vista);
		transicionEntrada.setFromValue(1);
		transicionEntrada.setToValue(0);
		transicionEntrada.setCycleCount(1);
		transicionEntrada.play();

		FadeTransition transicionSalida = new FadeTransition(Duration.seconds(2), vista);
		transicionSalida.setFromValue(0);
		transicionSalida.setToValue(1);
		transicionSalida.setCycleCount(1);

		transicionEntrada.setOnFinished(e -> {
			transicionSalida.play();

		});

		transicionSalida.setOnFinished(e -> {
			vista.setCenter(controladorMenu.getVista());

		});
	}

	private void onJugarButtonAction(ActionEvent e) {

		if (controladorOpciones.getNombreText().getText().equals("")
				|| controladorOpciones.getNombreText().getText() == null ) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!");
			alert.setHeaderText("Algo ha fallado...");
			alert.setContentText("Por favor, revise los campos.");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.initOwner(appStage);
			alert.showAndWait();

		} else {

			// CREO A UN NUEVO JUGADOR
			jugadorNuevo = new Jugador();
			jugadorNuevo.setNombre(controladorOpciones.getNombreText().getText());
			jugadorNuevo.setDificultad(controladorOpciones.getDificultadCombo().getValue().toString());
			jugadorNuevo.setModo(controladorOpciones.getJuegoCombo().getValue().toString());
			jugadorNuevo.setDirectorio(directorio);
			jugadorNuevo.setRondas(controladorOpciones.getRondasCombo().getValue());

			// ESTABLECEMOS EL NUMERO DE RONDAS
			this.rondas = controladorOpciones.getRondasCombo().getValue();

			switch (controladorOpciones.getDificultadCombo().getValue()) {
			case FACIL:
				System.out.println("FACIL");

				switch (controladorOpciones.getJuegoCombo().getValue()) {
				case PUZZLE_PIECES:
					System.out.println("PUZZLE PIECES");

					if(directorio!=null) {
					if (recolectaImagenes() == true) {
						
						if(sonido==true) {
							audio.stop();
							audio = new AudioClip(getClass().getResource("/dad/puzzlegames/resources/partidaMusic.mp3").toExternalForm());
							audio.play();
							
						} else {
							audio.stop();
							
						}

						iniciarPartidaPuzzlePiecesFacil(jugadorNuevo);

					}
					} else {
						
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error!!");
						alert.setHeaderText("Algo ha fallado...");
						alert.setContentText("Especifique la carpeta de imagenes.");
						alert.initModality(Modality.APPLICATION_MODAL);
						alert.initOwner(appStage);
						alert.showAndWait();
						
					}

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					this.sec = tiempoFacil;
					cuentaAtras();
					vista.setCenter(controladorMatchPuzzle.getVista());

					break;

				case BEJEWELED:
					System.out.println("BEJEWELED");
					this.sec = tiempoFacil;
					cuentaAtras();
					// vista.setCenter(value);
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
					this.sec = tiempoMedio;

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					this.sec = tiempoMedio;
					break;

				case BEJEWELED:
					System.out.println("BEJEWELED");
					this.sec = tiempoMedio;

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
					this.sec = tiempoDificil;

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					this.sec = tiempoDificil;
					break;

				case BEJEWELED:
					System.out.println("BEJEWELED");
					this.sec = tiempoDificil;
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
		File selectedDirectory = directoryChooser.showDialog(appStage);

		if (selectedDirectory == null) {
			controladorOpciones.getDirectorioLabel().setText("No hay directorio seleccionado.");
			this.directorio = null;
		} else {
			controladorOpciones.getDirectorioLabel().setText(selectedDirectory.getAbsolutePath());
			this.directorio = selectedDirectory.getAbsolutePath();
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
		alertExit.setContentText("¿Seguro que quiere salir?");

		Optional<ButtonType> result = alertExit.showAndWait();
		if (result.get() == ButtonType.OK) {
			appStage.close();
		}

	}

	private void onAcercaDeButtonAction(ActionEvent e) {
		Dialog<Void> dialog = new Dialog<>();
		dialog.setTitle("About...");
		dialog.initOwner(appStage);
		dialog.setContentText("Desarrollador:\n" + "Domingo Rodríguez");
		dialog.setGraphic(
				new ImageView(getClass().getResource("/dad/puzzlegames/resources/developer.png").toExternalForm()));
		ButtonType ok = new ButtonType("OK", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().add(ok);
		dialog.showAndWait();

	}

	private void onOpcionesPartidaButtonAction(ActionEvent e) {
		vista.setCenter(controladorOpciones.getVista());

	}

	private void iniciarPartidaPuzzlePiecesFacil(Jugador jugadorNuevo) {

		try {
			util.trozeaImagenes(imagenes.get(rondaActual), Dificultad.FACIL);

			File archivo1 = new File("\\piezas\\img0.jpg");
			Image imagen1 = new Image(archivo1.toURI().toString());
			controladorPuzzlePieces.getImagen1Ficha().setImage(imagen1);
			File archivo2 = new File("\\piezas\\img1.jpg");
			Image imagen2 = new Image(archivo2.toURI().toString());
			controladorPuzzlePieces.getImagen2Ficha().setImage(imagen2);
			File archivo3 = new File("\\piezas\\img2.jpg");
			Image imagen3 = new Image(archivo3.toURI().toString());
			controladorPuzzlePieces.getImagen3Ficha().setImage(imagen3);
			File archivo4 = new File("\\piezas\\img3.jpg");
			Image imagen4 = new Image(archivo4.toURI().toString());
			controladorPuzzlePieces.getImagen4Ficha().setImage(imagen4);
			File archivo5 = new File("\\piezas\\img4.jpg");
			Image imagen5 = new Image(archivo5.toURI().toString());
			controladorPuzzlePieces.getImagen5Ficha().setImage(imagen5);
			File archivo6 = new File("\\piezas\\img5.jpg");
			Image imagen6 = new Image(archivo6.toURI().toString());
			controladorPuzzlePieces.getImagen6Ficha().setImage(imagen6);
			File archivo7 = new File("\\piezas\\img6.jpg");
			Image imagen7 = new Image(archivo7.toURI().toString());
			controladorPuzzlePieces.getImagen7Ficha().setImage(imagen7);
			File archivo8 = new File("\\piezas\\img7.jpg");
			Image imagen8 = new Image(archivo8.toURI().toString());
			controladorPuzzlePieces.getImagen8Ficha().setImage(imagen8);
			File archivo9 = new File("\\piezas\\img8.jpg");
			Image imagen9 = new Image(archivo9.toURI().toString());
			controladorPuzzlePieces.getImagen9Ficha().setImage(imagen9);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ronda actual en inicar partida vale" + rondaActual);
		this.sec = tiempoFacil;
		cuentaAtras();
		controladorPuzzlePieces.setNombreLabel(jugadorNuevo.getNombre());
		controladorPuzzlePieces.getRondaLabel().setText(rondaActual + "");
		vista.setCenter(controladorPuzzlePieces.getVista());

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

	// METODO PARA RECOLECTAR IMAGENES DEL DIRECTORIO ESPECIFICADO
	private boolean recolectaImagenes() {
		boolean check = true;

		Utilidades util = new Utilidades();
		try {
			imagenes = util.seleccionaImagen(directorio, rondas);
		} catch (IndexOutOfBoundsException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Número de imagenes insuficiente");
			alert.setContentText(
					"Al parecer has establecido, mayor número de rondas, que imagenes tienes en la carpeta especificada.\nBaja el número de rondas o coloca más imagenes");
			alert.initOwner(appStage);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();
			check = false;

		}

		return check;

	}

	// METODO DEL CONTADOR
	private void cuentaAtras() {
		tiempo = new Timeline();
		tiempo.setCycleCount(Timeline.INDEFINITE);

		if (tiempo != null) {
			tiempo.stop();
		}
		KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				sec--;
				controladorPuzzlePieces.getTiempoLabel().setText(util.convertirAMinutos(sec));
				controladorMatchPuzzle.getTimeLabel().setText(util.convertirAMinutos(sec));

				if (0 >= sec) {
					System.out.println("Game Over");
					tiempo.stop();

				}

			}
		});

		tiempo.getKeyFrames().add(frame);
		tiempo.playFromStart();
	}

	

}
