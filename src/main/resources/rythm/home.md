@extends(act.md_base, title: "Simple CRUD Service Demo")

@verbatim() {

# Simple CRUD Service Demo

This demo project shows how to use ActFramework's 
[SimpleRestfulServiceBase](https://github.com/actframework/actframework/blob/master/src/main/java/act/app/util/SimpleRestfulServiceBase.java)
to create a RESTful service.

## Bookmark and it's service

The `Bookmark` entity

```java
@Entity(name = "bookmark")
public class Bookmark implements SimpleBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public String url;

}
```

The `BookmarkService` controller

```java
@UrlContext("api/v1/bookmarks")
public class BookmarkService extends SimpleRestfulServiceBase<Integer, Bookmark, JPADao<Integer, Bookmark>> {
}
```



}