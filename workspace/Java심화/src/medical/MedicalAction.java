package medical;

import java.util.*;
import person.Patient;

public interface MedicalAction {
	void addPatient(CDC cdc, Patient patient) throws NotCoronaException;
	void removePatient (CDC cdc, Patient patient);
	void writeReport (List<Patient> pList);
}
