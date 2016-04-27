package com.sort;

/**
 * @author blyang
 * 
 * 常见排序算法的java实现：
 * 
 * 	1、冒泡排序
 *  2、快速排序
 *  3、插入排序
 *  4、直接选择排序
 *  5、希尔排序
 *  6、归并排序
 *  7、堆排序
 */

import java.util.Arrays;

public class Sort {
	/**
	 * 冒泡排序算法
	 */
	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) { // 注意下标
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			System.out.print("第 " + i + 1 + " 次排序： ");
			for (int num : arr) {
				System.out.print(num + "  ");
			}
			System.out.println();

		}
	}

	/**
	 * 快速排序
	 * 
	 * @param args
	 */
	private static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = getMiddle(arr, left, right);
			quickSort(arr, left, middle - 1);
			quickSort(arr, middle + 1, right);
		}
	}

	private static int getMiddle(int[] arr, int left, int right) {
		int temp = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				right--;
			}
			arr[left] = arr[right];

			while (left < right && arr[left] <= temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = temp;
		return left;
	}

	/**
	 * 插入排序
	 */
	private static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			// 从0到j-1是已经排好序的一组数，从j-1开始递减，寻找当前的j(也就是i)应该插入的位置
			for (j = i; j > 0 && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}
	}

	/**
	 * 直接选择排序
	 * 
	 * @param args
	 */
	private static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int flag = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[flag]) {
					flag = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[flag];
			arr[flag] = temp;
		}
	}

	/**
	 * 希尔排序
	 * 
	 * @param arr
	 */
	private static void shellSort(int[] arr) {
		// 第一次的gap
		int gap = arr.length;
		while (true) {
			gap = (int) Math.ceil(gap / 2);
			for (int x = 0; x < gap; x++) {
				for (int i = x + gap; i < arr.length; i += gap) {
					// 对每一组进行直接选择排序
					int j = i - gap;
					int temp = arr[i];
					for (; j >= 0 && temp < arr[j]; j -= gap) {
						arr[j + gap] = arr[j];
					}
					arr[j + gap] = temp;
				}
			}
			if (gap == 1) {
				break;
			}
		}
	}

	/**
	 * 归并排序
	 */
	public static int[] mergeSort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// 左边
			mergeSort(nums, low, mid);
			// 右边
			mergeSort(nums, mid + 1, high);
			// 左右归并
			merge(nums, low, mid, high);
		}
		return nums;
	}

	// 合并
	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1]; // 新申请的空间，用于合并两个有序序列
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = nums[j++];
		}

		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}
	
	
	/**
	 *  堆排序算法
	 */
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		//建立大顶堆
		buildMaxHeap(arr);
		for (int i = arr.length - 1; i >= 1; i--) {
			exchangeElements(arr, 0, i);
			maxHeap(arr, i, 0);
		}
	}
	
	public static void exchangeElements(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			exchangeElements(array, index, largest);
			maxHeap(array, heapSize, largest);
		}
	}

	// 建个大堆
	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}


	// 测试
	public static void main(String[] args) {
		int[] arr = { 7, 6, 5, 4, 3, 2, 1 };

		bubbleSort(arr);
//		insertSort(arr);
//		selectSort(arr);
//		shellSort(arr);
//		heapSort(arr);
//		quickSort(arr, 0, arr.length - 1);
//		mergeSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}
}
