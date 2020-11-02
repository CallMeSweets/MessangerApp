CREATE KEYSPACE message_keyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use message_keyspace;

create table messages (uuid timeuuid PRIMARY KEY, email text, title text, content text, magic_number int) WITH DEFAULT_TIME_TO_LIVE = 300;



