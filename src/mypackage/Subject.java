package mypackage;

/**
 * Created by sergei on 10.03.2015.
 */
public class Subject {
    int id;
    String name;
    int forumId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public Subject(int id, String name, int forumId) {
        this.id = id;
        this.name = name;
        this.forumId = forumId;
    }


    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
