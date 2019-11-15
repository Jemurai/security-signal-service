# security-signal-service

The security-signal-service is a simple HTTP service that can collect security signals.
It is intended as a minimal example in Clojure to illustrate several things, both good
and bad, about security.

## Getting Started

1. Start the application: `lein run`
2. Go to [localhost:8000](http://localhost:8000/) to see: `This is a security signal application.  Post to /signal.`
3. Read your app's source code at src/security_signal_service/service.clj. Explore the docs of functions
   that define routes and responses.
4. Run your app's tests with `lein test`. Read the tests at test/security_example_service/service_test.clj.
5. Learn more! See the [Links section below](#links).

## Configuration

To configure logging see config/logback.xml. By default, the app logs to stdout and logs/.
To learn more about configuring Logback, read its [documentation](http://logback.qos.ch/documentation.html).

In the longer term, details about where security signals are logged may be configurable.

## Developing your service

1. Start a new REPL: `lein repl`
2. Start your service in dev-mode: `(def dev-serv (run-dev))`
3. Connect your editor to the running REPL session.
   Re-evaluated code will be seen immediately in the service.

### [Docker](https://www.docker.com/) container support

1. Configure your service to accept incoming connections (edit service.clj and add  ::http/host "0.0.0.0" )
2. Build an uberjar of your service: `lein uberjar`
3. Build a Docker image: `sudo docker build -t security-signal-service .`
4. Run your Docker image: `docker run -p 8000:8000 security-signal-service`

### [OSv](http://osv.io/) unikernel support with [Capstan](http://osv.io/capstan/)

1. Build and run your image: `capstan run -f "8000:8000"`

Once the image it built, it's cached.  To delete the image and build a new one:

1. `capstan rmi security-signal-service; capstan build`

### Security Notes

- This is a simple illustration, not a real full implementation.  Please test or adapt to your needs.
- If you change the version of jetty used in project.clj to the commented one and run `lein dependency-check` after setting that up, you will see interesting results.

## Links
* [Other Pedestal examples](http://pedestal.io/samples)
