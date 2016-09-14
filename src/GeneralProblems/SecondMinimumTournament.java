package GeneralProblems;

//https://blogs.oracle.com/malkit/entry/finding_2nd_minimum_element_in
public class SecondMinimumTournament {

	public static int getSecondMinimumNonOptimized(int[] values) {
		int min = -1, secondMin = -1;
		int firstValue = values[0];
		int secondValue = values[1];
		if (firstValue < secondValue) {
			min = firstValue;
			secondMin = secondValue;
		} else {
			min = secondValue;
			secondMin = firstValue;
		}
		int nextElement = -1;
		for (int i = 2; i < values.length; i++) {
			nextElement = values[i];
			if (nextElement < min) {
				secondMin = min;
				min = nextElement;
			} else if (nextElement < secondMin) {
				secondMin = nextElement;
			}
		}
		return secondMin;
	}

	/**
	 \* Takes an input array and generated a two-dimensional array whose rows are
	 \* generated by comparing adjacent elements and selecting minimum of two
	 \* elements. Thus the output is inverse triangle (root at bottom)
	 \* 
	 \* @param values
	 \* @return
	 \*/
	public static int[][] getOutputTree(int[] values) {
		Integer size = new Integer(values.length);
		double treeDepth = Math.log(size.doubleValue()) / Math.log(2);
		int intTreeDepth = getIntValue(Math.ceil(treeDepth)) + 1;
		int[][] outputTree = new int[intTreeDepth][];

		// first row is the input
		outputTree[0] = values;
		printRow(outputTree[0]);

		int[] currentRow = values;
		int[] nextRow = null;
		for (int i = 1; i < intTreeDepth; i++) {
			nextRow = getNextRow(currentRow);
			outputTree[i] = nextRow;
			currentRow = nextRow;
			printRow(outputTree[i]);
		}
		return outputTree;
	}

	/**
	 \* Compares adjacent elements (starting from index 0), and construct a new
	 \* array with elements that are smaller of the adjacent elements.
	 \* 
	 \* For even sized input, the resulting array is half the size, for odd size
	 \* array, it is half + 1.
	 \* 
	 \* @param values
	 \* @return
	 \*/
	private static int[] getNextRow(int[] values) {
		int rowSize = getNextRowSize(values);
		int[] row = new int[rowSize];
		int i = 0;
		for (int j = 0; j < values.length; j++) {
			if (j == (values.length - 1)) {
				// this is the case where there are odd number of elements
				// in the array. Hence the last loop will have only one element.
				row[i++] = values[j];
			} else {
				row[i++] = getMin(values[j], values[++j]);
			}
		}
		return row;
	}

	/**
	 \* The logic for finding second minimum is as follows:
	 \* 
	 \* Starting from root element (which is minimum element), find the lower of
	 \* two adjacent element one row above. One of the two element must be root
	 \* element. If the root element is left adjacent, the root index (for one
	 \* row above) is two times the root index of any row. For right-adjacent, it
	 \* is two times plus one. Select the other element (of two adjacent
	 \* elements) as second minimum.
	 \* 
	 \* Then move to one row further up and find elements adjacent to lowest
	 \* element, again, one of the element must be root element (again, depending
	 \* upon the fact that it is left or right adjacent, you can derive the root
	 \* index for this row). Compare the other element with the second least
	 \* selected in previous step, select the lower of the two and update the
	 \* second lowest with this value.
	 \* 
	 \* Continue this till you exhaust all the rows of the tree.
	 \* 
	 \* @param values
	 \* @return
	 \*/
	public static int getSecondMinimum(int[][] tree, int rootElement) {
		int adjacentleft = -1, adjacentRight = -1;
		int secondLeast = Integer.MAX_VALUE;
		int rootIndex = 0;
		int[] rowAbove = null;
		// we have to scan in reverse order
		for (int i = tree.length - 1; i > 0; i--) {
			// one row above
			rowAbove = tree[i - 1];
			adjacentleft = rowAbove[rootIndex * 2];

			// the root element could be the last element carried from row above
			// because of odd number of elements in array, you need to do
			// following
			// check. if you don't, this case will blow {8, 4, 5, 6, 1, 2}
			if (rowAbove.length >= ((rootIndex * 2 + 1) + 1)) {
				adjacentRight = rowAbove[rootIndex * 2 + 1];
			} else {
				adjacentRight = -1;
			}

			// if there is no right adjacent value, then adjacent left must be
			// root
			// continue the loop.
			if (adjacentRight == -1) {
				// just checking for error condition
				if (adjacentleft != rootElement) {
					throw new RuntimeException("This is error condition. Since there "
							+ " is only one adjacent element (last element), " 
							+ " it must be root element");
				} else {
					rootIndex = rootIndex * 2;
					continue;
				}
			}

			// one of the adjacent number must be root (min value).
			// Get the other number and compared with second min so far
			if (adjacentleft == rootElement && adjacentRight != rootElement) {
				secondLeast = getMin(secondLeast, adjacentRight);
				rootIndex = rootIndex * 2;
			} else if (adjacentleft != rootElement && adjacentRight == rootElement) {
				secondLeast = getMin(secondLeast, adjacentleft);
				rootIndex = rootIndex * 2 + 1;
			} else {
				throw new RuntimeException("This is error condition. One of the adjacent "
						+ "elements must be root element");
			}
		}

		return secondLeast;
	}

	/**
	 \* Returns minimum of two passed in values.
	 \* 
	 \* @param num1
	 \* @param num2
	 \* @return
	 \*/
	private static int getMin(int num1, int num2) {
		return Math.min(num1, num2);
	}

	/**
	 \* following uses Math.ceil(double) to round to upper integer value..since
	 \* this function takes double value, diving an int by double results in
	 \* double.
	 \* 
	 \* Another way of achieving this is for number x divided by n would be -
	 \* (x+n-1)/n
	 \* 
	 \* @param values
	 \* @return
	 \*/
	private static int getNextRowSize(int[] values) {
		double size = Math.ceil(values.length / 2.0);
		return getIntValue(size);
	}

	private static int getIntValue(double value) {
		return new Double(value).intValue();
	}

	/**
	 \* Returns the root element of the two-dimensional array.
	 \* 
	 \* @param tree
	 \* @return
	 \*/
	public static int getRootElement(int[][] tree) {
		int depth = tree.length;
		return tree[depth - 1][0];
	}

	private static void printRow(int[] values) {
		for (int i : values) {
			 System.out.print(i + " ");
		}
		 System.out.println(" ");
	}

	public static void main(String args[]) {
		int[] values = { 2, 4, 5, 3, 1, 8, 7, 10 };
		// Get Second Minimum (Non-Optimized)
		/*System.out.println("Second Minimum (using unoptimized algorithm): " 
				+ getSecondMinimumNonOptimized(values));
*/
		// Get Tree and obtain the Minimum Element in the array
		int[][] outputTree = getOutputTree(values);
		int min = getRootElement(outputTree);

		// Get Second Minimum (Optimized)
		System.out.println("Second Minimum (Using optimized algorithm): " 
				+ getSecondMinimum(outputTree, min));
	}
}