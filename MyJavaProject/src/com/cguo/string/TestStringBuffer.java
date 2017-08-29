package com.cguo.string;

/**
 * @author GuoCheng
 * StringBuffer
 * 线程同步的
 * 
 * StringBuilder 线程不安全的 单线程用StringBuilder，效率高
 */
public class TestStringBuffer {
	public static void main(String[] args) {
		TestStringBuffer.add();
		TestStringBuffer.delete();
	}
	
	//存储
	public static void add() {
		StringBuffer sb = new StringBuffer();
		sb.append("abc").append(123).append(true);
		System.out.println(sb.toString());
		sb.insert(1, "mm");
		System.out.println(sb.toString());
	}
	
	//删除
	public static void delete() {
		StringBuffer sb = new StringBuffer("abcde");
		sb.delete(1, 3);
		System.out.println(sb.toString());
	}
}
