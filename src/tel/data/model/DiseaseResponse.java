package tel.data.model;

public class DiseaseResponse {
	private  String ResponseText="";
	
	public  String getResponseText(int disease) {
	
		if(disease==1)
		{
			System.out.println("hee");
			ResponseText=ResponseText+
					paragraphText("You Current Body Temperature Is") +
					inputText() +
					"Farenhire" +
					"</br>";
			
			
			ResponseText=ResponseText+ 
					paragraphText("You Are Having Fever For")+
					inputText() +
					"Days" +
					"</br>";
					
			return ResponseText;
		}
		
		if(disease==3)
		{
			ResponseText=ResponseText+
						paragraphText("Pain In")+
						bodyParts()+
						"</br>";
						
		}
		return ResponseText;
		
	}
	
	private String inputText()
	{
		return "<input type=\"text\" placeholder=\"What  \"/> ";
	}
	
	
	private String paragraphText(String middleText)
	{
		return "<p class=\"span4\">"+middleText +"</p>";
	}
	
	private String bodyParts()
	{
		return "<select>" +
				"<option>Whole Body</option>" +
				"<option>Head</option>" +
				"<option>Chest</option>" +
				"<option>Hand</option>" +
				"<option>Stomach</option>" +
				"<option>Leg</option>" +
				
				"<option></option>" +
				"</select>";
	}
	
	public void setResponseText(String responseText) {
		ResponseText = responseText;
	}
	
	

}
