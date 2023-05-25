package modelo;

import java.util.ArrayList;

public class CGrupo {
	private String nombre;
	private ArrayList<CAlumno> alumnos;
	public CGrupo(String nombre) {
		super();
		this.nombre = nombre;
		alumnos=new ArrayList<CAlumno>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<CAlumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<CAlumno> alumnos) {
		this.alumnos = alumnos;
	}
	public CAlumno obtenerAlumno(int pos) {
		CAlumno buscar=null;
		if(pos<=numeroAlumnos()) {
		buscar=alumnos.get(pos);
		}
		return buscar;
	}
	public void anyadirAlumno(CAlumno nuevo) {
		if(numeroAlumnos()<30) {
		alumnos.add(nuevo);
		}else {
			System.out.println("El alumno no se añadio, el limite es de 30.");
		}
	}
	public int numeroAlumnos() {
		return alumnos.size();
	}
}
