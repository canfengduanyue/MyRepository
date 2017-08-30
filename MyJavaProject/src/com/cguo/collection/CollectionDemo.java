package com.cguo.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo {
	public static void main(String[] args) {
		method_get();
		
	}
	
	public static void method_get() {
		ArrayList<String> a = new ArrayList<String>();
		//增加
		a.add("java01");
		a.add("java02");
		a.add("java03");
		
		Iterator<String> it = a.iterator();	//获取迭代器
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		

		//相比第一种写法，对内存的消耗较少，for循环结束，内存就回收了迭代器对象
		for(Iterator<String> it1 = a.iterator(); it1.hasNext();) {
			System.out.println(it1.next());
		}
		
		System.out.println("over");
	}
	
	public static void base_method() {
		ArrayList<String> a = new ArrayList<String>();
		//增加
		a.add("java01");
		a.add("java02");
		a.add("java03");
		System.out.println(a.size());
		
		//判断元素
		System.out.println(a.contains("java02"));
		
		//删除		
		a.remove("java02");
		System.out.println(a);
		a.clear();
		
		
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("01");
		a1.add("02");
		a1.add("03");
		a1.add("04");
		
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("04");
		a2.add("05");
		a2.add("06");
		a2.add("07");
		
		a1.retainAll(a2);
		System.out.println("a1:::::::"+a1);
		System.out.println("a2:::::::"+a2);
	}
}
