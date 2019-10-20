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

    public int likes;

}
```

The `BookmarkService` controller

```java
@UrlContext("api/v1/bookmarks")
public class BookmarkService extends SimpleRestfulServiceBase&lt;Integer, Bookmark, JPADao&lt;Integer, Bookmark>> {
}
```

These are all you need to build up a RESTful service for model `Bookmark`, including:

* `POST /api/v1/bookmarks` - create an new bookmark
* `GET /api/v1/bookmarks` - query a list of bookmarks
* `GET /api/v1/bookmarks/{bookmark-id}` - get a specific bookmark by `id`
* `PUT /api/v1/bookmarks/{bookmark-id}` - update a specific bookmark by `id`
* `DELETE /api/v1/bookmarks/{bookmark-id}` - delete a specific bookmark by `id`

## Play with the service

Try the following links to see the query feature provided by the bookmark RESTful service:

* [List all bookmarks](/api/v1/bookmarks)
* [List all bookmarks with likes greater than 200](/api/v1/bookmarks?likes=gt_200)
* [List all bookmarks with name contains "oo"](/api/v1/bookmarks?name=~oo)
* [List all bookmarks order by likes in descending order](/api/v1/bookmarks?_orderBy=-likes)
* [Create new bookmark](/add_bookmark)
* [Update existing bookmark](/update_bookmark)
* [Delete bookmark](/delete_bookmark)

}

