public class Comment extends Post {


    private Post post = new Post("");

    Comment(String text) {
        super(text);
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}