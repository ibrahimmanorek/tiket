CREATE DATABASE tiket
USE tiket

CREATE TABLE employees  (
  EmployeeId int(11) NOT NULL AUTO_INCREMENT,
  FirstName varchar(50) NULL,
  LastName varchar(50) NULL,
  Title varchar(30) NULL,
  WorkPhone varchar(30) NULL,
  PRIMARY KEY (EmployeeId)
);

CREATE TABLE customers  (
  CustomerId int(11) NOT NULL AUTO_INCREMENT,
  CompanyName varchar(50) NULL,
  FirstName varchar(30) NULL,
  LastName varchar(50) NULL,
  BillingAddress varchar(255) NULL,
  City varchar(50) NULL,
  StateOrProvince varchar(20) NULL,
  ZipCode varchar(20) NULL,
  Email varchar(75) NULL,
  CompanyWebsite varchar(200) NULL,
  PhoneNumber varchar(30) NULL,
  FaxNumber varchar(30) NULL,
  ShipAddress varchar(255) NULL,
  ShipCity varchar(50) NULL,
  ShipStateOrProvince varchar(50) NULL,
  ShipZIPCode varchar(29) NULL,
  ShipPhoneNumber varchar(30) NULL,
  PRIMARY KEY (CustomerId)
);

CREATE TABLE shipping_methods  (
  ShippingMethodId int(11) NULL AUTO_INCREMENT,
  ShippingMethode varchar(20) NULL,
  PRIMARY KEY (ShippingMethodId)
);

CREATE TABLE products  (
  ProductId int(11) NOT NULL AUTO_INCREMENT,
  ProductName varchar(50) NULL,
  UnitPrice int(11) NULL,
  InStock char(1) NULL,
  PRIMARY KEY (ProductId)
);

CREATE TABLE order_details  (
  OrderDetailId int(11) NOT NULL AUTO_INCREMENT,
  OrderId int(11) NULL,
  ProductId int(11) NULL,
  Quantity int(11) NULL,
  UnitPrice int(11) NULL,
  Discount int(11) NULL,
  PRIMARY KEY (OrderDetailId)
);

CREATE TABLE orders  (
  OrderId int(11) NOT NULL AUTO_INCREMENT,
  CustomerId int(11) NULL,
  EmployeeId int(11) NULL,
  OrderDate datetime(0) NULL,
  PurchaseOrderNumber varchar(30) NULL,
  ShipDate datetime(0) NULL,
  ShippingMethodId int(11) NULL,
  FreightCharge int(11) NULL,
  Taxes int(11) NULL,
  PaymentReceived char(1) NULL,
  Comment varchar(150) NULL,
  PRIMARY KEY (OrderId)
);

#Daftar pelanggan yang beralamat di kota Irvine
select * from customers where city = 'irvine'

#Daftar semua pelanggan yang pesanannya ditangani karyawan bernama Adam Barr
select cs.* from customers cs
left join orders o
ON cs.customer_id = o.customer_id
left join employees emp
on emp.employee_id = o.employee_id
where emp.first_name = 'Adam'
and emp.last_name = 'Barr'

#Daftar produk yang dipesan oleh pelanggan Contoso, Ltd
select p.* from customers cs
left join orders o
on cs.customer_id = o.customer_id
left join order_details od
on o.order_id = od.order_id
left join products p
on p.product_id = od.product_id
where cs.company_name = 'Contoso, Ltd'

#Daftar transaksi pemesanan yang dikirimkan melalui UPS Ground
select p.product_name, od.quantity, od.unit_price, o.freight_charge, o.taxes, sm.shipping_methode 
from shipping_methods sm
join orders o 
on o.shipping_method_id = sm.shipping_method_id
join order_details od
on od.order_id = o.order_id
join products p
on p.product_id = od.product_id
where sm.shipping_methode = 'UPS Ground'

#Daftar biaya total pemesanan (termasuk pajak dan biaya pengiriman) setiap
#transaksi diurut berdasarkan tanggal transaksi
select p.product_name, o.purchase_order_number, o.order_date, o.taxes, o.freight_charge, od.quantity, od.unit_price, od.discount,
(od.quantity * od.unit_price - (od.quantity * od.unit_price * (od.discount/100))) as total
from orders o
join order_details od
on od.order_id = o.order_id
join products p
on od.product_id = p.product_id
order by order_date asc