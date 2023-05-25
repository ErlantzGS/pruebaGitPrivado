package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class CAlumno {
	private String DNI;
	private String nombre;
	private String direccion;
	private ArrayList<CAsignatura> listaAsignaturas;
	
	public CAlumno(String DNI, String nombre, String direccion) {
		super();
		this.DNI = DNI;
		this.nombre = nombre;
		this.direccion = direccion;
		listaAsignaturas=new ArrayList<CAsignatura>();
	}
	public CAlumno(CAlumno antiguo) {
		this.DNI = antiguo.getDNI();
		this.nombre = antiguo.getNombre();
		this.direccion = antiguo.getDireccion();
		this.listaAsignaturas = antiguo.getListaAsignaturas();
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<CAsignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}
	public void setListaAsignaturas(ArrayList<CAsignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}
	public CAsignatura obtenerAsignatura(int pos) {
		CAsignatura buscar=null;
		if(pos<=numeroAsignaturas()) {
		buscar=listaAsignaturas.get(pos);
		}
		return buscar;
	}
	public void anyadirAsignatura(CAsignatura anyadir) {
		if(numeroAsignaturas()<=10) {
		listaAsignaturas.add(anyadir);
		}else {
			System.out.println("No se pudo añadir esta asignatura, el limite es de 10.");
		}
			
	}
	public int numeroAsignaturas() {
		return listaAsignaturas.size();
	}
	
	public float obtenerNotaMedia() {
		float total=0;
		int cont=0;
		for(CAsignatura una : listaAsignaturas) {
			total+=una.getNota();
			cont++;
		}
		return total/cont;
	}
	@Override
	public String toString() {
		return "DNI :" + DNI + " Nombre :" + nombre + " Direccion :" + direccion +  "\n Nº Asignaturas "+numeroAsignaturas()
				+ listaAsignaturas+"\n Nota Media:"+obtenerNotaMedia();
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CAlumno other = (CAlumno) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
}
