package com.cguo.string;

/**
 * @author GuoCheng
 * StringBuffer
 * �߳�ͬ����
 * 
 * StringBuilder �̲߳���ȫ�� ���߳���StringBuilder��Ч�ʸ�
 */
public class TestStringBuffer {
	public static void main(String[] args) {
		TestStringBuffer.add();
		TestStringBuffer.delete();
	}
	
	//�洢
	public static void add() {
		StringBuffer sb = new StringBuffer();
		sb.append("abc").append(123).append(true);
		System.out.println(sb.toString());
		sb.insert(1, "mm");
		System.out.println(sb.toString());
	}
	
	//ɾ��
	public static void delete() {
		StringBuffer sb = new StringBuffer("abcde");
		sb.delete(1, 3);
		System.out.println(sb.toString());
	}
}
