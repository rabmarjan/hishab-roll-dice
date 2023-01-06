# build jar file
./mvnw package && java -jar target/hishab.jar

# Build docker image
docker build -t dice/hishab .

# Run hishab container
docker run -p 8080:8080 dice/hishab
