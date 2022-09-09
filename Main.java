import java.lang.Math;
public class Main {
	
	public static void main(String args[]) {
		int maxLen = 10000000;
		int arr1[] = new int[maxLen];
		int arr2[] = new int[maxLen];
		//int arr3[] = new int[maxLen];
		int ranNum = 0;
		
		for(int i = 0; i < maxLen; i++) {
			ranNum = (int)(Math.random() * maxLen);
			arr1[i] = ranNum;
			arr2[i] = ranNum;

		}
		
		SortingAlgorithm.hybridSort(arr1, 0,arr1.length-1);

		//SortingAlgorithm.printInsertionSortComparisons();
		//SortingAlgorithm.printMergeSortComparisons();
		
		//hybridSortComparisons = mergeSortComparisons + InsertionSortComparisons
		SortingAlgorithm.printHybridSortComparisons();
		
		SortingAlgorithm.resetStatic();
		
		SortingAlgorithm.mergeSort(arr2, 0,arr2.length-1);
		SortingAlgorithm.printMergeSortComparisons();
		

	}
	
	public static void printArr(int arr[], int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
}
