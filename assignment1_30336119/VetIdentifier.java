package assignment1_30336119;

public class VetIdentifier {
	private static int vetIdNo = 1000; // Internal use only - no get/set methods
	private String identifier; // Veterinarian's staff id 
	
	public final void setIdentifier(){
		this.identifier = "V" + String.valueOf(vetIdNo++);
	}
	public final String getIdentifier() {
		return identifier;
	}
}
