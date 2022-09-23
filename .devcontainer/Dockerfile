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
