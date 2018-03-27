package com.example.demo.controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IEmpDao;
import com.example.demo.dao.IEmpDivDao;
import com.example.demo.entity.NbEmp;
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
	private IEmpDao empdao;
	@Autowired
	private IEmpDivDao empdivdao;
	
	@GetMapping("all-Civilite")
	public ResponseEntity<List<StaPrmCivilite>> getAllStaPrmCivilite() {
		List<StaPrmCivilite> list = empdivdao.getAllCivilites();
		return new ResponseEntity<List<StaPrmCivilite>>(list, HttpStatus.OK);
	}
	
	@GetMapping("nbEmpParSexO")
	public ResponseEntity<List<NbEmpParSexe>> nbEmpParSexO() {
		List<NbEmpParSexe> list = empdivdao.nbEmpParSexO();
		return new ResponseEntity<List<NbEmpParSexe>>(list, HttpStatus.OK);
	}
	
	@GetMapping("nbEmp")
	public ResponseEntity<NbEmp> nbEmp() {
		NbEmp NbEmp = empdao.nbEmp();
		return new ResponseEntity<NbEmp>(NbEmp, HttpStatus.OK);
	}
	
}
