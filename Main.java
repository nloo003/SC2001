import java.lang.Math;
import java.util.Scanner;
import java.io.File; //to read the file
import java.io.FileNotFoundException;


public class Main {
	
	public static void main(String args[]) {
		int maxLen = 0;
		//int arr3[] = new int[maxLen];
		int ranNum = 0;
		String filename = "";
		Scanner input = new Scanner(System.in);
		
		while(true) {
			int arr1[] = null;
			int arr2[] = null;
			System.out.println("What data do you want to retrieve?");
			System.out.println("1) Best Case \n2) Average Case \n3) Worst Case");
			int choice = input.nextInt();
			System.out.println("What data size do you want?");
			System.out.println("1) 1000 \n2) 10,000 \n3) 100,000 \n4) 1,000,000 \n5) 10,000,000");
			int size = input.nextInt();
			
			switch(choice) {
				case 1:
					switch(size) {
						case 1:
							filename = "1000BestCase.txt";
							maxLen = 1000;
							break;
						case 2:
							filename = "10000BestCase.txt";
							maxLen = 10000;
							break;
						case 3:
							filename = "100000BestCase.txt";
							maxLen = 100000;
							break;
						case 4:
							filename = "1000000BestCase.txt";
							maxLen = 1000000;
							break;
						case 5:
							filename = "10000000BestCase.txt";
							maxLen = 10000000;
							break;
						default:
							break;
					}
					
					break;
				case 2:
					switch(size) {
						case 1:
							filename = "1000Data.txt";
							maxLen = 1000;
							break;
						case 2:
							filename = "10000Data.txt";
							maxLen = 10000;
							break;
						case 3:
							filename = "100000Data.txt";
							maxLen = 100000;
							break;
						case 4:
							filename = "1000000Data.txt";
							maxLen = 1000000;
							break;
						case 5:
							filename = "10000000Data.txt";
							maxLen = 10000000;
							break;
						default:
							break;
					}
					break;
				case 3:
					switch(size) {
						case 1:
							filename = "1000WorstCase.txt";
							maxLen = 1000;
							break;
						case 2:
							filename = "10000WorstCase.txt";
							maxLen = 10000;
							break;
						case 3:
							filename = "100000WorstCase.txt";
							maxLen = 100000;
							break;
						case 4:
							filename = "1000000WorstCase.txt";
							maxLen = 1000000;
							break;
						case 5:
							filename = "10000000WorstCase.txt";
							maxLen = 10000000;
							break;
						default:
							break;
					}
					break;
				default:
					break;
			}
			arr1 = new int[maxLen];
			arr2 = new int[maxLen];
			Scanner sc = null;
			try {
				sc = new Scanner(new File(filename));//put the file name here
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        int i = 0;
	        int val = 0;
	        while(sc.hasNextInt()){
	        	val = sc.nextInt();
	            arr1[i] = val; // to convert text to array
	            arr2[i++] = val;

	        }

			/*
			for(int i = 0; i < maxLen; i++) {
				ranNum = (int)(Math.random() * maxLen);
				arr1[i] = ranNum;
				arr2[i] = ranNum;

			} */
			
			SortingAlgorithm.hybridSort(arr1, 0,arr1.length-1);

			//SortingAlgorithm.printInsertionSortComparisons();
			//SortingAlgorithm.printMergeSortComparisons();
			
			//hybridSortComparisons = mergeSortComparisons + InsertionSortComparisons
			SortingAlgorithm.printHybridSortComparisons();
			
			SortingAlgorithm.resetStatic();
			
			SortingAlgorithm.mergeSort(arr2, 0,arr2.length-1);
			SortingAlgorithm.printMergeSortComparisons();
			SortingAlgorithm.resetStatic();
			System.out.print("Do you want to quit? (1)Yes (2)No");
			choice = input.nextInt();
			if(choice == 1) {
				return;
			}
			
		}
		

	}
	
	public static void printArr(int arr[], int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
}
