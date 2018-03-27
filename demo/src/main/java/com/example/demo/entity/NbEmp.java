package com.example.demo.entity;

public class NbEmp {

	int count;

	public NbEmp(int c){
		count=c;
		
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	@Override
	public String toString() {
		return "NbEmp [count=" + count +"]";
	}
	
	
	
	
	
	
	
}
