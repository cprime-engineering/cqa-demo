#!/bin/sh -l

# Group --------------------------------------------------------------------------------------------
echo "::group::Debug Support"
    pwd
    ls -a
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------

# Group --------------------------------------------------------------------------------------------
echo "::group::AZ Login"
    az login --service-principal -u $INPUT_AZ_USER_NAME -p $INPUT_AZ_PASSWORD --tenant $INPUT_AZ_TENANT_ID
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------

# Group --------------------------------------------------------------------------------------------
echo "::group::AZ AKS Get Credentials"
    az aks get-credentials --resource-group $INPUT_AZ_RESOURCE_GROUP_NAME --name $INPUT_AZ_AKS_CLUSTER_NAME
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------

# Group --------------------------------------------------------------------------------------------
echo "::group::Set Environment Variables"
    echo "App Version: $INPUT_APP_VERSION"
    export APP_VERSION=$INPUT_APP_VERSION
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------

# Group --------------------------------------------------------------------------------------------
echo "::group::Kubectl Apply"
    kubectl apply -f deploy/deployment.yml --namespace $INPUT_ENVIRONMENT
    kubectl apply -f deploy/service.yml --namespace $INPUT_ENVIRONMENT
    kubectl apply -f deploy/ingress.yml --namespace $INPUT_ENVIRONMENT
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------
