package com.cguo.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


/*
Collection
	|--List：元素是有序的，元素可以重复，因为该体系元素有索引
		|--ArrayList：底层的数据结构是数组结构，特点：查询速度快，但是增删稍慢   线程不同步
		|--LinkedList：底层的数据结构是链表结构的，特点：查询速度慢，增删很快
		|--Vector：底层的数据结构是数组结构   线程同步
	|--Set：元素是无序的，元素不可以重组

List:
特有方法：凡是可以操作角标的方法都是该体系的特有方法

增：
	add(index,element);
	addAll(index,collection);
删：
	remove(index);
改：
	set(index,element);
查：
	get(index);
	subList(from,to);
	listIterator();
	
List集合特有的迭代器：ListIterator是Iterator的子接口
在迭代时，不可以通过集合对象的方法操作集合中的元素。
因为会发生ConcurrentModificationException

在迭代过程中，要操作元素，只能用迭代器的方法，但是Iterator方法有限，这时使用子接口ListIterator
 */
public class ListDemo {
	public static void main(String[] args) {
		//iterator();
		listIterator();
	}
	
	/**
	 * 子接口ListIterator
	 */
	public static void listIterator() {
		ArrayList<String> a = new ArrayList<String>();
		//增加
		a.add("java01");
		a.add("java02");
		a.add("java03");
		System.out.println(a);
		ListIterator<String> it = a.listIterator();
		while(it.hasNext()) {
			String str = it.next();
			if("java02".equals(str)) {
				it.add("java0009");
			}
		}
		System.out.println(a);
	}
	/**
	 * 使用迭代器，操作集合，会抛异常
	 */
	public static void iterator() {
		ArrayList<String> a = new ArrayList<String>();
		//增加
		a.add("java01");
		a.add("java02");
		a.add("java03");
		
		Iterator<String> it = a.iterator();
		while(it.hasNext()) {
			String str = it.next();
			if("java02".equals(str)) {
				a.add("rrrr");
				//it.remove();
			}
		}
		System.out.println(a);
	}
	
	public static void base_method() {
		ArrayList<String> a = new ArrayList<String>();
		//增加
		a.add("java01");
		a.add("java02");
		a.add("java03");
		
		System.out.println(a);
		
		a.add(1, "java09");
		
		System.out.println(a);
		
		for(int i=0; i<a.size();i++) {
			System.out.println(a.get(i));
		}
		
		Iterator<String> it = a.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		for(Iterator<String> it2 = a.iterator();it2.hasNext();) {
			System.out.println(it2.next());
		}
		
		System.out.println("index"+a.indexOf("java"));
	}
}
