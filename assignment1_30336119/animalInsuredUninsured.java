package assignment1_30336119;

import java.util.ArrayList;

public class animalInsuredUninsured extends Animal{
	public String animalType="Uninsured"; // can be "Insured" or "Uninsured" - Uninsured should be "default"
	private String preferredVeterinarian=null; // Only useful for "Insured" - null for Uninsured animal
	private String insuredHealthFundNo; // Fund number for animals with insured health
	
	public animalInsuredUninsured(String name, int age, int hoursTreated, String aBreed){  // constructor to create an uninsured animal
		
	
		super( name,  age,  hoursTreated,  aBreed);
		this.preferredVeterinarian = null;
		this.insuredHealthFundNo = null;
		
	}

	public animalInsuredUninsured(String name, int age, String animalType, String preferredVeterinarian, String insuredHealthFundNo, int hoursTreated, String aBreed){ //create insured animal
		
		
		super( name,  age,   hoursTreated,  aBreed);
		this.animalType = animalType;
		this.preferredVeterinarian = preferredVeterinarian;
		this.insuredHealthFundNo = insuredHealthFundNo;
		
	}

	
	
	public final boolean assignVeterinarian(ArrayList<specialisedVet> listOfVeterinarians){
		if (animalType.equals("Insured")){
			for (int i = 0; i < listOfVeterinarians.size(); i++){
				specialisedVet temp = (specialisedVet)listOfVeterinarians.get(i);
				if (this.preferredVeterinarian.equals(temp.name)){  // is this the preferred vet?
					if(this.assignToVet(temp))
					{
						return true;
					}
					else // that preferred vet has no capacity for new animals on their list, need to find another vet at this clinic
					{
						mvToANewVet (this.animalType);
						if(this.assignToAvailableVet(listOfVeterinarians))
							return true;
						
					}
				}
			}
		}
		else if (animalType.equals("Uninsured")){


			if(this.assignToAvailableVet(listOfVeterinarians))
				return true;
		}
		return false;
	}

	public final String mvToANewVet (String animalInsuranceType){
		String output = "";
		if (animalInsuranceType.equals("Uninsured")){
			output += "Assigning uninsured animal " + this.name +
								  " to the waiting list until a veterinarian becomes available somewhere\n";
		}
		else if (animalInsuranceType.equals("Insured")){
			output += "Preferred Veterinarian unavailable. Reassigning Insured Animal " + this.name + " to a different Vet at this clinic\n";
		}
		System.out.print(output);
		return output;
	}
	
	public final boolean assignToVet(specialisedVet temp) {
		if (temp.listOfAnimals.size() < temp.maxNumOfAnimals){  // allocate animal to this vet - if possible
			assignedVeterinarian = temp;
			temp.listOfAnimals.add(this);
			return true;	
		}
		return false;
	}
	public final boolean assignToAvailableVet(ArrayList<specialisedVet> listOfVeterinarians) {
		int vets = listOfVeterinarians.size();
		specialisedVet temp2 = null;
		for (int ii = 0; ii < vets; ii++){   // choose which vet to allocate - find a vet with room left in list of registered animals
			temp2 = (specialisedVet)(listOfVeterinarians.get(ii));
			if (temp2.listOfAnimals.size() < temp2.maxNumOfAnimals){
				temp2.listOfAnimals.add(this);
				
				this.assignedVeterinarian = temp2;
				System.out.println("Allocating "+ this.getName() + " to " + temp2.name + "\n");
				return true;
				}
		}
		return false;
		
	}
	
	public final String mv(String animalInsuranceType){
		String output = "";
		if (animalInsuranceType.equals("Uninsured")){
			output += "Will need to assign uninsured animal " + this.name +
								  " to the waiting list until a veterinarian becomes available\n";
		}
		else if (animalInsuranceType.equals("Insured")){
			output += "Will need to reassign Insured Animal " + this.name + " to a different clinic\n";
		}
		System.out.print(output);
		return output;
	}

	

	
	public String toString(){
		if (animalType.equals("Uninsured")){
			String temp = "Uninsured Animal - " + this.name + "\n\t Identifier: " + this.identifier.getIdentifier() + "\n\t Assigned Veterinarian: ";

			String temp2;
			if (this.assignedVeterinarian == null){
				temp2 = "not assigned as yet";
			}
			else{
				temp2 = this.assignedVeterinarian.name + "\n\t Fee for "+ this.hoursTreated + " hours consultation = $" + this.hoursTreated * this.assignedVeterinarian.getHourlyRate();
			}
			return temp + temp2 + "\n";
		}
		else { //if (animalType == "Insured")
			String temp = "Insured Animal - " + this.name + "\n\t Identifier: " + this.identifier.getIdentifier() + "\n\t Preferred Veterinarian: " + this.preferredVeterinarian + "\n\t Insured Health Fund Number: " + this.insuredHealthFundNo +
						  "\n\t Assigned Veterinarian: ";
			String temp2;
			if (this.assignedVeterinarian == null){
				temp2 = "not assigned as yet";
			}
			else{
				temp2 = this.assignedVeterinarian.name + "\n\t Fee for "+ this.hoursTreated + " hours consultation = $" + this.hoursTreated * this.assignedVeterinarian.getHourlyRate();
			}
			return temp + temp2 + "\n";
		}
	}
	
}
