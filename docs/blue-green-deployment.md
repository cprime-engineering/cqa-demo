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

kubectl create namespace cqa-demo-blue

kubectl create namespace cqa-demo-green

kubectl get namespaces

kubectl describe namespaces cqa-demo-blue

kubectl describe namespaces cqa-demo-green

## Delete Namespaces

kubectl delete namespace cqa-demo-blue

kubectl delete namespace cqa-demo-green



## Manual Deployment

kubectl apply -f deploy/fibonacci-calculator-deployment.yml --namespace cqa-demo-blue --dry-run=client

kubectl apply -f deploy/fibonacci-calculator-deployment.yml --namespace cqa-demo-blue

kubectl apply -f deploy/fibonacci-calculator-service.yml --namespace cqa-demo-blue

kubectl apply -f deploy/web-ui-ingress.yml --namespace cqa-demo-blue
