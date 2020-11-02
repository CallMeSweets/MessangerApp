FROM cassandra:3.11.8

COPY ["docker-entrypoint.sh", "/usr/local/bin"]

RUN chmod +x /usr/local/bin/docker-entrypoint.sh

COPY initdb.cql /usr/local/bin/

CMD ["docker-entrypoint.sh"]


