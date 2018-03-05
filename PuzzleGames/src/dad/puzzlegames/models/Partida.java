package dad.puzzlegames.models;

import javafx.beans.property.IntegerProperty;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Partida {

	private IntegerProperty id, rondas;
	private StringProperty nombre, dificultad, tiempo;

	public Partida() {
		id = new SimpleIntegerProperty(this, "id");
		tiempo = new SimpleStringProperty(this, "tiempo");
		rondas = new SimpleIntegerProperty(this, "rondas");
		nombre = new SimpleStringProperty(this, "nombre");
		dificultad = new SimpleStringProperty(this, "dificultad");

	}

	public IntegerProperty idProperty() {
		return this.id;
	}

	public int getId() {
		return this.idProperty().get();
	}

	public void setId(final int id) {
		this.idProperty().set(id);
	}

	public IntegerProperty rondasProperty() {
		return this.rondas;
	}

	public int getRondas() {
		return this.rondasProperty().get();
	}

	public void setRondas(final int rondas) {
		this.rondasProperty().set(rondas);
	}

	public StringProperty nombreProperty() {
		return this.nombre;
	}

	public String getNombre() {
		return this.nombreProperty().get();
	}

	public void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public StringProperty dificultadProperty() {
		return this.dificultad;
	}

	public String getDificultad() {
		return this.dificultadProperty().get();
	}

	public void setDificultad(final String dificultad) {
		this.dificultadProperty().set(dificultad);
	}

	public StringProperty tiempoProperty() {
		return this.tiempo;
	}

	public String getTiempo() {
		return this.tiempoProperty().get();
	}

	public void setTiempo(final String tiempo) {
		this.tiempoProperty().set(tiempo);
	}

}
