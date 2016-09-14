package DesignPatterns.IteratorPattern;

public class Test {

	public static void main(String[] args) {
		Animal lion = new Animal("lion", "Wild");
		Animal tiger = new Animal("tiger", "Wild");
		
		Zoo zoo = new ZooImpl();
		
		zoo.addAnimal(lion);
		zoo.addAnimal(tiger);
		
		Iterator itr = zoo.createIterator("Wild");
		
		while(!itr.isLastAnimal()){
			System.out.println("Wild Animal "+ itr.nextAnimal().getName());
		}

	}

}
