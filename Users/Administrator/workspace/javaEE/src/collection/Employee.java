package collection;
import java.util.*;
public class Employee implements Comparable<Employee>  {
	private String ID,name,position;
	public Employee(String ID,String name,String position){
		this.ID=ID;
		this.name=name;
		this.position=position;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String toString(){
		return this.ID+" "+this.name+" "+this.position;
	}

	public int compareTo(Employee arg0) {
		
		return Integer.parseInt(this.ID) - Integer.parseInt(arg0.ID);
	}
}
