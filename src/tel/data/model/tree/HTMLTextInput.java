package tel.data.model.tree;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HTMLTextInput extends HTMLInput
{
	public String inpuString;

	public HTMLTextInput(String prevString, String lastString,LinkedHashMap<Integer, Medicine> valueMedMap,
			String placeHolderText,int count) {
		super(prevString, lastString, valueMedMap);
		this.inpuString = inputText(count,placeHolderText);
	}
	
	private String inputText(int count,String paceholderText)
	{
		return "<input name=\"info"+count+"\" id=\"input"+count+"\" type=\"text\" placeholder=\""+paceholderText+" \"/> ";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//System.out.println(prevString+" "+inpuString+" "+lastString);
		return prevString+" "+inpuString+" "+lastString;
	}
	
	public String getInpuString() {
		return inpuString;
	}
	
	
}
