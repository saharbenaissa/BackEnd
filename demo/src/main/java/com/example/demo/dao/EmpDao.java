package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.NbEmp;

@Transactional
@Repository
public class EmpDao implements IEmpDao {
	@PersistenceContext	
	private EntityManager entityManager;
	

	@Override
	public NbEmp nbEmp() {
		 BigDecimal result = (BigDecimal) entityManager.createNativeQuery("select count(*) from sta_grh_employes where EMPY_TYPEMP=1").getSingleResult();
		 System.out.println("NbEmp :" +result.intValue());
					
		return  new NbEmp(result.intValue());
	}

public static void main(String args[]){
	EmpDao n= new EmpDao();}

}