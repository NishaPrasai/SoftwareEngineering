package assignment1_30336119;

import java.util.ArrayList;

public class specialisedVet extends Veterinarian{
	private String specialisation; // Veterinarian's special skill
	public ArrayList<Animal> listOfAnimals; // Veterinarian's personal list of animals responsible for care
	
	public specialisedVet(){  // constructor to set up a Veterinarian object
		super();
		specialisation = "Unknown";

		listOfAnimals = new ArrayList<Animal>();  // initially no animals registered
		listOfAnimals.clear();
		
	}

	
	public specialisedVet(String name, int age, int animals2, String specialisation){
		
		super(name, age, animals2);
		listOfAnimals = new ArrayList<Animal>();
		listOfAnimals.clear();
		
		this.specialisation = specialisation;
		
	}

	public specialisedVet(String name, int age, int animals2, String specialisation, double hourlyRate){
		super(name, age, animals2, hourlyRate);
		listOfAnimals = new ArrayList<Animal>();
		listOfAnimals.clear();
		
		this.specialisation = specialisation;
		
	}
	
	public final boolean HasAnimals(){  // does the Vet have any animals registered for care?
		return !listOfAnimals.isEmpty();
	}
	public final String printListOfAnimals(){
		String temp = "";
		temp += "\nList of Animals registered for Dr " + this.name + "\n\n";
		for (int i = 0; i < this.listOfAnimals.size(); i++){
			temp += ((Animal) this.listOfAnimals.get(i)) + "\n";
		}
		return temp;
	}


}
