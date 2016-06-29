package projekt;

import java.util.Arrays;

public class Ort {
	private int ID;
	private String Oname;
	public int getID() {
		return ID;
	}
	public Ort(int iD,  String name) 
	{
		ID = iD;
		Oname = name;
		
		
		
		
	}
	@Override
	public String toString() {
		return "Ort [ID=" + ID + ", Oname=" + Oname + "]";
	}
	

}
