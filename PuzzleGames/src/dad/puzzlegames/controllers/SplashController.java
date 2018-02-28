package dad.puzzlegames.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SplashController implements Initializable {

	@FXML
	private StackPane vista;



	public SplashController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlegames/views/SplashScreenView.fxml"));
		loader.setController(this);
		loader.load();
		
		FadeTransition transicionEntrada= new FadeTransition(Duration.seconds(3),vista);
		transicionEntrada.setFromValue(0);
		transicionEntrada.setToValue(1);
		transicionEntrada.setCycleCount(1);
		transicionEntrada.play();
			
		FadeTransition transicionSalida= new FadeTransition(Duration.seconds(3),vista);
		transicionSalida.setFromValue(1);
		transicionSalida.setToValue(0);
		transicionSalida.setCycleCount(1);
		
		
		transicionEntrada.setOnFinished(e->{
			transicionSalida.play();
			
		});
		
		transicionSalida.setOnFinished(e->{
			
		});
		
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public StackPane getVista() {
		return vista;
	}

	public void setVista(StackPane vista) {
		this.vista = vista;
	}
	

}
