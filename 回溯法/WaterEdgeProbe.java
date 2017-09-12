/**
 * 
 */
package org.feng.demo;

/**
 * ��һ����ά����ƽ��ģ���У�̽��ĳһ���Ƿ���һ��������ˮ�������߽��·�� ���õݹ���ݵķ���
 * 
 * @author Administrator 2017��9��8�� ����12:32:29
 */
public class WaterEdgeProbe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] roadModel = { 
				{ 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 6, 4, 0, 0 }, 
				{ 0, 6, 5, 6, 0, 0 }, 
				{ 0, 6, 5, 4, 5, 0 },
				{ 0, 0, 6, 5, 1, 0 }, 
				{ 0, 0, 0, 0, 0, 0 } 
			};
		int x = 2, y = 2;
		boolean res = hasPath2Edge(roadModel, x, y);
		System.out.println(res);
	}

	/**
	 * @param roadModel
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean hasPath2Edge(int[][] roadModel, int x, int y) {
		// ���˲���������
		if (roadModel == null || x >= roadModel.length || x < 0 || y >= roadModel[0].length || y < 0) {
			return false;
		}
		// ���ʱ�־λ������̽����һ��ʱ������ظ�֮ǰ��·������̬��ʼ��Ĭ����false��
		boolean[][] visited = new boolean[roadModel.length][roadModel[0].length];
		return hasPathCore(roadModel, x, y, visited);
	}

	/**
	 * @param roadModel
	 * @param x
	 * @param y
	 * @param visited
	 * @return
	 */
	private static boolean hasPathCore(int[][] road, int x, int y, boolean[][] visited) {
		// �����ǰ̽�⵽�߽���Χtrue
		if (x == 0 || x == road.length - 1 || y == 0 || y == road[0].length - 1) {
			return true;
		}
		// ���ֵ�ǰ�ڵ��Ѿ��ڵ�ǰ̽��·�������̽�ⷽ�򲻿��У�����false
		if (visited[x][y] == true) {
			return false;
		}
		// ֻ��ִ��̽����һ��ʱ�򣬵�ǰλ�ò���Ҫ����ѷ��ʱ�־
		visited[x][y] = true;
		boolean left = false, up = false, right = false, down = false;
		// ̽�����
		if (road[x][y - 1] <= road[x][y]) {
			left = hasPathCore(road, x, y - 1, visited);
		}
		// ̽���ϱ�
		if (road[x - 1][y] <= road[x][y]) {
			up = hasPathCore(road, x - 1, y, visited);
		}
		// ̽���ұ�
		if (road[x][y + 1] <= road[x][y]) {
			right = hasPathCore(road, x, y + 1, visited);
		}
		// ̽���±�
		if (road[x + 1][y] <= road[x][y]) {
			down = hasPathCore(road, x + 1, y, visited);
		}
		// ̽����� �ָ���ǰδ����״̬
		visited[x][y] = false;
		// ֻҪ��һ������̽�⵽�߽�ɹ��ͱ������ڵ���߽��·��
		if (left || up || right || down) {
			return true;
		}
		return false;
	}

}
