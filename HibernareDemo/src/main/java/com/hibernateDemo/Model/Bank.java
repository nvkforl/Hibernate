package com.hibernateDemo.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BANK")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BANK_ID")
	private Long bankId;

	@Column(name = "NAME")
	private String name;

	@Embedded
	private Address address = new Address();

	@Column(name = "IS_INTERNATIONAL")
	private boolean international;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name = "BANK_CONTACT", joinColumns = @JoinColumn(name =
	 * "BANK_ID"))
	 * 
	 * @Column(name = "NAME") private List<String> contacts = new ArrayList<>();
	 */
	
	@ElementCollection
	@CollectionTable(name = "BANK_CONTACT", joinColumns = @JoinColumn(name = "BANK_ID"))
	@MapKeyColumn(name = "POSITION_TYPE") // Key
	@Column(name = "NAME") //Value
	private Map<String,String> contacts = new HashMap<String,String>();

	public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return address.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.address.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return address.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.address.addressLine2 = addressLine2;
	}

	public String getCity() {
		return address.city;
	}

	public void setCity(String city) {
		this.address.city = city;
	}

	public String getState() {
		return address.state;
	}

	public void setState(String state) {
		this.address.state = state;
	}

	public String getZipCode() {
		return address.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.address.zipCode = zipCode;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Map<String, String> getContacts() {
		return contacts;
	}

	public void setContacts(Map<String, String> contacts) {
		this.contacts = contacts;
	}

	/*
	 * public List<String> getContacts() { return contacts; }
	 * 
	 * public void setContacts(List<String> contacts) { this.contacts = contacts; }
	 */
	
	
	

}
