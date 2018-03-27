package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STA_PRM_CIVILITES database table.
 * 
 */
@Entity
@Table(name="STA_PRM_CIVILITES")
@NamedQuery(name="StaPrmCivilite.findAll", query="SELECT s FROM StaPrmCivilite s")
public class StaPrmCivilite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CVLT_UID", unique=true, nullable=false, precision=12)
	private long cvltUid;

	@Column(name="CVLT_COD", nullable=false, length=20)
	private String cvltCod;

	@Column(name="CVLT_DES_LN1", length=100)
	private String cvltDesLn1;

	@Column(name="CVLT_DES_LN2", length=100)
	private String cvltDesLn2;

	@Column(name="CVLT_DES_LN3", length=100)
	private String cvltDesLn3;

	public StaPrmCivilite() {
	}

	public long getCvltUid() {
		return this.cvltUid;
	}

	public void setCvltUid(long cvltUid) {
		this.cvltUid = cvltUid;
	}

	public String getCvltCod() {
		return this.cvltCod;
	}

	public void setCvltCod(String cvltCod) {
		this.cvltCod = cvltCod;
	}

	public String getCvltDesLn1() {
		return this.cvltDesLn1;
	}

	public void setCvltDesLn1(String cvltDesLn1) {
		this.cvltDesLn1 = cvltDesLn1;
	}

	public String getCvltDesLn2() {
		return this.cvltDesLn2;
	}

	public void setCvltDesLn2(String cvltDesLn2) {
		this.cvltDesLn2 = cvltDesLn2;
	}

	public String getCvltDesLn3() {
		return this.cvltDesLn3;
	}

	public void setCvltDesLn3(String cvltDesLn3) {
		this.cvltDesLn3 = cvltDesLn3;
	}

}