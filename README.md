# Deploy spring boot application with sql and nosql persistence databases

## Minimum Requirements
    - JDK 11
    - Apache Maven 3.6.0
    - Docker

## Start docker postgres

```bash
docker run --name example-postgres -e POSTGRES_DB=example-postgres -e POSTGRES_PASSWORD=postgrespw -d -p 5432:5432 postgres
```

## Start docker mongodb

```bash
docker run --name example-mongo -e MONGO_INITDB_ROOT_USERNAME=mongo-user -e MONGO_INITDB_ROOT_PASSWORD=mongopw -p 27017:27017 mongo
```

