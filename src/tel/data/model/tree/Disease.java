package tel.data.model.tree;

import java.util.Vector;

public class Disease extends MyNode {
	
	private String diseaseName;
	//private int numberOfInput;
	
	public Disease(String diseaseName) {
		super();
		this.diseaseName = diseaseName;
	}

	public String getDiseaseName() {
		return diseaseName;
	}
	
	
	
}