import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

/**
 * Comment Component
 * 
 * class that represents the GUI component for a comment
 */
public class CommentComponent extends JComponent {
    private static final long serialVersionUID = 1L;

    private final Comment comment; // The comment that the component represents

    private final JButton
            usernameButton; // The user of the comment and the button to access the user's posts
    private final JButton optionsButton; // Options button that allows the user to edit the comment
    /**
     * Creates many action listeners that detects when buttons are pressed..
     */
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == optionsButton) {
                String[] options = {"Cancel", "Delete", "Edit"};

                int option = JOptionPane.showOptionDialog(null, "Action?", "Click a button",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                        options[0]);

                if (option == 1) {
                    Client.removeCommentServer(comment);
                } else if (option == 2) {
                    String newMessage = JOptionPane.showInputDialog(null,
                            "Enter New Comment Here:", "Edit Comment", JOptionPane.QUESTION_MESSAGE);

                    if (newMessage == null)
                        return;

                    comment.setComment(newMessage);
                    Client.updateCommentServer(comment);
                }
            }
            if (e.getSource() == usernameButton) {
                System.out.println();
                String[] options = {"Cancel", "Comments", "Posts"};
                int choice = JOptionPane.showOptionDialog(null, "View User",
                        "What do you want to view from user " + comment.getUser() + "?",
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
                GUI.userViewing = comment.getUser().getId();
                GUI.createFrame();
            }
        }
    };

    /**
     * Constructs a comment GUI component
     *
     * @param comment The comment that is represented by the GUI component
     */
    public CommentComponent(Comment comment) {
        super();

        this.comment = comment;
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(border);

        usernameButton = new JButton(comment.getUser().getUsername());
        optionsButton = new JButton("...");
        JTextArea textArea = new JTextArea(comment.getComment());

        usernameButton.addActionListener(actionListener);

        JScrollPane scrPane = new JScrollPane(textArea);
        scrPane.setPreferredSize(new Dimension(50, 50));

        setLayout(new BorderLayout()); // Sets frames layout to FlowLayout
        JPanel main = new JPanel();
        JPanel posty = new JPanel();
        JLabel timeStamp = new JLabel(
                comment.getDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea.setColumns(10);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        GridBagLayout layout = new GridBagLayout();
        posty.setLayout(layout);
        GridBagConstraints s = new GridBagConstraints();
        optionsButton.addActionListener(actionListener);
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
        s.ipadx = 200;
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

        main.setLayout(new BoxLayout(
                main, BoxLayout.Y_AXIS)); // Setting the JPanel main to be aligned to the left

        main.add(posty);
        add(main);
    }
}
