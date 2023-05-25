package modelo;

public class CAsignatura {
	private String nombre;
	private int nota;
	public CAsignatura(String nombre) {
		super();
		this.nombre = nombre;
	}
	public CAsignatura(CAsignatura antigua) {
	this.nombre=antigua.getNombre();
	this.nota=antigua.getNota();
	}
	public CAsignatura() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		if (nota<0 || nota>10) {
			System.out.println("Tiene que ser mayor de 0 o menor de 10, no se inserto");
		}else {
			System.out.println("Nota insertada correctamente");
		this.nota = nota;
		}
	}
	@Override
	public String toString() {
		return  "\n"+nombre + ":" + nota;
	}
	
}
