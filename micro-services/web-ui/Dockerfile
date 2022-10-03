FROM nginx:1.23-alpine

# set working directory ---------------------------------------------------------------------------------------
WORKDIR /cqa-demo-io

# remove default nginx config from container image ------------------------------------------------------------
RUN rm /etc/nginx/conf.d/default.conf

# copy cqa-demo nginx config to container image ---------------------------------------------------------------
COPY ./nginx.conf /etc/nginx/conf.d

# copy web distribution code ----------------------------------------------------------------------------------
COPY ./dist /cqa-demo-io
