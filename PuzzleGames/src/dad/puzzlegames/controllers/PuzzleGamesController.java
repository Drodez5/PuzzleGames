package dad.puzzlegames.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
import javafx.scene.media.AudioClip;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Domingo Rodriguez
 * @version 1.0
 */
public class PuzzleGamesController implements Initializable {

	private MenuController controladorMenu;
	private OpcionesPartidaController controladorOpciones;
	private MarcadorController controladorMarcador;
	private PuzzlePiecesController controladorPuzzlePieces;
	private MatchPuzzleController controladorMatchPuzzle;
	private BorderPane vista;
	private Stage appStage;

	private Integer tiempoMedio = 60;
	private Integer tiempoFacil = 180;
	private Integer tiempoDificil = 30;
	private Integer sec;
	private int rondas = 0;
	private int rondaActual = 1;

	private ArrayList<File> imagenes;
	private ArrayList<Image> imagenesMatch, imagenesPiezes;
	private Timeline tiempo;
	private AudioClip audio;

	private int clic = 0;
	private int clic1 = -1;
	private int clic2 = -1;

	private FadeTransition transicionEntrada, transicionSalida;

	// Modelo
	private Jugador jugadorNuevo;

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

		initialize(null, null);

	}

	/**
	 * Metodo initialize
	 * 
	 * @param location,resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// INSTANCIAS E INICIALIZACIONES
		audio = new AudioClip(getClass().getResource("/dad/puzzlegames/resources/openingIntro.mp3").toExternalForm());
		jugadorNuevo = new Jugador();
		util = new Utilidades();
		imagenes = new ArrayList<>();
		imagenesMatch = util.cargaMatches();
		imagenesPiezes = new ArrayList<>();
		audio.play();

		controladorOpciones.getJuegoCombo().setOnAction(e -> {
			if (controladorOpciones.getJuegoCombo().getValue() == Modo.MATCH_PUZZLE) {
				jugadorNuevo.setDirectorio(" ");
				controladorOpciones.getAbrirButton().setDisable(true);
			} else {
				controladorOpciones.getAbrirButton().setDisable(false);
			}
		});

		// EVENTOS
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
		controladorMatchPuzzle.getSiguienteButton().setOnAction(e -> onTerminarButtonAction(e));

		// CONTROLADOR PUZZLE PIECES
		controladorPuzzlePieces.getAbandonarButton().setOnAction(e -> onAbandonarButtonAction(e));
		controladorPuzzlePieces.getSiguienteButton().setOnAction(e -> onTerminarButtonAction(e));
		
		

		// BINDEOS
		controladorOpciones.getContinuarButton().disableProperty()
				.bind(controladorOpciones.getRondasCombo().valueProperty().isEqualTo(1));
		controladorOpciones.getContinuarButton().disableProperty()
				.bind(controladorOpciones.getNombreText().textProperty().isEmpty());
		controladorOpciones.getContinuarButton().disableProperty().bind(jugadorNuevo.directorioProperty().isEmpty());
//		controladorMarcador.getGenerarInformeButton().disableProperty().bind(controladorMarcador.getTableScores().itemsProperty().isEqualTo(0));

	}

	/*
	 * Metodo de terminar
	 * 
	 * @param ActionEvent e
	 * 
	 */
	private void onTerminarButtonAction(ActionEvent e) {

		tiempo.stop();
		if (compruebaPuzzles() == true) {
			System.out.println("La victoria es nuestra");
		} else {
			System.out.println("La derrota yacerá sobre tu tumba");
		}

	}

	/**
	 * Metodo de sonido
	 * 
	 * @param ActionEvent
	 *            e
	 * 
	 */
	private void onSonidoButtonAction(ActionEvent e) {
		if (audio.isPlaying()) {
			audio.stop();
			controladorMenu.getSonidoImage().setImage(new Image("/dad/puzzlegames/resources/sound_off.png"));

		} else {
			audio.play();
			controladorMenu.getSonidoImage().setImage(new Image("/dad/puzzlegames/resources/sound_on.png"));

		}

	}

	/**
	 * Metodo de abandonar
	 * 
	 * @param ActionEvent
	 *            e
	 * 
	 */
	private void onAbandonarButtonAction(ActionEvent e) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("¿Seguro que deseas abandonar?");
		alert.setHeaderText("Tu puntuación se verá afectada.");
		alert.setContentText("¿Estas seguro?");
		alert.initOwner(appStage);
		alert.initModality(Modality.APPLICATION_MODAL);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			audio.stop();
			vista.setCenter(controladorMenu.getVista());

		}

	}

	/**
	 * Metodo de Tema
	 * 
	 * @param ActionEvent
	 */
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

	/**
	 * Metodo cargar SplashScreen
	 */

	private void loadSplashScreen() throws IOException {
		cargaSplash = true;

		FadeTransition transicionEntrada = new FadeTransition(Duration.seconds(1), vista);
		transicionEntrada.setFromValue(1);
		transicionEntrada.setToValue(0);
		transicionEntrada.setCycleCount(1);
		transicionEntrada.play();

		FadeTransition transicionSalida = new FadeTransition(Duration.seconds(1), vista);
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

	/**
	 * Metodo de jugar
	 * 
	 * @param ActionEvent
	 */
	private void onJugarButtonAction(ActionEvent e) {

		// CREO A UN NUEVO JUGADOR

		jugadorNuevo.setNombre(controladorOpciones.getNombreText().getText());
		jugadorNuevo.setDificultad(controladorOpciones.getDificultadCombo().getValue().toString());
		jugadorNuevo.setModo(controladorOpciones.getJuegoCombo().getValue());
		jugadorNuevo.setRondas(controladorOpciones.getRondasCombo().getValue());

		// ESTABLECEMOS EL NUMERO DE RONDAS
		this.rondas = controladorOpciones.getRondasCombo().getValue();

		switch (controladorOpciones.getDificultadCombo().getValue()) {
		case FACIL:
			System.out.println("FACIL");

			switch (controladorOpciones.getJuegoCombo().getValue()) {
			case PUZZLE_PIECES:
				System.out.println("PUZZLE PIECES");
				if (recolectaImagenes() == true) {

					iniciarPartidaPuzzlePiecesFacil(jugadorNuevo);

				}

				break;
			case MATCH_PUZZLE:
				System.out.println("MATCH PUZZLE");
				util.noDisponibleDialog(appStage);
				this.sec = tiempoFacil;

				break;

			case SLIDING_PUZZLE:
				System.out.println("SLIDING PUZZLE");
				this.sec = tiempoFacil;
				cuentaAtras();

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
				util.noDisponibleDialog(appStage);
				this.sec = tiempoMedio;

				break;
			case MATCH_PUZZLE:
				System.out.println("MATCH PUZZLE");
				this.sec = tiempoMedio;
				cuentaAtras();
				vista.setCenter(controladorMatchPuzzle.getVista());
				iniciarPartidaMatchPuzzle(jugadorNuevo);

				break;

			case SLIDING_PUZZLE:
				System.out.println("SLIDING PUZZLE");
				util.noDisponibleDialog(appStage);
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
				util.noDisponibleDialog(appStage);

				break;
			case MATCH_PUZZLE:
				System.out.println("MATCH PUZZLE");
				this.sec = tiempoDificil;
				util.noDisponibleDialog(appStage);
				break;

			case SLIDING_PUZZLE:
				System.out.println("SLIDING_PUZZLE");
				this.sec = tiempoDificil;
				util.noDisponibleDialog(appStage);
				break;

			default:
				break;
			}

			break;

		default:
			break;
		}

	}

	/**
	 * Metodo de iniciar partida
	 * 
	 * @param jugadorNuevo
	 */
	private void iniciarPartidaMatchPuzzle(Jugador jugadorNuevo) {

		controladorMatchPuzzle.getNamePlayerLabel().setText(jugadorNuevo.getNombre());
		controladorMatchPuzzle.getRoundLabel().setText(rondaActual + "");

		Image interrogation = new Image("/dad/puzzlegames/resources/interrogation.jpg");

		controladorMatchPuzzle.getImagen1().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen1());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen1());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen1().setImage(imagenesMatch.get(0));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen1().setImage(interrogation);
				clic++;
				compruebaClic(1);
			});

		});

		controladorMatchPuzzle.getImagen2().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen2());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen2());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen2().setImage(imagenesMatch.get(1));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen2().setImage(interrogation);
				clic++;
				compruebaClic(2);
			});

		});
		controladorMatchPuzzle.getImagen3().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen3());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen3());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen3().setImage(imagenesMatch.get(1));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen3().setImage(interrogation);
				clic++;
				compruebaClic(2);
			});

		});
		controladorMatchPuzzle.getImagen4().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen4());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen4());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen4().setImage(imagenesMatch.get(2));
				clic++;
				compruebaClic(3);

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen4().setImage(interrogation);
			});

		});

		controladorMatchPuzzle.getImagen5().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen5());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen5());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen5().setImage(imagenesMatch.get(7));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen5().setImage(interrogation);
				clic++;
				compruebaClic(8);
			});

		});
		controladorMatchPuzzle.getImagen6().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen6());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen6());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen6().setImage(imagenesMatch.get(5));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen6().setImage(interrogation);
			});

		});

		controladorMatchPuzzle.getImagen7().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen7());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen7());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen7().setImage(imagenesMatch.get(4));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen7().setImage(interrogation);
				clic++;
				compruebaClic(5);
			});

		});

		controladorMatchPuzzle.getImagen8().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen8());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen8());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen8().setImage(imagenesMatch.get(4));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen8().setImage(interrogation);
				clic++;
				compruebaClic(5);
			});

		});
		controladorMatchPuzzle.getImagen9().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen9());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen9());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen9().setImage(imagenesMatch.get(6));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen9().setImage(interrogation);
				clic++;
				compruebaClic(7);
			});

		});

		controladorMatchPuzzle.getImagen10().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen10());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen10());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen10().setImage(imagenesMatch.get(5));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen10().setImage(interrogation);
				clic++;
				compruebaClic(6);
			});

		});

		controladorMatchPuzzle.getImagen11().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen11());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen11());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen11().setImage(imagenesMatch.get(3));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen11().setImage(interrogation);
				clic++;
				compruebaClic(4);
			});

		});

		controladorMatchPuzzle.getImagen12().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen12());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen12());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen12().setImage(imagenesMatch.get(7));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen12().setImage(interrogation);
				clic++;
				compruebaClic(8);
			});

		});
		controladorMatchPuzzle.getImagen13().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen13());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen13());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen13().setImage(imagenesMatch.get(0));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen13().setImage(interrogation);
				clic++;
				compruebaClic(1);
			});

		});
		controladorMatchPuzzle.getImagen14().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen14());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen14());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen14().setImage(imagenesMatch.get(3));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen14().setImage(interrogation);
				clic++;
				compruebaClic(4);
			});

		});

		controladorMatchPuzzle.getImagen15().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen15());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen15());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen15().setImage(imagenesMatch.get(2));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen15().setImage(interrogation);
				clic++;
				compruebaClic(3);
			});

		});

		controladorMatchPuzzle.getImagen16().setOnMouseClicked(e -> {
			transicionEntrada = abrirTransicion(controladorMatchPuzzle.getImagen16());

			transicionEntrada.play();

			transicionSalida = cerrarTransicion(controladorMatchPuzzle.getImagen16());

			transicionEntrada.setOnFinished(a -> {
				transicionSalida.play();
				controladorMatchPuzzle.getImagen16().setImage(imagenesMatch.get(6));

			});

			transicionSalida.setOnFinished(a -> {
				controladorMatchPuzzle.getImagen16().setImage(interrogation);
				clic++;
				compruebaClic(7);
			});

		});

	}

	/**
	 * Metodo de abrir
	 * 
	 * @param ActionEvent
	 */
	private void onAbrirButtonAction(ActionEvent e) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDirectory = directoryChooser.showDialog(appStage);

		if (selectedDirectory == null) {
			controladorOpciones.getDirectorioLabel().setText("No hay directorio seleccionado.");

		} else {
			controladorOpciones.getDirectorioLabel().setText(selectedDirectory.getAbsolutePath());
			jugadorNuevo.setDirectorio(selectedDirectory.getAbsolutePath());
		}

	}

	/**
	 * Metodo de volver
	 * 
	 * @param ActionEvent
	 *            e
	 */
	private void onAtrasButtonAction(ActionEvent e) {
		volverAMenu();
	}

	/**
	 * Metodo para visualizar el marcador
	 * 
	 * @param ActionEvent
	 *            e
	 */
	private void onMarcadorButtonAction(ActionEvent e) {
		vista.setCenter(controladorMarcador.getVista());
	}

	/**
	 * Metodo para salir
	 * 
	 * @param ActionEvent
	 *            e
	 */
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

	/**
	 * Metodo de acerca de
	 * 
	 * @param ActionEvent
	 *            e
	 */
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

	/**
	 * Metodo cambiar vista opciones
	 * 
	 * @param ActionEvent
	 *            e
	 */
	private void onOpcionesPartidaButtonAction(ActionEvent e) {
		vista.setCenter(controladorOpciones.getVista());

	}

	/**
	 * Metodo para iniciar Partida Puzzle Pieces Facil
	 * 
	 * @param jugadorNuevo
	 * @throws URISyntaxException
	 */
	private void iniciarPartidaPuzzlePiecesFacil(Jugador jugadorNuevo) {

		try {
			util.trozeaImagenes(imagenes.get(rondaActual), Dificultad.FACIL);

			for (int i = 0; i < 9; i++) {
				Image imagen = new Image(new File("\\piezas\\img" + i + ".jpg").toURI().toString());
				imagenesPiezes.add(imagen);

			}
			controladorPuzzlePieces.getImagen1Ficha().setImage(imagenesPiezes.get(0));
			controladorPuzzlePieces.getImagen2Ficha().setImage(imagenesPiezes.get(1));
			controladorPuzzlePieces.getImagen3Ficha().setImage(imagenesPiezes.get(2));
			controladorPuzzlePieces.getImagen4Ficha().setImage(imagenesPiezes.get(3));
			controladorPuzzlePieces.getImagen5Ficha().setImage(imagenesPiezes.get(4));
			controladorPuzzlePieces.getImagen6Ficha().setImage(imagenesPiezes.get(5));
			controladorPuzzlePieces.getImagen7Ficha().setImage(imagenesPiezes.get(6));
			controladorPuzzlePieces.getImagen8Ficha().setImage(imagenesPiezes.get(7));
			controladorPuzzlePieces.getImagen9Ficha().setImage(imagenesPiezes.get(8));

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

	/**
	 * Metodo para volver a menu principal
	 */
	private void volverAMenu() {
		vista.setCenter(controladorMenu.getVista());
	}

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

	/**
	 * Metodo para recolectar imagenes del directorio especificado
	 */
	private boolean recolectaImagenes() {
		boolean check = true;
		try {
			imagenes = util.seleccionaImagen(jugadorNuevo.getDirectorio(), rondas);
		} catch (IndexOutOfBoundsException e) {
			util.imagenesInsuficientesDialog(appStage);
			check = false;

		}

		return check;

	}

	/**
	 * Metodo del contador (Cuenta atrás)
	 */
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

				if (0 == sec) {
					System.out.println("Game Over");
					tiempo.stop();

				}

			}
		});

		tiempo.getKeyFrames().add(frame);
		tiempo.playFromStart();
	}

	/**
	 * Metodo que comprueba y registra el clic
	 * 
	 * @param int
	 *            cod
	 */
	private void compruebaClic(int cod) {

		if (clic == 2) {

			System.out.println("Clic igual a 2");
			clic2 = cod;
			if (clic1 == clic2) {
				System.out.println("son iguales");
				resolverMatch(cod);
			} else {
				System.out.println("no lo son");
			}

			this.clic = 0;
			this.clic1 = -1;
			this.clic2 = -1;
		} else if (clic == 1) {
			System.out.println("Clic igual a 1");

			clic1 = cod;

		}
	}

	/**
	 * Metodo de reolverMatch
	 */
	private void resolverMatch(int cod) {
		switch (cod) {
		case 1:
			controladorMatchPuzzle.getImagen1().setImage(imagenesMatch.get(0));
			controladorMatchPuzzle.getImagen13().setImage(imagenesMatch.get(0));

			break;

		case 2:
			controladorMatchPuzzle.getImagen2().setImage(imagenesMatch.get(1));
			controladorMatchPuzzle.getImagen3().setImage(imagenesMatch.get(1));

			break;

		case 3:
			controladorMatchPuzzle.getImagen4().setImage(imagenesMatch.get(2));
			controladorMatchPuzzle.getImagen15().setImage(imagenesMatch.get(2));

			break;

		case 4:
			controladorMatchPuzzle.getImagen14().setImage(imagenesMatch.get(3));
			controladorMatchPuzzle.getImagen11().setImage(imagenesMatch.get(3));
			break;

		case 5:
			controladorMatchPuzzle.getImagen7().setImage(imagenesMatch.get(4));
			controladorMatchPuzzle.getImagen8().setImage(imagenesMatch.get(4));
			break;

		case 6:
			controladorMatchPuzzle.getImagen6().setImage(imagenesMatch.get(5));
			controladorMatchPuzzle.getImagen10().setImage(imagenesMatch.get(5));
			break;

		case 7:
			controladorMatchPuzzle.getImagen9().setImage(imagenesMatch.get(6));
			controladorMatchPuzzle.getImagen16().setImage(imagenesMatch.get(6));

			break;
		case 8:
			controladorMatchPuzzle.getImagen5().setImage(imagenesMatch.get(7));
			controladorMatchPuzzle.getImagen12().setImage(imagenesMatch.get(7));

			break;

		default:
			break;
		}

	}

	private boolean compruebaPuzzles() {
		boolean puzzleCorrecto = false;

		if (jugadorNuevo.getModo() == Modo.MATCH_PUZZLE) {

		} else if (jugadorNuevo.getModo() == Modo.PUZZLE_PIECES) {

			// if() {
			//
			// }

		} else {

		}

		return puzzleCorrecto;

	}

	private FadeTransition abrirTransicion(ImageView imagen) {
		transicionEntrada = new FadeTransition(Duration.seconds(0.5), controladorMatchPuzzle.getImagen1());
		transicionEntrada.setFromValue(1);
		transicionEntrada.setToValue(0);
		transicionEntrada.setCycleCount(1);

		return transicionEntrada;
	}

	private FadeTransition cerrarTransicion(ImageView imagen) {
		transicionSalida = new FadeTransition(Duration.seconds(0.5), controladorMatchPuzzle.getImagen1());
		transicionSalida.setFromValue(0);
		transicionSalida.setToValue(1);
		transicionSalida.setCycleCount(1);
		return transicionSalida;

	}

}
