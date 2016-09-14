package DesignPatterns.IteratorPattern;



public interface Zoo {
	public void addAnimal(Animal animal);
	public void removeAnimal(Animal animal);
	public Iterator createIterator(String iteratorType);

}
