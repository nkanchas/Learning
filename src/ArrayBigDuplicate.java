import java.util.Arrays;

public class ArrayBigDuplicate {

	public static void main(String[] args) {
		int[] array = { 2, 6, 2, 2, 6, 2, 2, 8, 2, 1 };
		System.out.println(Arrays.toString(array) + " \nMajority Element: " + getMajorityElement(array));

	}

	

	public static Integer getMajorityElement(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}

		Integer candidate = null;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (count == 0) {
				candidate = array[i];
				count = 1;
				continue;
			} else {
				if (candidate == array[i]) {
					count++;
				} else {
					count--;
				}
			}
		}

		if (count == 0) {
			return null;
		}

		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (candidate == array[i]) {
				count++;
			}
		}
		return (count > array.length / 2) ? candidate : null;
	}

}

