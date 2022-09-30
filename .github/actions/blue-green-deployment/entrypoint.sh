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
echo "::group::Describe Version and Environment"
    echo "Version: $INPUT_VERSION"
    echo "Environment: $INPUT_ENVIRONMENT"
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------
