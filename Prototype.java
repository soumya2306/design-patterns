

//A Java program to demonstrate working of 
//Prototype Design Pattern with example 
//of a ColorStore class to store existing objects. 

import java.util.HashMap; 
import java.util.Map; 


abstract class Department implements Cloneable 
{ 
	
	protected String DepartmentName; 
	
	abstract void addDepartment(); 
	
	public Object clone() 
	{ 
		Object clone = null; 
		try
		{ 
			clone = super.clone(); 
		} 
		catch (CloneNotSupportedException e) 
		{ 
			e.printStackTrace(); 
		} 
		return clone; 
	} 
} 

class CSEDepartment extends Department 
{ 
	public CSEDepartment() 
	{ 
		this.DepartmentName = "CSE"; 
	} 

	@Override
	void addDepartment() 
	{ 
		System.out.println("CSE Department added"); 
	} 
	
} 

class ITDepartment extends Department{ 

	public ITDepartment() 
	{ 
		this.DepartmentName = "IT"; 
	} 

	@Override
	void addDepartment() 
	{ 
		System.out.println("IT Department added"); 
	} 
} 

class DepartmentStore { 

	private static Map<String, Department> DepartmentMap = new HashMap<String,Department>(); 
	
	static
	{ 
		DepartmentMap.put("blue", new CSEDepartment()); 
		DepartmentMap.put("black", new ITDepartment()); 
	} 
	
	public static Department getDepartment(String DepartmentName) 
	{ 
		return (Department) DepartmentMap.get(DepartmentName).clone(); 
	} 
} 


//Driver class 
class Prototype 
{ 
	public static void main (String[] args) 
	{ 
		DepartmentStore.getDepartment("blue").addDepartment(); 
		DepartmentStore.getDepartment("black").addDepartment(); 
		DepartmentStore.getDepartment("black").addDepartment(); 
		DepartmentStore.getDepartment("blue").addDepartment(); 
	} 
} 
