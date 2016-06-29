package projekt;

public class Kanten {

	private int ID;
	private int source_ID;
	private int destination_ID;
	private int distance;
	
	public Kanten(int source_ID, int destination_ID, int distance, int id) {
		
		this.ID = id; // lft ID-Nummer 1 bis ....
		this.source_ID = source_ID;
		this.destination_ID = destination_ID;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Kanten [ID=" + ID + ", source_ID=" + source_ID + ", destination_ID=" + destination_ID + ", distance="
				+ distance + "]";
	}

}
