package DesignPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class ZooImpl implements Zoo{
	
	public List<Animal> list;
	
	
   public ZooImpl(){
	   list = new ArrayList<Animal>();
   }


 @Override
 public void addAnimal(Animal animal) {
	list.add(animal);
	
 }


 @Override
 public void removeAnimal(Animal animal) {
	list.remove(animal);
	
 }


  @Override
   public Iterator createIterator(String iteratorType) {
	  Iterator iterator = null;
	  if(iteratorType != null && iteratorType.equalsIgnoreCase("Wild"))
		  iterator = new WildAnimalIterator(list);
	  
	  return  iterator;
	
   }
   
   
}
