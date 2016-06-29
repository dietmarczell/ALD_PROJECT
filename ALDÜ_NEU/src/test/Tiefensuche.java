package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Tiefensuche extends BaseTree<Ort> {

	@Override
	protected int compare(Ort a, Ort b) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/**
	 * Retourniert die Titelliste der Ort-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in symmetrischer Reihenfolge
	 */
	public List<String> getNodesInOrder(Node<Ort> node) {

		List<String> flatList = new ArrayList<String>();
		
		if (node.getLeft() != null)
		{
			flatList.addAll(getNodesInOrder(node.getLeft()));
		}
		
		flatList.add(node.getValue().getName());
		
		if (node.getRight() != null)
		{
			flatList.addAll(getNodesInOrder(node.getRight()));
		}
		
		return flatList;
	}
		
	/**
	 * Retourniert Titelliste jener Orte, deren L�nge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
	 * @param min Minimale L�nge des SpielOrts
	 * @param max Maximale L�nge des SpielOrts
	 * @return Liste der Orttitel in Hauptreihenfolge
	 */
	public List<String> getMinMaxPreOrder(double min, double max) {

		return getMinMaxPreOrder(getRoot(), min, max);
	}
	
	private List<String> getMinMaxPreOrder(Node<Ort> node, double min, double max){
		
		List<String> flatList = new ArrayList<String>();
		
		// Beim eigenen �berpr�fen
		if (node.getValue().getID() >= min && node.getValue().getID() <= max)
		{
			flatList.add(node.getValue().getName());
		}
		// Links �berpr�fen (Eigene Ortl�nge gr��er/gleich MIN ?)
		if (node.getLeft() != null && node.getValue().getID() >= min)
		{
			flatList.addAll(getMinMaxPreOrder(node.getLeft(), min, max));
		}
		// Rechts �berpr�fen (Eigene Ortl�nge kleiner-gleich MAX ?)
		if (node.getRight() != null && node.getValue().getID() <= max)
		{
			flatList.addAll(getMinMaxPreOrder(node.getRight(), min, max));
		}
		
		return flatList;
	}


}
