public class Profesor extends Persona{
	
	private int area;
	private Id nomina;
	private String iniciales;
	private String homoclave;
	
	public static final int AREA_SIN_AREA = -1;
	public static final int AREA_CIENCIAS_EXACTAS = 0;
	public static final int AREA_CIENCIAS_SOCIALES = 1;
	public static final int AREA_LINGUISTICA = 2;
	public static final int AREA_ARTES = 3;
		
	public Profesor(){
		this.area = -1;
		nomina = new Id();
		iniciales = "";
		homoclave = "";
	}
	
	public void setArea(int a){
		this.area = a;
	}
	
	public int getArea(){
		return this.area;
	}
	
	public void setNomina(Id i){
		this.nomina = i;
	}
	
	public Id getNomina(){
		return this.nomina;
	}
	
	public void setRfc(String i, String h){
		this.iniciales = i;
		this.homoclave = h;
	}
	
	public String getRfc(){
		return
			this.iniciales + 
			LPad(super.getAnioNac() % 100,2,'0') +
			LPad(super.getMesNac(),2,'0') +
			LPad(super.getDiaNac(),2,'0') +
			this.homoclave;
	}
	
	public boolean equals(Profesor p){
		return
			this.getRfc().equals(p.getRfc());
	}
	
	public String toString(){
		String s = 
			this.nomina.toString() + " " +
			super.getNombre() + " " + super.getAPaterno();
		if(super.getAMaterno() != "")
			s = s + " " + super.getAMaterno();
		s = s + " (" + this.getRfc() + ")";
		return s;
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
}