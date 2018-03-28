package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.NbEmp;
import com.example.demo.entity.NbEmpParQQchose;
import com.example.demo.entity.NbEmpParSexe;
import com.example.demo.entity.StaPrmCivilite;
@Transactional
@Repository
public class EmpDivDao implements IEmpDivDao{

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public List<NbEmpParQQchose> nbEmpParQQChose(String query) {
		List<Object[]> results = entityManager.createNativeQuery(query).getResultList();
		List<NbEmpParQQchose> l= new ArrayList<NbEmpParQQchose>();
		NbEmpParQQchose e;
		
		String label=null; int count;
		for (Object[] result : results) {
			if(result[0]!=null){
				label=result[0].toString();
			}else label="undefined";
		    count = ((Number) result[1]).intValue();
		    e= new NbEmpParQQchose(label, count);
		    l.add(e);
		}   return l;
		
	}

	//String hql = "select C.CVLT_DES_LN1, count(E.EMPY_UID) as nb FROM Employe E, Civilite C where C.CVLT_UID=ECVLT_UID group by sexe ";
	//return (List<Object[]>) entityManager.createQuery(hql).getResultList();
	
	@Override
	public NbEmp nbEmp() {
		 BigDecimal result = (BigDecimal) entityManager.createNativeQuery("select count(*) from sta_grh_employes where EMPY_TYPEMP=1").getSingleResult();
		 System.out.println("NbEmp :" +result.intValue());
					
		return  new NbEmp(result.intValue());
	}
	
	
	
	
	@Override
	public List<NbEmpParSexe> nbEmpParSexO() {
		System.out.println("Hallo1");
		List<Object[]> results = entityManager.createNativeQuery("select EMPY_GNR, count(*) from sta_grh_employes group by EMPY_GNR").getResultList();
		System.out.println("Hallo2");
		int genre; int count ;
		List<NbEmpParSexe> l= new ArrayList<NbEmpParSexe>();
		NbEmpParSexe e;
		for (Object[] result : results) {
			System.out.println("Hallo3");
			if(result[0]!=null)
				 genre = ((Number) result[0]).intValue();
				else genre=100;
				System.out.println("genre :"+genre);
			    count = ((Number) result[1]).intValue();
			e= new NbEmpParSexe(genre, count);
		    System.out.println("NbEmpParSexe :"+e.toString());
		    l.add(e);
		}
		return l;
	}

	public static void main(String args[]){
		EmpDivDao n= new EmpDivDao();

	}
	
	
	
	
	
}
