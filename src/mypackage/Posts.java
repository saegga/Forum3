package mypackage;

import java.util.Date;

/**
 * Created by sergei on 10.03.2015.
 */
public class Posts {

    public Posts() {
    }

    int id;
    Date date;
    int userId;
    int forumId;
    String text;
    int subjectId;
    int replyTo;

    public Posts(String text, int subjectId, Date date, int userID) {
        this.text = text;
        this.subjectId = subjectId;
        this.date = date;
        this.userId = userId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(int replyTo) {
        this.replyTo = replyTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
