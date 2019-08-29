package assignment1_30336119;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Clinic {
	private ArrayList<specialisedVet> listOfVeterinarians;
	private ArrayList<animalInsuredUninsured> listOfAnimals;
	private String inputFileName;
	
	public Clinic(){
		listOfVeterinarians = new ArrayList<specialisedVet>();
		listOfVeterinarians.clear();
		listOfAnimals = new ArrayList<animalInsuredUninsured>();
		listOfAnimals.clear();
		inputFileName="MyInput.csv";
		}
	
	public final String run(){
		String output = "";

		System.out.println("Begin run\n");
		 // set up data for clinic
		
		try {
			File inputFile = new File(inputFileName);
			Scanner s = new Scanner(inputFile);
			String vName,  vSpeciality, line, tokens[], aName,  aBreed, aPreferredVet, aInsuranceNo;
			int vAge, vMax, aHoursTreated, aAge;
			while (s.hasNext()) {
				line = s.nextLine();
				tokens = line.split(",");
				if (tokens[0].equalsIgnoreCase("Veterinarian")) {
					this.addNewVet(tokens);
				}
				if (tokens[0].equalsIgnoreCase("InsuredAnimal")) {
					this.addNewInsuredAnimal(tokens);
					
				}
				if (tokens[0].equalsIgnoreCase("Animal")) {
					this.addNewUninsuredAnimal(tokens);
				}
			}
		}
		catch ( IOException e) 
		{
			System.out.println(e.getStackTrace());
			this.listOfVeterinarians.add(new specialisedVet("Ben Casey", 32, 3, "Small Animals"));
			this.listOfVeterinarians.add(new specialisedVet("Hawkeye Pierce", 47, 3, "Large Animals"));
			this.listOfVeterinarians.add(new specialisedVet("Doogie Howser", 22, 1, "Horses"));
			// set up animal data
			this.listOfAnimals.add(new animalInsuredUninsured("Fred Bear", 2, "Insured", "Ben Casey", "HCF236788", 10, "Cockerspaniel"));
			this.listOfAnimals.add(new animalInsuredUninsured("Betty Bird", 3, 7, "Budgerigar"));
			this.listOfAnimals.add(new animalInsuredUninsured("Bella Plant", 3, "Insured", "Ben Casey", "HCF265123", 23, "Rabbit"));
			this.listOfAnimals.add(new animalInsuredUninsured("Dagwood Dog", 8, "Insured", "Doogie Howser", "HCF265988", 2, "Labrador" ) );
			this.listOfAnimals.add(new animalInsuredUninsured("Ernie", 2, "Insured", "Ben Casey", "HCF134231", 1, "Guinea Pig" ) );
			this.listOfAnimals.add(new animalInsuredUninsured("Tinkerbell", 4,  1, "Siamese cat") );
			this.listOfAnimals.add(new animalInsuredUninsured("Slinky", 1, 1, "Blue Tongue Lizard") );
			this.listOfAnimals.add(new animalInsuredUninsured("Mickey Mouse", 5, "Insured", "Ben Casey", "HCF234511", 1, "Mouse") );
		}
		
		
		// Add details of data to output string

		output += "___________________\n\nList of registered veterinarians\n___________________\n\n";
		output += this.printListofVeterinerians();

		output += "\n";
		
		output += "\n___________________\n\nList of animals before veterinarians assigned\n___________________\n\n";
		output += this.printListAnimalsBeforeAssigned();

		// assign animals to a particular veterinarian in this clinic
		
		output += "\n___________________\n\n Assigning Veterinarians to Animals\n___________________\n";
		output += this.assignVets();
		
		// Add new information of assignments to output string 

		output += "\n___________________\n\nList of animals after veterinarians assigned\n___________________\n";
		output += this.printListAnimalsAssigned();

		output += "___________________\n\nList of veterinarians after animals assigned\n___________________\n" + "\n";
		output += this.printListVetsAfterAssigned();
		
		return output;  // return string to calling method to print out
	}
	
	public String printListVetsAfterAssigned() {
		String output = "";
		for (int i = 0; i < this.listOfVeterinarians.size(); i++){
			specialisedVet temp = ((specialisedVet)this.listOfVeterinarians.get(i));
			output += temp.toString() + "\n";
			if (temp.HasAnimals()){
				output += temp.printListOfAnimals();
			}
			else{
				output += "No animals assigned to this veterinarian as yet";
			}
			output += "\n";
		}
		return output;
	}
	
	public String printListAnimalsAssigned() {
		String output = "";
		for (int i = 0; i < this.listOfAnimals.size(); i++){
			output += ((Animal)this.listOfAnimals.get(i)).toString() + "\n";
		}
		return output;
	}
	public String assignVets() {
		String output = "";
		ArrayList<animalInsuredUninsured> list = this.listOfAnimals;
		for (int i = 0; i < list.size(); i++){
			animalInsuredUninsured temp = (animalInsuredUninsured)list.get(i);
			if (this.listOfVeterinarians == null) {
				output += "- No available veterinarians\n*******************\n"; 
				break;  // go no further will allocations, list of Veterinarians is empty - may need to check for availability in another clinic in a later version 
			}
			if (temp.assignVeterinarian(this.listOfVeterinarians) == false){  // attempt to assign animal to a veterinarian
				output += "\n********************************************************************\n Not yet assigned animal " + temp.getName() + "- No available veterinarians\n********************************************************************\n";
				output += ((animalInsuredUninsured)list.get(i)).mv(temp.animalType);
			}
			else{
				output += "Assigning veterinarian " + temp.assignedVeterinarian.name + " to " + temp.getName() + "\n";
			}
		}
		return output;
	}
	public String printListofVeterinerians(){
		String output = "";
		for (int i = 0; i < this.listOfVeterinarians.size(); i++){
			specialisedVet temp = ((specialisedVet)this.listOfVeterinarians.get(i));
			output += temp.toString() + "\n";
			if (temp.HasAnimals()){
				output += temp.printListOfAnimals();
			}
			else{
				output += "No animals assigned to this veterinarian as yet";
			}
			output += "\n";
		}
		return output;
	}
	
	public String printListAnimalsBeforeAssigned() {
		String output = "";
		for (int i = 0; i < this.listOfAnimals.size(); i++){
			output += ((Animal)this.listOfAnimals.get(i)).toString() + "\n";
		}
		return output;
	}
	public void addNewVet(String tokens[]) {
		String vName, vSpeciality;
		int vAge, vMax;
		vName = tokens[1];
		vAge = Integer.valueOf(tokens[2]);
		vMax = Integer.valueOf(tokens[3]);
		vSpeciality = tokens[4];
		this.listOfVeterinarians.add(new specialisedVet(vName, vAge, vMax, vSpeciality));
	}
	
	public void addNewInsuredAnimal(String tokens[]) {
		String aName,aPreferredVet,aInsuranceNo,aBreed;
		int aAge,aHoursTreated;
		aName = tokens[1];
		aAge = Integer.valueOf(tokens[2]);
		aPreferredVet = tokens[3];
		aInsuranceNo = tokens[4];
		aHoursTreated = Integer.valueOf(tokens[5]);
		aBreed = tokens[6];
		this.listOfAnimals.add(new animalInsuredUninsured(aName, aAge, "Insured", aPreferredVet, aInsuranceNo, aHoursTreated, aBreed));
	}
	
	public void addNewUninsuredAnimal(String tokens[]) {
		String aName,aBreed;
		int aAge,aHoursTreated;
		aName = tokens[1];
		aAge = Integer.valueOf(tokens[2]);
		aHoursTreated = Integer.valueOf(tokens[3]);
		aBreed = tokens[4];
		this.listOfAnimals.add(new animalInsuredUninsured(aName, aAge, aHoursTreated, aBreed));
	}
}
