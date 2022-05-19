package com.formacionbdi.springboot.app.registroClientes.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ClienteRequestDto implements Serializable{

	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private char bender;
	private Integer cellPhone;
	private Integer homePhone;
	private String addressHome;
	private String profession;
	private Double incomes;
	
	
	public ClienteRequestDto() {

	}


	public ClienteRequestDto(String firstName, String lastName, Date birthday, char bender, Integer cellPhone,
			Integer homePhone, String addressHome, String profession, Double incomes) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.bender = bender;
		this.cellPhone = cellPhone;
		this.homePhone = homePhone;
		this.addressHome = addressHome;
		this.profession = profession;
		this.incomes = incomes;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public char getBender() {
		return bender;
	}


	public void setBender(char bender) {
		this.bender = bender;
	}


	public Integer getCellPhone() {
		return cellPhone;
	}


	public void setCellPhone(Integer cellPhone) {
		this.cellPhone = cellPhone;
	}


	public Integer getHomePhone() {
		return homePhone;
	}


	public void setHomePhone(Integer homePhone) {
		this.homePhone = homePhone;
	}


	public String getAddressHome() {
		return addressHome;
	}


	public void setAddressHome(String addressHome) {
		this.addressHome = addressHome;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public Double getIncomes() {
		return incomes;
	}


	public void setIncomes(Double incomes) {
		this.incomes = incomes;
	}
	
	
}
