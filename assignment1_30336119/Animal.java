package assignment1_30336119;

import java.util.*;

public class Animal {

	
	
		public specialisedVet assignedVeterinarian=null; // Veterinarian assigned to Animal
		
		protected String name;
		private int age;
		protected animalIdentifier identifier;
		
		
		protected int hoursTreated; // No of hours animal treated by Veterinarian
		protected String animalBreed;

		public final String getName(){
			return name;
		}
		
		public Animal(String name, int age, int hoursTreated, String aBreed){  // constructor to create an uninsured animal
			this.name = name;
			this.age = age;
			assignedVeterinarian = null;
			identifier = new animalIdentifier();
			identifier.SetIdentifier();
			
			this.hoursTreated = hoursTreated;
			this.animalBreed = aBreed;
		}

		public Animal(String name, int age, String animalType, String preferredVeterinarian, String insuredHealthFundNo, int hoursTreated, String aBreed){ //create insured animal
			this.name = name;
			this.age = age;
			assignedVeterinarian = null;
			identifier = new animalIdentifier();
			identifier.SetIdentifier();
			
			
			this.hoursTreated = hoursTreated;
			this.animalBreed = aBreed;
		}

		
}
