public class FindRange {

	public int[] findBound(int[] num, int target) {
		if (num == null)
			throw new NullPointerException("Null array");
		int[] bound = { -1, -1 };
		if (num.length == 0)
			return bound;
		findRange(0, num.length - 1, bound, num, target);
		return bound;

	}

	private void findRange(int start, int end, int[] bound, int[] num,
			int target) {
		
		if (start > end)
			return;
		
		int mid = (start + end) / 2;
		
		if (num[mid] == target) {
			
			if (start == mid || num[mid - 1] != num[mid]) {
				if (bound[0] == -1 || mid < bound[0])
					bound[0] = mid;
			} else {
				findRange(start, mid - 1, bound, num, target);
			}
			
			if (end == mid || num[mid + 1] != num[mid]) {
				if (mid > bound[1])
					bound[1] = mid;
			} else {
				findRange(mid + 1, end, bound, num, target);
			}
		} else if (num[mid] < target)
			findRange(mid + 1, end, bound, num, target);
		else
			findRange(start, mid - 1, bound, num, target);
	}

	public static void main(String[] args) {
		int[] input = { 0, 2, 3, 3, 3, 10, 10 };
		int[] bnd = new FindRange().findBound(input, 3);

		System.out.println("(" + bnd[0] + ", " + bnd[1] + ")");

	}

}
