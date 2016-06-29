package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import projekt.Kanten;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Breitensuche bs = new Breitensuche();
		BreitensucheTest bstest = new BreitensucheTest();
		/*bstest.setUp();
		bstest.getBreadthFirstOrder1();
		bstest.getBreadthFirstOrder2();
		bstest.getBreadthFirstOrder3();*/
		BaseTree<String> BST = new BaseTree<String>() {
			@Override
			protected int compare(String a, String b) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		//BinaryTree BT = new BinaryTree();
		
		ArrayList<Node<Integer>> KnotenOrte = new ArrayList<>();
		ArrayList<Node<Integer>> KOint = new ArrayList<>();
		ArrayList<Kanten> kanten = new ArrayList<>();
		File f = new File("D://temp//ALD_UEBUNG_CSV.csv");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int id = 0;
		int kid=0;
		String Ort = null;
		
		
		int kanten_source_id;
		int kanten_destin_id;
		int kanten_distance;
		
		while((line = br.readLine())!=null)
		{
			if(line.split(";").length>0){
			id= Integer.parseInt(line.split(";")[0]);
			}
			if(line.split(";").length>1){
			Ort = line.split(";")[1];
			}
		//	BT.addNote(id, Ort);
			KnotenOrte.add(new Node<Integer>(id));
			for (Node<Integer> node : KnotenOrte) {
		//		node.name = Ort;
				bs.add(id);
				

			}
			
			
			
			for( int x = 2; x < line.split(";").length ; x++)
			{
				kid++;
				kanten_source_id = id;
				kanten_destin_id = Integer.parseInt(line.split(";")[x].split("x")[0]);
				kanten_distance = Integer.parseInt(line.split(";")[x].split("x")[1]);
				kanten.add(new Kanten(kanten_source_id, kanten_destin_id, kanten_distance, kid ));
			}
			//System.out.println(kanten.toString());
			//System.out.println(orte.toString());
			
				
		}
		String start = "Innsbruck";
		String ziel = "Amstetten";
		int sindex = KnotenOrte.indexOf(start);
		System.out.println(sindex);
		
		bs.printTree();
		BST.printTree();
		/*Node<Integer> current = new Node<Integer>(KnotenOrte.get(sindex).id, KnotenOrte.get(sindex).id);
		bs.find(current, KnotenOrte.indexOf(ziel));
		bs.getBreadthFirstOrder(current);*/
		
		for (Node<Integer> node : KnotenOrte) {
			if(node.getValue() == 45)
			{
				System.out.println(bs.getBreadthFirstOrder(bs.find(45)));
				//System.out.println(bs.getBreadthFirstOrder(bs.find(KnotenOrte.get(KnotenOrte.indexOf("Innsbruck")), KnotenOrte.indexOf("Feldbach"))));
			}
		

		/*for (Node<String> node : KnotenOrte) {
		bs.add(node.getValue());
		}
		
			for (Node<Integer> node: KOint) {
			bs.add(node.getValue());	
			}
			bs.printTree();	
			System.out.println("----------------------------------");
			bs.printTree(KOint.get(1), "+");
			System.out.println(bs.getBreadthFirstOrder(KOint.get(2)));
			System.out.println(bs.getRoot());
			System.out.println(bs.getBreadthFirstOrder(KOint.get(18)));
		*/
	//	BT.printNode(BT.root);
		//System.out.println(BT.search("Feldbach", BT.root));

		//System.out.println("Arraylist  ort mit Objekten ORT: -----------------------");
		
	//	for (Node<String> x : KnotenOrte) {	System.out.println(x.toString());		}
		//bei der toString Methode wird hier nur der pointer auf das Array con[][] ausgegeben!
		
		
		
	/*	System.out.println("Arraylist  katnen mit Objekten KANTEN: -----------------------");
		for (Kanten x : kanten) {System.out.println(x.toString());	}
		System.out.println("Breitensuche Test -----------------------");*/
		
	//	for (Or is : con) {
			
			
		}
		
		
			
		}
}
		




