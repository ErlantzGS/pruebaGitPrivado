package controlador;

import java.util.Scanner;
import modelo.*;
public class CAplicacion {
	static Scanner sc=new Scanner(System.in);
	static CGrupo clase=new CGrupo("1º DAM");
public void Menu() {
	int op=0;
	do {
	System.out.println("1. Matricular.\r\n"
			+ "2. Baja de alumno.\r\n"
			+ "3. Poner notas.\r\n"
			+ "4. Mostrar expediente.\r\n"
			+ "5. Mostrar datos de todo el grupo.\r\n"
			+ "6. Salir.");
	String opcion=sc.nextLine();
	op=validaNumeros(opcion);
	seleccion(op,clase);
	}while(op!=6);
}
public int validaNumeros(String numero) {
	int op=0;
	try {
		op=Integer.valueOf(numero);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return op;
}
public void seleccion(int op,CGrupo clase){
	switch (op){
	case 1:
		crearAlumno(clase);
		Menu();
		break;
	case 2:
		eliminarAlumno(clase,buscarAlumno(clase));
		Menu();
		break;
	case 3:
		darNotasAlumno(clase,buscarAlumno(clase));
		Menu();
		break;
	case 4:
		mostrarDatosAlumno(clase,buscarAlumno(clase));
		Menu();
		break;
	case 5:
		mostrarDatosGrupo(clase);
		Menu();
		break;
	case 6:
		System.exit(0);
		break;
	default:
	Menu();
	}
}

public void crearAlumno(CGrupo clase) {
	System.out.println("Introduzca el DNI del Alumno:");
	String dni=sc.nextLine();
	System.out.println("Introduzca el nombre del Alumno:");
	String nombre=sc.nextLine();
	System.out.println("Introduzca la direccion del Alumno:");
	String direccion=sc.nextLine();
	CAlumno nuevoA=new CAlumno(dni,nombre,direccion);
	asignaturasParaAlumno(nuevoA);
	clase.anyadirAlumno(nuevoA);
}
public void asignaturasParaAlumno(CAlumno nuevoA) {
	int IntNumAsig=0;
	do {
	System.out.println("¿Cuantas asignaturas se va a matricular?");
	String numAsig=sc.nextLine();
	IntNumAsig=validaNumeros(numAsig);
	}while(IntNumAsig>0 && IntNumAsig<10);
	String asig="";
	for(int i=0;i<IntNumAsig;i++) {
		System.out.println("La asignatura numero "+(i+1)+" se llamara:");
		asig=sc.nextLine();
		CAsignatura nuevaAsig=new CAsignatura(asig);
		nuevoA.anyadirAsignatura(nuevaAsig);
	}
}
public int buscarAlumno(CGrupo clase) {
	System.out.println("Escriba el nombre del alumno que quiere usar:");
	String nombre=sc.nextLine();
	CAlumno per=new CAlumno("",nombre,"");
	int pos=clase.getAlumnos().indexOf(per);
	if(pos!=-1) {
		System.out.println("Alumno encontrado");
	}else {
		System.out.println("Alumno no encontrado");
		Menu();
	}
	return pos;
}
public void eliminarAlumno(CGrupo clase,int pos) {
	if(pos!=-1) {
		clase.getAlumnos().remove(pos);
		System.out.println("Alumno borrado");
	}else {
		System.out.println("Alumno no borrado");
	}
}
public void darNotasAlumno(CGrupo clase, int pos) {
	// TODO Auto-generated method stub
	String notaS="";
	int nota=0;
	for(int i=0;i<clase.getAlumnos().get(pos).numeroAsignaturas();i++) {
		System.out.println("Que nota le quieres dar a la asingatura "+clase.getAlumnos().get(pos).getListaAsignaturas().get(i).getNombre());
		notaS=sc.nextLine();
		nota=validaNumeros(notaS);
		clase.getAlumnos().get(pos).getListaAsignaturas().get(i).setNota(nota);
	}
}
public void mostrarDatosAlumno(CGrupo clase, int buscarAlumno) {
	// TODO Auto-generated method stub
	System.out.println(clase.getAlumnos().get(buscarAlumno).toString());
}
private void mostrarDatosGrupo(CGrupo clase) {
	// TODO Auto-generated method stub
	System.out.println("El grupo "+clase.getNombre()+" tiene estos alumnos:");
	for(int i=0;i<clase.numeroAlumnos();i++) {
		System.out.println(clase.getAlumnos().get(i).toString());
	}
}
}