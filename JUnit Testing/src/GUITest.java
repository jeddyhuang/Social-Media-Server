import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * GUITest
 * 
 * A class that tests GUI
 */
public class GUITest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testGUIClass() {
        try {
            Class.forName("GUI");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `GUI`");
        }
        Class<?> clazz = GUI.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `GUI` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `GUI` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `GUI` extends `Object`!", Object.class, superclass);
        Assert.assertEquals("Ensure that `GUI` implements only 1 interface!", 1, superinterfaces.length);
        Assert.assertEquals("Ensure that `GUI` implements Runnable!", Runnable.class, superinterfaces[0]);
    }
    
    @Test(timeout = 1000)
    public void testCPostButtonField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("cPostButton");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field cPostButton in class GUI is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field cPostButton in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field cPostButton in class GUI "
                    + "that is of type JButton, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPostButtonField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("postButton");
            if (!field.getType().equals(JButton.class)) {
                Assert.fail("Ensure that your field postButton in class GUI is of type JButton!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field postButton in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field postButton in class GUI "
                    + "that is of type JButton, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testDisposedField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("disposed");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field disposed in class GUI is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
                Assert.fail("Ensure that your field disposed in class GUI is private and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field disposed in class GUI "
                    + "that is of type boolean, is private and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testMenuBarField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("menuBar");
            if (!field.getType().equals(JMenuBar.class)) {
                Assert.fail("Ensure that your field menuBar in class GUI is of type JMenuBar!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field menuBar in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field menuBar in class GUI "
                    + "that is of type JMenuBar, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testAccountSettingsField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("accountSettings");
            if (!field.getType().equals(JMenu.class)) {
                Assert.fail("Ensure that your field accountSettings in class GUI is of type JMenu!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field accountSettings in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field accountSettings in class GUI "
                    + "that is of type JMenu, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUsernameDisplayField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("usernameDisplay");
            if (!field.getType().equals(JMenu.class)) {
                Assert.fail("Ensure that your field usernameDisplay in class GUI is of type JMenu!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field usernameDisplay in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field usernameDisplay in class GUI "
                    + "that is of type JMenu, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testChangeUsernameField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("changeUsername");
            if (!field.getType().equals(JMenuItem.class)) {
                Assert.fail("Ensure that your field changeUsername in class GUI is of type JMenuItem!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field changeUsername in class GUI is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field changeUsername in class GUI "
                    + "that is of type JMenuItem and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testDeleteAccountField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("deleteAccount");
            if (!field.getType().equals(JMenuItem.class)) {
                Assert.fail("Ensure that your field deleteAccount in class GUI is of type JMenuItem!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field deleteAccount in class GUI is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field deleteAccount in class GUI "
                    + "that is of type JMenuItem and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testChangePasswordField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("changePassword");
            if (!field.getType().equals(JMenuItem.class)) {
                Assert.fail("Ensure that your field changePassword in class GUI is of type JMenuItem!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field changePassword in class GUI is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field changePassword in class GUI "
                    + "that is of type JMenuItem and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testLogoutField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("logout");
            if (!field.getType().equals(JMenuItem.class)) {
                Assert.fail("Ensure that your field logout in class GUI is of type JMenuItem!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field logout in class GUI is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field logout in class GUI "
                    + "that is of type JMenuItem and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testMainField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("main");
            if (!field.getType().equals(JPanel.class)) {
                Assert.fail("Ensure that your field main in class GUI is of type JPanel!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field main in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field main in class GUI "
                    + "that is of type JPanel, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testOptionsField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("options");
            if (!field.getType().equals(JPanel.class)) {
                Assert.fail("Ensure that your field options in class GUI is of type JPanel!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field options in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field options in class GUI "
                    + "that is of type JPanel, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testFrameField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("frame");
            if (!field.getType().equals(JFrame.class)) {
                Assert.fail("Ensure that your field frame in class GUI is of type JFrame!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field frame in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field frame in class GUI "
                    + "that is of type JFrame, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testViewPostsField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("viewPosts");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field viewPosts in class GUI is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field viewPosts in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field viewPosts in class GUI "
                    + "that is of type boolean, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testViewingUserField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("viewingUser");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field viewingUser in class GUI is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field viewingUser in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field viewingUser in class GUI "
                    + "that is of type boolean, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUserViewingField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("userViewing");
            if (!field.getType().equals(int.class)) {
                Assert.fail("Ensure that your field userViewing in class GUI is of type int!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field userViewing in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field userViewing in class GUI "
                    + "that is of type int, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPcField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("pc");
            if (!field.getType().equals(ArrayList.class)) {
                Assert.fail("Ensure that your field pc in class GUI is of type ArrayList!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                Assert.fail("Ensure that your field pc in class GUI is public and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field pc in class GUI "
                    + "that is of type ArrayList, is public and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testTITLEField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("TITLE");
            if (!field.getType().equals(String.class)) {
                Assert.fail("Ensure that your field TITLE in class GUI is of type String!");
            }
            if (field.getModifiers() != Modifier.PUBLIC + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field TITLE in class GUI is public, static and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field TITLE in class GUI "
                    + "that is of type String, is public, static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testActionListenerField() {
        Assume.assumeTrue(exists);
        try {
            Field field = GUI.class.getDeclaredField("actionListener");
            if (!field.getType().equals(ActionListener.class)) {
                Assert.fail("Ensure that your field actionListener in class GUI is of type ActionListener!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field actionListener in class GUI is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field actionListener in class GUI "
                    + "that is of type ActionListener and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testStartGUIMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("startGUI");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method startGUI in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method startGUI in class GUI returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method startGUI in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method startGUI in class GUI that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testRunMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("run");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method run in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method run in class GUI returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method run in class GUI is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method run in class GUI that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testUpdateAllPostsGUIMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("updateAllPostsGUI", Post[].class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method updateAllPostsGUI in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method updateAllPostsGUI in class GUI returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method updateAllPostsGUI in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method updateAllPostsGUI in class GUI that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testDisposeMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("dispose");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method dispose in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method dispose in class GUI returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method dispose in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method dispose in class GUI that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testIsDisposedMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("isDisposed");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method isDisposed in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method isDisposed in class GUI returns boolean!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method isDisposed in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method isDisposed in class GUI that"
                    + " is static, is public, and returns boolean!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testCreateFrameMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("createFrame");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method createFrame in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method createFrame in class GUI returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method createFrame in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method createFrame in class GUI that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testCreateUserFrameMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("createUserFrame", int.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method createUserFrame in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method createUserFrame in class GUI returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method createUserFrame in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method createUserFrame in class GUI that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testConfirmDialogMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("confirmDialog", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method confirmDialog in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != int.class) {
                Assert.fail("Ensure that your method confirmDialog in class GUI returns int!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method confirmDialog in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method confirmDialog in class GUI that"
                    + " is static, is public, and returns int");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testErrorDialogMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("errorDialog", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method errorDialog in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method errorDialog in class GUI returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method errorDialog in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method errorDialog in class GUI that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testMessageDialogMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("messageDialog", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method messageDialog in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method messageDialog in class GUI returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method messageDialog in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method messageDialog in class GUI that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //GUI Method
    public void testInputDialogMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = GUI.class.getDeclaredMethod("inputDialog", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method inputDialog in class GUI throws no exceptions!");
            }
            if (method.getReturnType() != String.class) {
                Assert.fail("Ensure that your method inputDialog in class GUI returns String!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method inputDialog in class GUI is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method inputDialog in class GUI that"
                    + " is static, is public, and returns String!");
            e.printStackTrace();
        }
    }
}
