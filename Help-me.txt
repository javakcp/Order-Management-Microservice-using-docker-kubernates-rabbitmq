Problem statement of Order management system using micro service architecture and deploy in minikube/Docker for MAC environment using docker and kubernetes tools

   1. Add the products to Inventory using REST API. (Persist in DB)
   2. Should be able to take the order based on the product availability in Inventory and generate the invoice using REST API
   3. Once the invoice is generated post the Order to Shipping service using message broker like Kafka/Rabbit MQ


Help me to Deploy:
	1- copy Order-Management-microservice in local workspace
	2- run the shell script Order-Management-microservice/rabbitmq/make_rabbitmq_up.sh
	3- run the shell script Order-Management-microservice/postgres/make_postgres_up.sh
	4- run the shell script Order-Management-microservice/inventory-service/build_and_run_inventory_service.sh
	5- run the shell script Order-Management-microservice/order-service/build_and_run_order_service.sh
	6- run the shell sript Order-Management-microservice/shipping-service/build_and_run_shipping_service.sh

Post script run: rabbitMQ, postgres, inventory-service, order-service and shipping-service will up and running.

To access swagger of inventory-service, use http://localhost:30200/swagger-ui.html
To access swagger of order-service, use     http://localhost:30300/swagger-ui.html

Note: Shipping service will get notification once invoice is ready. the message for shipping will display in console.


