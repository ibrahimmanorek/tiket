package com.ibrahim.tiket.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the shipping_methods database table.
 * 
 */
@Entity
@Table(name="shipping_methods")
@NamedQuery(name="ShippingMethod.findAll", query="SELECT s FROM ShippingMethod s")
public class ShippingMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int shippingMethodId;

	@Column(length=20)
	private String shippingMethode;

	public ShippingMethod() {
	}

	public int getShippingMethodId() {
		return this.shippingMethodId;
	}

	public void setShippingMethodId(int shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public String getShippingMethode() {
		return this.shippingMethode;
	}

	public void setShippingMethode(String shippingMethode) {
		this.shippingMethode = shippingMethode;
	}

}