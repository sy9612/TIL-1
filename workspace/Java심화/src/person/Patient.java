package person;

public class Patient extends Person{
	String diseaseName;
	String hospitalld;
	boolean isCorona;
	public Patient(String name, int age, String phone, String diseaseName, String hospitalld, boolean isCorona) {
		super(name, age, phone);
		this.diseaseName = diseaseName;
		this.hospitalld = hospitalld;
		this.isCorona = isCorona;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getHospitalld() {
		return hospitalld;
	}
	public void setHospitalld(String hospitalld) {
		this.hospitalld = hospitalld;
	}
	public boolean isCorona() {
		return isCorona;
	}
	public void setCorona(boolean isCorona) {
		this.isCorona = isCorona;
	}
	
	@Override
	public String getName() {
		char n = name.charAt(0);
		String x = "";
		for(int i=1; i<name.length(); i++) {
			x += "X";
		}
		String n1 = n + x;
		return n1;
	}
	
	@Override
	public String getPhone() {
		String p = phone.substring(0, 9);
		String x = "";
		for(int i=0; i<4; i++) {
			x += "X";
		}
		String p1 = p + x;
		return p1;
	}
	
	@Override
	public boolean equals(Object o) {
		Patient p = (Patient)o;
		if( this.getName().equals(p.getName()) && this.getPhone().equals(p.getPhone())) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + this.getName().hashCode();
		hash = 31 * hash + this.getPhone().hashCode();
		return hash;
	}
	
	
}
