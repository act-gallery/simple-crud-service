package gallery.crud.model;

import act.util.SimpleBean;

import javax.persistence.*;

@Entity(name = "bookmark")
public class Bookmark implements SimpleBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public String url;

}
