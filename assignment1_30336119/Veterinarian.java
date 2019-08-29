package assignment1_30336119;
import java.util.*;

public class Veterinarian {

	
		
		public int maxNumOfAnimals; // Maximum no. of animals a Veterinarian can have at one time
		private double hourlyRate; // Hourly rate of pay
		private VetIdentifier identifier; // Vet Identifier
		public String name;  // Name of Veterinarian
		private int age;  // Age of Veterinarian
		

		
		public Veterinarian(){  // constructor to set up a Veterinarian object
			
			maxNumOfAnimals = 0;  // maximum number of animals that can be registered to the Vet
			hourlyRate = 100;
			identifier = new VetIdentifier();
			identifier.setIdentifier();
		}

		
		public Veterinarian(String name, int age, int animals2){
			this.name = name;
			this.age = age;

			
			maxNumOfAnimals = animals2;
			
			hourlyRate = 100;
			identifier = new VetIdentifier();
			identifier.setIdentifier();
		}

		public Veterinarian(String name, int age, int animals2,  double hourlyRate){
			this.name = name;
			this.age = age;

			
			maxNumOfAnimals = animals2;
			
			identifier = new VetIdentifier();
			identifier.setIdentifier();
			this.hourlyRate = hourlyRate;
		}

		public String toString(){
			return "*******************\n Dr " + this.name + "\n\t id number: " + 
					identifier.getIdentifier() + 
					"\n\t Max Number of Patients: " + this.maxNumOfAnimals;
		}

		public final double getHourlyRate(){
			return this.hourlyRate;
		}

		

		
		
	
		
	}
