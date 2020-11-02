CREATE KEYSPACE MESSAGES_KEYSPACE WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

use MESSAGES_KEYSPACE;

create table messages (uuid timeuuid PRIMARY KEY, email text, title text, content text, magic_number int) WITH DEFAULT_TIME_TO_LIVE = 300;



