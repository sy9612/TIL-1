package medical;

import java.util.List;

import person.Patient;

public class Hospital extends Organization implements MedicalAction{
	String hospitalld;
	int roomTotalCount;
	int roomEmptyCount;
	public Hospital(String name, int employeeCount, String hospitalld, int roomTotalCount, int roomEmptyCount) {
		super(name, employeeCount);
		this.hospitalld = hospitalld;
		this.roomTotalCount = roomTotalCount;
		this.roomEmptyCount = roomEmptyCount;
	}
	
	public void about(String more) {
		System.out.println("We are Hospital");
	}

	public String getHospitalld() {
		return hospitalld;
	}

	public void setHospitalld(String hospitalld) {
		this.hospitalld = hospitalld;
	}

	public int getRoomTotalCount() {
		return roomTotalCount;
	}

	public void setRoomTotalCount(int roomTotalCount) {
		this.roomTotalCount = roomTotalCount;
	}

	public int getRoomEmptyCount() {
		return roomEmptyCount;
	}

	public void setRoomEmptyCount(int roomEmptyCount) {
		this.roomEmptyCount = roomEmptyCount;
	}

	@Override
	public void addPatient(CDC cdc, Patient p) throws NotCoronaException {
		// TODO Auto-generated method stub
		if(! p.isCorona())
			throw new NotCoronaException("NotCorona");
		cdc.addPatient(p);
	}

	@Override
	public void removePatient(CDC cdc, Patient p) {
		// TODO Auto-generated method stub
		cdc.removePatient(p);

	}
	@Override
	public void writeReport(List<Patient> pList) {
		// TODO Auto-generated method stub
		
	}
	
	
}
