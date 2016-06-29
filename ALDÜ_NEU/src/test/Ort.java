package test;

public class Ort implements Comparable<Ort> {
	String Name;
	Integer ID;

	public Ort( String name,int ID) {
		super();
		this.ID = ID;
		Name = name;
		
		
	}

	@Override
	public String toString() {
		return "Ort [Name=" + Name + ", ID=" + ID + "]";
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int compareTo(Ort arg0) {
		// TODO Auto-generated method stub
		if (this.ID > arg0.getID())
			return 1;
		else if (this.ID < arg0.getID())
			return -1;
		return 0;

	}

}
