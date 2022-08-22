import java.io.Serializable;

/**
 * Protocol
 * 
 * This Class is a serializable protocol function
 * that is used for internet communication.
 * 
 * Headers:
 * Register -> registers new user, then logs them in
 * Login -> logs in existing user
 * UpdatePost -> sends post to server
 * LoadPost -> get posts from server to client
 * UpdateAllPosts -> sends arraylist of all posts to client
 * RefreshPost -> no current functionality ;)
 * Error (String) -> there was an error in the transaction and gives the error message
 * Success (String) -> shows that there was a successful transaction and gives a success message
 * EndSession -> client tells server to close session
 */
public class Protocol implements Serializable {
    private final Object object; // main object associated with internet transfer
    private final String header; // header explaining specific protocol

    /**
     * Creates a new Protocol with a header and an object
     *
     * @param header header describing contents of protocol
     * @param object the Object content of this protocol
     */
    public Protocol(String header, Object object) {
        this.object = object;
        this.header = header;
    }

    /**
     * Gets protocol object.
     *
     * @return the object associated with this Protocol
     */
    public Object getObject() {
        return object;
    }

    /**
     * Gets protocol header.
     *
     * @return the header String value
     */
    public String getHeader() {
        return header;
    }
}
