FROM docker:20.10.18-alpine3.16

# Set working directory ----------------------------------------------------------------------------
WORKDIR /

# Install npm --------------------------------------------------------------------------------------
RUN apk add --update npm --no-cache

# Install ember-cli --------------------------------------------------------------------------------
RUN npm install -g ember-cli

# Copy entrypoint.sh -------------------------------------------------------------------------------
COPY entrypoint.sh /entrypoint.sh

# Grant executable permissions to entrypoint.sh ----------------------------------------------------
RUN chmod +x /entrypoint.sh

# Set container entrypoint to entrypoint.sh --------------------------------------------------------
ENTRYPOINT ["/entrypoint.sh"]
