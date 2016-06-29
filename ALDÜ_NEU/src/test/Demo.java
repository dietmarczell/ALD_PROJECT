package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Breitensuche bsu = new Breitensuche();
		ArrayList<String> info = new ArrayList<>();
		ArrayList<Node> nodes = new ArrayList<>();
		File f = new File("D://temp//ALD_UEBUNG_CSV.csv");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			BaseTree<Node> bs = new BaseTree<Node>() {
				
				@Override
				protected int compare(Node a, Node b) {
					// TODO Auto-generated method stub
					return 0;
				}
			};
			int j = 0;
			while((line = br.readLine()) != null)
			{
				info.clear();
				for(int i=0; i<line.split(";").length; i++)
				{
					info.add(line.split(";")[i]);
				}
				//System.out.println(new Node<ArrayList<String>>(new ArrayList<>(info)).toString());
				
				nodes.add(new Node<ArrayList<String>>(new ArrayList<>(info)));
				
				//bs.add(nodes.get(j));
				j++;
			}
			//bs.printTree();
			//bs.find(nodes.get(0), nodes.get(17));
			//bsu.getBreadthFirstOrder(nodes.get(0));
			//System.out.println(nodes.get(0).getValue().toString().split(",")[0].substring(1));
			System.out.println(nodes.get(0).id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> nodevalues = new ArrayList<>();
		nodevalues.add("1");
		
		/*
		
		
		Node n1 = new Node<ArrayList<String>>(new ArrayList<String>(nodevalues));
		nodevalues.clear();
		System.out.println(n1.toString());
		System.out.println("------");
		
		
		nodevalues.add("Graz");
		Node n2 = new Node<ArrayList<String>>(nodevalues);
		System.out.println(n2.toString());
		nodevalues.clear();
		*/
	}

}
