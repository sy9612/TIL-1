package virus;

import java.util.ArrayList;
import java.util.List;

public class VirusContainer<T> {
	private List<T> virusList = new ArrayList<T>();
	
	public List<T> getViruseList(){
		return virusList;
	}
	
	public void setVirusList(List<T> virusList) {
		this.virusList = virusList;
	}
	
	public static void main(String[] args) {
		VirusContainer<Corona> container = new VirusContainer<Corona>();
		container.getViruseList().add(new Corona("covid19", 10, "A10"));
		System.out.println(container.getViruseList().get(0).getName());
		
	}
}
