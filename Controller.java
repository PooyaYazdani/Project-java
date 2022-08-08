import java.util.List;

public class Controller {

    static int postsNum;
    static int usersNum;

    public void newPost(String text, User user){
        Post post = new Post(text);
        post.setUser(user);
    }

    public void newComment(String text, User user, Post post){
        Comment comment = new Comment(text);
        comment.setPost(post);
        comment.setUser(user);
        post.addComments(comment);
    }

    public void showComments(Post post){
        for (Comment comment : post.getComments()){
            System.out.println(comment.getUser().userName + " : " + comment.getText() + "  ("+ comment.getLikeNum()+" likes)");
            showComments(comment);
        }
    }

}
