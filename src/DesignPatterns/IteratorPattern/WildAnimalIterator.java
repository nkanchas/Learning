package DesignPatterns.IteratorPattern;

import java.util.List;



public class WildAnimalIterator implements Iterator {
	
	private int position;
	private List<Animal>  animalList;
	
	public WildAnimalIterator(List<Animal> animalList){
		this.animalList = animalList;
	}
	

	@Override
	public Animal nextAnimal() {
		Animal animal = null;
		for(;position < animalList.size(); position++){
			if((animalList.get(position).getAnimalType().equalsIgnoreCase("Wild"))) {
				
				animal= animalList.get(position);
				position++;
				break;
			}
		}
		
		return animal;
		
				
	}

	@Override
	public boolean isLastAnimal() {
		for(int i=position; i<animalList.size();++i){
			if(animalList.get(position).getAnimalType().equalsIgnoreCase("Wild")){
				return false;
			}
		}
	
		return true;
	}

	@Override
	public Animal currentAnimal() {
		if(position < animalList.size())
			return animalList.get(position);
		return null;
	}


	

}
