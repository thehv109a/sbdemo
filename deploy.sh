git pull; mvn clean package -DskipTests; docker build -t sbdemo:latest -f Dockerfile .;
docker rm -f sbdemo; docker run --name sbdemo -p 80:80 -d sbdemo:latest