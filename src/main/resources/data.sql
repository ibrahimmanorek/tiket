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