# RandomNameAPI
This project creates a simple web service that consumes JSON name objects originating from [uinames.com](http://uinames.com). 
When a get request is received, a list of JSON name objects is retrieved from uinames and converted to 
RandomNameAPI.Models.Name objects. This conversion is performed to more closely represent what would occur if
the data were being retreived from a database. The list of RandomNameAPI.Models.Name objects is then converted 
back to JSON and attached to the response.

### How to Use
When deployed, **get** requests to the following URL will be processed:
```
http://localhost:8080/RandomNameAPI/webapi/names
```

### Built With
- **uinames.com** - external API and ultimate source of name data
- **java** - development language
- **Tomcat v7** - web server
- **Maven** - dependency management
- **Jersey** - RESTful web service development tool
- **Jackson** - JSON processor for java
