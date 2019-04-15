#!/bin/bash
mvn clean install

docker build -t inventory-service:1.0 .

kubectl apply -f deployment.yml
kubectl apply -f svc.yml
