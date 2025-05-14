

# This script can be used to test the application
curl -X POST http://localhost:8080/realms/food-ordering/protocol/openid-connect/token \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "client_id={CLIENT_ID}" \
  -d "client_secret={SECRET}" \
  -d "username={USERNAME}" \
  -d "password={PASSWORD}" \
  -d "grant_type=password" \
  -d "scope=openid offline_access"


