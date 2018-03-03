package dad.puzzlegames.models;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Utilidades {

	// DEVUELVE UN CONJUNTO DE IMGENES SELECCIONADO, DEPEDNIENDO DEL NUM DE RONDAS
	public ArrayList<File> seleccionaImagen(String dir, int rondas) {
		File directorio = new File(dir);
		File[] archivos = directorio.listFiles();
		ArrayList<File> imagenes = new ArrayList<>();
		ArrayList<File> imagenesSeleccionadas = new ArrayList<>();

		if (directorio.list() == null) {
			System.out.println("Directorio vacío.");
		} else {
			System.out.println(archivos.length);

			// recorre los archivos
			for (int i = 0; i <= archivos.length - 1; i++) {

				// si son imagenes las mete
				if (archivos[i].getName().endsWith(".jpg") | archivos[i].getName().endsWith(".png")) {
					imagenes.add(archivos[i]);

				}

			}

			for (int i = 0; i < rondas; i++) {
				imagenesSeleccionadas.add(imagenes.get(i));

			}

		}
		return imagenes;

	}

	public ArrayList<Image> cargaMatches() {

		ArrayList<Image> imagenes = new ArrayList<>();

		for (int i = 0; i <= 7; i++) {
			Image imagen = new Image("/dad/puzzlegames/resources/matches/img" + i + ".gif"); // parametros add ,800,500,false,false
			imagenes.add(imagen);

		}

		return imagenes;

	}

	// METODO PARA CONVERTIR A MINUTOS
	public String convertirAMinutos(int num) {
		int hor, min, seg;
		hor = num / 3600;
		min = (num - (3600 * hor)) / 60;
		seg = num - ((hor * 3600) + (min * 60));
		return "" + min + ":" + seg + "s";

	}

	// TROZEA LA IMAGEN (MODO FACIL)
	public void trozeaImagenes(File imagen, Dificultad mode) throws IOException {
		FileInputStream fis = new FileInputStream(imagen);
		BufferedImage image = ImageIO.read(fis); // reading the image file

		// DETERMINAMOS EL NUMERO DE FILAS Y COLUMNAS, SEGUN EL MODO ESPECIFICADO

		int filas = 0;
		int columnas = 0;
		int recorte = 0;

		switch (mode) {
		case FACIL:

			filas = 3;
			columnas = 3;
			recorte = filas * columnas;

			break;

		case MEDIA:

			filas = 4;
			columnas = 4;
			recorte = filas * columnas;

			break;
		case DIFICIL:

			filas = 5;
			columnas = 5;
			recorte = filas * columnas;

			break;

		default:
			break;
		}

		// ESPECIFICAMOS EL ANCHO Y ALTO DEL RECORTE
		int anchoRecorte = image.getWidth() / columnas;
		int altoRecorte = image.getHeight() / filas;
		int count = 0;
		BufferedImage imgs[] = new BufferedImage[recorte]; // Image array to hold image chunks
		for (int x = 0; x < filas; x++) {
			for (int y = 0; y < columnas; y++) {
				// Initialize the image array with image chunks
				imgs[count] = new BufferedImage(anchoRecorte, altoRecorte, image.getType());

				// draws the image chunk
				Graphics2D gr = imgs[count++].createGraphics();
				gr.drawImage(image, 0, 0, anchoRecorte, altoRecorte, anchoRecorte * y, altoRecorte * x,
						anchoRecorte * y + anchoRecorte, altoRecorte * x + altoRecorte, null);
				gr.dispose();
			}
		}
		System.out.println("Recorte realizado con éxito");

		File piezas = new File("\\piezas");
		piezas.mkdirs();

		for (int i = 0; i < imgs.length; i++) {

			ImageIO.write(imgs[i], "jpg", new File("\\piezas\\img" + i + ".jpg"));

		}
		System.out.println("Mini imagenes creadas con éxito.");
	}

	// OPCION NO DISPONIBLE
	public void noDisponibleDialog(Stage appStage) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("No se encuentra disponible");
		alert.setHeaderText("La opción que buscas no se encuentra disponible.");
		alert.setContentText("No esta disponible para la versión demo.");
		alert.initOwner(appStage);

		alert.showAndWait();
	}

	// IMAGENES INSUFICIENTES
	public void imagenesInsuficientesDialog(Stage appStage) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Número de imagenes insuficiente");
		alert.setContentText(
				"Al parecer has establecido, mayor número de rondas, que imagenes tienes en la carpeta especificada.\nBaja el número de rondas o coloca más imagenes");
		alert.initOwner(appStage);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.showAndWait();
		
		

	}
	
	

}
