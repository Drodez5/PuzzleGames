package dad.puzzlegames.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jugador {

	private StringProperty nombre;
	private StringProperty dificultad;
	private StringProperty directorio;
	private ObjectProperty<Modo> modo;
	private IntegerProperty rondas;

	public Jugador() {
		nombre = new SimpleStringProperty();
		dificultad = new SimpleStringProperty();
		directorio = new SimpleStringProperty();
		modo = new SimpleObjectProperty<>(this,"modo");
		rondas = new SimpleIntegerProperty();
	}

	public final StringProperty nombreProperty() {
		return this.nombre;
	}

	public final String getNombre() {
		return this.nombreProperty().get();
	}

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public final StringProperty dificultadProperty() {
		return this.dificultad;
	}

	public final String getDificultad() {
		return this.dificultadProperty().get();
	}

	public final void setDificultad(final String dificultad) {
		this.dificultadProperty().set(dificultad);
	}

	public final StringProperty directorioProperty() {
		return this.directorio;
	}

	public final String getDirectorio() {
		return this.directorioProperty().get();
	}

	public final void setDirectorio(final String directorio) {
		this.directorioProperty().set(directorio);
	}

	

	public final IntegerProperty rondasProperty() {
		return this.rondas;
	}

	public final int getRondas() {
		return this.rondasProperty().get();
	}

	public final void setRondas(final int rondas) {
		this.rondasProperty().set(rondas);
	}

	public final ObjectProperty<Modo> modoProperty() {
		return this.modo;
	}
	

	public final Modo getModo() {
		return this.modoProperty().get();
	}
	

	public final void setModo(final Modo modo) {
		this.modoProperty().set(modo);
	}
	

}
