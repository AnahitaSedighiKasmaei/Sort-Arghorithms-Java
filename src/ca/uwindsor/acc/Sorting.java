package ca.uwindsor.acc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import algorithmDesign.Sequences;
import sorting.RadixSort;
import sorting.Sort;

public class Sorting {
	private static final int NUM_ITEMS = 100000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//task2aAnd2b();
		// task3aAnd3b(4, false);
		// task3c();
		 String[][] pairArr =task5a();
		 task5b(pairArr);
		task5c();
	}

	public static long mergeSort() {
		Long[] a = new Long[NUM_ITEMS];
		Random rand = new Random();

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = rand.nextLong();

		long start = System.nanoTime();
		Sort.mergeSort(a);
		return System.nanoTime() - start;
	}

	public static long mergeSortStr(int stringLength) {
		String[] a = new String[NUM_ITEMS];

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = createRandomStrOf(stringLength);

		long start = System.nanoTime();
		Sort.mergeSort(a);
		return System.nanoTime() - start;
	}

	public static long quickSort() {
		Long[] a = new Long[NUM_ITEMS];
		Random rand = new Random();

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = rand.nextLong();

		long start = System.nanoTime();
		Sort.quicksort(a);
		return System.nanoTime() - start;
	}

	public static void quickSortStr(int stringLength) {
		String[] a = new String[NUM_ITEMS];

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = createRandomStrOf(stringLength);

		Sort.quicksort(a);
	}

	public static long heapSort() {
		Long[] a = new Long[NUM_ITEMS];
		Random rand = new Random();

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = rand.nextLong();

		long start = System.nanoTime();
		Sort.heapsort(a);
		return System.nanoTime() - start;
	}

	public static long heapSortStr(int stringLength) {
		String[] a = new String[NUM_ITEMS];

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = createRandomStrOf(stringLength);

		long start = System.nanoTime();
		Sort.heapsort(a);
		return System.nanoTime() - start;
	}

	public static long dualPivotSort() {
		Long[] a = new Long[NUM_ITEMS];
		Random rand = new Random();

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = rand.nextLong();

		long start = System.nanoTime();
		Arrays.sort(a);
		return System.nanoTime() - start;
	}

	public static void dualPivotSortStr(int stringLength) {
		String[] a = new String[NUM_ITEMS];

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = createRandomStrOf(stringLength);

		Arrays.sort(a);
	}

	public static void radixSort(int stringLength) {
		String[] a = new String[NUM_ITEMS];

		// Fill array a with random numbers
		for (int i = 0; i < a.length; i++)
			a[i] = createRandomStrOf(stringLength);

		RadixSort.radixSortA(a, 3);
	}

	public static void task3aAnd3b(int randomStringLength, boolean innerRun) {
		// 3.a ----------------
		long start, end, mergeSortTotal = 0, quickSortTotal = 0, heapSortTotal = 0, dualPivotTotal = 0, radixTotal = 0,
				n = 10;

		long worscase1 = 0, worscase2 = 0, worscase3 = 0, worscase4 = 0, worscase5 = 0;

		if (!innerRun) {
			System.out.println("");
			System.out.println("");
			System.out.println("3.a ----------------");
			System.out.println("");
		}
		long tem = 0;
		for (int j = 0; j <= n; j++) {
			start = System.nanoTime();
			mergeSortStr(randomStringLength);
			mergeSortTotal += System.nanoTime() - start;
			tem = System.nanoTime() - start;
			if (worscase1 < tem)
				worscase1 = tem;

		}
		System.out.println("");
		System.out.println("\tMergeSort (Random string array) Worscase Time:\t" + worscase1);
		System.out.println("\tMergeSort (Random string array) Avg-case Time:\t" + (mergeSortTotal / n));

		worscase2 = 0;
		long tem2 = 0;
		for (int j = 0; j <= n; j++) {
			start = System.nanoTime();
			quickSortStr(randomStringLength);
			quickSortTotal += System.nanoTime() - start;

			tem2 = System.nanoTime() - start;
			if (worscase2 < tem2)
				worscase2 = tem2;

		}
		System.out.println("");
		System.out.println("\tQuickSort (Random string array) Worstcase Time:\t" + worscase2);
		System.out.println("\tQuickSort (Random string array) Avg Time:\t" + (quickSortTotal / n));

		worscase3 = 0;
		long tem3 = 0;
		for (int j = 0; j <= n; j++) {
			start = System.nanoTime();
			heapSortStr(randomStringLength);
			heapSortTotal += System.nanoTime() - start;
			tem3 = System.nanoTime() - start;
			if (worscase3 < tem3)
				worscase3 = tem3;
		}
		System.out.println("");
		System.out.println("\tHeapkSort (Random string array) Worstcase Time:\t" + worscase3);
		System.out.println("\tHeapkSort (Random string array) Avg Time:\t" + (heapSortTotal / n));

		worscase4 = 0;
		long temp4 = 0;
		for (int j = 0; j <= n; j++) {
			start = System.nanoTime();
			dualPivotSortStr(randomStringLength);
			dualPivotTotal += System.nanoTime() - start;
			temp4 = System.nanoTime() - start;
			if (worscase4 < temp4)
				worscase4 = temp4;
		}
		System.out.println("");
		System.out.println("\tDualPivotSort (Random string array) Worstcase Time:\t" + worscase4);
		System.out.println("\tDualPivotSort (Random string array) Avg Time:\t" + (dualPivotTotal / n));
		worscase5 = 0;
		long temp5 = 0;
		for (int j = 0; j <= n; j++) {
			start = System.nanoTime();
			radixSort(randomStringLength);
			radixTotal += System.nanoTime() - start;

			temp5 = System.nanoTime() - start;
			if (worscase5 < temp5)
				worscase5 = temp5;
		}
		System.out.println("");
		System.out.println("\tRadixSort (Random string array) Worstcase Time:\t" + worscase5);
		System.out.println("\tRadixSort (Random string array) Avg Time:\t" + (radixTotal / n));

	}

	public static void task3c() {
		System.out.println("3.c ----------------");

		System.out.println("");
		System.out.println("");
		System.out.println("Sort for random string length 6");
		task3aAnd3b(6, true);

		System.out.println("");
		System.out.println("");
		System.out.println("Sort for random string length 8");
		task3aAnd3b(8, true);

		System.out.println("");
		System.out.println("");
		System.out.println("Sort for random string length 10");
		task3aAnd3b(10, true);
	}

	public static void task2aAnd2b() {

		// 2.a ----------------
		long mergeSortTotal = 0, quickSortTotal = 0, heapSortTotal = 0, dualPivotTotal = 0, radixTotal = 0, n = 100;
		System.out.println("");
		System.out.println("");
		System.out.println("2.a ----------------");
		System.out.println("");

		for (int j = 0; j <= n; j++) {
			mergeSortTotal += mergeSort();
		}

		System.out.println("\tMergeSort Avg Time:\t" + (mergeSortTotal / n));

		for (int j = 0; j <= n; j++) {
			quickSortTotal += quickSort();
		}

		System.out.println("\tQuickSort Avg Time:\t" + (quickSortTotal / n));

		for (int j = 0; j <= n; j++) {
			heapSortTotal += heapSort();
		}

		System.out.println("\tHeapkSort Avg Time:\t" + (heapSortTotal / n));

		for (int j = 0; j <= n; j++) {
			dualPivotTotal += dualPivotSort();
		}

		System.out.println("\tDualPivotSort Avg Time:\t" + (dualPivotTotal / n));

	}

	public static String[][] task5a() {
		String[][] arr = new String[1000][2];
		int[] allLength = { 10, 20, 50, 100 };

		for (int i = 0; i < 1000; i++) {
			int index = (int) (allLength.length * Math.random());
			int length = allLength[index];

			arr[i][0] = createRandomStrOf(length);
			arr[i][1] = createRandomStrOf(length);
		}

		return arr;
	}

	public static void task5b(String[][] pairArr) {
		System.out.println("5.b ----------------");

		System.out.println("");
		System.out.println("");

		int n = 1000;
		long start = 0, total = 0;
		String[][] arr = pairArr;
		start = System.nanoTime();
		for (int i = 0; i < n; i++) {
			Sequences.editDistance(arr[i][0], arr[i][1]);
		}

		total = System.nanoTime() - start;

		System.out.println("\tEdit Distance Avg Time:\t" + (total / n));

	}

	public static void task5c() {
		System.out.println("5.c ----------------");

		System.out.println("");
		System.out.println("");

		int[] allLength = { 10, 20, 50, 100 };
		long[][] stats = new long[allLength.length][2]; // Only to store stats

		for (int i = 0; i < 1000; i++) {
			int index = (int) (allLength.length * Math.random());
			int length = allLength[index];

			String word1 = createRandomStrOf(length);
			String word2 = createRandomStrOf(length);

			long start = System.nanoTime();
			Sequences.editDistance(word1, word2);
			
			stats[index][0] += System.nanoTime() - start;	// Total time
			stats[index][1] += 1;							// Total number of items in each length
		}

		for (int j = 0; j < allLength.length; j++) {
			int length = allLength[j];
			long total = stats[j][0];
			long number = stats[j][1];
			System.out.println("\tEdit Distance Avg Time For each length of "+length+":\t" + (total/number));
		}

	}

	private static void checkSort(Long[] a) {
		for (int i = 0; i < a.length - 1; i++)
			if (a[i] > a[i + 1])
				System.out.println("Error at " + i);
		System.out.println("Finished checksort");
	}

	public static String createRandomStrOf(int stringLength) {

		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(stringLength);
		for (int i = 0; i < stringLength; i++) {

			int index = (int) (alphaNumericString.length() * Math.random());

			sb.append(alphaNumericString.charAt(index));
		}
		return sb.toString();
	}

}
