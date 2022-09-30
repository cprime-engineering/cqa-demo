FROM alpine:3.16

#--------------------------------------------------------------------------------------------------------------
# Set working directory
#--------------------------------------------------------------------------------------------------------------
WORKDIR /

# apk update ---------------------------------------------------------------------------------------
RUN apk update

# Install python3 and pip3 -------------------------------------------------------------------------
ENV PYTHONUNBUFFERED=1
RUN apk add --update --no-cache python3 && ln -sf python3 /usr/bin/python
RUN python3 -m ensurepip
RUN pip3 install --no-cache --upgrade pip setuptools

# install docker -----------------------------------------------------------------------------------
RUN apk add --update --no-cache docker openrc
RUN rc-update add docker boot

# Install azure cli dependencies -------------------------------------------------------------------
RUN apk add --no-cache gcc musl-dev python3-dev libffi-dev openssl-dev cargo make

# upgrade pip --------------------------------------------------------------------------------------
RUN pip install --upgrade pip

# install azure-cli --------------------------------------------------------------------------------
RUN pip install azure-cli

# Install helm and kubectl dependencies ------------------------------------------------------------
RUN apk add --no-cache ca-certificates bash git openssh curl gettext jq

# Install kubectl ----------------------------------------------------------------------------------
RUN wget -q "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" -O /usr/local/bin/kubectl
RUN chmod +x /usr/local/bin/kubectl

# Copy entrypoint.sh -------------------------------------------------------------------------------
COPY entrypoint.sh /entrypoint.sh

# Grant executable permissions to entrypoint.sh ----------------------------------------------------
RUN chmod +x /entrypoint.sh

# Set container entrypoint to entrypoint.sh --------------------------------------------------------
ENTRYPOINT ["/entrypoint.sh"]
