package ch.mse.app.types;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class VarianceTest1 {
	
	static class Animal {}
	static class Bird extends Animal {}
	
	static void readList(List<? extends Animal> list) {
		Animal a = list.get(0);
		list.add(null);
		// list.add(new Animal());
		// The method add(...) in the type List<....> is not applicable for the arguments (Animal)	
	}

	static void writeList(List<? super Bird> list) {
		list.add(new Bird());
		// Animal a = list.get(0);
		// cannot convert from ? super Bird to Animal
	}
	
	public static void main(String[] args) {
		ArrayList<Bird> bList = new ArrayList<Bird>();
		bList.add(new Bird());
		readList(bList);
		
		ArrayList<Animal> aList = new ArrayList<Animal>();
		aList.add(new Animal());
		readList(aList);
	}

}
