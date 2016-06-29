package test;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo3 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Node<Ort>> ANO = new ArrayList<>();
		ArrayList<Ort> Orte = new ArrayList<>();
		HashMap<String, Integer> hashi = new HashMap<>();
		Orte.add(new Ort("Flennsburg",1010));
		Orte.add(new Ort("Hamburg", 2010));
		Orte.add(new Ort("Wien", 1009));
		Orte.add(new Ort("Graz", 2344));
		Orte.add(new Ort("Laibach", 2248));
		Orte.add(new Ort("Berlin", 8010));
		
		ANO.add(new Node<Ort>(new Ort("Flennsburg",1010)));
		ANO.add(new Node<Ort>(new Ort("Hamburg", 2010)));
		ANO.add(new Node<Ort>(new Ort("Wien", 1009)));
		ANO.add(new Node<Ort>(new Ort("Graz", 2344)));
		ANO.add(new Node<Ort>(new Ort("Laibach", 2248)));
		ANO.add(new Node<Ort>(new Ort("Berlin", 8010)));

		
	
		//Beginn Breitensuche
		Breitensuche bs = new Breitensuche();
		for (Ort ort : Orte) {
			
			bs.add(new Node<Integer>(ort.getID()).value);
			hashi.put(ort.getName(), ort.getID());
			
		}
		bs.printTree();
		String start;
		String ziel;
		int startid;
		int zielid;
		start = "Hamburg";
		ziel = "Laibach";
		startid = hashi.get(start);
		zielid = hashi.get(ziel);
		bs.printTree(bs.find(startid), "");
		System.out.println("_________________________________");
		System.out.println(bs.getBreadthFirstOrder(bs.find(startid)));
		System.out.println("_________________________________");
		
		//Beginn Tiefensuche
		Tiefensuche tf = new Tiefensuche();
		
		tf.add(new Ort("The Jungle Book", 150));
		tf.add(new Ort("The First Avenger: Civil War", 123));
		tf.add(new Ort("How to Be Single", 114));
		tf.add(new Ort("Zoomania - Ganz schön ausgefuchst!", 91));
		tf.add(new Ort("Ein Hologramm für den König", 85));
		tf.add(new Ort("The Boss - Dick im Geschäft ", 116));
		tf.add(new Ort("The Huntsman & the Ice Queen", 121));
		tf.add(new Ort("Gods of Egypt", 102));
		tf.add(new Ort("Bad Neighbors 2", 87));
		tf.add(new Ort("Wild", 111));
				
		tf.printTree();
		
		System.out.println("-------------------------");
		System.out.println("-------------getNodesInOrder------------");
		System.out.println("-------------------------");
		
		for (String title : tf.getNodesInOrder(tf.getRoot()))
		{
			System.out.println(title);
		}
		
				
		System.out.println("-------------------------");
		System.out.println("-----------getMinMaxPreOrder-------------");
		System.out.println("-------------------------");
		
		for (String title : tf.getMinMaxPreOrder(1000, 20000))
		{
			System.out.println(title);
		}
		
		
	}

}
