package com.ibrahim.tiket.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int orderId;

	@Column(length=150)
	private String comment;

	private int customerId;

	private int employeeId;

	private int freightCharge;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	@Column(length=1)
	private String paymentReceived;

	@Column(length=30)
	private String purchaseOrderNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Date shipDate;

	private int shippingMethodId;

	private int taxes;

	public Order() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getFreightCharge() {
		return this.freightCharge;
	}

	public void setFreightCharge(int freightCharge) {
		this.freightCharge = freightCharge;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentReceived() {
		return this.paymentReceived;
	}

	public void setPaymentReceived(String paymentReceived) {
		this.paymentReceived = paymentReceived;
	}

	public String getPurchaseOrderNumber() {
		return this.purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public Date getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public int getShippingMethodId() {
		return this.shippingMethodId;
	}

	public void setShippingMethodId(int shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public int getTaxes() {
		return this.taxes;
	}

	public void setTaxes(int taxes) {
		this.taxes = taxes;
	}

}