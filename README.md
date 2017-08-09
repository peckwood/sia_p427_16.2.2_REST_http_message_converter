

#### Produce JSON output with @ResponseBody

- method: `rest.controller.UserController.users(long, int)`
- URL: http://localhost:8080/sia_p427_16.2.2_REST_http_message_converter/users
- returns JSON

#### Receiving resource state in the request body

- classpath: there is a library that can transfer json from/to Java Objects

```
<dependency>
  <groupId>com.fasterxml.jackson.dataformat</groupId>
  <artifactId>jackson-dataformat-xml</artifactId>
  <version>2.7.4</version>
</dependency>
```

- back end method: `rest.controller.UserController.users(long, int)`

- front end:`/main/webapp/saveUser.html` with javaScript `/main/webapp/addUser.js`

  - Ajax: the json object is what is in the controller's method input parameter(@nnotated with `@RequestBody`)
    -  if it is `var user = {...}`
    -  send user
    -  do not send `{user:user}`
  - Ajax: the json object must be stringified: `JSON.stringify(jsonObject)`
  - Ajax: must specify contentType as `application/json`, or code `415: Unsupported media type` will be returned (thanks to `consumes` on the controller method)
  - method must be `POST`


#### Restful Controller

- `@RestController` can be added to a controller class so all methods are automatically annotated with `@ResponseBody`, `@RequestBody` is not affected


  - See class `rest.controller.UserRestController`

### Serve more than resources

#### use ResponseEntity to return resource and status code if FOUND

- See the links in index.jsp
- The book's teaching about this starts at page P432 (16.3)

#### Use ResponseEntity to return resource, status code and headers

- link `[Serve more than resource: return response headers(browser debug)]` in index.jsp
- check the response headers with browser and see that the status code is **201**(created), the response headers now contain **Location** with the one added in controller
- controller method: `rest.controller.UserController.saveUserAndReturnResponseHeaders(User)`
- the method uses `UriComponentsBuilder` to avoid hardcoding the base path(P438)







