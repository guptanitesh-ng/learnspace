## ApplicationRunner - Implemented startup loader using SpringBoot ApplicationRunner implementation
## ESApplicationRunner performs following actions - Create and Delete Index, Get and Update Mapping, Bulk Index creation, Put and Get document
## All the other kinds of request related to search, create, update and cluster are part of the postman collection available under root folder.  
## Elastic Search Cluster configuration - Implemented using two nodes the configuration files are under elastic search folder.
## Implement Logging - Spring using logback as default logging. Specified elastic-search.log as the file to write to. The same has been used in ElasticSearchController.search fo logging request and response.
## Log Elastic Search requests - Set the log level for elastic serach package in application.properties.
## Debugging at startup of Spring Boot app - mvn spring-boot:run -debug
