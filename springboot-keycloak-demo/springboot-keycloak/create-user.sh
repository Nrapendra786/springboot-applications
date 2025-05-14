#!/bin/bash
echo "Waiting for Keycloak to boot..."
sleep 20

/opt/keycloak/bin/kcadm.sh config credentials --server http://localhost:8080 --realm master --user admin --password admin

#Create Realm ApplicationRealm
/opt/keycloak/bin/kcadm.sh create realms -s realm=ApplicationRealm -s enabled=true -o

#Create User user1
./opt/keycloak/bin/kcadm.sh create users -r ApplicationRealm \
  -s username=user1 \
  -s enabled=true \
  -s email="joe@gmail.com" \
  -s emailVerified=true \
  -s firstName=Joe \
  -s lastName=Doe

#Set user1 password
/opt/keycloak/bin/kcadm.sh set-password -r ApplicationRealm --username user1 --new-password 123456

#Create Client
/opt/keycloak/bin/kcadm.sh create clients -r ApplicationRealm -s clientId=my-client -s bearerOnly="false" -s "redirectUris=[\"http://localhost:8080/*\"]" -s enabled=true -s directAccessGrantsEnabled=true -s clientAuthenticatorType=client-secret -s secret=mysecret

#Create Role customer-manager
/opt/keycloak/bin/kcadm.sh create roles -r ApplicationRealm -s name=admin

#Assign Role to user1
/opt/keycloak/bin/kcadm.sh add-roles --uusername user1 --rolename admin -r ApplicationRealm