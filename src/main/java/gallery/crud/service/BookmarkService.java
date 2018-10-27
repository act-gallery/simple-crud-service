package gallery.crud.service;

import act.app.util.SimpleRestfulServiceBase;
import act.controller.annotation.UrlContext;
import act.db.jpa.JPADao;
import gallery.crud.model.Bookmark;

@UrlContext("api/v1/bookmarks")
public class BookmarkService extends SimpleRestfulServiceBase<Integer, Bookmark, JPADao<Integer, Bookmark>> {
}
