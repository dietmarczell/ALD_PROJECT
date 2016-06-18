package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Breitensuche extends BaseTree<Integer> {

	@Override
	protected int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück
	 * @param start Startknoten für Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<Integer> getBreadthFirstOrder(Node<Integer> start) {

		ArrayList<Integer> result = new ArrayList<>();

		ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
		
		queue.add(start);
		
		while (!queue.isEmpty())
		{
			Node<Integer> current = queue.remove();
			
			result.add(current.value);
			
			if (current.getLeft() != null)
				queue.add(current.getLeft());
			if (current.getRight() != null)
				queue.add(current.getRight());
			
		}
		
		
		return result;
	}

}