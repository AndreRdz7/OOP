import java.lang.Math;

/**
	Clase que describe las caracteristicas particulares de un alumno de universidad
	
	@author	JEHR
*/
public class Alumno extends Persona{
	
	private int carrera;
	public static final int CARRERA_DEFAULT = -1;
	public static final int CARRERA_ITC = 0;
	public static final int CARRERA_ISD = 1;
	public static final int CARRERA_LAD = 2;
	
	private Id matricula;
	
	public Alumno(){
		super();
		this.carrera = this.CARRERA_DEFAULT;
		this.matricula = new Id();
	}
	
	/**
		Modifica la carrera del alumno
		
		@param	c	Nueva carrera, utilizar las constantes de clase
	*/
	public void setCarrera(int c){
		this.carrera = c;
	}
	
	/**
		Obtiene la carrera del alumno
		
		@return	Valor entero que representa la carrera del alumno
	*/
	public int getCarrera(){
		return this.carrera;
	}
	
	/**
		Obtiene la matricula del alumno
		
		@return	Objeto que contiene la matricula del alumno
	*/
	public Id getMatricula(){
		return this.matricula;
	}
	
	/**
		Cambia la matrícula del alumno
	
		@param	i	Objeto que contiene la nueva matricula del alumno
	*/
	public void setMatricula(Id i){
		this.matricula = i;
	}	
	
	/**
		Representacion impresa del alumno
		
		@return	Cadena de texto que representa al alumno
	*/
	public String toString(){
		String s = 
			this.matricula.toString() + " " +
			super.getNombre() + " " + super.getAPaterno();
		if(super.getAMaterno() != "")
			s = s + " " + super.getAMaterno();
		return s;
		
	}
	
	/**
		Compara dos objetos de la clase Alumno
		
		@param	a	Alumno contra el que se quiere comparar
		@return		Devuelve <em>true</em> si las matriculas son iguales. Devuelve <em>false</em> en caso contrario.
	*/
	public boolean equals(Alumno a){
		return this.matricula.equals(a.getMatricula());
	}
	
	/**
		Crea una copia del Alumno actual y lo devuelve como objeto
		
		@return		Copia del alumno actual
	*/
	public Alumno clone(){
		Alumno a = new Alumno();
		a.setNombre(super.getNombre());
		a.setAPaterno(super.getAPaterno());
		a.setAMaterno(super.getAMaterno());
		a.setAnioNac(super.getAnioNac());
		a.setMesNac(super.getMesNac());
		a.setDiaNac(super.getDiaNac());
		a.setGenero(super.getGenero());
		a.setCarrera(this.carrera);
		a.setMatricula(this.matricula);
		return a;
	}
}