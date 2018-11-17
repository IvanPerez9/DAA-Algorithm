package Quicksort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {

	public static void quickSort(int[] arr, int low, int high){
        if(arr.length <= 0) return;
        if(low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];   
        while (left < right){
            while(left < right && arr[right] >= temp){  
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp){   
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;   
        System.out.println("Sorting: " + Arrays.toString(arr));
        quickSort(arr, low, left-1);
        quickSort(arr, left+1, high);
    }
	
	public static void quickSortByStack(int[] arr){
        if(arr.length <= 0) return;
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        stack.push(arr.length - 1);
        while(!stack.isEmpty()){
            int high = stack.pop();     
            int low = stack.pop();

            int pivotIdx = partition(arr, low, high);

            if(pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if(pivotIdx < high && pivotIdx >= 0){
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
        }
    }
	
	 private static int partition(int[] arr, int low, int high){
	        if(arr.length <= 0) return -1;
	        if(low >= high) return -1;
	        int l = low;
	        int r = high;

	        int pivot = arr[l];    
	        while(l < r){
	            while(l < r && arr[r] >= pivot){  
	                r--;
	            }
	            arr[l] = arr[r];
	            while(l < r && arr[l] <= pivot){   
	                l++;
	            }
	            arr[r] = arr[l];
	        }
	        arr[l] = pivot;   
	        return l;
	    }
}
