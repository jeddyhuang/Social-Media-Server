import java.io.Serializable;
import java.util.ArrayList;

/**
 * User
 * 
 * Class that carries all the information about the User: posts, username, id, password
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private final ArrayList<Post> posts; // The posts that the user makes
    private String username; // The users username
    private String password; // The users password
    private int id; // The users id
    private boolean loggedIn; // Whether the user is logged in

    /**
     * Constructs a User object with the specific parameters.
     *
     * @param username Users specific username
     * @param password Users specific password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        posts = new ArrayList<>();
        id = 0;
        loggedIn = false;
    }

    /**
     * Adding a post that the user makes.
     *
     * @param post post is added to the general array
     */
    public void addPost(Post post) {
        posts.add(post);
    }

    /**
     * Returns the users username
     *
     * @return a String of a Users username returned.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the users username. This should only be called
     * by the server.
     *
     * @param username the Users new username
     */
    public void setUsername(String username) {
        Server.updateUserMapUsername(this.username, username);
        this.username = username;
    }

    /**
     * Retrieves whether the user is logged in
     *
     * @return a boolean on whether the user is logged in
     */
    public boolean getLoggedIn() {
        return loggedIn;
    }

    /**
     * Sets whether the user is logged in or not, should only be called by the server
     *
     * @param loggedIn the new loggedIn value
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * Returns the users password
     *
     * @return a String of a Users password returned.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the users password
     *
     * @param password the Users new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the users id
     *
     * @return the Int value of the Users Id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets te id of a user. This id should only be
     * set in the server and only set once.
     *
     * @param id the users id number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Compares two users to find if they're equal by
     * comparing their id's.
     *
     * @param o the Object that is being compared with this user
     * @return true if object id's are equal, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        if (this == o)
            return true;
        User u = (User) o;

        return u.id == id;
    }

    /**
     * Returns the users posts
     *
     * @return an Arraylist of the Users posts
     */
    public ArrayList<Post> getPosts() {
        return posts;
    }
}
