/**
 * 
 */
package org.feng.demo.sort;

/**
 * ϣ������ѭ����
 * 
 * @author Administrator 2017��9��1�� ����9:59:43
 */
public class ShellSortTest {

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
		int[] nums = { 3, 4, 5, 8, 1, 0, 9, 10, 14, 3, 5, 7, 12};
		printArray(nums);
		shellSort(nums);
		printArray(nums);
	}

	/**
	 * ϣ��������ֱ�Ӳ��������һ�ָĽ��㷨����ֱ�Ӳ�������֮ǰ�Ƚ����˲�ͬ���������е�ֱ�Ӳ�������
	 * ʹ�ò������ӱ�Ϊ1��ʱ��ֱ�ӽ������һ��ֱ�Ӳ��������ʱ������������򣬴Ӷ�����������ֱ�Ӳ������� ��Ч��
	 * 
	 * @param nums
	 */
	private static void shellSort(int[] nums) {
		// TODO Auto-generated method stub
		for (int h = nums.length / 2; h > 0; h = h / 2) {
			// �׿���㲽�������ѭ�����ڲ���ʵ����һ���̶�������ֱ�Ӳ����������
			for (int i = h; i < nums.length; i++) {
				int sentry = nums[i];// ����h����ĳ�������е���Ŧֵ
				if (sentry < nums[i - h]) {
					// ��һ��ѭ�����ڶ���Ŧֵ��λ
					for (int j = i - h; j >= 0; j = j - h) {
						 if (nums[j] > sentry) {
							 nums[j + h] = nums[j];
						 } else {
							 nums[j + h] = sentry;
							 break;
						 }
					}
				}// ֻ����ŦС����ߵ�һ��ֵ����Ҫ��λ
			}
		}
	}

}
