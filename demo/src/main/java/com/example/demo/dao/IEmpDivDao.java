package com.example.demo.dao;
import java.util.List;

import com.example.demo.entity.NbEmp;
import com.example.demo.entity.NbEmpParQQchose;
import com.example.demo.entity.NbEmpParSexe;
import com.example.demo.entity.StaPrmCivilite;

public interface IEmpDivDao {
	 NbEmp nbEmp();
	List<NbEmpParSexe> nbEmpParSexO();
	List<NbEmpParQQchose> nbEmpParQQChose(String query);
	
}
