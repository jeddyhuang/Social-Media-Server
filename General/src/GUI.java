import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * GUI.java
 * 
 * Class that carries all the GUI used towards the client.
 */
public class GUI implements Runnable {
    public static final String TITLE = "Social Media"; // Title for GUI windows
    public static JButton cPostButton; // a button to create posts
    public static JButton postButton; // a button to look at all posts
    public static JMenuBar menuBar; // Menu bar with user options
    public static JMenu accountSettings; // Account settings drop down menu
    public static JMenu usernameDisplay;
    public static JPanel main; // The main panel consisting of posts and comments
    public static JPanel options; // Options panel that has buttons for the user
    public static JFrame frame; // The frame that holds the GUI components
    public static boolean viewPosts = false;
    public static boolean viewingUser = false;
    public static int userViewing;
    public static ArrayList<PostComponent> pc; // The components for the posts
    private static boolean disposed = false;
    private JMenuItem changeUsername; // Menu action to change username
    private JMenuItem deleteAccount; // Menu action to delete account
    private JMenuItem changePassword; // Menu action to change password
    private JMenuItem logout; // Menu action to logout
    /**
     * Creates many action listeners that detects when buttons are pressed..
     */
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == postButton) {
                GUI.viewingUser = false;
                createFrame();
            } else if (e.getSource() == cPostButton) {
                String[] userOptions = {"Cancel", "Post", "Poll"};
                int option =
                        JOptionPane.showOptionDialog(null, "Do you want to make a post or poll?",
                                "Choose a post type", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, userOptions, userOptions[0]);
                if (option == 0)
                    return;
                else if (option == 1) {
                    String post = JOptionPane.showInputDialog(
                            null, "Enter your post", "Create Post", JOptionPane.INFORMATION_MESSAGE);
                    if (post == null)
                        return;

                    Post p = new Post(post);
                    Client.updatePostServer(p);
                } else if (option == 2) {
                    String post = JOptionPane.showInputDialog(
                            null, "Enter your poll: ", "Create Poll", JOptionPane.INFORMATION_MESSAGE);
                    if (post == null)
                        return;

                    Post p = new Post(post);
                    p.isPoll = true;
                    Client.updatePostServer(p);
                }
            } else if (e.getSource() == changeUsername) {
                String newUsername = JOptionPane.showInputDialog(
                        null, "Enter new username: ", TITLE, JOptionPane.PLAIN_MESSAGE);
                if (newUsername != null) {
                    Client.changeUsername(newUsername);
                }
            } else if (e.getSource() == changePassword) {
                String newPassword = JOptionPane.showInputDialog(
                        null, "Enter new password: ", TITLE, JOptionPane.PLAIN_MESSAGE);
                if (newPassword != null) {
                    Client.changePassword(newPassword);
                }
            } else if (e.getSource() == logout) {
                frame.dispose();
                disposed = true;
                Client.closeSession();
            } else if (e.getSource() == deleteAccount) {
                Client.deleteAccount();
            }
        }
    };

    /**
     * Begins the run method that shows the GUI
     */
    public static void startGUI() {
        SwingUtilities.invokeLater(new GUI());
    }

    /**
     * Updates the GUI with the given posts
     *
     * @param posts The updated posts to draw on to the GUI
     */
    public static void updateAllPostsGUI(Post[] posts) {
        pc.clear();
        List<Post> postList = Arrays.asList(posts);
        Collections.sort(postList);
        for (Post post : postList) {
            pc.add(new PostComponent(post));
        }
        createFrame();
    }

    /**
     * Disposes the frame
     */
    public static void dispose() {
        if (frame != null)
            frame.dispose();
    }

    /**
     * Returns if the frame has been disposed
     *
     * @return boolean on whether the frame has been disposed
     */
    public static boolean isDisposed() {
        return disposed;
    }

    /**
     * Creates the frame and GUI components
     */
    public static void createFrame() {
        if (viewingUser) {
            createUserFrame(userViewing);
            return;
        }

        frame.getContentPane().removeAll();
        main.removeAll();

        usernameDisplay.setText(Client.getUser().getUsername());

        int numOfComments = 0;
        for (PostComponent postComp : pc) {
            numOfComments += postComp.getPost().getComments().size();
        }

        main.setLayout(new GridLayout(pc.size() + numOfComments, 1));

        for (PostComponent postComp : pc) {
            main.add(postComp);
            for (Comment comment : postComp.getPost().getComments()) {
                main.add(new CommentComponent(comment));
            }
        }

        JScrollPane scrPane = new JScrollPane(main);

        scrPane.setPreferredSize(new Dimension(600, 550));
        frame.add(menuBar, BorderLayout.NORTH);
        frame.add(scrPane, BorderLayout.CENTER);

        frame.add(options, BorderLayout.SOUTH);
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.validate();
        frame.repaint();
    }

    /**
     * Creates the frame and GUI components specifically for a users Id
     *
     * @param id that represents a user
     */
    public static void createUserFrame(int id) {
        frame.getContentPane().removeAll();
        main.removeAll();

        int numOfComments = 0;
        int numOfPosts = 0;
        for (PostComponent postComp : pc) {
            for (Comment comment : postComp.getPost().getComments()) {
                if (comment.getUser().getId() == id) {
                    numOfComments++;
                }
            }
            if (postComp.getPost().getUser().getId() == id)
                numOfPosts++;
            // numOfComments += postComp.getPost().getComments().size();
        }

        System.out.println("User with ID: " + id + " has " + numOfComments + " comments");
        System.out.println("User with ID: " + id + " has " + numOfPosts + " posts");

        if (viewPosts)
            main.setLayout(new GridLayout(numOfPosts, 1));
        else
            main.setLayout(new GridLayout(numOfComments, 1));

        for (PostComponent postComp : pc) {
            if (viewPosts) {
                if (postComp.getPost().getUser().getId() == id) {
                    main.add(postComp);
                }
            } else {
                for (Comment comment : postComp.getPost().getComments()) {
                    if (comment.getUser().getId() == id)
                        main.add(new CommentComponent(comment));
                }
                // for (Comment comment : postComp.getPost().getComments()) {
                //    System.out.println(comment.getUser().getUsername());
                //    System.out.println(comment.getUser().getId());
                //}
            }
        }

        JScrollPane scrPane = new JScrollPane(main);

        scrPane.setPreferredSize(new Dimension(600, 550));
        frame.add(menuBar, BorderLayout.NORTH);
        frame.add(scrPane, BorderLayout.CENTER);

        frame.add(options, BorderLayout.SOUTH);
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.validate();
        frame.repaint();
    }

    /**
     * wrapper for JOptionPane.showConfirmDialog()
     *
     * @param message message shown in the dialog
     * @return the user's choice
     */
    public static int confirmDialog(String message) {
        return JOptionPane.showConfirmDialog(
                null, message, TITLE, JOptionPane.YES_NO_CANCEL_OPTION);
    }

    /**
     * wrapper for Error JOptionPane.showMessageDialog()
     *
     * @param message the error message to display
     */
    public static void errorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, TITLE, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Wrapper for Information Message JOptionPane.showMessageDialog()
     *
     * @param message The message to display
     */
    public static void messageDialog(String message) {
        JOptionPane.showMessageDialog(null, message, TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * wrapper for JOptionPane.showInputDialog();
     *
     * @param message message shown on dialog window
     * @return input String that the user inputted
     */
    public static String inputDialog(String message) {
        return JOptionPane.showInputDialog(null, message, TITLE, JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Run method that contains the different JFrames and JPanels.
     */
    public void run() {
        frame = new JFrame("Social Media");

        cPostButton = new JButton("Create Post");
        postButton = new JButton("All Posts");

        menuBar = new JMenuBar();
        accountSettings = new JMenu("Settings");
        usernameDisplay = new JMenu(Client.getUser().getUsername());
        menuBar.add(usernameDisplay);
        menuBar.add(accountSettings);
        changeUsername = new JMenuItem("Change Username");
        deleteAccount = new JMenuItem("Delete Account");
        changePassword = new JMenuItem("Change Password");
        logout = new JMenuItem("Logout");
        changeUsername.addActionListener(actionListener);
        changePassword.addActionListener(actionListener);
        deleteAccount.addActionListener(actionListener);
        logout.addActionListener(actionListener);
        accountSettings.add(changeUsername);
        accountSettings.add(changePassword);
        accountSettings.add(logout);
        accountSettings.add(deleteAccount);

        pc = new ArrayList<>();

        frame.getContentPane().setLayout(new BorderLayout());

        options = new JPanel();
        main = new JPanel();

        postButton.addActionListener(actionListener);
        cPostButton.addActionListener(actionListener);

        options.add(postButton);
        options.add(cPostButton);

        createFrame();

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                disposed = true;
                Client.closeSession();
            }
        });

        frame.setResizable(false);
        frame.setSize(620, 650);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
