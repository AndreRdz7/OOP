/**
	Clase que define las caracteristicas generales de una persona
	
	@author		JEHR
	@version	1.0
*/
public class Persona{

	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private int anioNac;
	private int mesNac;
	private int diaNac;
	private boolean genero; //false = m, true = f
	
	/**
		Constructor vacio
	*/
	public Persona(){
		this.nombre = "";
		this.aPaterno = "";
		this.aMaterno = "";
		this.anioNac = 1900;
		this.mesNac = 1;
		this.diaNac = 1;
		this.genero = true;
	}
	
	/**
		Constructor parametrizado
		
		@param 	n	Nombre de la persona
		@param	ap	Apellido paterno de la persona
		@param	am	Apellido materno de la persona
		@param 	an	Anio de nacimiento de la persona
		@param	mn	Mes de nacimiento de la persona
		@param	dn	Dia de nacimiento de la persona
		@param	g	Genero de la persona
	*/
	public Persona(String n, String ap, String am, int an, int mn, int dn, boolean g){
		this.nombre = n;
		this.aPaterno = ap;
		this.aMaterno = am;
		this.anioNac = an;
		this.mesNac = mn;
		this.diaNac = dn;
		this.genero = g;
	}
	
	/**
		Modifica el nombre de la persona
		
		@param	n	Nuevo nombre de la persona
	*/
	public void setNombre(String n){
		this.nombre = n;
	}
	
	/**
		Regresa el nombre de la persona
		
		@return	Nombre actual de la persona
	*/
	public String getNombre(){
		return this.nombre;
	}
	
	/**
		Modifica el apellido paterno de la persona
		
		@param	ap	Nuevo apellido paterno de la persona
	*/
	public void setAPaterno(String ap){
		this.aPaterno = ap;
	}
	
	/**
		Regresa el apellido paterno de la persona
		
		@return	Apellido paterno actual de la persona
	*/
	public String getAPaterno(){
		return this.aPaterno;
	}
	
	/**
		Modifica el apellido materno de la persona
		
		@param	am	Nuevo apellido materno de la persona
	*/
	public void setAMaterno(String am){
		this.aMaterno = am;
	}
	
	/**
		Regresa el apellido materno de la persona
		
		@return	Apellido materno actual de la persona
	*/
	public String getAMaterno(){
		return this.aMaterno;
	}
	
	/**
		Modifica el anio de nacimiento de la persona
		
		@param	an	Nuevo anio de nacimiento de la persona
	*/
	public void setAnioNac(int an){
		this.anioNac = an;
	}
	
	/**
		Regresa el anio de nacimiento de la persona
		
		@return	Anio de nacimiento actual de la persona
	*/
	public int getAnioNac(){
		return this.anioNac;
	}
	
	/**
		Modifica el mes de nacimiento de la persona
		
		@param	mn	Nuevo mes de nacimiento de la persona
	*/
	public void setMesNac(int mn){
		this.mesNac = mn;
	}
	
	/**
		Regresa el mes de nacimiento de la persona
		
		@return	Mes de nacimiento actual de la persona
	*/
	public int getMesNac(){
		return this.mesNac;
	}
	
	/**
		Modifica el dia de nacimiento de la persona
		
		@param	dn	Nuevo dia de nacimiento de la persona
	*/
	public void setDiaNac(int dn){
		this.diaNac = dn;
	}
	
	/**
		Regresa el dia de nacimiento de la persona
		
		@return	Dia de nacimiento actual de la persona
	*/
	public int getDiaNac(){
		return this.diaNac;
	}
	
	/**
		Modifica el genero de la persona
		
		@param	g	Nuevo genero de la persona, true = femenino, false = masculino
	*/
	public void setGenero(boolean g){
		this.genero = g;
	}
	
	/**
		Regresa el genero de la persona
		
		@return	Genero actual de la persona
	*/
	public boolean getGenero(){
		return this.genero;
	}
	
	/**
		Representacion impresa de la persona
		
		@return	Cadena de texto que representa a la persona
	*/
	public String toString(){
		return 
			this.nombre + " " + this.aPaterno + 
			(this.aMaterno != "" ? " " + this.aMaterno : "");
		
	}
	
	/**
		Compara dos objetos de la clase Persona
		
		@param	p	Persona contra la que se quiere comparar
		@return		Devuelve <em>true</em> si las personas coinciden en nombre, apellido paterno, fecha de nacimiento y genero. Devuelve <em>false</em> en caso contrario.
	*/
	public boolean equals(Persona p){
		return 
			this.nombre.equals(p.getNombre()) && 
			this.aPaterno.equals(p.getAPaterno()) &&
			this.anioNac == p.getAnioNac() &&
			this.mesNac == p.getMesNac() &&
			this.diaNac == p.getDiaNac() &&
			this.genero == p.getGenero();
	}
	
	/**
		Crea una copia de la Persona actual y la devuelve como objetos
		
		@return		Copia de la persona actual
	*/
	public Persona clone(){
		return new Persona(this.nombre, this.aPaterno, this.aMaterno, this.anioNac, this.mesNac, this.diaNac, this.genero);
	}
}