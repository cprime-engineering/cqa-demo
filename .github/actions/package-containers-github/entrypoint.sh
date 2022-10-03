#!/bin/sh -l

# Group --------------------------------------------------------------------------------------------
echo "::group::Debug Support"
    pwd
    ls -a
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------

# Group --------------------------------------------------------------------------------------------
echo "::group::Login To Container Registry"
    docker login $INPUT_REGISTRY -u $INPUT_USER_NAME -p $INPUT_PASSWORD
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------


# Group --------------------------------------------------------------------------------------------
echo "::group::Build Container Images"
    # fibonacci-calculator
    docker build -f ./micro-services/fibonacci-calculator/Dockerfile -t ghcr.io/cprime-labs/cqa-demo/fibonacci-calculator:$INPUT_APP_VERSION ./micro-services/fibonacci-calculator
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------

# Group --------------------------------------------------------------------------------------------
echo "::group::Push Container Images"
    # fibonacci-calculator
    docker push ghcr.io/cprime-labs/cqa-demo/fibonacci-calculator:$INPUT_APP_VERSION
echo "::endgroup::"
# End Group ----------------------------------------------------------------------------------------
