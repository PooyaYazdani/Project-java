import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Post {

    private User user;
    private String text;
    private LocalDate localDate;
    private LocalTime localTime;
    private int id;
    private Set<User> likes = new HashSet<>();
    private int likeNum = 0;
    private Set<Comment> comments = new HashSet<>();
    private int commentNum = 0;


    Post (String text){
        setText(text);
        setLocalDate(LocalDate.now());
        setLocalTime(LocalTime.now());
        Controller.postsNum += 1;
        setId(Controller.postsNum+10000);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public void addComments(Comment comment) {
        this.comments.add(comment);
        this.commentNum+=1;
    }

    public void addLikes(User user) {
        this.likes.add(user);
        this.likeNum += 1;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }
}
