import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

/**
 * Post Component
 * 
 * A class that represents the GUI for a post
 */
public class PostComponent extends JComponent {

    private static final long serialVersionUID = 1L;

    private Post post; // Variable referencing the post.

    private JButton usernameButton; //Button on a post with a username
    private JButton optionsButton; // Options Button that allows the user to edit and delete
    private JTextArea textArea; // textArea that holds the information for each post
    private JLabel timeStamp; // Label that holds information on when the post or comment was posted
    private JButton commentButton; // Button that allows a user to comment on a specific post
    private JPanel emojiHold; // Panel that holds the two emojis sad/smile
    private JButton happyFace; // Button that represents a smile face emoji that a user can click
    private JButton sadFace; // Button that represents a sad face emoji that a user can click
    private JLabel nScore; // Value of the Negative
    private JLabel pScore; // Value of the Positive
    /**
     * Creates many action listeners that detects when buttons are pressed..
     */
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == commentButton) {
                String comment = JOptionPane.showInputDialog(null,
                        "Enter your comment: ", "Create Comment", JOptionPane.INFORMATION_MESSAGE);
                if (comment == null)
                    return;
                Comment add = new Comment(comment, post);
                Client.updateCommentServer(add);
            }

            if (e.getSource() == optionsButton) {
                String[] options = {"Cancel", "Delete", "Edit"};

                int option = JOptionPane.showOptionDialog(null, "Action?", "Click a button",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                        options[0]);

                if (option == 1) {
                    Client.removePostServer(post);
                } else if (option == 2) {
                    String input = JOptionPane
                            .showInputDialog(null, "Enter your post", "Edit Post",
                                    JOptionPane.PLAIN_MESSAGE, null, null, post.getContent())
                            .toString();

                    if (input == null)
                        return;

                    post.setContent(input);
                    Client.updatePostServer(post);
                }
            }
            if (e.getSource() == usernameButton) {
                String[] options = {"Cancel", "Comments", "Posts"};
                int choice = JOptionPane.showOptionDialog(null, "View User",
                        "What do you want to view from user " + post.getUser() + "?",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (choice == 1) {
                    GUI.viewPosts = false;
                } else if (choice == 2) {
                    GUI.viewPosts = true;
                } else {
                    return;
                }
                GUI.viewingUser = true;
                GUI.userViewing = post.getUser().getId();
                GUI.createFrame();
            }
            if (e.getSource() == happyFace) {
                if (post.getReactedUsers().contains(Client.getUser().getId())) {
                    GUI.errorDialog("You already reacted to this post!");
                    return;
                }
                post.setPScore(post.getPScore() + 1);
                post.addReactedUser(Client.getUser().getId());
                Client.updatePostServer(post);
            }
            if (e.getSource() == sadFace) {
                if (post.getReactedUsers().contains(Client.getUser().getId())) {
                    GUI.errorDialog("You already reacted to this post!");
                    return;
                }
                post.setNScore(post.getNScore() + 1);
                post.addReactedUser(Client.getUser().getId());
                Client.updatePostServer(post);
            }
        }
    };

    /**
     * Constructs a post GUI component
     *
     * @param post The post that is represented by the GUI component
     */
    public PostComponent(Post post) {
        super();

        //        Font myFont = new Font("Apple Color Emoji", Font.BOLD, 12);
        //        String happy = "\uD83D\uDE00";
        //        String sad = "\uD83D\uDE41";
        //        int happyCodepoint = happy.codePointAt(happy.offsetByCodePoints(0, 0));
        //        int sadCodepoint = sad.codePointAt(sad.offsetByCodePoints(0, 0));
        //        char happyChar[] = {Character.highSurrogate(happyCodepoint),
        //                Character.lowSurrogate(happyCodepoint)};
        //        char sadChar[] = {Character.highSurrogate(sadCodepoint),
        //                Character.lowSurrogate(sadCodepoint)};

        this.post = post;
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(border);
        usernameButton = new JButton(post.getUser().getUsername());
        optionsButton = new JButton("...");
        textArea = new JTextArea(post.getContent());

        timeStamp = new JLabel(
                post.getDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        emojiHold = new JPanel();

        sadFace = new JButton();
        happyFace = new JButton();

        if (!post.isPoll) {
            try {
                Image img = ImageIO.read(getClass().getResource("happy.png"))
                        .getScaledInstance(30, 20, Image.SCALE_DEFAULT);

                happyFace.setIcon(new ImageIcon(img));
                Image img2 = ImageIO.read(getClass().getResource("sadface.png"))
                        .getScaledInstance(30, 20, Image.SCALE_DEFAULT);

                sadFace.setIcon(new ImageIcon(img2));
            } catch (Exception e) {
                System.out.println("noimage");
            }

        } else {
            sadFace.setText("No");
            happyFace.setText("Yes");
        }

        nScore = new JLabel(post.getNScore() + "");
        pScore = new JLabel(post.getPScore() + "");

        emojiHold.add(happyFace);
        emojiHold.add(pScore);
        emojiHold.add(sadFace);
        emojiHold.add(nScore);

        happyFace.addActionListener(actionListener);
        sadFace.addActionListener(actionListener);

        commentButton = new JButton("Comment");
        commentButton.addActionListener(actionListener);
        optionsButton.addActionListener(actionListener);
        usernameButton.addActionListener(actionListener);

        JScrollPane scrPane = new JScrollPane(textArea);
        scrPane.setPreferredSize(new Dimension(100, 50));

        setLayout(new BorderLayout()); // Sets frames layout to FlowLayout
        JPanel main = new JPanel();
        JPanel posty = new JPanel();
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea.setColumns(10);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        GridBagLayout layout = new GridBagLayout();
        posty.setLayout(layout);
        GridBagConstraints s = new GridBagConstraints();

        s.fill = GridBagConstraints.HORIZONTAL;
        s.gridwidth = 1;
        s.gridx = 0;
        s.gridy = 0;
        posty.add(usernameButton, s);
        s.fill = GridBagConstraints.HORIZONTAL;
        s.gridwidth = 1;
        s.gridx = 3;
        s.gridy = 0;
        posty.add(optionsButton, s);
        s.fill = GridBagConstraints.HORIZONTAL;
        s.ipadx = 250;
        s.gridwidth = 1;
        s.gridx = 1;
        s.gridy = 1;
        posty.add(scrPane, s);
        s.ipadx = 0;
        s.fill = GridBagConstraints.HORIZONTAL;
        s.gridwidth = 1;
        s.gridx = 0;
        s.gridy = 3;

        posty.add(timeStamp, s);
        s.fill = GridBagConstraints.HORIZONTAL;
        s.gridwidth = 1;
        s.gridx = 3;
        s.gridy = 3;
        posty.add(commentButton, s);
        s.fill = GridBagConstraints.HORIZONTAL;
        s.gridwidth = 1;
        s.gridx = 1;
        s.gridy = 3;
        posty.add(emojiHold, s);

        main.setLayout(new BoxLayout(
                main, BoxLayout.Y_AXIS)); // Setting the JPanel main to be aligned to the left
        main.add(posty);
        // for (int i = 0; i<post.getComments().size(); i++) {
        //   main.add(new CommentComponent(post.getComments().get(i)));
        // }

        add(main);
    }

    /**
     * Returns the post
     *
     * @return the post of the component
     */
    public Post getPost() {
        return post;
    }
}
