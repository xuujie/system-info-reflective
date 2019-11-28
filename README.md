1. Build spring boot jar
    ```bash
    gradle clean build
    ```
2. Build docker image
    ```bash
    docker build -t xuujie/system-info-reflective:latest .
    ```
3. Run container on port 8080
    ```bash
    docker run -d --name system-info-reflective -p 8080:8080 xuujie/system-info-reflective:latest
    ```
4. Clean up
    ```bash
    docker container stop system-info-reflective
    docker container rm system-info-reflective
    docker image rm xuujie/system-info-reflective:latest
    ```
5. Push to docker hub
    ```bash
    docker login --username=xuujie
    docker tag <image-id> xuujie/server-info-reflective:latest
    docker push xuujie/system-info-reflective:latest
    ```