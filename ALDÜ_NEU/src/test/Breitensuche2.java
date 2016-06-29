package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Breitensuche2 extends BaseTree<String> {

	/*@Override
	protected int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}*/

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück
	 * @param start Startknoten für Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<String> getBreadthFirstOrder(Node<String> start) {

		ArrayList<String> result = new ArrayList<>();

		ArrayDeque<Node<String>> queue = new ArrayDeque<>();
		
		queue.add(start);
		
		while (!queue.isEmpty())
		{
			Node<String> current = queue.remove();
			
			result.add(current.value);
			
			if (current.getLeft() != null)
				queue.add(current.getLeft());
			if (current.getRight() != null)
				queue.add(current.getRight());
			
		}
		
		
		return result;
	}

	@Override
	protected int compare(String a, String b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
