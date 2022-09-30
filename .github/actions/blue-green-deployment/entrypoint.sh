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
    echo "Version: $INPUT_VERSION"
    export VERSION=$INPUT_VERSION
    echo "Environment: $INPUT_ENVIRONMENT"
    export ENVIRONMENT=$INPUT_ENVIRONMENT
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------
