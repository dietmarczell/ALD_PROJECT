package Final;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class VersuchteBreitensuche {

	 public static void findByBreitenSuche(
			   Graph g, int von, int nach, ArrayList<Edge> edge_list) {
			 
			 ArrayDeque<Integer> nodes = new ArrayDeque<Integer>();
			 boolean[] visited = new boolean[g.numVertices()];
			 int[] pred = new int[g.numVertices()];
			 boolean found = false;
			 for(int i=0; i<pred.length; i++) {
			  pred[i] = -1; 
			 }
			 nodes.add(von);
			 outer: while(!nodes.isEmpty()) {
			  int current = nodes.poll();
			  visited[current] = true;
			  ArrayList<Vertex> nachbarn = new ArrayList<Vertex>(); //= g.getEdges(current);
			  for (Edge edge : edge_list) {
				  
				if(Integer.parseInt(edge.getSource().getId()) == current)
				{
					//System.out.println(nachbarn.toString() + " " + edge);
					
					//Nachbarknoten wird hinzugefügt
					nachbarn.add(edge.getDestination());
					if(Integer.parseInt(edge.getDestination().getId()) == current)
					{
					System.out.println(edge.getDestination().getId());
					}
				}
			}
			  for(Vertex nachbar: nachbarn) {
				//  System.out.println("Visited: " + visited);
			   if (!visited[Integer.parseInt(nachbar.getId())]) {
			    nodes.add(Integer.parseInt(nachbar.getId()));
			    pred[Integer.parseInt(nachbar.getId())] = current;
			    
			    if (Integer.parseInt(nachbar.getId()) == nach) {
			     found = true;
			     break outer;
			    }
			   }
			  }
			}

			if (found) {
			 // Route ausgeben
			 for(int i=0; i<pred.length; i++) {
				 if(server.Vertexeshash.get(pred[i] ) != null)
				 {
					 System.out.println(i + " über " + server.Vertexeshash.get(pred[i]));
				 }
			 }
			}
			else {
			 System.out.println("Keine Verbindung gefunden");
			}

			}
	
}
