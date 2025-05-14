#!/bin/bash

# Start Keycloak in the background
/opt/keycloak/bin/kc.sh start-dev &


# Wait for it to become ready (basic delay or health check loop)
echo "Waiting for Keycloak to be ready..."
  sleep 60

# Run custom script
echo "Running create-user.sh"
/bin/bash /opt/keycloak/bin/create-user.sh

# Bring Keycloak back to foreground (waits for it)
wait
