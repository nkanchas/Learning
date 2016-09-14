import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GenericsAndClassLoader {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		if(list1.getClass() == list2.getClass())
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		
		if(list1.getClass().getName() == list2.getClass().getName())
			System.out.println("name --> equal");
		else
			System.out.println("name --> not equal");
		

	}

}
