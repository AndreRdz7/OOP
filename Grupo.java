public class Grupo{
	
	private String nombre;
	private Profesor titular;
	private Alumno[] lista;
	private int noAlumnos;
	
	public Grupo(){
		this.nombre = "Grupo default";
		this.titular = new Profesor();
		this.lista = new Alumno[5];
		this.noAlumnos = 0;
	}
	
	public Grupo(String n, int cupo){
		this.nombre = n;
		this.titular = new Profesor();
		this.lista = new Alumno[cupo];
		this.noAlumnos = 0;
	}
	
	public void setProfesor(Profesor p){
		this.titular = p;
	}
	
	public Profesor getProfesor(){
		return this.titular;
	}

	public boolean addAlumno(Alumno a){
		if(this.noAlumnos >= this.lista.length){
			return false;
		}
		else{
			this.lista[noAlumnos] = a;
			this.noAlumnos++;
			return true;
		}
	}
	
	public String toString(){
		String res = "";
		res = res + "====================================================\n";
		res = res + "    " + this.nombre + "\n";
		res = res + "    Profesor: " + this.titular.toString() + "\n";
		res = res + "    Poblacion: " + this.noAlumnos + "\n";
		res = res + "====================================================\n";
		for(int i = 0; i < this.noAlumnos; i++){
			res = res + "    " + this.lista[i].toString() + "\n";
		}
		res = res + "====================================================\n";
		return res;
	}
	
	public boolean tieneCupo(){
		return this.noAlumnos < this.lista.length;
	}
}