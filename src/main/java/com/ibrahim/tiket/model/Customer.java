package com.ibrahim.tiket.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int customerId;

	@Column(length=255)
	private String billingAddress;

	@Column(length=50)
	private String city;

	@Column(length=50)
	private String companyName;

	@Column(length=200)
	private String companyWebsite;

	@Column(length=75)
	private String email;

	@Column(length=30)
	private String faxNumber;

	@Column(length=30)
	private String firstName;

	@Column(length=50)
	private String lastName;

	@Column(length=30)
	private String phoneNumber;

	@Column(length=255)
	private String shipAddress;

	@Column(length=50)
	private String shipCity;

	@Column(length=30)
	private String shipPhoneNumber;

	@Column(length=50)
	private String shipStateOrProvince;

	@Column(length=29)
	private String shipZIPCode;

	@Column(length=20)
	private String stateOrProvince;

	@Column(length=20)
	private String zipCode;

	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getBillingAddress() {
		return this.billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyWebsite() {
		return this.companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getShipAddress() {
		return this.shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return this.shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipPhoneNumber() {
		return this.shipPhoneNumber;
	}

	public void setShipPhoneNumber(String shipPhoneNumber) {
		this.shipPhoneNumber = shipPhoneNumber;
	}

	public String getShipStateOrProvince() {
		return this.shipStateOrProvince;
	}

	public void setShipStateOrProvince(String shipStateOrProvince) {
		this.shipStateOrProvince = shipStateOrProvince;
	}

	public String getShipZIPCode() {
		return this.shipZIPCode;
	}

	public void setShipZIPCode(String shipZIPCode) {
		this.shipZIPCode = shipZIPCode;
	}

	public String getStateOrProvince() {
		return this.stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}