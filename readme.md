What I have finished:

I have created the cassandra db with the TTL 5 min. Also the backend with all necessary endpoints is finished. The Dockerfile for backend app is written. In the docker compose file there is declaration
of two services: DB: cassandradb and BACKEND: messanger.

The problem which I could not solve was connection error. My backend could not connect with cassandradb even when I have created the network between those containers.