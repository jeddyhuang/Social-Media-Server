import javax.swing.*;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

/**
 * Client
 * 
 * A class that represents the client that communicates with the server
 */
public class Client extends JComponent {
    private static final long serialVersionUID = 1L;
    private static Client client; // Client instance
    private final Socket socket; // Socket to connect to the server with
    private final ObjectOutputStream oos; // ObjectOutputStream to write objects to the server
    private final ObjectInputStream ois; // ObjectOutputStream to write objects to the server
    private boolean running = true; // whether Client is running
    private User user; // Reference to current user of the client

    /**
     * Constructs a client that connects to localhost at port 8888
     */
    public Client() throws IOException {
        socket = new Socket("localhost", 8888);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    // main
    public static void main(String[] args) {
        try {
            client = new Client();
        } catch (IOException e) {
            System.out.println("Couldn't establish connection!");
            closeSession();
            return;
        }

        if (client.loginOrSignUp()) {
            client.start();
        } else
            closeSession();

        try {
            client.socket.close();
        } catch (IOException e) {
            System.out.println("Couldn't close client socket, probably already closed");
        }
    }

    /**
     * Closes the Client's current session with the server
     */
    public static void closeSession() {
        GUI.dispose();
        System.out.println("Closing");
        if (client == null)
            return;
        try {
            if (client.socket != null && !client.socket.isClosed()) {
                client.send("EndSession");
                client.socket.close();
            }
            if (client.oos != null)
                client.oos.close();
            if (client.ois != null)
                client.ois.close();
            client.running = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Closed!");
    }

    /**
     * Sends a request to the Server to change username
     *
     * @param username the new username
     */
    public static void changeUsername(String username) {
        client.send("ChangeUsername", username);
    }

    /**
     * Sends a request to the Server to change password
     *
     * @param password the new password
     */
    public static void changePassword(String newPassword) {
        client.send("ChangePassword", newPassword);
    }

    /**
     * Sends a request to the Server to update a post with new data
     *
     * @param post the new post
     */
    public static void updatePostServer(Post post) {
        client.send("UpdatePost", post);
    }

    /**
     * Sends a request to the Server to remove a post
     *
     * @param the post to remove
     */
    public static void removePostServer(Post post) {
        client.send("RemovePost", post);
    }

    /**
     * Sends a request to the Server to update a comment with new data
     *
     * @param comment the new comment
     */
    public static void updateCommentServer(Comment comment) {
        client.send("UpdateComment", comment);
    }

    /**
     * Sends a request to the Server to remove a comment
     *
     * @param comment the comment to remove
     */
    public static void removeCommentServer(Comment comment) {
        client.send("RemoveComment", comment);
    }

    /**
     * Sends a request to the Server to delete the Client's account
     */
    public static void deleteAccount() {
        client.send("DeleteAccount");
    }

    /**
     * @return the Client's User object
     */
    public static User getUser() {
        return client.user;
    }

    /**
     * Prompts the user whether they want to register or login and does
     * the appropriate actions with the server in response
     */
    private boolean loginOrSignUp() {
        while (true) {
            int haveAccount = GUI.confirmDialog("Do you have a account");
            if (haveAccount == JOptionPane.CANCEL_OPTION
                    || haveAccount == JOptionPane.CLOSED_OPTION) {
                return false;
            }
            User tryUser = initializeUser();
            if (tryUser == null)
                continue;

            if (haveAccount == JOptionPane.YES_OPTION) {
                if (responseHandler(sendLogin(tryUser))) {
                    user = tryUser;
                    return true;
                }
            } else if (haveAccount == JOptionPane.NO_OPTION) {
                if (responseHandler(sendRegister(tryUser))) {
                    user = tryUser;
                    return true;
                }
            } else
                throw new IllegalArgumentException(
                        "User input does not conform to Yes, No, Cancel");
        }
    }

    /**
     * Prompts the user for a username and password and initializes a User object
     */
    private User initializeUser() {
        String username;
        String password;

        username = GUI.inputDialog("Enter a username");
        if (username == null)
            return null;

        password = GUI.inputDialog("Enter a password");
        if (password == null)
            return null;

        return new User(username, password);
    }

    /**
     * Updates the Client's view of Posts with the array recieved from Server
     *
     * @param postArr The recieved Object array from Server
     */
    private void updateAllPosts(Object[] postArr) {
        Post[] posts = Arrays.stream(postArr).map(object -> (Post) object).toArray(Post[]::new);
        GUI.updateAllPostsGUI(posts);
    }

    /**
     * Starts the GUI and communication with the server
     */
    private void start() {
        // start the gui
        GUI.startGUI();
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // start communication with server
        while (running) {
            try {
                if (socket.isClosed() || !socket.isConnected() || GUI.isDisposed()) {
                    closeSession();
                    return;
                }

                Protocol o = (Protocol) ois.readObject();
                String header = o.getHeader();
                Object obj = o.getObject();

                switch (header) {
                    case "AccountClosed", "Close" -> closeSession();
                    case "UpdateAllPosts" -> updateAllPosts((Object[]) obj);
                    case "UserId" -> user.setId((Integer) obj);
                    case "ChangeUsername" -> user.setUsername((String) obj);
                    case "Success" -> GUI.messageDialog((String) obj);
                    case "Error" -> GUI.errorDialog((String) obj);
                }
            } catch (ClassCastException | ClassNotFoundException | InvalidClassException e) {
                System.out.println("Unexpected Protocol Class" + e.getCause());
                return;
            } catch (IOException e) {
                System.out.println("IOException!");

                closeSession();
                return;
            }

        }
    }

    /**
     * Sends a protocol to server associated with
     * this client. Protocol consists of a description
     * header and any object associated.
     * <p>
     * Returns the response protocol from the server or
     * a local error protocol if it ran into an error
     *
     * @param header description header of object
     * @param obj    object being sent over socket
     * @return Protocol Protocol object send back in response from the server
     */

    private Protocol responseSend(String header, Object obj) {
        //response from server
        Protocol response;

        try {
            //sends file
            oos.writeObject(new Protocol(header, obj));
            oos.flush();

            //get the response
            response = (Protocol) ois.readObject();

        } catch (IOException e) {
            return new Protocol("Error", "Client: IO Exception");
        } catch (ClassNotFoundException e) {
            return new Protocol("Error", "Client: ClassNotFoundException");
        }
        return response;
    }

    /**
     * Sends a request to the server with a Protocol object
     *
     * @param header the header of the Protocol object
     * @param obj    the content of the request to send
     */
    private void send(String header, Object obj) {
        //response from server
        try {
            //sends file
            oos.writeObject(new Protocol(header, obj));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends an empty protocol with just a header
     *
     * @param header the header to send to the Server
     */
    private void send(String header) {
        send(header, null);
    }

    /**
     * Sends a register request to the Server
     *
     * @param user1 the user to register on the Server
     */
    public Protocol sendRegister(User user1) {
        return responseSend("Register", user1);
    }

    /**
     * Sends a login request to the Server
     *
     * @param user1 the user requesting to login
     */
    public Protocol sendLogin(User user1) {
        return responseSend("Login", user1);
    }


    /**
     * handles responses from server by showing the users the responses in the form of JOptionPanes
     * <p>
     * returns true if its a success response
     * returns false if it is an error response or neither response
     *
     * @param response Protocol response from server after sending a Protocol from client
     * @return boolean boolean where true is successful response and false is error response or neither response
     */

    public boolean responseHandler(Protocol response) {

        String responseHeader = response.getHeader();

        if (responseHeader.equals("Success")) {
            GUI.messageDialog((String) response.getObject());
            return true;
        } else if (responseHeader.equals("Error")) {
            GUI.errorDialog((String) response.getObject());
            return false;
        } else {
            GUI.errorDialog("Response Neither Success nor Error");
            return false;
        }

    }

}
