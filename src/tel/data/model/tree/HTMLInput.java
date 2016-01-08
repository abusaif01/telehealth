package tel.data.model.tree;


import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Vector;


public  class HTMLInput extends MyNode{
	public String prevString;
	public String lastString;

	private LinkedHashMap<Integer, Medicine> valueMedMap;

	private int inputValue;
	private Medicine medicine=null;
	public HTMLInput(String prevString, String lastString,LinkedHashMap<Integer, Medicine> valueMedMap) {
		
		this.prevString = paragraphTextFisrt(prevString);
		this.lastString = paragraphTextLast(lastString);
		this.valueMedMap=valueMedMap;
	}



	private String paragraphTextFisrt(String middleText)
	{
		return "<p class=\"span4\">"+middleText +"</p>";
		
	}
	
	private String paragraphTextLast(String middleText)
	{
		return middleText+"</br>" ;
		
	}
	
	public Medicine getMedicine(int inputValue)
	{
		Integer[] values=(Integer[]) valueMedMap.keySet().toArray(new Integer[0]);
		if(inputValue>values[values.length-1])
		{
			return null;
		}
		System.out.println("len"+values.length);
		for(int i=0;i<values.length;i++)
		{
			
			System.out.println(values[i].intValue());
			if(inputValue<=values[i].intValue())
			{
				return valueMedMap.get(new Integer(values[i]));
			}
		}
		
		return medicine;
	}
	
	public String getPrevString() {
		return prevString;
	}

	public String getLastString() {
		return lastString;
	}
	
	
	
}
