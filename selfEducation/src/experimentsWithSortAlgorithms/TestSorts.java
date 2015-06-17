package experimentsWithSortAlgorithms;

import java.util.Arrays;

public class TestSorts {

	public static void main(String[] args) {
		int[] testData = {100, 20, 10, 15, 20, 40,};
		System.out.println(Arrays.toString(testData));
		MySorts sortClas = new MySorts();
//		System.out.println(Arrays.toString(sortClas.insertionSort(testData)));
//		testData =new int[] {100, 20, 10, 15, 20, 40};
//		System.out.println(Arrays.toString(sortClas.bubbleSort(testData)));
//		testData =new int[] {100, 20, 10, 15, 20, 40};
//		System.out.println(Arrays.toString(sortClas.selectionSort(testData)));
		testData =new int[] {100, 20, 10, 15, 20, 40, 1};
		System.out.println(Arrays.toString(sortClas.quickSort(testData)));
	}

}
