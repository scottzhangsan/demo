package com.atguigu.crud.test;

import java.util.ArrayList;
import java.util.List;

public class SubListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>() ;
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		list = list.subList(1, 3) ;
		
		for (Integer integer : list) {
			System.out.println(integer);
		}

		
		System.out.println("1111");
	}

}
