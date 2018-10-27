# ActFramework HelloWorld Demo

This application demonstrates how to use write a simplest HelloWorld application using  actframework application

## Start the application

Start the application in dev mode

```
mvn clean compile act:run
```

Run automate test

```
mvn clean compile act:test
```

Start the application in prod mode

```
mvn clean package
cd target/dist
tar xzf *.gz
./run
```

Once application has been started, you can open browser and locate to `http://localhost:5460` get the home page.

## Understanding the Demo app

The demo application contains a single Java class `gallery.helloworld.AppEntry`

```java
public class HelloWorldApp {

    @GetAction
    public void home(@DefaultValue("World") @Output String who) {
    }

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
```

The main method call `act.Act.start()` method to bootstrap ActFramework and load this application:

### Action handler

The `AppEntry` class contains one action handler method:

```java
    @GetAction
    public void home(@DefaultValue("World") @Output String who) {
    }
```

`@GetAction` annotation without parameter tells ActFramework that this method is a handler that answers request sent to `/`. 

Parameter `String who` tells ActFramework that if there is a request parameter named `who` the value shall be inject to this parameter when calling to this handler method.

The `@Output` annotation before `String who` tells ActFramework to put the value of `who` to the template using name `who`.

The template `home.html` is located at `resources/rythm/demo/helloworld/AppEntry`. Literally the path is corresponding to the package/class/method hierarchy, based in `resources/rythm` template root.
 
The template is created using [Rythm Engine](http://rythmengine.org). For more information about Rythm engine, please visit the official site at http://rythmenigne.org
 
## FAQ

**Question**: Why do I get the following error message ?

`Cannot encrypt/decrypt! Please download Java Crypto Extension pack from Oracle`

**Answer**: Please download and install the JCE pack from Oracle for
[Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html) or 
[Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html)
