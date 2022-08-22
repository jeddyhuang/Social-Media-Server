import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Server
 * 
 * A Class that implements Runnable. Each instance connects to a
 * client and processes their requests.
 */
public class Server implements Runnable {
    private static final ArrayList<Server> CURRENT_CLIENTS =
            new ArrayList<>(); // List of server instances for each connected client
    private static final Map<String, User> USERS =
            new HashMap<>(); // Hash map of users accessible by their username
    private static final ArrayList<Post> POSTS =
            new ArrayList<>(); // List of all posts in the program
    private static final Map<Integer, Post> POST_MAP =
            new HashMap<>(); // Hash map of posts accessible by their ID
    private static final User mod = new User("moderator", "mod123"); // The moderator user
    private static int idCounter = 1; // The counter to keep track of used ID's
    private static boolean running = true; // Whether the server is currently running
    private final Object key = new Object(); // For synchronization purposes
    private final Socket socket; // The socket of connection between the server and client
    private final ObjectOutputStream oos; // Output stream for objects
    private final ObjectInputStream ois; // Input stream for objects
    private final InputStream is; // Input stream
    private boolean loggedIn = false; // Determines whether the user is logged in
    private boolean update = true; // Determines whether to update posts for users
    private User user; // The user connected to the server

    /**
     * Constructs a Server instance for a single Client
     *
     * @param socket the Client socket
     **/
    public Server(Socket socket) throws IOException {
        this.socket = socket;

        oos = new ObjectOutputStream(socket.getOutputStream());
        is = socket.getInputStream();
        ois = new ObjectInputStream(is);
        CURRENT_CLIENTS.add(this);

        mod.setId(idCounter++);
        USERS.put(mod.getUsername(), mod);
    }

    /**
     * Updates hashmap with new username.
     *
     * @param oldUsername changing from this username
     * @param newUsername changing to this username
     */
    public static void updateUserMapUsername(String oldUsername, String newUsername) {
        if (USERS.containsKey(oldUsername)) {
            User user1 = USERS.get(oldUsername);
            USERS.remove(oldUsername);
            USERS.put(newUsername, user1);
            System.out.print("User " + oldUsername + " changed their username to " + newUsername);
        }
    }

    /**
     * Listens in the server console for the word "Close"
     * and if that is written, closes the server.
     *
     * @param serverSocket serverSocket to close
     */
    private static void serverCloser(ServerSocket serverSocket) {
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String next = scanner.nextLine();
                if (next.equals("Close") || next.equals("close")) {
                    try {
                        System.out.println("Closing Server!");
                        for (Server server : CURRENT_CLIENTS) server.send("Close");

                        serverSocket.close();
                        running = false;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }).start();
    }

    /**
     * The main method
     */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            serverCloser(serverSocket);

            while (running) {
                try {
                    Socket socket = serverSocket.accept();
                    Server server = new Server(socket);
                    new Thread(server).start();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Couldn't establish server!");
            return;
        }
        System.out.println("Server closed");
    }

    /**
     * Checks to see if a password conforms to rules
     *
     * @param password the password to check
     */
    public static boolean passwordConforms(String password) {
        return !password.contains(" ");
    }

    /**
     * Marks all users to be updated with new data
     */
    private static void updateAllUsers() {
        for (Server server : CURRENT_CLIENTS) {
            if (server.loggedIn)
                server.notifyUpdate();
        }
    }

    /**
     * Checks if user exists in the system if it doesn't, add
     * user to the users map and the login the user.
     *
     * @param user1 user that is trying to sign-up
     */
    public void register(User user1) {
        if (USERS.containsKey(user1.getUsername())) {
            System.out.println("Username already exists");
            sendError("Username Already Exists");
        } else {
            if (!passwordConforms(user1.getPassword())) {
                sendError("Password does not conform!");
                return;
            }
            user1.setId(idCounter++);
            USERS.put(user1.getUsername(), user1);
            System.out.println("User " + user1.getUsername() + " registered");
            login(user1);
        }
    }

    /**
     * Checks if user exists in the system if it does, check if
     * the user password matches the password in the system. If it
     * does, send a LoggedIn message and then sends
     * POST_SENT_QUANTITY number of posts to the client.
     *
     * @param user1 user that is trying to login
     */
    public void login(User user1) {
        if (USERS.containsKey(user1.getUsername())) {
            User prospectiveLoginUser = USERS.get(user1.getUsername());

            if (prospectiveLoginUser.getPassword().equals(user1.getPassword())) {
                if (prospectiveLoginUser.getLoggedIn()) {
                    sendError("This user is already logged in");
                    return;
                }
                this.user = prospectiveLoginUser;
                user.setLoggedIn(true);
                System.out.println("User " + user1.getUsername() + " logged in");
                loggedIn = true;
                sendSuccess("Logged In");
                send("UserId", user1.getId(), false);
            } else {
                sendError("Received incorrect password");
            }
        } else {
            sendError("Received incorrect username");
        }
    }

    /**
     * Sends the posts to the Client
     *
     * @param postArr The array of posts to send
     */
    private void sendPostArray(Object[] postArr) {
        send("UpdateAllPosts", postArr, true);
    }

    /**
     * Sends an error to the client
     *
     * @param message the error message
     */
    public void sendError(String message) {
        send("Error", message, false);
    }

    /**
     * Sends a success to the client
     *
     * @param message the success message
     */
    public void sendSuccess(String message) {
        send("Success", message, false);
    }

    /**
     * Finds post with same id as testPost and returns
     * it. throws RuntimeException if the post is not in
     * the posts list.
     *
     * @param testPost post you are trying to find
     * @return returns the post found in the array
     */
    private Post findPost(Post testPost) {
        Post post = POST_MAP.get(testPost.getId());
        if (post != null)
            return post;
        throw new RuntimeException("Can't find existing post");
    }

    /**
     * Finds an existing comment in the program
     *
     * @param testComment The comment to find
     */
    private Comment findComment(Comment testComment) {
        Post parentPost = findPost(testComment.getParentPost());

        Comment comment = parentPost.findComment(testComment.getId());
        if (comment != null)
            return comment;
        throw new RuntimeException("Can't find existing comment");
    }

    /**
     * Adds or changes an existing comment with new data
     *
     * @param comment the comment to add or change
     */
    private void addOrChangeComment(Comment comment) {
        if (user == null || !user.getLoggedIn()) {
            sendError("You aren't Logged in! Closing session.");
            closeSession();
            return;
        }

        if (comment.getId() == 0) {
            Post parentPost = findPost(comment.getParentPost());
            comment.setId(idCounter++);
            comment.setUser(user);
            parentPost.addComment(comment);
            sendSuccess("Added new comment! ");
        } else {
            Comment foundComment = findComment(comment);

            if (!user.equals(foundComment.getUser()) || !user.equals(mod)) {
                sendError("You can only modify your own comments");
                return;
            }

            foundComment.setComment(comment.getComment());

            sendSuccess("Modified comment!");
        }
        updateAllUsers();
    }

    /**
     * Adds posts fetched from client to the user
     * posts list and the global server posts list.
     * Sends out a post update to each client
     * currently online.
     *
     * @param post post received by user
     */
    private void addOrChangePost(Post post) {
        if (user == null || !user.getLoggedIn()) {
            sendError("You aren't Logged in! Closing session.");
            closeSession();
            return;
        }

        if (post.getId() == 0) {
            post.setId(idCounter++);
            post.setUser(user);
            POSTS.add(post);
            POST_MAP.put(post.getId(), post);
            user.addPost(post);
            sendSuccess("Added new post!");
        } else {
            Post foundPost = findPost(post);

            if ((!user.equals(foundPost.getUser()) && !user.equals(mod))
                    && !foundPost.getContent().equals(post.getContent())) {
                sendError("You can only modify your own posts");
                return;
            }

            foundPost.setContent(post.getContent());
            foundPost.setPScore(post.getPScore());
            foundPost.setNScore(post.getNScore());

            for (int userId : post.getReactedUsers()) {
                foundPost.addReactedUser(userId);
            }

            sendSuccess("Modified post!");
        }
        updateAllUsers();
    }

    /**
     * Removes a post
     *
     * @param post the post to remove
     */
    private void removePost(Post post) {

        if (user == null || !user.getLoggedIn()) {
            sendError("You aren't Logged in! Closing session.");
            closeSession();
            return;
        }

        if (!user.equals(post.getUser()) && !user.equals(mod)) {
            sendError("You can only delete your own posts");
            return;
        }
        POST_MAP.remove(post.getId());
        POSTS.remove(post);
        sendSuccess("Removed" + post.getId());
        updateAllUsers();
    }

    /**
     * Remove a comment
     *
     * @param comment the comment to remove
     */
    private void removeComment(Comment comment) {

        if (user == null || !user.getLoggedIn()) {
            sendError("You aren't Logged in! Closing session.");
            closeSession();
            return;
        }

        if (!user.equals(comment.getUser()) && !user.equals(mod)) {
            sendError("You can only delete your own comment");
            return;
        }
        findPost(comment.getParentPost()).removeComment(comment);
        sendSuccess("Removed" + comment.getId());
        updateAllUsers();
    }

    /**
     * Sends a header only message to the client
     *
     * @param header the header to send
     */
    private boolean send(String header) {
        return send(header, null, false);
    }

    /**
     * Sends a protocol to client associated with
     * this server. Protocol consists of a description
     * header and any object associated.
     *
     * @param header description header of object
     * @param obj    object being sent over socket
     * @return boolean representing if object successfully sent
     */
    private boolean send(String header, Object obj, boolean reset) {
        try {
            synchronized (key) {
                if (reset)
                    oos.reset();
                oos.writeObject(new Protocol(header, obj));
                oos.flush();
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Deletes the current user's account
     */
    private void deleteAccount() {

        if (user == null || !user.getLoggedIn()) {
            sendError("You aren't Logged in! Closing session.");
            closeSession();
            return;
        }

        USERS.remove(user.getUsername());
        send("AccountClosed");
        closeSession();
    }

    /**
     * Called whenever a client closes their connection with the server.
     * Closes the socket and the I/O streams and removes this server
     * from the list of open servers.
     */
    private void closeSession() {
        try {
            if (socket != null)
                socket.close();
            if (oos != null)
                oos.close();
            if (ois != null)
                ois.close();

            if (loggedIn) {
                System.out.println("User " + user.getUsername() + " logged off");
            }
            user.setLoggedIn(false);
            loggedIn = false;
            // running = false;
            CURRENT_CLIENTS.remove(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Informs server instance that there has been a change
     * to a post or a comment and prompts it to send an
     * update at the nearest convenience.
     */
    public void notifyUpdate() {
        update = true;
    }

    /**
     * Runs a Server instance that loops over reading an object
     * from the ObjectInputStream. Converts object into a Protocol
     * and reads protocol header to execute necessary operations.
     * Exits when server is closed.
     */
    @Override
    public void run() {
        while (running) {
            if (socket.isClosed() || !socket.isConnected()) {
                closeSession();
                return;
            } else if (update && loggedIn) {
                sendPostArray(POSTS.toArray());
                update = false;
            }

            try {
                if (is.available() != 0) {
                    synchronized (key) {
                        Protocol o = (Protocol) ois.readObject();
                        String header = o.getHeader();
                        Object obj = o.getObject();

                        switch (header) {
                            case "Register" -> register((User) obj);
                            case "Login" -> login((User) obj);
                            case "UpdatePost" -> addOrChangePost((Post) obj);
                            case "RemovePost" -> removePost((Post) obj);
                            case "UpdateComment" -> addOrChangeComment((Comment) obj);
                            case "RemoveComment" -> removeComment((Comment) obj);
                            case "RefreshPosts" -> sendPostArray(POSTS.toArray());
                            case "EndSession" -> closeSession();
                            case "ChangePassword" -> user.setPassword((String) obj);
                            case "DeleteAccount" -> deleteAccount();
                            case "ChangeUsername" -> {
                                String newUsername = (String) obj;
                                if (!USERS.containsKey(newUsername)) {
                                    user.setUsername((String) obj);

                                    send("ChangeUsername", user.getUsername(), false);
                                    updateAllUsers();
                                } else sendError("Username already exists!");

                            }
                            default -> System.out.println("Unknown Header: " + header);
                        }
                    }
                }
            } catch (ClassCastException | InvalidClassException | ClassNotFoundException e) {
                System.out.println("Unexpected Protocol Class" + e.getCause());
                sendError("Unexpected Protocol Class");

            } catch (EOFException e) {
                closeSession();
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
