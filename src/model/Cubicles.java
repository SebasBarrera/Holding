/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Icesi (Cali - Colombia)
 * Departamento TIC - Algoritmos y programación I
 * Laboratio #5 & 6
 * Autor: Juan Sebastián Barrera Pulido <juan.barrera4@correo.icesi.edu.co
 * Periodo: 2019-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

public class Cubicles{
			
	//------------------------------------------------------------------------------------------------

	// Constants

	//------------------------------------------------------------------------------------------------	

	//------------------------------------------------------------------------------------------------

	// Atributes

	//------------------------------------------------------------------------------------------------
	private int extension;
	
	//relations
	private Employee employeeOnCubicle;
	//methods
	//constructor
	public Cubicles(int e){
		extension = e;
	}
	public int getExtension(){
		return extension;
	}
	public void setExtension(int newExtension){
		extension = newExtension;
	}
	public Employee getEmployee(){
		return employeeOnCubicle;
	}
	public boolean addEmployeeToCubicle(String n, String a, String e){
		boolean ward = false;
		if(employeeOnCubicle==null){
			employeeOnCubicle = new Employee (n,a,e);
			ward = true;
		}
		return ward;
	}
}