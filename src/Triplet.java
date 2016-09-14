import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  Total time complexity  O(n2)
 * 
 * @author nareshkancharla
 *
 */
public class Triplet {

	List<String> result = new ArrayList<String>();

	public static void main(String args[]) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		//Step 1  Sorting
		Arrays.sort(arr);
		//Setp 2 Searching pairs
        System.out.println("O/P:"+ new Triplet().findTripletsSumZero(arr));
	}

	List<String> findTripletsSumZero(int[] arr) {
		int n = arr.length;
		//1st iteration n times
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;
			//worst case another n iterations
			while (j < k) {
				int sum_two = arr[i] + arr[j];
				if (sum_two + arr[k] < 0) {
					j++;
				} else if (sum_two + arr[k] > 0) {
					k--;
				} else {

					result.add("( " + arr[i] + "," + arr[j] + ","+arr[k] + ")");
					j++;
					k--;
				}
			}
		}

		return result;
	}

}
