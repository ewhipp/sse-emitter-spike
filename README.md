# sse-emitter-spike

Basically run the spring boot app 

There is an accompanying index.html that will create the EventSource as well, but you can also do 
`let sse = new EventSource(http://localhost:8080/api/v1/event/unlockEvent)`

PUT http://localhost:8080/api/v1/event/unlockEvent?dmsId={dmsID} will do a fake update to a request
GET http://localhost:8080/api/v1/event/unlockEvent should return a stream of events

