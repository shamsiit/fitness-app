#!/bin/bash

BASE_URL=http://localhost:8080/api

echo "Registering a new user..."
curl -s -X POST $BASE_URL/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"john_doe","email":"john@example.com","password":"password123"}' | tee register_response.json
echo -e "\n"

echo "Logging in..."
curl -s -X POST $BASE_URL/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"john_doe","password":"password123"}' | tee login_response.json
echo -e "\n"

TOKEN=$(jq -r '.token' login_response.json)

echo "Calling protected endpoint..."
curl -s -X GET $BASE_URL/protected \
  -H "Authorization: Bearer $TOKEN"
echo -e "\n"

echo "Creating an exercise..."
curl -s -X POST $BASE_URL/exercises \
  -H "Authorization: Bearer $TOKEN" \
  -H "Content-Type: application/json" \
  -d '{"name":"Bench Press","category":"Chest"}' | tee exercise_response.json
echo -e "\n"

EXERCISE_ID=$(jq -r '.id' exercise_response.json)

echo "Fetching all exercises..."
curl -s -X GET $BASE_URL/exercises \
  -H "Authorization: Bearer $TOKEN"
echo -e "\n"

echo "Creating a workout..."
curl -s -X POST $BASE_URL/workouts \
  -H "Authorization: Bearer $TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
        "name":"Monday Chest Day",
        "date":"2025-04-20",
        "userId":1,
        "sets":[
          {
            "exerciseId":'"$EXERCISE_ID"',
            "reps":10,
            "weight":80.0,
            "restTime":60
          }
        ]
      }'
echo -e "\n"

echo "Fetching workouts by user ID..."
curl -s -X GET $BASE_URL/workouts/user/1 \
  -H "Authorization: Bearer $TOKEN"
echo -e "\n"

echo "Fetching progress summary for user..."
curl -s -X GET $BASE_URL/progress/user/1 \
  -H "Authorization: Bearer $TOKEN"
echo -e "\n"

echo "Fetching progress for user 1 and exercise $EXERCISE_ID..."
curl -s -X GET $BASE_URL/progress/user/1/exercise/$EXERCISE_ID \
  -H "Authorization: Bearer $TOKEN"
echo -e "\n"

echo "Creating structured routine..."
curl -s -X POST $BASE_URL/routines \
  -H "Authorization: Bearer $TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
        "name": "Push-Pull Sample",
        "userId": 1,
        "workoutPlans": [
          {
            "day": "Monday",
            "exerciseId": '"$EXERCISE_ID"',
            "reps": 12,
            "weight": 60.0,
            "restTime": 90
          }
        ]
      }'
echo -e "\n"

echo "Fetching structured routines by user..."
curl -s -X GET $BASE_URL/routines/user/1 \
  -H "Authorization: Bearer $TOKEN"
echo -e "\n"

echo "Fetching analytics report for user 1..."
curl -s -X GET $BASE_URL/analytics/user/1 \
  -H "Authorization: Bearer $TOKEN"
echo -e "\n"

rm -f register_response.json login_response.json exercise_response.json
