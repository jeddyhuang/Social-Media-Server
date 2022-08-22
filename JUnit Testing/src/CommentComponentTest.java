import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import javax.swing.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * CommentComponentTest
 * 
 * A class that tests CommentComponent
 */
public class CommentComponentTest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testCommentComponentClass() {
        try {
            Class.forName("CommentComponent");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `CommentComponent`");
        }
        Class<?> clazz = CommentComponent.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `CommentComponent` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `CommentComponent` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `CommentComponent` extends `JComponent`!", JComponent.class, superclass);
        Assert.assertEquals("Ensure that `CommentComponent` implements no interfaces!", 0, superinterfaces.length);
    }
    
    @Test(timeout = 1000)
    public void testSerialVersionUIDField() {
        Assume.assumeTrue(exists);
        try {
            Field field = CommentComponent.class.getDeclaredField("serialVersionUID");
            if (!field.getType().equals(long.class)) {
                Assert.fail("Ensure that your field serialVersionUID in class CommentComponent is of type long!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field serialVersionUID in class CommentComponent is private, "
                        + "static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field serialVersionUID in class CommentComponent "
                    + "that is of type long, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testCommentField() {
        Assume.assumeTrue(exists);
        try {
            Field field = CommentComponent.class.getDeclaredField("comment");
            if (!field.getType().equals(Comment.class)) {
                Assert.fail("Ensure that your field comment in class CommentComponent is of type Comment!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field comment in class CommentComponent is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field comment in class CommentComponent "
                    + "that is of type Comment, is private and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUsernameButtonField() {
        Assume.assumeTrue(exists);
        try {
            Field field = CommentComponent.class.getDeclaredField("usernameButton");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field usernameButton in class CommentComponent is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field usernameButton in class CommentComponent is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field usernameButton in class CommentComponent "
                    + "that is of type JButton, is private and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testOptionsButtonField() {
        Assume.assumeTrue(exists);
        try {
            Field field = CommentComponent.class.getDeclaredField("optionsButton");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field optionsButton in class CommentComponent is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field optionsButton in class CommentComponent is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field optionsButton in class CommentComponent "
                    + "that is of type JButton, is private and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testActionListenerField() {
        Assume.assumeTrue(exists);
        try {
            Field field = CommentComponent.class.getDeclaredField("actionListener");
            if (!field.getType().equals(ActionListener.class)) {
                Assert.fail("Ensure that your field actionListener in class CommentComponent is of "
                        + "type ActionListener!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field actionListener in class CommentComponent is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field actionListener in class CommentComponent "
                    + "that is of type ActionListener and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testCommentComponentConstructor() {
        Assume.assumeTrue(exists);
        try {
            Constructor<CommentComponent> constructor = CommentComponent.class.getDeclaredConstructor(Comment.class);
            if (constructor.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your constructor in class CommentComponent throws no exceptions!");
            }
            if (constructor.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your constructor in class CommentComponent is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure you have a constructor in class CommentComponent that is public, and takes "
                    + "a Comment parameter!");
            e.printStackTrace();
        }
    }
}
