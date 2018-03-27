package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.NbEmpParSexe;
import com.example.demo.entity.StaPrmCivilite;
@Transactional
@Repository
public class EmpDivDao implements IEmpDivDao{

	@PersistenceContext	
	private EntityManager entityManager;
	
	
	public List<StaPrmCivilite>  getAllCivilites() {
		//String hql = "FROM Article as atcl ORDER BY atcl.articleId DESC";
		//System.out.println(entityManager);
		 List<StaPrmCivilite>results= entityManager.createNamedQuery("StaPrmCivilite.findAll").getResultList();
		for (StaPrmCivilite result : results) {
			System.out.println(result.getCvltCod());
		}
		return results;
	}

	//String hql = "select C.CVLT_DES_LN1, count(E.EMPY_UID) as nb FROM Employe E, Civilite C where C.CVLT_UID=ECVLT_UID group by sexe ";
	//return (List<Object[]>) entityManager.createQuery(hql).getResultList();
	
	
	
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
		//n.nbEmpParSex();
		n.getAllCivilites();
	}
	
	
	
	
	
}
