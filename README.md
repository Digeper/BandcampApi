# BandcampApi

## What it does

Searches and retrieves random songs from Bandcamp music platform. Listens to Kafka topics for song requests and publishes discovered tracks.

## Local Setup

1. Ensure Kafka is running on `localhost:9092`
2. Update Kafka configuration in `application.properties` if needed
3. Run: `mvn spring-boot:run`
4. Service starts on port `8080`

## Deployment

Deploy to Kubernetes namespace `muzika`:
```bash
kubectl apply -k k8s/
```

Image: `${ACR_NAME}.azurecr.io/muzika/bandcampapi:latest`

Requires: Kafka cluster, Azure Key Vault secrets, ConfigMap
