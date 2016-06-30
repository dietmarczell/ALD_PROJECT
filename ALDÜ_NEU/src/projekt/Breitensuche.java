package projekt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import test.BinaryTree;

public class Breitensuche extends BinaryTree {

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück
	 * @param start Startknoten für Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<Integer> getBreadthFirstOrder(Vertex start) {

		ArrayList<Integer> result = new ArrayList<>();

		ArrayDeque<Vertex> queue = new ArrayDeque<>();
		
		queue.add(start);
		
		while (!queue.isEmpty())
		{
			Vertex current = queue.remove();
			
			result.add(Integer.parseInt(current.getId()));
			
			if (current.getLeft() != null)
				queue.add(current.getLeft());
			if (current.getRight() != null)
				queue.add(current.getRight());
			
		}
		
		
		return result;
	}

}