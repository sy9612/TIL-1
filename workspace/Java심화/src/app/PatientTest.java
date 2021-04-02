package app;

import person.PatientCareAction;

public class PatientTest {
	public static void main(String[] args) {
		// #1 complex
		//PatientCareAction helper = new [Some class which implements PatientCareAction]();
		//helper.whatIsYourName();
		
		// #2 better
		PatientCareAction helper = new PatientCareAction() {
			@Override
			public void whatIsYourName() {
				System.out.println("Patient..");
			};
		};
		helper.whatIsYourName();
		helper.whatIsYourCountry();
		// #3 what about lambda
		PatientCareAction helper2 = () -> { System.out.println("Patient.."); };
		helper2.whatIsYourName();
	}
}
