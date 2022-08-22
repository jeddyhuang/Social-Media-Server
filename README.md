# Social Media Server

## Class Documentation

### Server Description
This class has static data representations of users and posts. The Server main 
method waits for a connection from a client, and upon connection, creates a new
server instance running on a new server thread. Each server thread waits for the
Client to send a protocol over the ObjectInputStream, then handles that Protocol
accordingly. Protocol Headers that can be handled include "Login", "Register", 
"UpdatePost", "RemovePost", "UpdateComment", "RemoveComment", "DeleteAccount" and
a few others. After any post is updated, the Server sends the PostArray to all
users currently online. 

### Server Testing
The relevant testing for the Server Class were executed within the ServerTest by RunLocalTest. The testing done by ServerTest are the following:
- Verifies that the Server class exists and inherits from the correct superclass
- Verifies that every field within the Server class exists as well as having the correct type and access modifier
- Verifies that every method within the Server class exists as well as having the correct return type, access modifier and exceptions thrown

**This only tests how the Server reacts to certain actions**
1. Start the Server
2. Start the Client
    - A JOptionPane asking whether you have an account with three options should pop up
    - No should prompt for a username and password with JOptionPane's
    - Yes should do the same thing as No
3. Press No
4. Enter user1 as username
5. Enter pass as password
    - Server console should print and a frame should appear
        - User user1 registered
6. Click Create Post, Post, then enter "I am user1", then Ok
7. Repeat the steps 3-5 by running another client
    - An error pop up should show up indicating that the username is already taken
8. Do step 7 again except with username: "user2"
    - Both Clients should be able to see the post made in step 6
10. Do step 6 for user2 with the content "I am user2"
    - Both Clients view's should be updated with the new post
12. For user1, click Settings then change username and enter user3
    - All occurences of user1 should change to user3
13. For both Client's, click on Settings, then Logout
    - All posts should persist showing the Server stores the data
14. Log back into user1 with password pass
    - This should say that the username is incorrect, because user1 no longer exists
15. Log back into user3 with password pass
    - This should work since user1 from before is now user3
17. Click on a ... button on a post, click Edit, and change the content.
    - One of two things should happen
        - If the user logged in owns the post then both Client's views should be updated with the new post content        
        - Otherwise an error dialog will pop up indicating you can only modify your own posts
18. Repeat 15 with from a different Client in order to test the other possibility
19. Click on a ... button on a post and click Delete
    - One of two things should happen
        - If the user logged in owns the post then both Client's views should no longer see the post
        - Otherwise an error dialog will pop up indicating you can only delete your own posts
20. Repeat 17 with a different Client in order to test the other possibility
21. Click comment on a post, and enter "this is a comment", and click Ok
    - This should update both views with a new comment that appears below the post that was commented on
22. Click on a ... button on the comment, click Edit, and change the content.
    - One of two things should happen
        - If the user logged in owns the comment then both Client's views should be updated with the new comment content        
        - Otherwise an error dialog will pop up indicating you can only modify your own comments
23. Repeat 20 with from a different Client in order to test the other possibility
24. Click on a ... button on the comment and click Delete
    - One of two things should happen
        - If the user logged in owns the comment then both Client's views should no longer see the comment
        - Otherwise an error dialog will pop up indicating you can only delete your own comments
25. Repeat 22 with a different Client in order to test the other possibility
26. On one of the Clients, click Settings, then Change Password, then enter "pass123", then Ok
27. Then click Settings and Logout on that Client
28. Attempt to log back in with the old password "pass"
    - This should say that the password is incorrect, because it was just changed
29. Attempt to log back in with the new password "pass123"
    - This should work
30. Click on a posts reaction button
    - This should add to the number to the right
    - Both Client's should be updated with the new number
31. Attempt to react to that post again
    - This should show an error dialog pop up because you can only react once to a post
32. Finally, on one of the Clients, Click Settings, then Delete Account
    - This should close the Client 
    - The user should be deleted
    - Posts and comments made by the user should persist despite the user no longer existing
    - Attempting to log in to the user again will not work, since the user should be removed from the Server

### Client Description
A class that operates as the middleman between the Server and the GUI. The Client
main method is run by a user at which point it will create a connection between
it and the server. It will then run a loginOrSignup method that issues a series
of JOptionPane dialogues to the user walking them through the login process. Once
they have successfully logged in, the client will listen for protocol messages
from the server and update the GUI via GUI static functions as needed. Client also
has a static client variable representing your client and has static methods for the
GUI to call that send messages to the server when content is modified.

### Client Testing
The relevant testing for the Client Class were executed within the ClientTest by RunLocalTest. The testing done by ClientTest are the following:
- Verifies that the Client class exists and inherits from the correct superclass
- Verifies that every field within the Client class exists as well as having the correct type and access modifier
- Verifies that every method within the Client class exists as well as having the correct return type, access modifier and exceptions thrown

Testing the Client should follow the same procedure as Server and as GUI since it behaves as the middleman,
if the expected results from following each procedure is met, it shows that the Client is working correctly.
In order to test Client, perform the testing for GUI and the testing for Server.

### Protocol Description
A class that represents the information sent over the web socket between the Client
and Server. This class an object field that could represent ay object and an header
field that is a brief String description of the contents of this protocol. The server
and client should be aware of all headers that are sent to them. The Protocol class
is serealizeable to allow for transfer over an ObjectOutputStream.

### Protocol Testing
The relevant testing for the Protocol Class were executed within the ProtocolTest by RunLocalTest. The testing done by ProtocolTest are the following:
- Verifies that the Protocol class exists and inherits from the correct superclass
- Verifies that every field within the Protocol class exists as well as having the correct type and access modifier
- Verifies that every method within the Protocol class exists as well as having the correct return type, access modifier and exceptions thrown
- Verifies that every method within the Protocol class properly functions with both valid and invalid inputs.

### Post Description
A class representing a post in the program. Contains all the data for a post and 
is compareable by DateTime in order to sort by when it was create. Post is also 
Serializable in order to be able to be sent over Object streams.

### Post Testing
The relevant testing for the Post Class were executed within the PostTest by RunLocalTest. The testing done by PostTest are the following:
- Verifies that the Post class exists and inherits from the correct superclass
- Verifies that every field within the Post class exists as well as having the correct type and access modifier
- Verifies that every method within the Post class exists as well as having the correct return type, access modifier and exceptions thrown
- Verifies that every method within the Post class properly functions with both valid and invalid inputs.

### Comment Description
A class representing a comment in the program. Contains all the data for a comment and 
is Serializable to be able to be sent over Object streams.

### Comment Testing
The relevant testing for the Comment Class were executed within the CommentTest by RunLocalTest. The testing done by CommentTest are the following:
- Verifies that the Comment class exists and inherits from the correct superclass
- Verifies that every field within the Comment class exists as well as having the correct type and access modifier
- Verifies that every method within the Comment class exists as well as having the correct return type, access modifier and exceptions thrown
- Verifies that every method within the Comment class properly functions with both valid and invalid inputs.

### User Description
A class representing a user in the program. Contains all the data for a User such as
their username, ID, password, comments, and posts. User is serializable in order to be
able to be sent over Object streams.

### User Testing
The relevant testing for the User Class were executed within the CommentTest by RunLocalTest. The testing done by CommentTest are the following:
- Verifies that the User class exists and inherits from the correct superclass
- Verifies that every field within the User class exists as well as having the correct type and access modifier
- Verifies that every method within the User class exists as well as having the correct return type, access modifier and exceptions thrown
- Verifies that every method within the User class properly functions with both valid and invalid inputs.

### GUI Description
Class that represents the GUI that is displayed to the Client and handles all interaction between the user 
and the client. 
The GUI displays a frame that consists of a "main" panel and "options" panel. 
The main panel consists of the GUI representations of Posts and Comments while 
the options panel consists of the button options for viewing and creating posts/polls.
The GUI class also handles the top menu bar with account options and information such as
deleting accounts, logging out, and changing usernames and passwords. 

### GUI Testing
The relevant testing for the GUI Class were executed within the GUITest by RunLocalTest. The testing done by GUITest are the following:
- Verifies that the GUI class exists and inherits from the correct superclass
- Verifies that every field within the GUI class exists as well as having the correct type and access modifier
- Verifies that every method within the GUI class exists as well as having the correct return type, access modifier and exceptions thrown
- Verifies that each button and panel has own action listener that will allow it to be functional 

**Disclaimer**
This testing only tests the GUI functionality and not the functionality of the Server 
or the Client networking. All expected results documented here 
is strictly in the scope of how only the GUI class reacts.

1. Start the Server
2. Start the Client
    - A JOptionPane asking whether you have an account with three options should pop up
    - Cancel should end the Client
        - All cancel buttons should cancel whatever action the user was currently doing
    - No should prompt for a username and password with JOptionPane's
    - Yes should do the same thing as No
3. Press No
4. Enter a username
5. Enter a password
    - A frame should appear
    - The top should have a menu bar with two items
        - First menu item should be the username you entered
        - Second should be Settings, clicking on it should show a dropdown
            - The dropdown contains:
                - Change Username
                    - Clicking should display a JOptionPane prompt for a new username   
                - Change Password
                    - Clicking should display a JOptionPane prompt for a new password   
                - Logout
                    - Should close the GUI and terminate the program
                - Delete Account
                    - Should close the GUI and terminate the program
    - The bottom should have two buttons
        - Create Post should prompt for whether the user wants to make a post or poll
            - After selecting, the user should be prompted for the content of their post
        - All Posts functionality should be to return the user to viewing all posts after 
          selecting to view only one user's posts or comments

### PostComponent Description
The PostComponent is the GUI representation of a Post in the program. It consists of 5 buttons,
a label, and a text area. The buttons are for displaying the user of the post, further options of the user
a button to comment on the post, and reacting to the post or poll. If a post is a poll, the reactions 
will be Yes and No instead of emojis. The label displays the time of the post in 24 hour format.

### PostComponent Testing
The relevant testing for the PostComponent Class were executed within the PostComponentTest by RunLocalTest. The testing done by PostComponentTest are the following:
- Verifies that the PostComponent class exists and inherits from the correct superclass
- Verifies that every field within the PostComponent class exists as well as having the correct type and access modifier
- Verifies that every method within the PostComponent class exists as well as having the correct return type, access modifier and exceptions thrown

Creating the PostComponent 
When creating creating a post component, we had an initial panel that would hold all the components. We would create Buttons and Textfields to fill the panel. We came to the conclusion that GridBagLayout would be the most versitile for the best results. Before adding any components, we would need to set the width of the the layout. After playing around, we decided that one was the best size. After this, we would add more peices starting with the location of 0,0. Once this initial peice was added, we could add other buttons where we wanted with different x and y values. Buttons also had to have different sizes in order to be visually appealing for the user. For the post, we knew that it was a centeral component so we added padding on the xaxis of 250. Other buttons, we did not need to pad as much as they are less significant. Once this post component was completed, we would pass it to the GUI method so it could add it to the main JScrollPane that would be presented to the user. Finally, once all the visual aspects were completed, we needed to make sure that all the components of the post had its own action listener for the buttons to be functional. 

1. Click on the username
    - The user should be prompted whether they want to view the post's user's comments or posts
2. Click on the ... button
    - The user should be prompted whether they want to edit or delete the post
        - Deleting a post should remove it 
        - Editing a post should prompt for the new content of the post
3. Click on the Comment button 
    - The user should be prompted to enter a comment for the post
4. Click on a reaction
    - The user should get either a Modified Post or error dialog depending on whether
      they have reacted to that post before
5. The label should display the correct time for the original date and time in 24 hour format
   that the post was created. 

### CommentComponent Description
The CommentComponent is the GUI representation of a Comment in the program. It consists of 
2 buttons, a text area, and a label. The buttons represent the user of the comment and 
further options. The text area holds the content of the comment. The label displays the
date and time of the creation of the comment in 24 hour format.

### CommentComponent Testing
The relevant testing for the CommentComponent Class were executed within the CommentComponentTest by RunLocalTest. The testing done by CommentComponentTest are the following:
- Verifies that the CommentComponent class exists and inherits from the correct superclass
- Verifies that every field within the CommentComponent class exists as well as having the correct type and access modifier
- Verifies that every method within the CommentComponent class exists as well as having the correct return type, access modifier and exceptions thrown

Creating the CommentComponent
When creating creating a comment component, we had an initial panel that would hold all the components, similar to the post component. We would create Buttons and Textfields to fill the panel. We created a similar layout as the PostComponent for the CommentComponent. To distiguish between the post and comment, we decided to make the testbox for comments smaller. In the PostComponent, we set the padding for the textbox at 250 however for the comment component, we set the value to 200 so there could be a visual difference. Another difference was that we took away the comment button from a CommentComponent. We only wanted posts to have a Comment button so there could be another visual distinguish between the two. In the end, a CommentComponent was added similar to a post component to the main JScrollPane that the user would see. Similar to the PostComponent, we made sure that each button and panel had action listeners that would perform that action desired. 

1. Create a comment on a post by clicking the comment button and entering placeholder text
2. Click the username button
    - The functionality and result should be the exact same as the username button for
      a PostComponent  
3. Click the ... button
    - The functionality and result should be the exact same as the ... button for a 
      PostComponent
