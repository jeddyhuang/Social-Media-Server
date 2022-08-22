import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.net.*;
import java.util.ArrayList;
import java.util.Map;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * ServerTest
 * 
 * A class that tests Server
 */
public class ServerTest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testServerClass() {
        try {
            Class.forName("Server");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `Server`");
        }
        Class<?> clazz = Server.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `Server` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `Server` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `Server` extends `Object`!", Object.class, superclass);
        Assert.assertEquals("Ensure that `Server` implements only 1 interface!", 1, superinterfaces.length);
        Assert.assertEquals("Ensure that `Server` implements Runnable!", Runnable.class, superinterfaces[0]);
    }
    
    @Test(timeout = 1000)
    public void testIdCounterField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("idCounter");
            if (!field.getType().equals(int.class)) {
                Assert.fail("Ensure that your field idCounter in class Server is of type int!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
                Assert.fail("Ensure that your field idCounter in class Server is private and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field idCounter in class Server "
                    + "that is of type int, is private, and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testCURRENTCLIENTSField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("CURRENT_CLIENTS");
            if (!field.getType().equals(ArrayList.class)) {
                Assert.fail("Ensure that your field CURRENT_CLIENTS in class Server is of type ArrayList!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field CURRENT_CLIENTS in class Server is private, static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field CURRENT_CLIENTS in class Server "
                    + "that is of type ArrayList, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUSERSField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("USERS");
            if (!field.getType().equals(Map.class)) {
                Assert.fail("Ensure that your field USERS in class Server is of type Map!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field USERS in class Server is private, static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field USERS in class Server "
                    + "that is of type Map, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPOSTSField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("POSTS");
            if (!field.getType().equals(ArrayList.class)) {
                Assert.fail("Ensure that your field POSTS in class Server is of type ArrayList!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field POSTS in class Server is private, static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field POSTS in class Server "
                    + "that is of type ArrayList, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPOSTMAPField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("POST_MAP");
            if (!field.getType().equals(Map.class)) {
                Assert.fail("Ensure that your field POST_MAP in class Server is of type Map!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field POST_MAP in class Server is private, static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field POST_MAP in class Server "
                    + "that is of type Map, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testRunningField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("running");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field running in class Server is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
                Assert.fail("Ensure that your field running in class Server is private and static!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field running in class Server "
                    + "that is of type boolean, is private, and static!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testKeyField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("key");
            if (!field.getType().equals(Object.class)) {
                Assert.fail("Ensure that your field key in class Server is of type Object!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field key in class Server is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field key in class Server "
                    + "that is of type Object, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testLoggedInField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("loggedIn");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field loggedIn in class Server is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field loggedIn in class Server is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field loggedIn in class Server "
                    + "that is of type boolean and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUpdateField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("update");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field update in class Server is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field update in class Server is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field update in class Server "
                    + "that is of type boolean and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testModField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("mod");
            if (!field.getType().equals(User.class)) {
                Assert.fail("Ensure that your field mod in class Server is of type User!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field mod in class Server is private, static and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field mod in class Server "
                    + "that is of type User, is private, static and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUserField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("user");
            if (!field.getType().equals(User.class)) {
                Assert.fail("Ensure that your field user in class Server is of type User!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field user in class Server is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field user in class Server "
                    + "that is of type User and is private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSocketField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("socket");
            if (!field.getType().equals(Socket.class)) {
                Assert.fail("Ensure that your field socket in class Server is of type Socket!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field socket in class Server is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field socket in class Server "
                    + "that is of type Socket, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testOosField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("oos");
            if (!field.getType().equals(ObjectOutputStream.class)) {
                Assert.fail("Ensure that your field oos in class Server is of type ObjectOutputStream!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field oos in class Server is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field oos in class Server "
                    + "that is of type ObjectOutputStream, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testOisField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("ois");
            if (!field.getType().equals(ObjectInputStream.class)) {
                Assert.fail("Ensure that your field ois in class Server is of type ObjectInputStream!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field ois in class Server is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field ois in class Server "
                    + "that is of type ObjectInputStream, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testIsField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Server.class.getDeclaredField("is");
            if (!field.getType().equals(InputStream.class)) {
                Assert.fail("Ensure that your field is in class Server is of type InputStream!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field is in class Server is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field is in class Server "
                    + "that is of type InputStream, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testServerConstructor() {
        Assume.assumeTrue(exists);
        try {
            Constructor<Server> constructor = Server.class.getDeclaredConstructor(Socket.class);
            if (constructor.getExceptionTypes().length != 1) {
                Assert.fail("Ensure that your constructor in class Server throws 1 exception!");
            }
            if (constructor.getExceptionTypes()[0] != IOException.class) {
                Assert.fail("Ensure that your constructor in class Server throws IOException!");
            }
            if (constructor.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your constructor in class Server is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure you have a constructor in class Server that is public, and takes a Socket parameter!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testMainMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("main", String[].class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method main in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method main in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method main in class Server is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method main in class Server that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testUpdateUserMapUsernameMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("updateUserMapUsername", String.class, String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method updateUserMapUsername in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method updateUserMapUsername in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method updateUserMapUsername in class Server is static and public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method updateUserMapUsername in class Server that"
                    + " is static, is public, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testServerCloserMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("serverCloser", ServerSocket.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method serverCloser in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method serverCloser in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PRIVATE) {
                Assert.fail("Ensure that your method serverCloser in class Server is static and private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method serverCloser in class Server that"
                    + " is static, is private, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testRegisterMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("register", User.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method register in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method register in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method register in class Server is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method register in class Server that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPasswordConformsMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("passwordConforms", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method passwordConforms in class Server throws no exceptions!");
            }
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method passwordConforms in class Server returns boolean!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PUBLIC) {
                Assert.fail("Ensure that your method passwordConforms in class Server is static and public!");
            }
            Server.passwordConforms("123");
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method passwordConforms in class Server that"
                    + " is static, is public, and returns boolean!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method passwordConforms in class Server works for valid inputs!");
            e.printStackTrace();
        }
        try {
            if (!Server.passwordConforms(" ")) throw new Exception();
            Assert.fail("Ensure that your method passwordConforms in class Server fails for invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testLoginMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("login", User.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method login in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method login in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method login in class Server is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method login in class Server that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendPostArrayMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("sendPostArray", Object[].class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method sendPostArray in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method sendPostArray in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method sendPostArray in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method sendPostArray in class Server that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendErrorMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("sendError", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method sendError in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method sendError in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method sendError in class Server is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method sendError in class Server that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendSuccessMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("sendSuccess", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method sendSuccess in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method sendSuccess in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method sendSuccess in class Server is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method sendSuccess in class Server that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testFindCommentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("findComment", Comment.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method findComment in class Server throws no exceptions!");
            }
            if (method.getReturnType() != Comment.class) {
                Assert.fail("Ensure that your method findComment in class Server returns Comment!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method findComment in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method findComment in class Server that"
                    + " is private and returns Comment!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testFindPostMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("findPost", Post.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method findPost in class Server throws no exceptions!");
            }
            if (method.getReturnType() != Post.class) {
                Assert.fail("Ensure that your method findPost in class Server returns Post!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method findPost in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method findPost in class Server that"
                    + " is private and returns Post!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testAddOrChangeCommentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("addOrChangeComment", Comment.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method addOrChangeComment in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method addOrChangeComment in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method addOrChangeComment in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method addOrChangeComment in class Server that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testAddOrChangePostMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("addOrChangePost", Post.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method addOrChangePost in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method addOrChangePost in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method addOrChangePost in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method addOrChangePost in class Server that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testRemoveCommentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("removeComment", Comment.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method removeComment in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method removeComment in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method removeComment in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method removeComment in class Server that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testRemovePostMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("removePost", Post.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method removePost in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method removePost in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method removePost in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method removePost in class Server that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testUpdateAllUsersMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("updateAllUsers");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method updateAllUsers in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method updateAllUsers in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.STATIC + Modifier.PRIVATE) {
                Assert.fail("Ensure that your method updateAllUsers in class Server is static and private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method updateAllUsers in class Server that"
                    + " is static, is private, and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendMethod1() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("send", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method send in class Server throws no exceptions!");
            }
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method send in class Client returns boolean!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method send in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method send in class Client that"
                    + " is private and returns boolean!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testSendMethod2() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("send", String.class, Object.class, boolean.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method send in class Server throws no exceptions!");
            }
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method send in class Client returns boolean!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method send in class Client is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method send in class Client that"
                    + " is private and returns boolean!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testDeleteAccountMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("deleteAccount");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method deleteAccount in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method deleteAccount in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method deleteAccount in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method deleteAccount in class Server that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testCloseSessionMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("closeSession");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method closeSession in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method closeSession in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your method closeSession in class Server is private!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method closeSession in class Server that"
                    + " is private and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testNotifyUpdateMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("notifyUpdate");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method notifyUpdate in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method notifyUpdate in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method notifyUpdate in class Server is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method notifyUpdate in class Server that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    //Server Method
    public void testUunMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Server.class.getDeclaredMethod("run");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method run in class Server throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method run in class Server returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method run in class Server is public!");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method run in class Server that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        }
    }
}
