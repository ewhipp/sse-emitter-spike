# sse-emitter-spike

Basically run the spring boot app 

There is an accompanying index.html that will create the EventSource as well, but you can also do 
`let sse = new EventSource(http://localhost:8080/api/v1/event/unlockEvent)`

PUT http://localhost:8080/api/v1/event/unlockEvent?dmsId={dmsID} will do a fake update to a request
GET http://localhost:8080/api/v1/event/unlockEvent should return a stream of events

However, the problem is that this appears to not work as expected. If we want to follow this strategy, we will need this service to simply provide events. We can't have this service also be a part of executing the events.

When we do a put request, it will not finish until the event has completed on the GET request. Causing problems.
