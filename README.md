# Deploy spring boot application with sql and nosql persistence databases

## Start docker postgres

```bash
docker run --name example-postgres -e POSTGRES_DB=example -e POSTGRES_PASSWORD=examplepw -d -p 5432:5432 postgres
```

## Start docker mongodb

```bash
docker run --expose 5432:5432 --name example-mongodb -e MONGO_INITDB_ROOT_USERNAME=example -e MONGO_INITDB_ROOT_PASSWORD=examplepw -d mongo
```
