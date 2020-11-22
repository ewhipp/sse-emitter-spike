# sse-emitter-spike

This is an example project of a simple usage of the SseEmitter.

### What this application does
There are two endpoints
- /api/v1/event  GET RETURNS server-sent event { dmsId: string, type: EventType } - but this can return anything that implements the Event type
- /api/v1/event/unlock?dmsId={dmsId} PUT - this is just an example of a simple operation that will produce an event

The front-end/index.html page registers the event source and will generate a list
of any events that come through once the page is opened.

A user can close the connection at anytime.

The application doesn't is simply a combination of System.out statements and a return event.

### What is this for
This is basically a scaffolding project for anyone to use for server sent events using spring boot
