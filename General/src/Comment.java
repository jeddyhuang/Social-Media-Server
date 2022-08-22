import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Comment
 * 
 * class that represents a comment on a post
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    private final LocalDateTime date; // The time of the post
    private final Post parentPost; // The post of the comment
    private User user; // User that the comment belongs to
    private String comment; // The content of the comment
    private int id; // id of the user that posted

    /**
     * Constructs a comment object
     *
     * @param content    the content of the comment
     * @param parentPost the post of the comment
     */
    public Comment(String content, Post parentPost) {
        date = LocalDateTime.now();
        this.parentPost = parentPost;
        this.comment = content;
        id = 0;
    }

    /**
     * Gets the Post object of the Post the comment is under.
     *
     * @return parentPost post the comment is under
     */
    public Post getParentPost() {
        return parentPost;
    }

    /**
     * Gets date this comment was created on the form of a
     * LocalDateTime object
     *
     * @return the comment creation date as a LocalDateTime
     */
    public LocalDateTime getDateTime() {
        return date;
    }

    /**
     * Gets the user that created this comment
     *
     * @return the User creator of this comment
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user of this comment. The user must
     * already have an initialized id.
     *
     * @param user the user who created this comment
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns the string content of the comment
     *
     * @return the text body of the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the string content of this comment to a new string
     *
     * @param comment new text body for comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns the id of this comment. If comment is newly
     * constructed, the id will be 0.
     *
     * @return the id associated with this comment
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id for this new comment. Comment id should
     * only be set in the server and set once.
     *
     * @param id the id for this comment
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Compares two comments to find if they're equal by
     * comparing their id's.
     *
     * @param o the Object that is being compared with this comment
     * @return true if object id's are equal, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Comment comment1 = (Comment) o;
        return id == comment1.id;
    }
}
