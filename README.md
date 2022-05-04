# BBQTime

Implemented model-view-controller architecture within Docker container using Maven, Springboot and Vanilla JS. Preparation for log level setting via application properties also implemented. The business logic is tested on unit test level with some jUnit testcases.

### ToDo/Improvement possibilities (there is a lot, unfortunately)
- there is a known bug near the post sending though UI
- implement proper logging
- implement better UI
- add defensive coding to pevent all the faulty method parameter specifications
- more unit test for the controller methods
- integreation test for contrioller
- separated comporehensive API testing
- ui test to check it in an E2E manner


## Project setup

To build the whole application run the makefile commands as:

```bash
$ make build
```

To run the whole application run the makefile commands as:

```bash
$ make start
```

To run tests

```bash
$ mvn test
```