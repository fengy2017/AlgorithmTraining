/**
 * 
 */
package org.feng.demo;

/**
 * �ݹ��˼·ʵ���ַ������ȫ�����������
 * 
 * @author Administrator 2017��8��30�� ����9:06:20
 */
public class AllPermutationTest {

	public static final synchronized void main(String[] args) {
		char[] seqs = new char[] { 'A', 'B', 'C', 'D' };
		printAllPermutation(seqs, 0, seqs.length - 1);
	}

	/**
	 * @param seqs
	 * @param to
	 * @param from
	 */
	private static void printAllPermutation(char[] seqs, int from, int to) {
		// �����ǰ�ݹ���̷���ֻʣ��һ��Ԫ��ʱ��ζ��һ�������Ѿ�����
		if (from == to) {
			for (char ch : seqs) {
				System.out.print(ch + "\t");
			}
			System.out.println();
		} else {
			for (int i = from; i <= to; i++) {
				// ��fromλ�õ�Ԫ������ȡ�鵱ǰ����[from, to]������ѡ�ģ�����Ե�ȫ����˼������
				swap(seqs, from, i);
				printAllPermutation(seqs, from + 1, to);
				swap(seqs, from, i);// ����ԭʼ״̬
			}
		}
	}

	/**
	 * @param seqs
	 * @param from
	 * @param to
	 */
	private static void swap(char[] seqs, int from, int to) {
		// TODO Auto-generated method stub
		char temp = seqs[from];
		seqs[from] = seqs[to];
		seqs[to] = temp;
	}

}
