import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Post
 * 
 * A class that represents a post
 */
public class Post implements Serializable, Comparable<Post> {
    private static final long serialVersionUID = 1L;
    private final ArrayList<Comment> comments = new ArrayList<>(); // Comments on the post
    private final Map<Integer, Comment> commentMap =
            new HashMap<>(); // hashmap that contains all the comments related to the post
    private final LocalDateTime date; // Time of post
    private final ArrayList<Integer> reactedUsers =
            new ArrayList<>(); // List of IDs that reacted to the certain post
    public boolean isPoll; // determines if the post is a poll or not
    private int id; // id of the user that posted the content
    private String content; // String representing content of post
    private User user; // User who created the post
    private int pScore; // Score of positive reaction
    private int nScore; // Score of negative reaction

    /**
     * Constructs a post object
     *
     * @param content The content of the post text body
     */
    public Post(String content) {
        this.content = content;
        this.date = LocalDateTime.now();
        this.id = 0;
        this.pScore = 0;
        this.nScore = 0;
    }

    /**
     * Retrieves the time and date of the post creation
     *
     * @return The post's date and time as a LocalDateTime
     */
    public LocalDateTime getDateTime() {
        return date;
    }

    /**
     * Adds a user to the arraylist of users that reacted
     *
     * @param userId The new users id value
     */
    public void addReactedUser(int userId) {
        if (reactedUsers.contains(userId))
            return;
        reactedUsers.add(userId);
    }

    /**
     * Returns a array that contains the list of users that reacted (id value)
     *
     * @return Arraylist of users that reacted.
     */
    public ArrayList<Integer> getReactedUsers() {
        return reactedUsers;
    }

    /**
     * Retrieves users ID
     *
     * @return The users ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user
     *
     * @param id The new users id value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves positive score of the post
     *
     * @return The post's int positive score
     */
    public int getPScore() {
        return pScore;
    }

    /**
     * Sets the Positive Score of this post
     *
     * @param score The new positive score value
     */
    public void setPScore(int score) {
        pScore = score;
    }

    /**
     * Retrieves negative score of the post
     *
     * @return The post's int negative score
     */
    public int getNScore() {
        return nScore;
    }

    /**
     * Sets the Negative Score of this post
     *
     * @param score The new negative score value
     */
    public void setNScore(int score) {
        nScore = score;
    }

    /**
     * Retrieves the content
     *
     * @return The post's String content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of this post
     *
     * @param content The new content to set content to
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Adds a comment to the post
     *
     * @param comment the comment to add
     */
    public void addComment(Comment comment) {
        commentMap.put(comment.getId(), comment);
        comments.add(comment);
    }

    /**
     * Removes a comment to the post
     *
     * @param comment the comment to take away
     */
    public void removeComment(Comment comment) {
        commentMap.remove(comment.getId());
        comments.remove(comment);
    }

    /**
     * Retrieves a comment based off the users id
     *
     * @return The users comment
     */
    public Comment findComment(int id1) {
        return commentMap.get(id1);
    }

    /**
     * Retrieves the post's comments
     *
     * @return The post's comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Retrieves the user who created the post
     *
     * @return the user that created this post
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user of this post. This should only be set
     * in the server and only set once.
     *
     * @param user The user who created this post
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Compare function
     *
     * @param o post you are comparing
     */
    @Override
    public int compareTo(Post o) {
        return o.getDateTime().compareTo(getDateTime());
    }

    /**
     * Equals function
     *
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Post post = (Post) o;
        return id == post.id;
    }
}
