# Tesodev Case

this project is built using spring boot microservice architecture api gateway and config server

 farklı projeleri aynı repo içine aldığım için projeler çalışmıyor lütfen clone yaptıktan sonra tek tek ide ile açın!!!

 first in order run discovery-server and run config server and run anothers

 ##  libraries and other things 

 - postgresql
 - spring boot 
 - lombok
 - spring cloud gateway
 - spring cloud config server
 - spring-netflix-eureka-server and client

 

## Endpoints

### Customer
customer microservice port: 8082
| Endpoint                | Desc                                                     |
|-------------------------|----------------------------------------------------------|
| POST /api/customer/create| Create customer                                   |
| POST /api/customer/update| Update customer                
| GET /api/customer/get-all| Get customers
| GET /api/customer/get-all/uuidv4| Get customers by id 
| GET /api/customer/get/uuidv4| Get customer by id
| DELETE  /api/customer/delete/uuidv4| Delete customer  


### Order
order microservice port: 8081
| Endpoint                | Desc                                                     |
|-------------------------|----------------------------------------------------------|
| POST /api/order/create| Create order|
| PUT /api/order/update| Update order
| GET /api/order/get-all| Get orders
| GET /api/order/get-all/uuidv4| Get orders by id
| GET /api/order/get/uuidv4| get order by id
| DELETE /api/order/delete/uuidv4| Delete order  

### Gateway
Gateway port: 8000
| Endpoint                | Route                                                     |
|-------------------------|----------------------------------------------------------|
| POST/GET/DELETE /api/{customer or order}/{TOP-ENDPOİNT}/{spec}

### 
All requests must be made via the gateway url, so we have isolated our microservices from use.
-for example: http://localhost:8000/api/{order-customer}/{endpoints}
-for example: http://localhost:8000/api/order/delete/10
-for example: http://localhost:8000/api/customer/delete/10


### Create postgresql Database ddl


-- public.address definition

-- Drop table

-- DROP TABLE public.address;

CREATE TABLE public.address (
	address_id smallserial NOT NULL,
	city_code int4 NOT NULL,
	address_line varchar(50) NULL,
	city varchar(20) NOT NULL,
	country varchar NOT NULL,
	CONSTRAINT address_pkey PRIMARY KEY (address_id)
);

-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	product_id serial4 NOT NULL,
	image_url varchar(100) NOT NULL,
	product_name varchar(20) NOT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (product_id)
);

-- public.customer definition

-- Drop table

-- DROP TABLE public.customer;

CREATE TABLE public.customer (
	customer_id serial4 NOT NULL,
	customer_name varchar(50) NOT NULL,
	email varchar(20) NOT NULL,
	address_id int2 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (customer_id),
	CONSTRAINT customer_fk FOREIGN KEY (address_id) REFERENCES public.address(address_id)
);


-- public."ordering" definition

-- Drop table

-- DROP TABLE public."ordering";

CREATE TABLE public."ordering" (
	ordering_id int4 NOT NULL DEFAULT nextval('orders_order_id_seq'::regclass),
	customer_id int4 NOT NULL,
	quantity int4 NOT NULL,
	prince float4 NOT NULL,
	status varchar(20) NOT NULL,
	address_id int2 NOT NULL,
	product_id int4 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	CONSTRAINT order_pkey PRIMARY KEY (ordering_id),
	CONSTRAINT address_fk FOREIGN KEY (address_id) REFERENCES public.address(address_id),
	CONSTRAINT customer_fk FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id),
	CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id)
);

