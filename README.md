# WHAT IS IT
The trace-gateway makes it possible to trace the exceptions that occur during multi-level calls in a microservice environment.

This traceability is achieved through the GlobalFilter and GlobalExceptionHandler based on Spring-Cloud-Gateway.

# HOW TO USE
The trace-gateway is an independent microservice that can be registered in any service registry and read the service routing method from a unified configuration center.In the 1.0 - SNAPSHOT version, we use Nacos as both the configuration center and the service registry. In the future, more common services may be supported.

This project provides a simple Login interface. You just need to register any interface with Nacos, then register the Trace - gateway with the same Nacos instance, and configure the gateway routes. After that, you can access the registered interfaces through the Trace - gateway and start using the exception traceability service.
