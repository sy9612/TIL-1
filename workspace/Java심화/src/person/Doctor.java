package person;

public class Doctor extends Person{
	String hospitalld;
	String licenseld;
	public Doctor(String name, int age, String phone, String hospitalld, String licenseld) {
		super(name, age, phone);
		this.hospitalld = hospitalld;
		this.licenseld = licenseld;
	}
	public String getHospitalld() {
		return hospitalld;
	}
	public void setHospitalld(String hospitalld) {
		this.hospitalld = hospitalld;
	}
	public String getLicenseld() {
		return licenseld;
	}
	public void setLicenseld(String licenseld) {
		this.licenseld = licenseld;
	}
	
	
	
}
