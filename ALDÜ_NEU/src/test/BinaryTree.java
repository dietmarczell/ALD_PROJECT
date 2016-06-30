package test;

public class BinaryTree {

	public Vertex root;
	
	
	public void addNote(int key, String name)
	{
		
		Vertex newVertex = new Vertex(key, name);
		
		if(root == null)
		{
			root = newVertex;
			
		}
		else
		{
			Vertex focusVertex = root;
			
			Vertex parent;
			
			while(true)
			{
				parent = focusVertex;
				
				if(key < focusVertex.Key)
				{
					focusVertex = focusVertex.leftChild;
					if(focusVertex == null)
					{
						parent.leftChild = newVertex;
						return;
					}
				}
				else
				{
					focusVertex = focusVertex.rightChild;
					if(focusVertex == null)
					{
						parent.rightChild=newVertex;
						return;
					}
				}
			}
		}
		
		
	}
	
	
	public void printVertex(Vertex focusVertex)
	{
		if(focusVertex!=null)
		{
			printVertex(focusVertex.leftChild);
			System.out.println(focusVertex);
			printVertex(focusVertex.rightChild);
		
		}
	}
	
	public Vertex search(String name, Vertex Vertex)
	{
		if(Vertex !=null)
		{
			if(Vertex.name.equals(name))
			{
				return Vertex;
			}
			else
			{
				Vertex foundVertex = search(name, Vertex.leftChild);
						
					if(foundVertex == null)
					{
						foundVertex = search(name, Vertex.rightChild);
					}
					return foundVertex;
						
			}
		}
			else
			{
				return null;
			}
		}
		
	
	public class Vertex{
		
		int Key;
		String name;
		Vertex leftChild;
		Vertex rightChild;
		
		Vertex(int key, String name) {
			
			Key = key;
			this.name = name;
		}

		@Override
		public String toString() {
			return name +" has the key " +Key;
		}
		
		public Integer getKey() {
			return Key;
		}
		public String getname() {
			return name;
		}
	}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree theTree = new BinaryTree();
		
		theTree.addNote(50, "Boston");
		
		theTree.addNote(25, "Birmingham");
		theTree.addNote(15, "Rapid City");
		theTree.addNote(30, "New York");
		theTree.addNote(75, "Washington");
		theTree.addNote(85, "Bar Harbor");
		theTree.addNote(55, "Miami");
		theTree.addNote(22, "Orlando");
		
		theTree.printVertex(theTree.root);
		
		System.out.println("------------------------------");
		
		
		System.out.println(theTree.search("Miami", theTree.root));
		System.out.println(theTree.search("Orlando", theTree.root));

	}
		
	
	
	
	
	

}
