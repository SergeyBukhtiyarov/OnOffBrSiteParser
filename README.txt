Create DB hibernate and admin user in postgres:

mac: download Postgres.App

1) psql   -> open postgres command line
2) CREATE DATABASE "onoffbrsiteparser" WITH OWNER=postgres;
3) CREATE USER "admin" WITH PASSWORD 'admin';
4) GRANT ALL PRIVILEGES ON DATABASE onoffbrsiteparser TO admin;
5) \l
   \du  -> list of all existing db and users, just created 'admin' & 'hibernate' should appear here
   \dt  -> list of all tables in selected db

=========================================================================================
- get and parse JSON( WebClient/ObjectMapper)
