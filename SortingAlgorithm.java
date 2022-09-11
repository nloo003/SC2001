
public class SortingAlgorithm {
	public static final int S = 10;
	private static long insertionSortComparisons = 0;
	private static long mergeSortComparisons = 0;
	private static long hybridSortComparisons = 0;
	
	
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
 	}
	
	//improvement on mergeSort
	
	public static void insertionSort(int arr[],int m, int n) {
		
		for(int i = m+1; i <= n; i++) {
			for (int j = i; j > m; j--) {
				insertionSortComparisons+=1;
				if (arr[j] < arr[j-1]) swap(arr,j,j-1);
				else break;
			}
		}
	
	    
			
	}
	
	public static void merge(int arr[], int m, int n) {
		if (n-m <= 0) return;
		int mid = (m+n) / 2;
		int a = m, b = mid + 1,i = 0;
		int len = n-m + 1;
		int temp[] = new int[len];
		while (a <= mid && b <= n) {
			//key comparison up by one
			if (arr[a] < arr[b]) {
				temp[i++] = arr[a++];
			}
			else if (arr[b] < arr[a]) {
				temp[i++] = arr[b++];
			}
			else {
				temp[i++] = arr[a++];
				temp[i++] = arr[b++];
			}
			mergeSortComparisons+=1;
		}
		while (a<=mid) {
			temp[i++] = arr[a++];
		}
		while (b<=n) {
			
			temp[i++] = arr[b++];
		}
		for(int j = 0 ; j < len; j++) {
			arr[m+j] = temp[j];
		}
	}
	
	public static void mergeSort(int arr[],int m, int n) {
		int mid = (m+n) / 2;
		if (n-m <= 0) return;
		else if(n-m > 1) {
			mergeSort(arr,m,mid);
			mergeSort(arr,mid+1,n);
		}
		merge(arr,m,n);
	}
	
	/*
	def hybrid_sort(start,end):
	    mid = math.trunc((start+end)/2)
	    if((end-start)<=0):
	        return
	    elif(end-start > 1):
	        if(mid-start<=5):
	            insertion_sort(start,mid)
	        else:
	            hybrid_sort(start, mid)

	        if (end - (mid+1) <= 5):
	            insertion_sort(mid+1,end)
	        else:
	            hybrid_sort(mid + 1, end)
	        # mergesort(start, mid)
	        # mergesort(mid + 1, end)
	    merge(start,end)
	*/
	
	public static void hybridSort(int arr[], int m, int n) {
	
		//key comparison up by one here
		int mid = (m+n) /2 ;
		/*
	    if (n-m <= 0) {
	    	return;
	    }
	    */
	    if (n-m > S) {
			//int mid = (m+n) / 2;
			hybridSort(arr,m,mid);
			hybridSort(arr,mid+1,n);
			merge(arr,m,n);
		}
		else {
			insertionSort(arr,m,n);
		}
		
		
	}
	
	public static void resetStatic() {
		mergeSortComparisons = 0;
		insertionSortComparisons=0;
		hybridSortComparisons = 0;
	}
	public static void printMergeSortComparisons() {
		
		System.out.println("\nMerge Sort Comparisons: " + mergeSortComparisons);
	}
	
	public static void printInsertionSortComparisons() {
		System.out.println("\nInsertion Sort Comparisons:" + insertionSortComparisons);
	}
	
	public static void printHybridSortComparisons() {
		hybridSortComparisons = mergeSortComparisons + insertionSortComparisons;
		System.out.println("\nHybrid Sort Comparisons: "+ hybridSortComparisons);
	}
}
