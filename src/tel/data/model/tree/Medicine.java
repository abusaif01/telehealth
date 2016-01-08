package tel.data.model.tree;

public class Medicine {
	private String medicineName;
	private String dessity;
	private int medTime;
	private int medDays;
	
	public Medicine(String medicineName, String dessity, int medTime,
			int medDays) {
		this.medicineName = medicineName;
		this.dessity = dessity;
		this.medTime = medTime;
		this.medDays = medDays;
	}
	
	public String getMedicineName() {
		return medicineName;
	}
	public String getDessity() {
		return dessity;
	}
	public int getMedTime() {
		return medTime;
	}
	public int getMedDays() {
		return medDays;
	}
	
	
	
}
