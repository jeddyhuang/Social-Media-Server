import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.net.*;
import javax.swing.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * ClientTest
 * 
 * A class that tests Client
 */
public class ClientTest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testClientClass() {
        try {
            Class.forName("Client");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `Client`");
        }
        Class<?> clazz = Client.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `Client` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `Client` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `Client` extends `JComponent`!", JComponent.class, superclass);
        Assert.assertEquals("Ensure that `Client` implements no interfaces!", 0, superinterfaces.length);
    }
    
    @Test(timeout = 1000)
    public void testSerialVersionUIDField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Client.class.getDeclaredField("serialVersionUID");
            if (!field.getType().equals(long.class)) {
                Assert.fail("Ensure that your field serialVersionUID in class Client is of type long!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field serialVersionUID in class Client is private, static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field serialVersionUID in class Client "
                    + "that is of type long, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testClientField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Client.class.getDeclaredField("client");
            if (!field.getType().equals(Client.class)) {
                Assert.fail("Ensure that your field client in class Client is of type Client!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
                Assert.fail("Ensure that your field client in class Client is private and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field client in class Client "
                    + "that is of type Client, is private, and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testRunningField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Client.class.getDeclaredField("running");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field running in class Client is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field running in class Client is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field running in class Client "
                    + "that is of type boolean and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSocketField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Client.class.getDeclaredField("socket");
            if (!field.getType().equals(Socket.class)) {
                Assert.fail("Ensure that your field socket in class Client is of type Socket!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field socket in class Client is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field socket in class Client "
                    + "that is of type Socket, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testOosField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Client.class.getDeclaredField("oos");
            if (!field.getType().equals(ObjectOutputStream.class)) {
                Assert.fail("Ensure that your field oos in class Client is of type ObjectOutputStream!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field oos in class Client is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field oos in class Client "
                    + "that is of type ObjectOutputStream, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testOisField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Client.class.getDeclaredField("ois");
            if (!field.getType().equals(ObjectInputStream.class)) {
                Assert.fail("Ensure that your field ois in class Client is of type ObjectInputStream!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field ois in class Client is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field ois in class Client "
                    + "that is of type ObjectInputStream, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUserField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Client.class.getDeclaredField("user");
            if (!field.getType().equals(User.class)) {
                Assert.fail("Ensure that your field user in class Client is of type User!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field user in class Client is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field user in class Client "
                    + "that is of type User and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testClientConstructor() {
        Assume.assumeTrue(exists);
        try {
            Constructor<Client> constructor = Client.class.getDeclaredConstructor();
            if (constructor.getExceptionTypes().length != 1) {
                Assert.fail("Ensure that your constructor in class Client throws 1 exception!");
            }
            if (constructor.getExceptionTypes()[0] != IOException.class) {
                Assert.fail("Ensure that your constructor in class Client throws IOException!");
            }
            if (constructor.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your default constructor in class Client is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure you have a constructor in class Client that is public, and takes 0 parameters!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testMainMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("main", String[].class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method main in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method main in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method main in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method main in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testLoginOrSignUpMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("loginOrSignUp");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method loginOrSignUp in class Client throws no exceptions!");
            }
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method loginOrSignUp in class Client returns boolean!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method loginOrSignUp in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method loginOrSignUp in class Client that"
                    + " is private and returns boolean!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testCloseSessionMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("closeSession");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method closeSession in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method closeSession in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method closeSession in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method closeSession in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testInitializeUserMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("initializeUser");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method initializeUser in class Client throws no exceptions!");
            }
            if (method.getReturnType() != User.class) {
                Assert.fail("Ensure that your method initializeUser in class Client returns User!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method initializeUser in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method initializeUser in class Client that"
                    + " is private and returns User!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testUpdateAllPostsMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("updateAllPosts", Object[].class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method updateAllPosts in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method updateAllPosts in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method updateAllPosts in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method updateAllPosts in class Client that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testStartMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("start");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method start in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method start in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method start in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method start in class Client that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testChangeUsernameMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("changeUsername", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method changeUsername in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method changeUsername in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method changeUsername in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method changeUsername in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testChangePasswordMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("changePassword", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method changePassword in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method changePassword in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method changePassword in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method changePassword in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testUpdatePostServerMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("updatePostServer", Post.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method updatePostServer in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method updatePostServer in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method updatePostServer in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method updatePostServer in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testRemovePostServerMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("removePostServer", Post.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method removePostServer in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method removePostServer in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method removePostServer in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method removePostServer in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testUpdateCommentServerMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("updateCommentServer", Comment.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method updateCommentServer in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method updateCommentServer in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method updateCommentServer in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method updateCommentServer in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testRemoveCommentServerMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("removeCommentServer", Comment.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method removeCommentServer in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method removeCommentServer in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method removeCommentServer in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method removeCommentServer in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testDeleteAccountMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("deleteAccount");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method deleteAccount in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method deleteAccount in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method deleteAccount in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method deleteAccount in class Client that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testGetUserMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("getUser");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getUser in class Client throws no exceptions!");
            }
            if (method.getReturnType() != User.class) {
                Assert.fail("Ensure that your method getUser in class Client returns User!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getUser in class Client is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getUser in class Client that"
                    + " is static, is public, and returns User!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testResponseSendMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("responseSend", String.class, Object.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method responseSend in class Client throws no exceptions!");
            }
            if (method.getReturnType() != Protocol.class) {
                Assert.fail("Ensure that your method responseSend in class Client returns Protocol!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method responseSend in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method responseSend in class Client that"
                    + " is private and returns Protocol!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendMethod1() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("send", String.class, Object.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method send in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method send in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method send in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method send in class Client that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendMethod2() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("send", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method send in class Client throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method send in class Client returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method send in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method send in class Client that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendRegisterMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("sendRegister", User.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method sendRegister in class Client throws no exceptions!");
            }
            if (method.getReturnType() != Protocol.class) {
                Assert.fail("Ensure that your method sendRegister in class Client returns Protocol!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method sendRegister in class Client is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method sendRegister in class Client that"
                    + " is public and returns Protocol!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendLoginMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("sendLogin", User.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method sendLogin in class Client throws no exceptions!");
            }
            if (method.getReturnType() != Protocol.class) {
                Assert.fail("Ensure that your method sendLogin in class Client returns Protocol!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method sendLogin in class Client is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method sendLogin in class Client that"
                    + " is public and returns Protocol!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testResponseHandlerMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Client.class.getDeclaredMethod("responseHandler", Protocol.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method responseHandler in class Client throws no exceptions!");
            }
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method responseHandler in class Client returns boolean!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method responseHandler in class Client is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method responseHandler in class Client that"
                    + " is public and returns boolean!");
            e.printStackTrace();
        }
    }
}
