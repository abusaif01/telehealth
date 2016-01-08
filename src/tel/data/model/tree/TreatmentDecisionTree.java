package tel.data.model.tree;



import java.util.LinkedHashMap;
import java.util.Vector;

public class TreatmentDecisionTree
{
	private static TreatmentDecisionTree treatmentDecisionTree;
	public MyNode root;
	LinkedHashMap<Integer, Medicine> valueMed;

	public Disease selectedDisease;
	public Medicine medicine;
	public HTMLInput htmlIn;
	
	public int childCount;
	public Vector<String> parameters=new Vector<String>(); 
	public String response;
	
	public Vector<Medicine> treatment;
//	int tempIn;
	/*-------------------------------this build the main tree---------------------------------------*/
	private TreatmentDecisionTree()
	{
		Disease disease;
		this.root=new MyNode();
		valueMed=new LinkedHashMap<Integer,Medicine>();
	/*-------------------------------1. Fever ---------------------------------------*/
		disease=new Disease("Fever");
		
		valueMed.put(new Integer(98), new Medicine(null,null, 0, 0));
		valueMed.put(new Integer(100), new Medicine("Napa", "500mg", 3, 3));
		valueMed.put(new Integer(102), new Medicine("Napa Extra", "650mg", 3, 3));
		valueMed.put(new Integer(104), new Medicine("Napa 500 Suppository","", 1, 1));
		
		HTMLTextInput feverTemparature=new HTMLTextInput("Body Temp", "Farenhite", valueMed, "what",disease.childs.size()+1);
		disease.addChild(feverTemparature);
		
		valueMed=new LinkedHashMap<>();
		valueMed.put(new Integer(2), new Medicine("Napa","500mg",3, 2));
		valueMed.put(new Integer(5), new Medicine("Napa Extra","650mg",3, 3));
		valueMed.put(new Integer(6), new Medicine("Consult with Doctor immediately",null,0, 0));
		
		HTMLTextInput feverDays=new HTMLTextInput("Having Fever For", "days", valueMed, "how many", disease.childs.size()+1);
		disease.addChild(feverDays);
		
		this.root.addChild(disease);
		
		/*-------------------------------2. Cold ---------------------------------------*/
		
		disease=new Disease("Cold");
		
		valueMed=new LinkedHashMap<>();
		valueMed.put(new Integer(2), new Medicine("Histacine","500mg",2, 3));
		valueMed.put(new Integer(4), new Medicine("Alatrol","650mg",2, 3));
		
		feverDays=new HTMLTextInput(" Having Cold For", "days", valueMed, "how many", disease.childs.size()+1);
		disease.addChild(feverDays);
		
		valueMed=new LinkedHashMap<>();
		valueMed.put(new Integer(1), new Medicine("Neli Cough","500mg",2, 3));
		valueMed.put(new Integer(2), new Medicine(null, null, 0, 0));
		String[] options={"Yes","No"};
		HTMLDropDwonInput coufhDD=new HTMLDropDwonInput(" Having Cough", " ", valueMed, disease.childs.size()+1,options);
		disease.addChild(coufhDD);
		
		this.root.addChild(disease);
		
		/*-------------------------------3. pain ---------------------------------------*/
		
		disease=new Disease("Pain");
		disease.addFixedMed(new Medicine("paracitamol","500mg",2,3));
		valueMed=new LinkedHashMap<>();
		
		valueMed.put(new Integer(2), new Medicine("Diclofenac ","",3,3));
		valueMed.put(new Integer(3), new Medicine("Nurotin","650mg",3,3));
		options= new String[] {"Minimum","High","Severe"};
		HTMLDropDwonInput htmldd=new HTMLDropDwonInput("Level Of Pain", "", valueMed, disease.childs.size()+1, options);
		
		disease.addChild(htmldd);
		
		
		this.root.addChild(disease);
		
		
		
		/*-------------------------------4. Headache ---------------------------------------*/
		
		disease=new Disease("Headache");
		disease.addFixedMed(new Medicine("Paracitamol","500mg",2,3));
		valueMed=new LinkedHashMap<>();
		
		valueMed.put(new Integer(1), new Medicine(null,null,0,0));
		valueMed.put(new Integer(2), new Medicine("Vergon","125mg",3,3));
		valueMed.put(new Integer(7), new Medicine("Consult with Doctor immediately",null,0, 0));
		options= new String[] {"Minimum","High","Severe"};
		htmldd=new HTMLDropDwonInput("Level Of Pain", "", valueMed, disease.childs.size()+1, options);
		
		disease.addChild(htmldd);
		
		
		this.root.addChild(disease);
		
		
		
		/*-------------------------------5. Dysentery ---------------------------------------*/
		
		disease=new Disease("Dysentery");
		
		disease.addFixedMed(new Medicine("ORS ",null,2, 3));
		valueMed=new LinkedHashMap<>();
		valueMed.put(new Integer(3), new Medicine("Metronidazole","",2,3));
		valueMed.put(new Integer(5), new Medicine("Vibramycin-D","",3,3));
		valueMed.put(new Integer(10), new Medicine("Consult with Doctor immediately",null,0, 0));
		options= new String[] {"Minimum","High","Severe"};
		feverDays=new HTMLTextInput("Frequency of dysentry", "time", valueMed, "how many", disease.childs.size()+1);
		
		disease.addChild(feverDays);
		
		
		this.root.addChild(disease);
		
		
		/*-------------------------------6. Food poisoning ---------------------------------------*/
		
		disease=new Disease("Food poisoning");
		disease.addFixedMed(new Medicine("ORS ",null,2, 3));
		valueMed=new LinkedHashMap<>();
		valueMed.put(new Integer(1), new Medicine("Emotil","",2,3));
		valueMed.put(new Integer(2), new Medicine("Flagyl","500mg",3,3));
		
		options= new String[] {"Yes","No"};
		htmldd=new HTMLDropDwonInput("Having Vomiting", "", valueMed, disease.childs.size()+1, options);
		
		disease.addChild(htmldd);
		
		
		this.root.addChild(disease);
		
		/*-------------------------------7. Allergy ---------------------------------------*/
		
		disease=new Disease("Allergy");
		disease.addFixedMed(new Medicine("Atrizin (Tablet)","Cetirizine 10 mg",2,3));
	//	valueMed=new LinkedHashMap<>();
	//	valueMed.put(new Integer(1), new Medicine("Atrizin Tablet ","Cetirizine 10 mg",2,3));
		
	
	//	options= new String[] {"Minimum","High","Severe"};
	//	htmldd=new HTMLDropDwonInput("Level Of Pain", "", valueMed, disease.childs.size()+1, options);
		
	//	disease.addChild(htmldd);
		
		
		this.root.addChild(disease);
		
		
		
	}
	
	
	public String getResponse(int diseaseNumber )
	{
		response="";
		selectedDisease=(Disease) root.childs.get(diseaseNumber);
		childCount=selectedDisease.childs.size();
		for(int i=0;i<childCount;i++)
		{
			
			//System.out.println(selectedDisease.childs.get(i).getClass());
			response=response+selectedDisease.childs.get(i).toString();
		}
		
		
		return response;
	}
	
	public Vector<Medicine> getTreatment(int[] info)
	{
		int i;
		treatment=new Vector<Medicine>();
		if(selectedDisease.getFixedMed().size()!=0)
		treatment.addAll(selectedDisease.getFixedMed());

			
		for(i=0;i<selectedDisease.childs.size();i++)
		{	
			htmlIn=(HTMLInput)selectedDisease.childs.get(i);
			System.out.println(htmlIn.getClass());
			medicine=htmlIn.getMedicine(info[i]);
			//System.out.println(medicine.getMedicineName());
			treatment.add(medicine);
			
		}
		
		return treatment;
	}
	public static TreatmentDecisionTree getTreatmentDecisionTree()
	{
		if(treatmentDecisionTree==null)
			treatmentDecisionTree=new TreatmentDecisionTree();
		
		return treatmentDecisionTree;
	}
	

}