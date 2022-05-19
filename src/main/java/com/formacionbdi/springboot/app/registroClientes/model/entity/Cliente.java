package com.formacionbdi.springboot.app.registroClientes.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date birthday;
	private char bender;
	@Column(name = "cell_phone")
	private Integer cellPhone;
	@Column(name = "home_phone")
	private Integer homePhone;
	@Column(name = "address_home")
	private String addressHome;
	private String profession;
	private Double incomes;
	
	
	public Cliente() {
	}


	public Cliente(Long id, String firstName, String lastName, Date birthday, char bender, Integer cellPhone,
			Integer homePhone, String addressHome, String profession, Double incomes) {
		this.id = id;
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
