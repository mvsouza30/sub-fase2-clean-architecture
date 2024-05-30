FROM postgres:15

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=carsales-prod-db

COPY script.sql /docker-entrypoint-initdb.d/

EXPOSE 5432

