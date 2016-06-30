package Final;

import java.util.List;

public class Graph {
  private final List<Vertex> vertexes;
  private final List<Edge> edges;

  public Graph(List<Vertex> vertexes, List<Edge> edges) {
    this.vertexes = vertexes;
    this.edges = edges;
  }

  public List<Vertex> getVertexes() {
    return vertexes;
  }

  public List<Edge> getEdges() {
    return edges;
  }

public int numVertices() {
	// TODO Auto-generated method stub
	return vertexes.size();
}

/*public List<Edge> getEdges(int current) {
	// TODO Auto-generated method stub
	List<Edge> result = new List<Edge>();
	for (Edge edge : edges) {
		if (edge.getDestination().equals(server.Vertexeshash.get(current)))
			result.add(edge);
	}
	return result;
}*/
  
  
  
} 

