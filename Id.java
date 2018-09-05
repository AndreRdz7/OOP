/**
	Esta clase controla los elementos propios de un identificador (matrícula y/o nómina)
	
	@author	José Eugenio Hernández Roldán
*/
public class Id{
	
	private int sufijo;
	private int prefijo;
	private boolean tipo; //0 = alumno, 1 = profesor
	private int campus; //0 = Pue, 1 = Ant
	
	public static final int CAMPUS_PUEBLA = 0;
	private int[] PREFIJOS_PUEBLA = new int[10];
	private int PUEBLA_INDEX = 3;
	private int PUEBLA_LAST = 183;
	public static final int CAMPUS_ANTARTIDA = 174;
	
	public static final boolean TIPO_ALUMNO = false;
	public static final boolean TIPO_PROFESOR = true;
	
	/**
		Constructor vacío
	*/
	public Id(){
		this.sufijo = 0;
		this.prefijo = 0;
		this.tipo = false;
		setPrefijos();
	}
	
	/**
		Constructor parametrizado
		
		@param	t	Tipo de id
		@param	c	Campus (consutar constantes de clase)
	*/
	public Id(boolean t, int c){
		this.tipo = t;
		this.campus = c;
		setPrefijos();
	}
	
	public void setPrefijos(){
		this.PREFIJOS_PUEBLA[0] = 109;
		this.PREFIJOS_PUEBLA[1] = 132;
		this.PREFIJOS_PUEBLA[2] = 173;
	}
	
	public void setTipo(boolean t){
		this.tipo = t;
	}
	
	public boolean getTipo(){
		return this.tipo;
	}
	
	/**
		Modifica el prefijo de matricula del alumno
		
		@param	p	Nuevo prefijo, entero a 4 posiciones
	*/
	public void setPrefijo(int p){
		this.prefijo = p;
	}
	
	/**
		Obtiene el prefijo de matricula del alumno
		
		@return	Valor entero que representa la carrera del alumno
	*/
	public int getPrefijo(){
		return this.prefijo;
	}
	
	/**
		Modifica el sufijo de matricula del alumno
		
		@param	s	Nuevo sufijo, entero a 4 posiciones
	*/
	public void setSufijo(int s){
		this.sufijo = s;
	}
	
	/**
		Obtiene el sufijo de matricula del alumno
		
		@return	Valor entero que representa el sufijo de matricula del alumno
	*/
	public int getSufijo(){
		return this.sufijo;
	}
	
	/**
		Modifica el campus de la matricula
		
		@param	c	Nuevo campus
	*/
	public void setCampus(int c){
		this.campus = c;
	}
	
	/**
		Obtiene el campus de la matrícula
		
		@return	Valor entero que representa el campus
	*/
	public int getCampus(){
		return this.campus;
	}
	
	/**
		Genera la siguiente matricula correspondiente al campus
	*/
	public void getNext(){
		switch(this.campus){
			case Id.CAMPUS_PUEBLA: //Puebla
				if(this.PUEBLA_LAST == 9999){
					this.PUEBLA_LAST = 0;
					this.PUEBLA_INDEX++;
				}
				this.prefijo = this.PREFIJOS_PUEBLA[this.PUEBLA_INDEX-1];
				this.sufijo = ++this.PUEBLA_LAST;
				break;
		}
	}
	
	/**
		Modifica la matricula del alumno
		
		@param	p	Prefijo del campus (4 numeros max)
		@param	s	Sufijo consecutivo del alumno (4 numeros max)
	*/
	public void setId(int p, int s, boolean t){
		this.prefijo = p;
		this.sufijo = s;
		this.tipo = t;
	}
	
	/**
		Regresa la matrícula del estudiante
		
		@return	Cadena de texto que representa la matricula
	*/
	public String toString(){
		return (this.tipo ? "L" : "A") + LPad(this.prefijo,4,'0') + LPad(this.sufijo, 4, '0');
	}
	
	/**
		Completa un numero entero a cierta cantidad de caracteres
		
		@param	num		Numero a completar
		@param	length	Longitud final de la cadena de texto
		@param	c		Caracter de mascara
	*/
	private String LPad(int num, int length, char c){
		if(num <= 0){
			String s = "";
			for(int i = 0; i < length; i++)
				s = s + c;
			return s;
		}
		int numLength = (int) Math.ceil(Math.log10(num));
		if(numLength >= length)
			return num + "";
		else{
			String s = num + "";
			for(int i = numLength; i < length; i++){
				s = c + s;
			}
			return s;
		}
	}
	
	public boolean equals(Id i){
		return 
			this.prefijo == i.getPrefijo() &&
			this.sufijo == i.getSufijo() &&
			this.tipo == i.getTipo();
	}
	
	public Id clone(){
		Id i = new Id();
		i.setPrefijo(this.prefijo);
		i.setSufijo(this.sufijo);
		i.setCampus(this.campus);
		i.setTipo(this.tipo);
		
		return i;
	}
	
	public String buscarMatricula(int campus, boolean tipo, int sufijo){
		int prefijo = 0;
		switch(campus){
			case Id.CAMPUS_PUEBLA:
				prefijo = this.PREFIJOS_PUEBLA[this.PUEBLA_INDEX-1];
				break;
		
		}
		return (tipo ? "L" : "A") + LPad(prefijo,4,'0') + LPad(sufijo, 4, '0');
	}
	
	public String buscarMatricula(int campus, boolean tipo, int sufijo, int retro){
		int max = 0;
		switch(campus){
			case Id.CAMPUS_PUEBLA:
				max = this.PUEBLA_INDEX;
			break;
		}
		if(retro < 0){
			System.out.println("Error: retro debe ser positivo");
			return "";
		}
		else if(retro >= max){
			System.out.println("Error: Fuera del limite, el campus solo tiene " + max + " prefijos");
			return "";
		}
		else if(retro == 0){
			System.out.println("Warning: Podria considerar usar el metodo sin el valor retroactivo");
		}
		int prefijo = 0;
		switch(campus){
			case Id.CAMPUS_PUEBLA:
				prefijo = this.PREFIJOS_PUEBLA[this.PUEBLA_INDEX-1-retro];
				break;
		
		}
		return (tipo ? "L" : "A") + LPad(prefijo,4,'0') + LPad(sufijo, 4, '0');
	}
}