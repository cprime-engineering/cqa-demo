---
layout: default
title: Blue Green Deployment
nav_order: 4
has_children: false
---

# Blue Green Deployment

https://kubernetes.io/docs/reference/kubectl/cheatsheet/

https://learn.microsoft.com/en-us/azure/aks/ingress-basic?tabs=azure-cli

## Create Namespaces

kubectl create namespace blue

kubectl create namespace green

kubectl get namespaces

kubectl describe namespaces blue

kubectl describe namespaces green

## Delete Namespaces

kubectl delete namespace blue

kubectl delete namespace green

## Manual Deployment

### Blue

kubectl apply -f deploy/deployment.yml --namespace blue --dry-run=client

kubectl apply -f deploy/deployment.yml --namespace blue

kubectl apply -f deploy/service.yml --namespace blue

kubectl apply -f deploy/ingress.yml --namespace blue

### Green

kubectl apply -f deploy/deployment.yml --namespace green --dry-run=client

kubectl apply -f deploy/deployment.yml --namespace green

kubectl apply -f deploy/service.yml --namespace green

kubectl apply -f deploy/ingress.yml --namespace green
