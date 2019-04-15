#!/bin/bash
kubectl create namespace kailash
kubectl create -f rabbitmq_rbac.yaml
kubectl create -f rabbitmq_statefulsets.yaml
