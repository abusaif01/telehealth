package tel.data.model.tree;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HTMLDropDwonInput extends HTMLInput
{

	public String dropDwonString;
	
	
	public HTMLDropDwonInput(String prevString, String lastString,LinkedHashMap<Integer, Medicine> valueMedMap,
			int count,String[] options) {
		super(prevString, lastString,valueMedMap);
		this.dropDwonString = dropdwonText(count,options);
	}
	
	private String dropdwonText(int count,String[] options)
	{
		String temp="<select name=\"info"+count+"\">";
		for(int i=0;i<options.length;i++)
		{	
			temp=temp +"<option value="+(i+1)+">"+options[i]+"</option>" ;

		}
		temp=temp +"</select>";
		return temp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return prevString+" "+dropDwonString+" "+lastString;
	}

	public String getDropDwonString() {
		return dropDwonString;
	}
	
	
}
