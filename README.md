# SENG401G3Backend

This project is using h2 database and Axon server to store all necessary information. To run our server, we are using docker to run our axon server.

H2 database will be storing all permenent values into it.

Axon server will hold all event and aggregate ids which can be used to trace back querying for the id's made.


To run the backend we will first need to make sure we create a docker container for Axon server to base off of. To do this we be running the command docker run -d --name axon-server -p 8024:8024 -p 8124:8124 axoniq/axonserver. This will create axon server on port 8024 on the localhost. THis axon server will store all events that occur with eventid's and aggregateid's based on the aggregate id that is made and placed into aggregateid coloumn in the database. 

After this, to run our backend api, we need to run the maven project which will need the command mvn clean package spring-boot:run. The line 'clean package' is not necessary all the time but without it, sometimes it will not run properly especially on the first run. 

With the api running, the front-end will be consuming the REST API from localhost:8081 which will be needed for the front-end functionalities to work but the api will be running on localhost:8080.
