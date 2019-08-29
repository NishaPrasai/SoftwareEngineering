package assignment1_30336119;

public class animalIdentifier {
	private static int pIdNo = 100000; // No get and set methods - internal use only
	private String identifier; // Animal identifier - unique for each animal in the system
	public final void SetIdentifier(){
		this.identifier = "P" + pIdNo++;
	}
	public final String getIdentifier() {
		return identifier;
	}
}
