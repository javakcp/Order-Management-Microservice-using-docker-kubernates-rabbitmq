#!/bin/bash
kubectl create -f config-map.yml

kubectl create -f deployment.yml

kubectl create -f storage.yml

kubectl create -f svc.yml

