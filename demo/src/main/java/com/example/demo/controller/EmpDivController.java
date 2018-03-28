package com.example.demo.controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IEmpDivDao;
import com.example.demo.entity.NbEmp;
import com.example.demo.entity.NbEmpParQQchose;
import com.example.demo.entity.NbEmpParSexe;
import com.example.demo.entity.StaPrmCivilite;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("EmpDiv")
public class EmpDivController {
	@Autowired
	private IEmpDivDao empdivdao;
	
	@GetMapping("nbEmpParQQChose")
	public ResponseEntity<List<NbEmpParQQchose>> nbEmpParQQChose(@RequestParam("label") String label) {
		String query=null;
		
		switch (label){
		case "categorie": query="select c.CTGR_DES_LN1, count(*) from sta_grh_employes e, STA_GRH_CATEGORIES c where empy_typemp=1 and e.CTGR_UID =c.CTGR_UID group by c.CTGR_DES_LN1";
						  break;
		case "structure": query="select s.STRC_DES_LN1, count(*) from sta_grh_employes e,STA_PRM_STRUCTURES s where empy_typemp=1 and e.STRC_UID =s.STRC_UID group by  s.STRC_DES_LN1 ";
		break;	
		}
		
		List<NbEmpParQQchose> list = empdivdao.nbEmpParQQChose(query);
		return new ResponseEntity<List<NbEmpParQQchose>>(list, HttpStatus.OK);
		
		}
	@GetMapping("nbEmpParSexO")
	public ResponseEntity<List<NbEmpParSexe>> nbEmpParSexO() {
		List<NbEmpParSexe> list = empdivdao.nbEmpParSexO();
		return new ResponseEntity<List<NbEmpParSexe>>(list, HttpStatus.OK);
	}
	
	@GetMapping("nbEmp")
	public ResponseEntity<NbEmp> nbEmp() {
		NbEmp NbEmp = empdivdao.nbEmp();
		return new ResponseEntity<NbEmp>(NbEmp, HttpStatus.OK);
	}
	
}
