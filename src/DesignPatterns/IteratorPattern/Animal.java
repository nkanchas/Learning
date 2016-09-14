package DesignPatterns.IteratorPattern;

public class Animal {
	
	private String name;
	private String animalType;
	
	public Animal(String name, String animalType){
		this.name = name;
		this.animalType = animalType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	
	

}
