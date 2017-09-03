/**
 * 
 */
package org.feng.demo.sort;

/**
 * �鲢���򣨵ݹ�ʵ�֣�
 * 
 * @author Administrator 2017��8��31�� ����7:02:21
 */
public class MergeSortTest {

	/**
	 * ��ӡһ��int����
	 * 
	 * @param a
	 */
	public static void printArray(int[] a) {
		if (a != null) {
			for (int num : a) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 3, 1, 0, 3, 9, 11, 10 };
		printArray(nums);
		MergeSort(nums, 0, nums.length - 1);
		printArray(nums);
	}

	/**
	 * @param nums
	 * @param i
	 * @param j
	 */
	private static void MergeSort(int[] nums, int start, int end) {
		// ���ٹ�ģΪ���������ܽ��й鲢�ݹ����
		if (start < end) {
			int middle = (start + end) / 2;
			MergeSort(nums, start, middle);
			MergeSort(nums, middle + 1, end);
			merge(nums, start, middle, end);
		}
	}

	/**
	 * ��һ�����������а���middle�����������������е�����������鲢
	 * 
	 * @param nums
	 * @param start
	 * @param middle
	 * @param end
	 */
	private static void merge(int[] nums, int start, int middle, int end) {
		// ��������ĺϲ��������Ҫ�����ռ䣬����O(n)�Ŀռ临�Ӷ�
		int[] a1 = new int[middle - start + 1];
		int[] a2 = new int[end - middle];
		for (int i = 0, k = start; i < a1.length; i++, k++) {
			a1[i] = nums[k];
		}
		for (int i = 0, k = middle + 1; i < a2.length; i++, k++) {
			a2[i] = nums[k];
		}
		// ģ��ϲ������˼·
		int p1 = 0, p2 = 0, p3 = start;// ���������ָ��
		while (p1 < a1.length && p2 < a2.length) {			
			if (a1[p1] <= a2[p2]) {
				nums[p3++] = a1[p1++];
			} else {
				nums[p3++] = a2[p2++];
			}
		}
		// ����ʣ������
		if (p1 == a1.length) {
			for (int i = p2; i < a2.length; i++) {
				nums[p3++] = a2[i];
			}
		} else {
			for (int i = p1; i < a1.length; i++) {
				nums[p3++] = a1[i];
			}
		}
	}
	
}
