package com.example.demo.dao;
import java.util.List;
import com.example.demo.entity.NbEmpParSexe;
import com.example.demo.entity.StaPrmCivilite;

public interface IEmpDivDao {

	List<StaPrmCivilite>   getAllCivilites();
	List<NbEmpParSexe> nbEmpParSexO();

	
}
