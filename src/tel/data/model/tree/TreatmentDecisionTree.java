package tel.data.model.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

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
	public String treatment;
//	int tempIn;
	/*-------------------------------this build the main tree---------------------------------------*/
	private TreatmentDecisionTree()
	{
		this.root=new MyNode();
		valueMed=new LinkedHashMap<Integer,Medicine>();
	/*------------------------------- Fever ---------------------------------------*/
		Disease fever=new Disease("Fever");
		
		valueMed.put(new Integer(98), new Medicine("no Med", "none", 0, 0));
		valueMed.put(new Integer(100), new Medicine("Napa", "500mg", 3, 3));
		valueMed.put(new Integer(102), new Medicine("Napa Extra", "650mg", 3, 3));
		valueMed.put(new Integer(104), new Medicine("Napa Extends", "650mg", 3, 3));
		
		HTMLTextInput feverTemparature=new HTMLTextInput("Body Temp", "Farenhite", valueMed, "what",fever.childs.size()+1);
		fever.addChild(feverTemparature);
		
		valueMed=new LinkedHashMap<>();
		valueMed.put(new Integer(2), new Medicine("Napa","500mg",3, 2));
		valueMed.put(new Integer(4), new Medicine("Napa Extra","650mg",3, 3));
		
		HTMLTextInput feverDays=new HTMLTextInput("You Having Fever For", "days", valueMed, "how many", fever.childs.size()+1);
		fever.addChild(feverDays);
		
		this.root.addChild(fever);
		
		/*------------------------------- Cold ---------------------------------------*/
		
		Disease cold=new Disease("Cold");
		
		valueMed=new LinkedHashMap<>();
		valueMed.put(new Integer(2), new Medicine("Deslor","500mg",2, 3));
		valueMed.put(new Integer(4), new Medicine("Alatrol","650mg",2, 3));
		
		feverDays=new HTMLTextInput("You Having Cold For", "days", valueMed, "how many", cold.childs.size()+1);
		cold.addChild(feverDays);
		
		valueMed=new LinkedHashMap<>();
		valueMed.put(new Integer(1), new Medicine("Neli Cufg","500mg",2, 3));
		valueMed.put(new Integer(2), new Medicine("no Med", "none", 0, 0));
		String[] options={"Yes","No"};
		HTMLDropDwonInput coufhDD=new HTMLDropDwonInput("DO YOu Having Cough", " ", valueMed, cold.childs.size()+1,options);
		cold.addChild(coufhDD);
		
		this.root.addChild(cold);
		
		/*------------------------------- Cold ---------------------------------------*/
		
		Disease pain=new Disease("Pain");
		
		this.root.addChild(pain);
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
	
	public String getTreatment(int[] info)
	{
		treatment="";
		for(int i=0;i<selectedDisease.childs.size();i++)
		{	
			htmlIn=(HTMLInput)selectedDisease.childs.get(i);
			System.out.println(htmlIn.getClass());
			medicine=htmlIn.getMedicine(info[i]);
			
			treatment=treatment+medicine.getMedicineName()+" "+medicine.getDessity()+" "+medicine.getMedTime()+"  "+medicine.getMedDays();
		}
		
		return treatment;
	}
	public static TreatmentDecisionTree getTreatmentDecisionTree()
	{
		if(treatmentDecisionTree==null)
			treatmentDecisionTree=new TreatmentDecisionTree();
		
		return treatmentDecisionTree;
	}
	
//	public String getTreatment()
//	{
//		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("give disese");
//		try {
//			tempIn=Integer.parseInt(bufferRead.readLine());
//			
//			selectedDisease=(Disease) root.childs.get(tempIn);
//			
//			
//			htmlIn=(HTMLInput) selectedDisease.childs.get(0);
//			System.out.println("give temp");
//			tempIn=Integer.parseInt(bufferRead.readLine());
//			med=htmlIn.getMedicine(tempIn);
//			
//			treatment=med.getMedicineName()+" "+med.getDessity()+" "+med.getMedTime()+"  "+med.getMedDays();
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//		return treatment;
//	}
//	
//	public static void main (String[] args) {
//
//		MyNode root=new MyNode();
//		HashMap<Integer, Medicine> valueMed=new HashMap<Integer,Medicine>();
//		//-----------fever------------------------------
//		Disease fever=new Disease("Fever");
//		
//		valueMed.put(new Integer(98), new Medicine("no Med", "none", 0, 0));
//		valueMed.put(new Integer(100), new Medicine("Napa", "500mg", 3, 3));
//		valueMed.put(new Integer(102), new Medicine("Napa Extra", "650mg", 3, 3));
//		valueMed.put(new Integer(104), new Medicine("Napa Extends", "650mg", 3, 3));
//		
//		HTMLTextInput feverTemparature=new HTMLTextInput("Body Temp", "Farenhite", valueMed, "what");
//		
//		fever.addChild(feverTemparature);
//		root.addChild(fever);
//		
//		System.out.println(new TreatmentDecisionTree(root).getTreatment());
//		//-----------pain------------------------------
//		//Disease pain=new Disease("Pain");
//		
//		
//		
//		
//		
//		
//	
//		
//		
//	}
}