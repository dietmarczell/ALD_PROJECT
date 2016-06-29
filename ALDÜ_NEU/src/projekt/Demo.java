package projekt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Dijkstra Test
		
		HashMap<String, Vertex> Vertexes = new HashMap<>();
		ArrayList<Node<String>> KnotenOrte = new ArrayList<>();
		ArrayList<Kanten> kanten = new ArrayList<>();
		File f = new File("D://temp//ALD_UEBUNG_CSV.csv");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		//Variablen initialisieren
		String line;
		
		String Kid=null;
		String Oid = null;
		String Ort = null;
		int kanten_source_id;
		int kanten_destin_id;
		int kanten_distance;
		
		while((line = br.readLine())!=null)
		{
			if(line.split(";").length>0){
			Oid= line.split(";")[0];
			}
			if(line.split(";").length>1){
			Ort = line.split(";")[1];
			}
			
			Vertex x = new Vertex(Oid, Ort);
			Vertexes.put(Oid, x);
			
				
		}
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		String srcid;
		String destid;
		int weight;
		while((line = br.readLine())!=null)
		{
			srcid = line.split(";")[0];
			for (int i = 2; i < line.split(";").length; i++) {
				destid = line.split(";")[i].split("x")[0];
				weight = Integer.parseInt(line.split(";")[i].split("x")[1]);
			//Edges erstellen
			}
			
				
		}
		/*System.out.println("Arraylist  ort mit Objekten ORT: -----------------------");
		for (Node<String> x : KnotenOrte) {	System.out.println(x.toString());		}
		//bei der toString Methode wird hier nur der pointer auf das Array con[][] ausgegeben!
		
		
		
		/*System.out.println("Arraylist  katnen mit Objekten KANTEN: -----------------------");
		for (Kanten x : kanten) {System.out.println(x.toString());	}
	//	for (Or is : con) {*/
			
			
		}
		
		
			
		}
		



