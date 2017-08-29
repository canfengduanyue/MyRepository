package com.cguo.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


/*
Collection
	|--List��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ����ϵԪ��������
		|--ArrayList���ײ�����ݽṹ������ṹ���ص㣺��ѯ�ٶȿ죬������ɾ����   �̲߳�ͬ��
		|--LinkedList���ײ�����ݽṹ������ṹ�ģ��ص㣺��ѯ�ٶ�������ɾ�ܿ�
		|--Vector���ײ�����ݽṹ������ṹ   �߳�ͬ��
	|--Set��Ԫ��������ģ�Ԫ�ز���������

List:
���з��������ǿ��Բ����Ǳ�ķ������Ǹ���ϵ�����з���

����
	add(index,element);
	addAll(index,collection);
ɾ��
	remove(index);
�ģ�
	set(index,element);
�飺
	get(index);
	subList(from,to);
	listIterator();
	
List�������еĵ�������ListIterator��Iterator���ӽӿ�
�ڵ���ʱ��������ͨ�����϶���ķ������������е�Ԫ�ء�
��Ϊ�ᷢ��ConcurrentModificationException

�ڵ��������У�Ҫ����Ԫ�أ�ֻ���õ������ķ���������Iterator�������ޣ���ʱʹ���ӽӿ�ListIterator
 */
public class ListDemo {
	public static void main(String[] args) {
		//iterator();
		listIterator();
	}
	
	/**
	 * �ӽӿ�ListIterator
	 */
	public static void listIterator() {
		ArrayList<String> a = new ArrayList<String>();
		//����
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
	 * ʹ�õ��������������ϣ������쳣
	 */
	public static void iterator() {
		ArrayList<String> a = new ArrayList<String>();
		//����
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
		//����
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
