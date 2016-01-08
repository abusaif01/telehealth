package tel.data.model.tree;

import java.util.Vector;

public class Disease extends MyNode {
	
	private String diseaseName;
	

	//private int numberOfInput;
	private Vector<Medicine> fixedMed=new Vector<Medicine> ();
	
	public Disease(String diseaseName) {
		super();
		this.diseaseName = diseaseName;
	}

	
	public String getDiseaseName() {
		return diseaseName;
	}
	
	public void addFixedMed(Medicine med)
	{
		fixedMed.add(med);
	}
	
	public Vector<Medicine> getFixedMed() {
		return fixedMed;
	}
	
}