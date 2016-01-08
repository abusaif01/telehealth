package tel.data.model.tree;

import java.util.Vector;

public class MyNode
{
	
	//private MyNode parent;
	public Vector<MyNode> childs; 
	public MyNode()
	{
		childs=new Vector<MyNode>();
	}
	
	public void addChild(MyNode child)
	{
		this.childs.add(child);
	}
	
	
	public static void main (String[] args) {
	
	}
}