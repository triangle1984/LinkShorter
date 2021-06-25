# LinkShorter

Description
-----------
Link shorter is a simple app for shorten link size app.
Example:
```
https://www.google.ru/maps/place/Tornovoye+Ops/@53.2751145,49.9475033,15z/data=!4m5!3m4!1s0x4168a65555555555:0x4bcec2a84f31e53b!8m2!3d53.276818!4d49.954729
```
To
```
https://domain/AMEeMsxK
```
The new url will be just redirected to the original url

There are many ways to shorten a link. Currently supported
* REST API
* Frontend on Vaadin

Technology stack
----------------
* Framework: Spring boot
* Database: H2
* Frontend: Vaadin
* Mapper: Model mapper
* Documentation: Swagger

Configuration
-------------
* Run on port 8080
* Swagger URI documentation/swagger-ui/index.html
* Vaadin frontend URI /ui