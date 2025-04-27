#!/bin/bash
curl -X POST -H "Content-Type: application/json" -d '{
  "id": "some_unique_id",
  "price": 5.99,
  "seasonal": true,
  "vegan": false,
  "brand": "Ben & Jerry\'s",
  "ice_cream_flavor": "Half Baked"
}' http://localhost:8080/api/v1/icecream-flavor
