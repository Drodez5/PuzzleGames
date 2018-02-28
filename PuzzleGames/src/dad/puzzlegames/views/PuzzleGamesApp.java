package dad.puzzlegames.views;

import dad.puzzlegames.controllers.PuzzleGamesController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PuzzleGamesApp extends Application {

	private PuzzleGamesController controladorPrincipal;
	
	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		PuzzleGamesApp.primaryStage=primaryStage;
		controladorPrincipal = new PuzzleGamesController();
		Scene scene = new Scene(controladorPrincipal.getVista(), 1100, 900);

		primaryStage.setTitle("PuzzleGames");
		primaryStage.setScene(scene);
		primaryStage.getScene().getStylesheets().add(getClass().getResource("/dad/puzzlegames/resources/Animado.css").toExternalForm());
		primaryStage.getIcons().add(new Image("/dad/puzzlegames/resources/icon.png"));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		PuzzleGamesApp.primaryStage = primaryStage;
	}
	
	

}
