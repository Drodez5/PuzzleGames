package dad.puzzlegames.models;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 * @author Domingo Rodriguez
 * @version 1.0
 * */

/**
 * Clase conexion
 * 
 * Permite la conexion con la BD
 * */

public class ConexionBD {

	private Connection conexion;
	private ListProperty<Partida> listaPartidas;

	public ConexionBD() throws IOException, ClassNotFoundException, SQLException {
		listaPartidas = new SimpleListProperty<>(this, "listaPartidas", FXCollections.observableArrayList());

		Class.forName("com.mysql.cj.jdbc.Driver");
		this.conexion = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com:3306/sql2223959",
				"sql2223959", "mU3*cQ5!");
	}


/**
 * Metodo para consultar usuarios
 * del modo de juego puzzle piezes
 * @throws SQLException
 * */
	 public ListProperty<Partida> consultarUsuariosPuzzlePiezes() throws SQLException {
	 listaPartidas.clear();
	 PreparedStatement visualizarUsuarios = conexion.prepareStatement("SELECT * FROM puzzle_pieces");
	 ResultSet rs = visualizarUsuarios.executeQuery();
	 while (rs.next()) {
	 Partida nuevaPartida = new Partida();
	 nuevaPartida.setId(rs.getInt(1));
	 nuevaPartida.setNombre(rs.getString(2));
	 nuevaPartida.setRondas(rs.getInt(3));
	 nuevaPartida.setTiempo(rs.getString(4));
	 nuevaPartida.setDificultad(rs.getString(5));
	 listaPartidas.add(nuevaPartida);
	
	 }
	return listaPartidas;
	
	 }
	
/**
 * Metodo para consultar los 
 * usuarios de la modalidad de juego matchpuzzle
 * @throws SQLException
 * */
	public ListProperty<Partida> consultarUsuariosMatchPuzzle() throws SQLException {
		listaPartidas.clear();
		PreparedStatement visualizarUsuarios = conexion.prepareStatement("SELECT * FROM match_puzzle");
		ResultSet rs = visualizarUsuarios.executeQuery();
		while (rs.next()) {
			Partida nuevaPartida = new Partida();
			nuevaPartida.setId(rs.getInt(1));
			nuevaPartida.setNombre(rs.getString(2));
			nuevaPartida.setRondas(rs.getInt(3));
			nuevaPartida.setTiempo(rs.getString(4));
			nuevaPartida.setDificultad(rs.getString(5));
			listaPartidas.add(nuevaPartida);

		}
		return listaPartidas;
	}

	/**
	 * Metodo para insertar jugador MatchPuzzle
	 * Dificultad Facil
	 * @throws SQLException
	 * */
	public void insertarUsuarioMatchPuzzle(String nombre, int rondas, String tiempo, String dificultad) {

		PreparedStatement insertarUsuario;
		try {
			insertarUsuario = conexion.prepareStatement(
					"INSERT INTO `match_puzzle` (`id`, `nombre`, `rondas`, `tiempo`, `dificultad`) VALUES (NULL, ?, ?, ?, ?);");
			insertarUsuario.setString(1, nombre);
			insertarUsuario.setInt(2, rondas);
			insertarUsuario.setString(3, tiempo);
			insertarUsuario.setString(4, dificultad);
			insertarUsuario.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para insertar jugador PuzzlePieces
	 * Dificultad Facil
	 * @throws SQLException
	 * */
	public void insertarUsuarioPuzzlePieces(String nombre, int rondas, String tiempo, String dificultad) {
		PreparedStatement insertarUsuario;
		try {
			insertarUsuario = conexion.prepareStatement("INSERT INTO `puzzle_pieces` (`id`, `nombre`, `rondas`, `tiempo`, `dificultad`) VALUES (NULL, ?, ?, ?, ?);");
			insertarUsuario.setString(1, nombre);
			insertarUsuario.setInt(2, rondas);
			insertarUsuario.setString(3, tiempo);
			insertarUsuario.setString(4, dificultad);
			insertarUsuario.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

	/**
	 * Metodo para consultar usuarios 
	 * Sliding Puzzle
	 * Dificultad Facil
	 * */
//	public ListProperty<Partida> consultarUsuariosMatchPuzzle() throws SQLException {
//		listaPartidas.clear();
//		PreparedStatement visualizarUsuarios = conexion.prepareStatement("SELECT * FROM sliding_puzzle");
//		ResultSet rs = visualizarUsuarios.executeQuery();
//		while (rs.next()) {
//			Partida nuevaPartida = new Partida();
//			nuevaPartida.setId(rs.getInt(1));
//			nuevaPartida.setNombre(rs.getString(2));
//			nuevaPartida.setRondas(rs.getInt(3));
//			nuevaPartida.setTiempo(rs.getString(4));
//			nuevaPartida.setDificultad(rs.getString(5));
//			listaPartidas.add(nuevaPartida);
//
//		}
//		return listaPartidas;
//	}
	
	/**
	 * Metodo para insertar usuarios Sliding Puzzle
	 * Dificultad Facil*/
//	public void insertarUsuarioSlidingPuzzle(String nombre, int rondas, String tiempo, String dificultad) {
//
//		PreparedStatement insertarUsuario;
//		try {
//			insertarUsuario = conexion.prepareStatement(
//					"INSERT INTO `sliding_puzzle` (`id`, `nombre`, `rondas`, `tiempo`, `dificultad`) VALUES (NULL, ?, ?, ?, ?);");
//			insertarUsuario.setString(1, nombre);
//			insertarUsuario.setInt(2, rondas);
//			insertarUsuario.setString(3, tiempo);
//			insertarUsuario.setString(4, dificultad);
//			insertarUsuario.execute();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
