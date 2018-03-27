package com.example.demo.entity;


public class NbEmpParSexe {
	int sexe;
	int count;
	public NbEmpParSexe(int s , int c){
		sexe=s;
		count=c;
	}
	public int getSexe() {
		return sexe;
	}
	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "NbEmpParSexe [sexe=" + sexe + ", count=" + count + "]";
	}
	
	
}
