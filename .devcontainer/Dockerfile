FROM mcr.microsoft.com/vscode/devcontainers/universal:2-linux

# As root user ------------------------------------------------------------------------------------------------
USER root

# copy codespace .bashrc --------------------------------------------------------------------------------------
COPY home/codespace/.bashrc /home/codespace/.bashrc

# copy toolkit directory --------------------------------------------------------------------------------------
COPY opt/toolkit /opt/toolkit

# As codespace user -------------------------------------------------------------------------------------------
USER codespace

# Install pre-commit ------------------------------------------------------------------------------------------
RUN pip install pre-commit

# Install snyk ------------------------------------------------------------------------------------------------
RUN npm install snyk -g

# Install github_changelog_generator --------------------------------------------------------------------------
RUN gem install github_changelog_generator

# As root user ------------------------------------------------------------------------------------------------
USER codespace

# Install adr-tools -------------------------------------------------------------------------------------------
RUN git clone https://github.com/npryce/adr-tools.git ~/adr-tools \
	&& cd ~/adr-tools && git checkout tags/3.0.0

COPY home/codespace/adr-tools/src/template.md /home/codespace/adr-tools/src/template.md
