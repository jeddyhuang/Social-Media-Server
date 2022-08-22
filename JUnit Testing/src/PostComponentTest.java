import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.swing.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * PostComponentTest
 * 
 * A class that tests PostComponent
 */
public class PostComponentTest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testPostComponentClass() {
        try {
            Class.forName("PostComponent");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `PostComponent`");
        }
        Class<?> clazz = PostComponent.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `PostComponent` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `PostComponent` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `PostComponent` extends `JComponent`!", JComponent.class, superclass);
        Assert.assertEquals("Ensure that `PostComponent` implements no interfaces!", 0, superinterfaces.length);
    }
    
    @Test(timeout = 1000)
    public void testSerialVersionUIDField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("serialVersionUID");
            if (!field.getType().equals(long.class)) {
                Assert.fail("Ensure that your field serialVersionUID in class PostComponent is of type long!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field serialVersionUID in class PostComponent is private, "
                        + "static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field serialVersionUID in class PostComponent "
                    + "that is of type long, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPostField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("post");
            if (!field.getType().equals(Post.class)) {
                Assert.fail("Ensure that your field post in class PostComponent is of type Post!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field post in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field post in class PostComponent "
                    + "that is of type Post and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUsernameButtonField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("usernameButton");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field usernameButton in class PostComponent is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field usernameButton in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field usernameButton in class PostComponent "
                    + "that is of type JButton and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testOptionsButtonField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("optionsButton");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field optionsButton in class PostComponent is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field optionsButton in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field optionsButton in class PostComponent "
                    + "that is of type JButton and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testTextAreaField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("textArea");
            if (!field.getType().equals(JTextArea.class)) {
                Assert.fail("Ensure that your field textArea in class PostComponent is of type JTextArea!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field textArea in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field textArea in class PostComponent "
                    + "that is of type JTextArea and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testTimeStampField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("timeStamp");
            if (!field.getType().equals(JLabel.class)) {
                Assert.fail("Ensure that your field timeStamp in class PostComponent is of type JLabel!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field timeStamp in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field timeStamp in class PostComponent "
                    + "that is of type JLabel and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testCommentButtonField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("commentButton");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field commentButton in class PostComponent is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field commentButton in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field commentButton in class PostComponent "
                    + "that is of type JButton and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testEmojiHoldField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("emojiHold");
            if (!field.getType().equals(JPanel.class)) {
                Assert.fail("Ensure that your field emojiHold in class PostComponent is of type JPanel!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field emojiHold in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field emojiHold in class PostComponent "
                    + "that is of type JPanel and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testHappyFaceField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("happyFace");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field happyFace in class PostComponent is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field happyFace in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field happyFace in class PostComponent "
                    + "that is of type JButton and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSadFaceField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("sadFace");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field sadFace in class PostComponent is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field sadFace in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field sadFace in class PostComponent "
                    + "that is of type JButton and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testNScoreField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("nScore");
            if (!field.getType().equals(JLabel.class)) {
                Assert.fail("Ensure that your field nScore in class PostComponent is of type JLabel!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field nScore in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field nScore in class PostComponent "
                    + "that is of type JLabel and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPScoreField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("pScore");
            if (!field.getType().equals(JLabel.class)) {
                Assert.fail("Ensure that your field pScore in class PostComponent is of type JLabel!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field pScore in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field pScore in class PostComponent "
                    + "that is of type JLabel and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testActionListenerField() {
        Assume.assumeTrue(exists);
        try {
            Field field = PostComponent.class.getDeclaredField("actionListener");
            if (!field.getType().equals(ActionListener.class)) {
                Assert.fail("Ensure that your field actionListener in class PostComponent is of type ActionListener!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field actionListener in class PostComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field actionListener in class PostComponent "
                    + "that is of type ActionListener and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testPostComponentConstructor() {
        Assume.assumeTrue(exists);
        try {
            Constructor<PostComponent> constructor = PostComponent.class.getDeclaredConstructor(Post.class);
            if (constructor.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your constructor in class PostComponent throws no exceptions!");
            }
            if (constructor.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your constructor in class PostComponent throws no exceptions!");
            }
            if (constructor.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your constructor in class PostComponent is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure you have a constructor in class PostComponent that is public, "
                    + "and takes a Post parameter!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testGetPostMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = PostComponent.class.getDeclaredMethod("getPost");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getPost in class PostComponent throws no exceptions!");
            }
            if (method.getReturnType() != Post.class) {
                Assert.fail("Ensure that your method getPost in class PostComponent returns Post!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getPost in class PostComponent is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getPost in class PostComponent that"
                    + " is public and returns Post!");
            e.printStackTrace();
        }
    }
}
