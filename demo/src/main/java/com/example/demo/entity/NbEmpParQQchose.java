package com.example.demo.entity;

public class NbEmpParQQchose {

	String label;
	int count;
	public NbEmpParQQchose(String s , int c){
		label=s;
		count=c;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "NbEmpParQQchose [Label=" + label + ", count=" + count + "]";
	}
	
	
}