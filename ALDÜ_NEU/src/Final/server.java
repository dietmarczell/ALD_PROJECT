package Final;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;


public class server {
	private static final String Vertex = null;
	static BufferedWriter bw = null;
	static BufferedReader br = null;
	static ServerSocket ss = null;
	static ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
	static ArrayList<Edge> edges = new ArrayList<Edge>();
	static HashMap<String, Vertex> Vertexeshash = new HashMap<>();
	static BinaryTree BT = new BinaryTree();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
	static Timestamp time = new Timestamp(System.currentTimeMillis());
	static String timenow = sdf.format(time);
	
	//jakob
	static ArrayList<Edge> edge_list = new ArrayList<>();
	private static Final.Vertex startvertex;
	private static Final.Vertex endvertex;
	
	public static void main(String[] args) {

//		Logger Anfang
		
		Logger.setPath("D://Files//RS_log.txt");
		//Logger Ende
		
		
//		Import CSV Anfang
		File fimport = new File("D://Files//ALD_UEBUNG_CSV.csv");
		FileReader fr;
		try {
			fr = new FileReader(fimport);
			BufferedReader br = new BufferedReader(fr);
			//Import CSV Ende
			
//			Variablen initialisieren
			String line;
			String Oid = new String();
			String Ort = new String();
			
			
//			Knoten erfassen
			try {
				while((line = br.readLine())!=null)
				{
					if(line.split(";").length>0){
					Oid= line.split(";")[0];
					}
					if(line.split(";").length>1){
					Ort = line.split(";")[1];
					}
					
					Vertex x = new Vertex(Oid, Ort);
					Vertexeshash.put(Oid, x);
					vertexes.add(x);
					BT.addNote(Integer.parseInt(Oid), Ort);
						
				}
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				try {
					bw.write("Logfile beachten");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Logger.LogMessage(timenow + "Schreiben nicht möglich Bufferedwriter überprüfen");
				}
				Logger.LogMessage(timenow + "Fehler beim Einlesen. Format überprüfen: ");
				Logger.LogMessage(timenow + " Übergebene Variablen: Oid:" + Oid + ", Ort: "+ Ort);
			}
//			Knoten erfassen ende
			
//			Datei erneut einlesen für Kanten
			fr = new FileReader(fimport);
			br = new BufferedReader(fr);
//			variablen für Kanten
			int Kid = 0;
			String srcid = null;
			String destid = null;
			int weight = 0;
			String edge_name = null;
//			Einlesen der Kanten
			try {
				while((line = br.readLine())!=null)
				{
					srcid = line.split(";")[0];
					for (int i = 2; i < line.split(";").length; i++) 
					{
						destid = line.split(";")[i].split("x")[0];
						weight = Integer.parseInt(line.split(";")[i].split("x")[1]);
						edge_name = line.split(";")[i].split("x")[2]; 
						//Edges erstellen
						Edge e = new Edge(String.valueOf(Kid++), Vertexeshash.get(srcid), Vertexeshash.get(destid), weight, edge_name);
						new Edge(String.valueOf(Kid), Vertexeshash.get(srcid), Vertexeshash.get(destid), weight, edge_name);
						edges.add(e);
						edge_list.add(e); // will be given to Dijkstra to give out Edge_names
					}
				}
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Logger.LogMessage(timenow + "Fehler beim Einlesen. Format Überprüfen");
				Logger.LogMessage(timenow + " Übergebene Variablen: Kanten-id:" + Kid + ", Ausgangsknotenid: "+ srcid
				+ ", Zielknotenid: " + destid + " Kantengewicht: " + weight);
			}
//			Kanten Ende
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Logger.LogMessage(timenow + "Datei zum Einlesen der Knoten und Kanten nicht gefunden");
		}
		

		
//		Graph initialisieren
		Graph g = new Graph(vertexes, edges);
		//Graph Ende
		

//		Dangerzone begin
		Dijkstra ca = new Dijkstra(g);
		
/*		Alter Test auf Serverkonsole		
		System.out.println(Vertexeshash.get("1"));
		Vertex vx = new Vertex("1", "Graz");
		System.out.println(vx);

		BT.printNode(BT.root);
		TODO String ignore case
		

		
		/*Eingabe Anfang
		String Eingabe_start = "Graz";
		System.out.println(BT.search(Eingabe_start.trim(), BT.root));
		test.BinaryTree.Node startnode = BT.search(Eingabe_start.trim(), BT.root);
		Vertex startvertex = new Vertex(startnode.getKey().toString(), startnode.getname());
		ca.execute(startvertex);*/
		
//		Eingabe Ende
		/*String Eingabe_end = "Wien";
		System.out.println(BT.search(Eingabe_end.trim(), BT.root));
		test.BinaryTree.Node endnode = BT.search(Eingabe_end.trim(), BT.root);
		Vertex endvertex = new Vertex(endnode.getKey().toString(), endnode.getname());
		System.out.println(ca.getPath(endvertex));*/
//		Alter Test Ende		
		
		try (ServerSocket ss = new ServerSocket(45000);)	
		{	
			//End Import	
			Logger.LogMessage(timenow + " Server gestartet");
			while(true)
			{
				Socket cls = ss.accept();
				//Putty begrüßung anfang
				bw = new BufferedWriter(new OutputStreamWriter(cls.getOutputStream()));
				br = new BufferedReader(new InputStreamReader(cls.getInputStream()));
				bw.write("Verbindung erfolgreich hergestellt");
				bw.newLine();
				bw.write("Verfuegbare Befehle:");
				bw.newLine();
				bw.write("START:IHR STANDORT, ZIEL:GEWÜNSCHTES ZIEL, EXIT");
				bw.newLine();
				bw.write("Verfügbare Orte:");
				bw.newLine();
				bw.write(vertexes.toString());
				bw.newLine();
				bw.write("Verfuegbare Suchstrategien:");
				bw.newLine();
				bw.write("Dijkstra, Tiefensuche, Breitensuche");
				bw.newLine();
				bw.flush();
				//Putty begrüßung ende
				String[] strategies = {"DIJKSTRA", "TIEFENSUCHE", "BREITENSUCHE"};
				String[] commands = {"STRATEGIE","START","ZIEL","EXIT"};
				String consoleline = new String();
				String Eingabe_start = new String();
				String Eingabe_end = new String();
				boolean found = false;
				while((consoleline = br.readLine()) != null) 
				{		
					String[] consoleline_split = consoleline.split(":");
					
					
				 if(consoleline_split[0].toUpperCase().equals(commands[1]))
					{
						Eingabe_start = consoleline.split(":")[1];
						Eingabe_start = Eingabe_start.substring(0,1).toUpperCase() + Eingabe_start.substring(1);
						
						for (Vertex v : vertexes) {
							if(v.getName().equals(Eingabe_start))
							{
								found = true;
								BinaryTree.Node startnode = BT.search(Eingabe_start.trim(), BT.root);
								bw.write("Ihr Standort lautet: " + Eingabe_start);
								bw.newLine();
								bw.flush();
								startvertex = new Vertex(startnode.getKey().toString(), startnode.getname());
								break;
							}
							
						}
					if(!found)
					{
						bw.write("Startort nicht gefunden, Eingabe überprüfen");
						bw.newLine();
						bw.flush();
					}
						found = false;
						
						
					}
					else if(consoleline_split[0].toUpperCase().equals(commands[2]))
					{
						Eingabe_end = consoleline.split(":")[1];
						Eingabe_end = Eingabe_end .substring(0,1).toUpperCase() + Eingabe_end .substring(1);
						for (Vertex v : vertexes) {
							if(v.getName().equals(Eingabe_end))
							{
								found = true;
								BinaryTree.Node endnode = BT.search(Eingabe_end.trim(), BT.root);
								bw.write("Ihr Standort lautet: " + Eingabe_end);
								bw.newLine();
								bw.flush();
								endvertex = new Vertex(endnode.getKey().toString(), endnode.getname());
								break;
							}
							
						}
					if(!found)
					{
						bw.write("Zielort nicht gefunden, Eingabe überprüfen");
						bw.newLine();
						bw.flush();
					}
						found = false;
						
						
					}

					else if(consoleline_split[0].toUpperCase().equals(commands[0]))
					{
						if(consoleline_split[1].toUpperCase().equals(strategies[0]))
						{
							ca.execute(startvertex);
							if(Eingabe_start != null && Eingabe_end != null && Eingabe_end != Eingabe_start)
							bw.write("Ihre Strecke von " + Eingabe_start + " nach " +  Eingabe_end + " wird berechnet.");
							bw.newLine();
							bw.write("Kuerzester Weg: "+ca.getPath(endvertex, edge_list)); // soll auch ArrayList über Edges mitgeben
							bw.flush();
						}
						else if(consoleline.toUpperCase().equals(strategies[1]))
						{
							
						}
						else if(consoleline.toUpperCase().equals(strategies[2]))
						{
							
						}
						else
						{
							bw.write("Strategie nicht gefunden");
							bw.newLine();
						}
						
						
					}
					
					else if(consoleline_split[0].toUpperCase().equals(commands[3]))
					{
						bw.write("Verbindung wird getrennt");
						bw.newLine();
						bw.write("Verbindung getrennt");
						bw.newLine();
						bw.flush();
						close();
					} 
					else
					{
						bw.write("Ungueltiger Befehl");
						bw.newLine();
						bw.flush();
					}	
				}
			}
		} 	
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			Logger.LogMessage(timenow + "Server kann nicht gestartet werden, Port überprüfen");
		}	
	}
	public static void close() 
	{
		try {
			br.close();
			bw.close();
			ss.close();
			Logger.LogMessage(timenow + "Verbindung wurde getrennt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger.LogMessage(timenow + "Inputs und Outputs können nicht Ordnungsgemäß geschlossen werden");
		}	
	}
}
