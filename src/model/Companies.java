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

import java.util.*;

public abstract class Companies {
			
	//------------------------------------------------------------------------------------------------

	// Constants

	//------------------------------------------------------------------------------------------------	
	public final static char AGRICULTURE_FISHING_HUNTING_FISHERIES = 'A';
	public final static char EXPLOITATION_OF_MINES_AND_QUARRIES = 'E';
	public final static char MANUFACTURING_INDUSTRY = 'M';
	public final static char ELECTRICITY_GAS_AND_STEAM = 'G';
	public final static char CONSTRUCTION = 'C';
	public final static char WHOLESALE_AND_RETAIL = 'W';
	public final static char TRANSPORTATION_STORAGE_AND_COMMUNICATIONS = 'T';
	public final static char FINANCIAL_INSURANCE_STUDIES = 'F';
	public final static char SOCIAL_COMMUNALS = 'S';
	public final static int NUMBEROFCUBICLES = 20;

	//------------------------------------------------------------------------------------------------

	// Atributes

	//------------------------------------------------------------------------------------------------
	private String name;
	private String nit;
	private String address;
	private String phone;
	private int quantityOfEmployees;
	private double activeValue;
	private String dateConstitution;
	private char typeOfOrganization;
	private String representantName;
	private int numberOfFloors;

	//------------------------------------------------------------------------------------------------

	// Relations

	//------------------------------------------------------------------------------------------------
	ArrayList<Employee> employees;
	private Cubicles[][]tower;

	//construnctor
		/**
	* Constructor Companies
	* Description: this method creates a subordinate company
	* <b>pre</b>: el numero de numeros de la lista no debe superar el numero de letras del abecedario
	* <b>pos</b>: a subordinate company is created
	* @param n - the name of Company
	* @param ni - the NIT of Company
	* @param a - the address of Company
	* @param p - the phone of the Company
	* @param q - the quantity Of Employees of the Company
	* @param ac - the active value of the Company
	* @param d - the Date of constitution
	* @param t - the type Of Organization of the company
	* @param r - the representant Name of the company
	* @param nf - the number of floors of the company
	*/
	public Companies(String n, String ni, String a, String p, int q, double ac, String d, char t, String r, int nf){
		name = n;
		nit = ni;
		address = a;
		phone = p;
		quantityOfEmployees = q;
		activeValue = ac;
		dateConstitution = d;
		typeOfOrganization = t;
		representantName = r;
		numberOfFloors = nf;
		tower = new Cubicles[numberOfFloors][NUMBEROFCUBICLES];
		employees = new ArrayList<Employee>();
		filedCubicles();
	}
	//methods
		/**
	 * Description: this method is used to give the name of the company
	 * @return name
	 */
	public String getName(){
		return name;
	}
	public void setName(String newName){
		name = newName;
	}
		/**
	 * Description: this method is used to give the NIT of the company
	 * @return nit
	 */
	public String getNit(){
		return nit;
	}
	public void setNit(String newNit){
		nit = newNit;
	}
		/**
	 * Description: this method is used to give the address of the company
	 * @return address
	 */
	public String getAddress(){
		return address;
	}
	public void setAddress(String newAddress){
		address = newAddress;
	}
		/**
	 * Description: this method is used to give the phone
	 * @return phone
	 */
	public String getPhone(){
		return phone;
	}
	public void setPhone(String newPhone){
		phone = newPhone;
	}
		/**
	 * Description: this method is used to give the quantity of the employes
	 * @return quantityOfEmployees
	 */
	public int getQuantityOfEmployees(){
		return quantityOfEmployees;
	}
	public void setQuantityOfEmployees(int newQuantityOfEmployees){
		quantityOfEmployees = newQuantityOfEmployees;
	}
		/**
	 * Description: this method is used to give the Active value of the company
	 * @return activeValue
	 */
	public double getActiveValue(){
		return activeValue;
	}
	public void setActiveValue(double newActiveValue){
		activeValue = newActiveValue;
	}
		/**
	 * Description: this method is used to give the Date of the constitution
	 * @return dateConstitution
	 */
	public String getDateConstitution(){
		return dateConstitution;
	}
	public void setDateConstitution(String newDateConstitution){
		dateConstitution = newDateConstitution;
	}
		/**
	 * Description: this method is used to give the type of the organization of the company
	 * @return typeOfOrganization
	 */
	public char getTypeOfOrganization(){
		return typeOfOrganization;
	}
	public void setTypeOfOrganization(char newTypeOfOrganization){
		typeOfOrganization = newTypeOfOrganization;
	}
		/**
	 * Description: this method is used to give the representant Name of the company
	 * @return representantName
	 */
	public String getRepresentantName(){
		return representantName;
	}
	public void setRepresentantName(String newRepresentantName){
		representantName = newRepresentantName;
	}
		/**
	 * Description: this method is used to give the number of floors
	 * @return numberOfFloors
	 */
	public int getNumberOfFloors(){
		return numberOfFloors;
	}
	public void setNumberOfFloors(int newNumberOfFloors){
		numberOfFloors = newNumberOfFloors;
	}
	public String addEmployee(String n, String a, String e){
		Employee obje = new Employee(n,a,e);
		String text = "";
		employees.add(obje);
		text = "successfully added";
		return text;
	}
	public Employee searchEmployee(String name){
		Employee obje = null;
		boolean found = false;
		for(int i=0; i< employees.size() && found == false; i++){
			if( employees.get(i) != null && name.equals( employees.get(i).getName())){
				obje =  employees.get(i);
				found = true;
			}
		}
		return obje;
	}
	public boolean addEmployeeOnCubicle(String name,String a,String e){
		boolean ward = false;
		boolean add = false;
			for(int i = 0 ; i<tower.length && add == false; i++){
				for(int j=0 ; j<tower[0].length && add == false; j++){
					if(tower[i][j]!=null && tower[i][j].getEmployee()==null){
						ward = tower[i][j].addEmployeeToCubicle(name,a,e);
						add = true;
					}
				}
			}
		
		return ward;
	}
	public void filedCubicles(){
		int counter = 0;
		for(int i = 0 ; i<tower.length ; i++){
			for(int j = 0 ; j<tower[0].length ; j++){
				counter ++;
				tower[i][j] = new Cubicles(counter);
			}
		}
	}

	public String inL(String name) {
		String msg = "";
		for (int i = 0;i<tower.length ;i++ ) {
			if (tower[i][0].getEmployee() != null) {
				if (tower[i][0].getEmployee().getName().equalsIgnoreCase(name)) {
					msg += tower[i][0].getExtension() + "de la empresa" + this.name + "\n";
				}
			}
		}
		for (int i = 0 ;i<tower[0].length ;i++) {
			if (tower[0][i].getEmployee() != null) {
				if (tower[0][i].getEmployee().getName().equalsIgnoreCase(name)) {
					msg += tower[0][i].getExtension() + "de la empresa" + this.name + "\n";
				}
			}	
		}	
		return msg;
	}

	public String inZ(String name) {
		String msg = "";
		int last = tower.length-1;
		for (int i=0; i<tower[0].length ;i++ ) {
			if (tower[0][i].getEmployee() != null) {
				if (tower[0][i].getEmployee().getName().equalsIgnoreCase(name)) {
					msg += tower[0][i].getExtension() + "de la empresa" + this.name + "\n";
				}
			}
		}
		for (int i = 0 ;i<tower[0].length ;i++) {
			if (tower[last][i].getEmployee() != null) {
				if (tower[last][i].getEmployee().getName().equalsIgnoreCase(name)) {
					msg += tower[last][i].getExtension() + "de la empresa" + this.name + "\n";
				}
			}	
		}
		for (int f = tower.length - 2;f>0;f-- ) {
			for (int c = 1; c<tower[0].length-1; c++ ) {
				if (tower[f][c].getEmployee() != null) {
					if (tower[f][c].getEmployee().getName().equalsIgnoreCase(name)) {
						msg += tower[f][c].getExtension() + "de la empresa" + this.name + "\n";
					}
				}
			}
		}
		return msg;
	}

	public String inX(String name) {
		String msg = "";
		for (int f = tower.length - 1;f>=0;f-- ) {
			for (int c = 0; c<tower[0].length; c++ ) {
				if (tower[f][c].getEmployee() != null) {
					if (tower[f][c].getEmployee().getName().equalsIgnoreCase(name)) {
						msg += tower[f][c].getExtension() + "de la empresa" + this.name + "\n";
					}
				}
			}
		}
		for (int i = 0;i<tower.length ;i++ ) {
			for (int j = 0;j<tower.length ;j++ ) {
				if (i == j) {
					if (tower[i][j].getEmployee() != null) {
						if (tower[i][j].getEmployee().getName().equalsIgnoreCase(name)) {
							msg += tower[i][j].getExtension() + "de la empresa" + this.name + "\n";
						}
					}
				}
			}
		}
		return msg;
	}

	public String inO(String name) {
		String msg = "";
		int lastF = tower.length-1;
		int lastC = tower[0].length-1;
		for (int i = 0;i<tower.length ;i++ ) {
			for (int j = 0;j<tower.length ;j++ ) {
				if (tower[0][j].getEmployee() != null) {
					if (tower[0][j].getEmployee().getName().equalsIgnoreCase(name)) {
						msg += tower[0][j].getExtension() + "de la empresa" + this.name + "\n";
					}
				}
				if (tower[i][0].getEmployee() != null) {
					if (tower[i][0].getEmployee().getName().equalsIgnoreCase(name)) {
						msg += tower[i][0].getExtension() + "de la empresa" + this.name + "\n";
					}
				}
				if (tower[lastF][j].getEmployee() != null) {
					if (tower[lastF][j].getEmployee().getName().equalsIgnoreCase(name)) {
						msg += tower[lastF][i].getExtension() + "de la empresa" + this.name + "\n";
					}
				}
				if (tower[i][lastC].getEmployee() != null) {
					if (tower[i][lastC].getEmployee().getName().equalsIgnoreCase(name)) {
						msg += tower[i][lastC].getExtension() + "de la empresa" + this.name + "\n";
					}
				}
			}
		}
		return msg;
	}

	public String inE(String name) {
		String msg = "";
		if (numberOfFloors%2 != 0) {
			int actualF = 0;
			for (int i = 0;i<tower.length ; i += 2 ) {
				for (int j = 0;j<tower.length ;j++ ) {
					if (actualF % 2 == 0 ) {
						if (tower[i][j].getEmployee() != null) {
							if (tower[i][j].getEmployee().getName().equalsIgnoreCase(name)) {
								msg += tower[i][j].getExtension() + "de la empresa" + this.name + "\n";
							}
						}
					} else {
						if (tower[i][tower.length-j-1].getEmployee() != null) {
							if (tower[i][tower.length-j-1].getEmployee().getName().equals(name)){
								msg += tower[i][tower.length-j-1].getExtension();
							}
						}
					}
					if (actualF % 2 == 0 && i < tower.length-1){
						if (tower[i+1][tower.length-1].getEmployee() != null) {
							if (tower[i+1][tower.length-1].getEmployee().getName().equalsIgnoreCase(name)) {
								msg += tower[i+1][tower.length-1].getExtension() + "de la empresa" + this.name + "\n";
							}
						}
					} else {
						if (tower[i+1][0].getEmployee() != null) {
							if (tower[i+1][0].getEmployee().getName().equalsIgnoreCase(name)) {
								msg += tower[i+1][0].getExtension() + "de la empresa" + this.name + "\n";
							}
						}
					}

				}
				actualF++;
			}
		}else {
			msg += "We can't search in this way in "+ this.name +"because the number of floors of the tower isn't none";
		}
		return msg;
	}

	public String espiral(String charge) {
		String msg = "";
		int filaArriba = 0;
		int filaAbajo = tower.length-1;
		int columnaIzquierda = 0;
		int columnaDerecha = tower[0].length-1;
		while (filaArriba < filaAbajo && columnaIzquierda < columnaDerecha) {
			for ( int i = filaArriba ; i < filaAbajo ; i++ ) {
				if (tower[i][columnaIzquierda].getEmployee() != null) {
					if (tower[i][columnaIzquierda].getEmployee().getAppointment().equalsIgnoreCase(charge)) {
						msg += tower[i][columnaIzquierda].getEmployee().getEmail() + "de la empresa" + this.name + "\n";
					}
				}
			}
			columnaIzquierda++;
			for ( int i = columnaIzquierda ; i < columnaDerecha ; i++ ) {
				if (tower[filaAbajo][i].getEmployee() != null) {
					if (tower[filaAbajo][i].getEmployee().getAppointment().equalsIgnoreCase(charge)) {
						msg += tower[filaAbajo][i].getEmployee().getEmail() + "de la empresa" + this.name + "\n";
					}
				}
			}
			filaAbajo--;
			for ( int i = filaAbajo; i >= filaArriba ; i-- ) {
				if (tower[i][columnaDerecha].getEmployee() != null) {
					if (tower[i][columnaDerecha].getEmployee().getAppointment().equalsIgnoreCase(charge)) {
						msg += tower[i][columnaDerecha].getEmployee().getEmail() + "de la empresa" + this.name + "\n";
					}
				}
			}
			columnaDerecha--;
			for ( int i = columnaDerecha ; i >= columnaIzquierda ; i-- ) {
				if (tower[filaArriba][i].getEmployee() != null) {
					if (tower[filaArriba][i].getEmployee().getAppointment().equalsIgnoreCase(charge)) {
						msg += tower[filaArriba][i].getEmployee().getEmail() + "de la empresa" + this.name + "\n";
					}
				}
			}
			filaArriba++;
		}
		return msg;
	}
}
	
	