package gallery.crud;

/*-
 * #%L
 * actframework app demo - hello world
 * %%
 * Copyright (C) 2018 ActFramework
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import act.Act;
import act.db.Dao;
import act.inject.util.LoadResource;
import act.job.OnAppStart;
import gallery.crud.model.Bookmark;
import org.osgl.mvc.annotation.GetAction;

import java.util.List;

import static act.controller.Controller.Util.renderTemplate;

/**
 * The simple CRUD service app entry
 */
@SuppressWarnings("unused")
public class AppEntry {

    @LoadResource("test/fixtures/bookmarks.yml")
    private List<Bookmark> bookmarks;

    @OnAppStart
    public void loadTestData(Dao<?, Bookmark, ?> bookmarkDao) {
        if (bookmarkDao.count() == 0) {
            bookmarkDao.save(bookmarks);
        }
    }

    /**
     * Display the home page.
     */
    @GetAction
    public void home() {
        renderTemplate("/home");
    }

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
