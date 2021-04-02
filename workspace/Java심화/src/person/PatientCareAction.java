package person;

@FunctionalInterface
public interface PatientCareAction {
	public void whatIsYourName();

	default void whatIsYourCountry() {
		System.out.println("Korea!");
	}
}
