# ActFramework Simple CRUD Service Demo

This application demonstrates how to write a simple CRUD service in ActFramework

## Start the application

Start the application in dev mode

```
mvn clean compile act:run
```

Start the application in prod mode

```
mvn clean package
cd target/dist
tar xzf *.gz
./run
```
Once application has been started, you can open browser and locate to `http://localhost:5460` get the home page.

Run automate test

```
mvn clean compile act:test
```

This will start the application and run automate test scenarios and then shutdown the app. Normally you should add this 
to your CI pipeline.

## Understanding the application

### Application entry

The application starts with `gallery.crud.AppEntry`

```java
@SuppressWarnings("unused")
public class AppEntry {
    public static void main(String[] args) throws Exception {
        Act.start();
    }
}
```

The main method call `act.Act.start()` method to bootstrap ActFramework and load this application.

### The model class

There is one single model class defined to keep bookmark data:

```java
@Entity(name = "bookmark")
public class Bookmark implements SimpleBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public String url;

    public int likes;

}
```

The data structure is simple, we have defined an `id` field, and `name`, `url`, `likes` to keep track a bookmark.

The class implements `SimpleBean`, which allows we defined public fields instead of private field plus getter/setter, 
because ActFramework will enhance the class by generating getter/setter for the public fields defined in a `SimpleBean` 
typed class. It will also make sure a default constructor is defined in the class.

### The service class

The service class `BookmarkService` provides CRUD service for `Bookmark` model:

```java
@UrlContext("api/v1/bookmarks")
public class BookmarkService extends SimpleRestfulServiceBase<Integer, Bookmark, JPADao<Integer, Bookmark>> {
}
```

We noticed there is no single request handler code defined in the service as all of the logic is defined in 
`SimpleRestfulServiceBase` provided with ActFramework. The only thing app needs to provide is the `UrlContext` of the 
service class, which will be used to dispatch the request to the service.
 
## FAQ

**Question**: Why do I get the following error message ?

`Cannot encrypt/decrypt! Please download Java Crypto Extension pack from Oracle`

**Answer**: Please download and install the JCE pack from Oracle for
[Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html) or 
[Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html)
