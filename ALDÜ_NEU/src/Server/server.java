package Server;

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
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.SSLContext;
import javax.print.attribute.standard.DateTimeAtCompleted;

import projekt.Dijkstra;
import projekt.Edge;
import projekt.Graph;
import projekt.Kanten;
import projekt.Node;
import projekt.Vertex;
import test.BinaryTree;

public class server {
	static BufferedWriter bw = null;
	static BufferedReader br = null;
	static ServerSocket ss = null;
	static ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
	static ArrayList<Edge> edges = new ArrayList<Edge>();
	static HashMap<String, Vertex> Vertexeshash = new HashMap<>();
	static BinaryTree BT = new BinaryTree();
	public static void main(String[] args) throws IOException {
		// TODO
		
		//Import CSV Anfang
		File fimport = new File("D://temp//ALD_UEBUNG_CSV.csv");
		FileReader fr = new FileReader(fimport);
		BufferedReader br = new BufferedReader(fr);
		
			
		//Variablen initialisieren
		String line;
		String Oid = new String();
		String Ort = new String();
		
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
		fr = new FileReader(fimport);
		br = new BufferedReader(fr);
		int J = 0;
		String srcid;
		String destid;
		int weight;
		while((line = br.readLine())!=null)
		{
			srcid = line.split(";")[0];
			for (int i = 2; i < line.split(";").length; i++) 
			{
				destid = line.split(";")[i].split("x")[0];
				weight = Integer.parseInt(line.split(";")[i].split("x")[1]);
				//Edges erstellen
				Edge e = new Edge(String.valueOf(J++), Vertexeshash.get(srcid), Vertexeshash.get(destid), weight);
				new Edge(String.valueOf(J), Vertexeshash.get(srcid), Vertexeshash.get(destid), weight);
				edges.add(e);
			}
		}
		/*System.out.println("------------------------------");
		System.out.println(Vertexes.toString());*/
		Graph g = new Graph(vertexes, edges);
		//Import CSV Ende
		
		//Logger Anfang
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String timenow = sdf.format(time);
		Logger.setPath("D://Files//RS_log.txt");
		//Logger Ende
		//Dangerzone begin
		Dijkstra ca = new Dijkstra(g);
		
		//System.out.println(Vertexeshash.get("1"));
		Vertex vx = new Vertex("1", "Graz");
		System.out.println(vx);

		BT.printNode(BT.root);
		//TODO String ignore case
		
		//Eingabe Start
		/*String Eingabe_start = "Graz";
		System.out.println(BT.search(Eingabe_start.trim(), BT.root));
		test.BinaryTree.Node startnode = BT.search(Eingabe_start.trim(), BT.root);
		Vertex startvertex = new Vertex(startnode.getKey().toString(), startnode.getname());
		ca.execute(startvertex);*/
		
		//Eingabe End
		/*String Eingabe_end = "Wien";
		System.out.println(BT.search(Eingabe_end.trim(), BT.root));
		test.BinaryTree.Node endnode = BT.search(Eingabe_end.trim(), BT.root);
		Vertex endvertex = new Vertex(endnode.getKey().toString(), endnode.getname());
		System.out.println(ca.getPath(endvertex));*/
		
		try (ServerSocket ss = new ServerSocket(45000);)	
		{	
			//End Import	
			Logger.LogMessage(timenow + " Server gestartet");
			while(true)
			{
				Socket cls = ss.accept();
				File f = new File("D://Files//Mapdata.txt");
				
				bw = new BufferedWriter(new OutputStreamWriter(cls.getOutputStream()));
				br = new BufferedReader(new InputStreamReader(cls.getInputStream()));
				bw.write("Verbindung erfolgreich hergestellt");
				bw.newLine();
				bw.write("Verfügbare Befehle");
				bw.write("START:IHR STANDORT, ZIEL:GEWÜNSCHTES ZIEL, EXIT");
				bw.newLine();
				bw.flush();
				/*Dijkstra ca = new Dijkstra(g);
				//System.out.println(Vertexeshash.get("1"));
				Vertex vx = new Vertex("1", "Graz");
				System.out.println(vx.toString());
				Vertex vy = new Vertex("2", "Innsbruck");
				ca.execute(vx);*/
				
				/*bw.write((ca.getPath(vy)).toString());
				bw.flush();*/
				
				String[] commands = {"ROUTE","START","ZIEL","EXIT"};
				String consoleline;
				String Eingabe_start = new String();
				String Eingabe_end = new String();
				
				while((consoleline = br.readLine()) != null) 
				{		
					if(consoleline.split(":")[0].equals(commands[0]))
					{
						bw.write("bitte aktuellen Standort eingeben");
						bw.newLine();
						bw.flush();
					}
					else if(consoleline.split(":")[0].equals(commands[1]))
					{
						Eingabe_start = consoleline.split(":")[1];
						
						System.out.println(BT.search(Eingabe_start.trim(), BT.root));
						test.BinaryTree.Node startnode = BT.search(Eingabe_start.trim(), BT.root);
						Vertex startvertex = new Vertex(startnode.getKey().toString(), startnode.getname());
						ca.execute(startvertex);
						
						bw.write("Ihr Standort lautet: " + Eingabe_start);
						bw.newLine();
						bw.flush();
					}
					else if(consoleline.split(":")[0].equals(commands[2]))
					{
						Eingabe_end = consoleline.split(":")[1];
						bw.write("Ihr Ziel lautet: " + Eingabe_end);
						bw.newLine();
						bw.flush();
						if(Eingabe_start != null && Eingabe_end != null && Eingabe_end != Eingabe_start)
						bw.write("Ihre Strecke von " + Eingabe_start + " nach " +  Eingabe_end + " wird berechnet.");
						bw.newLine();
						bw.flush();
						
						System.out.println(BT.search(Eingabe_end.trim(), BT.root));
						test.BinaryTree.Node endnode = BT.search(Eingabe_end.trim(), BT.root);
						Vertex endvertex = new Vertex(endnode.getKey().toString(), endnode.getname());
						bw.write("kürzester Weg: "+ca.getPath(endvertex));
						bw.newLine();
						bw.flush();
					}
					else if(consoleline.split(":")[0].equals(commands))
					{
						bw.write("Ungültiger Befehl");
						bw.newLine();
						bw.flush();
					}
					else if(consoleline.split(":")[0].equals(commands[3]))
					{
						bw.write("Verbindung wird getrennt");
						bw.newLine();
						bw.write("Verbindung getrennt");
						bw.newLine();
						bw.flush();
						close();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
