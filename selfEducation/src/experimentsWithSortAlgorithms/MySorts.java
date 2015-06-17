package experimentsWithSortAlgorithms;

public class MySorts{
	public int[] insertionSort(int[] data){
		if (data.length < 2) {
			return data;
		}
		
		for (int outerIterator = 1; outerIterator <= data.length-1; outerIterator++) {
			for (int innerIterator = outerIterator-1; innerIterator >= 0; innerIterator--) {
				if (data[innerIterator+1] > data[innerIterator]) {
					change(data, innerIterator, innerIterator+1);
				}
			}
		}
		
		return data;
		
	}
	
	public int[] bubbleSort(int[] data){
	
		for (int outerIterator = 0; outerIterator < data.length; outerIterator++) {
			for (int innerIterator = 0; innerIterator < data.length-1; innerIterator++) {
				if (data[innerIterator]<data[innerIterator+1]) {
					change(data, innerIterator, innerIterator+1);
				}
			}
		}
		
		return data;
	}

	public int[] selectionSort(int[] data){
		int indexOfLesser = 0;
		
		for (int outerIterator = 0; outerIterator < data.length; outerIterator++) {
			indexOfLesser=outerIterator;
			for (int innerIterator = outerIterator; innerIterator < data.length; innerIterator++) {
				if (data[indexOfLesser]>data[innerIterator]) {
					indexOfLesser=innerIterator;
				}
			}
			change(data, outerIterator, indexOfLesser);			
		}
		return data;
	}

	public int[] quickSort(int[] data){
		
		if (data.length == 1) {
			return data;
		}
		else if (data.length == 2) {
			if (data[0]<data[1]) {
				return data;
			}
			else
			{
				change(data, 1, 0);
				return data;
			}
		
		}
		else if (data.length > 2) {
			int posOfAverageValue = findAverage(data);
			
			int tmpFirstHalfOfData[] = new int[data.length];
			int tmpSecondHalfOfData[] = new int[data.length];
			int firstIterator = 0, secondIterator = 0;
			for (int outerIterator = 0; outerIterator < data.length; outerIterator++) {
				if (data[outerIterator] <= data[posOfAverageValue]) {
					tmpFirstHalfOfData[firstIterator++] = data[outerIterator];
				}
				else
				{
					tmpSecondHalfOfData[secondIterator++] = data[outerIterator];
				}
			}
			
			int firstHalfOfData[] = new int[firstIterator];
			int secondHalfOfData[] = new int[secondIterator];
			for (int i = 0; i < firstHalfOfData.length; i++) {
				firstHalfOfData[i] = tmpFirstHalfOfData[i];				
			}
			for (int i = 0; i < secondHalfOfData.length; i++) {
				secondHalfOfData[i] = tmpSecondHalfOfData[i];				
			}
			
//			System.arraycopy(data, 0, firstHalfOfData, 0, posOfAverageValue+1);
//			System.arraycopy(data, posOfAverageValue, secondHalfOfData, 0, data.length - posOfAverageValue);
			System.arraycopy(quickSort(firstHalfOfData), 0, data, 0, firstIterator);
			System.arraycopy(quickSort(secondHalfOfData), 0, data,  firstIterator, secondIterator);
		}
		
		
		return data;
	}
	
	private int findAverage(int[] data) {
		int posOfAverageValue = 0;
		int sum=0;
		
		for (int i = 0; i < data.length; i++) {
			sum+=data[i];
		}
		
		int difference = Integer.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			if ((data[i]-(sum/data.length))<difference) {
				difference = data[i]-(sum/data.length);
				posOfAverageValue = i;
			}
		}
		
		return posOfAverageValue;
	}

	private void change(int[] data, int outerIterator, int indexOfLesser) {
		int tmp;
		tmp = data[outerIterator];
		data[outerIterator] = data[indexOfLesser] ; 
		data[indexOfLesser] = tmp;
	}
}
