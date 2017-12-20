package com.io;


public class ClassTest<T> {
	
	private T a ;
	
	
	public ClassTest(T a){
		this.a = a ;
	}


	public T getA() {
		return a;
	}


	public void setA(T a) {
		this.a = a;
	}

	public static void main(String[] args) {
		ClassTest<Integer> test = new ClassTest<Integer>(100) ;
		
		//test.setA(2);
		
		
		System.out.println(test.getA());
	}
	
}
