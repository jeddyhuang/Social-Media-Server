import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * UserTest
 * 
 * A class that tests User
 */
public class UserTest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testUserClass() {
        try {
            Class.forName("User");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `User`");
        }
        Class<?> clazz = User.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `User` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `User` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `User` extends `Object`!", Object.class, superclass);
        Assert.assertEquals("Ensure that `User` implements only 1 interface!", 1, superinterfaces.length);
        Assert.assertEquals("Ensure that `User` implements Serializable!", Serializable.class, superinterfaces[0]);
    }
    
    @Test(timeout = 1000)
    public void testSerialVersionUIDField() {
        Assume.assumeTrue(exists);
        try {
            Field field = User.class.getDeclaredField("serialVersionUID");
            if (!field.getType().equals(long.class)) {
                Assert.fail("Ensure that your field serialVersionUID in class User is of type long!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field serialVersionUID in class User is private, static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field serialVersionUID in class User "
                    + "that is of type long, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUsernameField() {
        Assume.assumeTrue(exists);
        try {
            Field field = User.class.getDeclaredField("username");
            if (!field.getType().equals(String.class)) {
                Assert.fail("Ensure that your field username in class User is of type String!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field username in class User is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field username in class User "
                    + "that is of type String and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPasswordField() {
        Assume.assumeTrue(exists);
        try {
            Field field = User.class.getDeclaredField("password");
            if (!field.getType().equals(String.class)) {
                Assert.fail("Ensure that your field password in class User is of type String!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field password in class User is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field password in class User "
                    + "that is of type String and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testIdField() {
        Assume.assumeTrue(exists);
        try {
            Field field = User.class.getDeclaredField("id");
            if (!field.getType().equals(int.class)) {
                Assert.fail("Ensure that your field id in class User is of type int!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field id in class User is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field id in class User "
                    + "that is of type int and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPostsField() {
        Assume.assumeTrue(exists);
        try {
            Field field = User.class.getDeclaredField("posts");
            if (!field.getType().equals(ArrayList.class)) {
                Assert.fail("Ensure that your field posts in class User is of type ArrayList!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field posts in class User is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field posts in class User "
                    + "that is of type ArrayList, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testLoggedInField() {
        Assume.assumeTrue(exists);
        try {
            Field field = User.class.getDeclaredField("loggedIn");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field loggedIn in class User is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field loggedIn in class User is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field loggedIn in class User "
                    + "that is of type boolean and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUserConstructor() {
        Assume.assumeTrue(exists);
        try {
            Constructor<User> constructor = User.class.getDeclaredConstructor(String.class, String.class);
            if (constructor.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your constructor in class User throws no exceptions!");
            }
            if (constructor.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your constructor in class User is public!");
            }
            if (new User("", "") == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure you have a constructor in class User that is public,"
                    + " and takes 2 parameters - a String and a String!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your constructor in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetUsernameMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("getUsername");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getUsername in class User throws no exceptions!");
            }
            if (method.getReturnType() != String.class) {
                Assert.fail("Ensure that your method getUsername in class User returns String!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getUsername in class User is public!");
            }
            if (new User("", "").getUsername() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getUsername in class User that"
                    + " is public and returns String!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getUsername in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetPasswordMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("getPassword");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getPassword in class User throws no exceptions!");
            }
            if (method.getReturnType() != String.class) {
                Assert.fail("Ensure that your method getPassword in class User returns String!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getPassword in class User is public!");
            }
            if (new User("", "").getPassword() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getPassword in class User that"
                    + " is public and returns String!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getPassword in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetIdMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("getId");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getId in class User throws no exceptions!");
            }
            if (method.getReturnType() != int.class) {
                Assert.fail("Ensure that your method getId in class User returns int!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getId in class User is public!");
            }
            if (new User("", "").getId() != 0) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getId in class User that"
                    + " is public and returns int!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getId in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetLoggedInMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("getLoggedIn");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getLoggedIn in class User throws no exceptions!");
            }
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method getLoggedIn in class User returns boolean!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getLoggedIn in class User is public!");
            }
            if (new User("", "").getLoggedIn() == true) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getLoggedIn in class User that"
                    + " is public and returns boolean!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getLoggedIn in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetPostsMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("getPosts");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getPosts in class User throws no exceptions!");
            }
            if (method.getReturnType() != ArrayList.class) {
                Assert.fail("Ensure that your method getPosts in class User returns ArrayList!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getPosts in class User is public!");
            }
            if (new User("", "").getPosts() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getPosts in class User that"
                    + " is public and returns ArrayList!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getPosts in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetIdMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("setId", int.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setId in class User throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setId in class User returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setId in class User is public!");
            }
            new User("", "").setId(123);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setId in class User that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setId in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetUsernameMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("setUsername", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setUsername in class User throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setUsername in class User returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setUsername in class User is public!");
            }
            new User("", "").setUsername("");
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setUsername in class User that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setUsername in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetLoggedInMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("setLoggedIn", boolean.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setLoggedIn in class User throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setLoggedIn in class User returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setLoggedIn in class User is public!");
            }
            new User("", "").setLoggedIn(true);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setLoggedIn in class User that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setLoggedIn in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetPasswordMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("setPassword", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setPassword in class User throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setPassword in class User returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setPassword in class User is public!");
            }
            new User("", "").setPassword("");
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setPassword in class User that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setPassword in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testAddPostMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("addPost", Post.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method addPost in class User throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method addPost in class User returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method addPost in class User is public!");
            }
            new User("", "").addPost(null);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method addPost in class User that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method addPost in class User works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testEqualsMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = User.class.getDeclaredMethod("equals", Object.class);
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method equals in class User returns boolean!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method equals in class User is public!");
            }
            if (!new User("", "").equals(new User("", ""))) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method equals in class User that"
                    + " is public and returns boolean!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method equals in class User works with valid inputs!");
            e.printStackTrace();
        }
        try {
            if (!new User("", "").equals("")) throw new Exception();
            Assert.fail("Ensure that your method equals in class Comment fails with invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
}
