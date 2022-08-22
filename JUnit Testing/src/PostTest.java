import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * PostTest
 * 
 * A class that tests Post
 */
public class PostTest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testPostClass() {
        try {
            Class.forName("Post");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `Post`");
        }
        Class<?> clazz = Post.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `Post` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `Post` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `Post` extends `Object`!", Object.class, superclass);
        Assert.assertEquals("Ensure that `Post` implements 2 interface!", 2, superinterfaces.length);
        Assert.assertTrue("Ensure that `Post` implements Serializable!",
                (superinterfaces[0].equals(Serializable.class)) || (superinterfaces[1].equals(Serializable.class)));
        Assert.assertTrue("Ensure that `Post` implements Comparable!",
                (superinterfaces[0].equals(Comparable.class)) || (superinterfaces[1].equals(Comparable.class)));
    }
    
    @Test(timeout = 1000)
    public void testSerialVersionUIDField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("serialVersionUID");
            if (!field.getType().equals(long.class)) {
                Assert.fail("Ensure that your field serialVersionUID in class Post is of type long!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field serialVersionUID in class Post is private, static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field serialVersionUID in class Post "
                    + "that is of type long, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testCommentsField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("comments");
            if (!field.getType().equals(ArrayList.class)) {
                Assert.fail("Ensure that your field comments in class Post is of type ArrayList!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field comments in class Post is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field comments in class Post "
                    + "that is of type ArrayList, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testCommentMapField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("commentMap");
            if (!field.getType().equals(Map.class)) {
                Assert.fail("Ensure that your field commentMap in class Post is of type Map!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field commentMap in class Post is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field commentMap in class Post "
                    + "that is of type Map, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testDateField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("date");
            if (!field.getType().equals(LocalDateTime.class)) {
                Assert.fail("Ensure that your field date in class Post is of type LocalDateTime!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field date in class Post is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field date in class Post "
                    + "that is of type LocalDateTime, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testReactedUsersField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("reactedUsers");
            if (!field.getType().equals(ArrayList.class)) {
                Assert.fail("Ensure that your field reactedUsers in class Post is of type ArrayList!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field reactedUsers in class Post is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field reactedUsers in class Post "
                    + "that is of type ArrayList, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testIsPollField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("isPoll");
            if (!field.getType().equals(boolean.class)) {
                Assert.fail("Ensure that your field isPoll in class Post is of type boolean!");
            }
            if (field.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your field isPoll in class Post is public!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field isPoll in class Post "
                    + "that is of type boolean and public!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testIdField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("id");
            if (!field.getType().equals(int.class)) {
                Assert.fail("Ensure that your field id in class Post is of type int!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field id in class Post is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field id in class Post "
                    + "that is of type int and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testContentField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("content");
            if (!field.getType().equals(String.class)) {
                Assert.fail("Ensure that your field content in class Post is of type String!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field content in class Post is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field content in class Post "
                    + "that is of type String and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUserField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("user");
            if (!field.getType().equals(User.class)) {
                Assert.fail("Ensure that your field user in class Post is of type User!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field user in class Post is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field user in class Post "
                    + "that is of type User and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPScoreField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("pScore");
            if (!field.getType().equals(int.class)) {
                Assert.fail("Ensure that your field pScore in class Post is of type int!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field pScore in class Post is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field pScore in class Post "
                    + "that is of type int and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testNScoreField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Post.class.getDeclaredField("nScore");
            if (!field.getType().equals(int.class)) {
                Assert.fail("Ensure that your field nScore in class Post is of type int!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field nScore in class Post is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field nScore in class Post "
                    + "that is of type int and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testPostConstructor() {
        Assume.assumeTrue(exists);
        try {
            Constructor<Post> constructor = Post.class.getDeclaredConstructor(String.class);
            if (constructor.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your constructor in class PostComponent throws no exceptions!");
            }
            if (constructor.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your constructor in class Post is public!");
            }
            if (new Post("") == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure you have a constructor in class Post that is public,"
                    + " and takes a String parameter!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your constructor in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetDateTimeMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("getDateTime");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getDateTime in class Post throws no exceptions!");
            }
            if (method.getReturnType() != LocalDateTime.class) {
                Assert.fail("Ensure that your method getDateTime in class Post returns LocalDateTime!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getDateTime in class Post is public!");
            }
            if (new Post("").getDateTime() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getDateTime in class Post that"
                    + " is public and returns LocalDateTime!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getDateTime in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetReactedUsersMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("getReactedUsers");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getReactedUsers in class Post throws no exceptions!");
            }
            if (method.getReturnType() != ArrayList.class) {
                Assert.fail("Ensure that your method getReactedUsers in class Post returns ArrayList!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getReactedUsers in class Post is public!");
            }
            if (new Post("").getReactedUsers() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getReactedUsers in class Post that"
                    + " is public and returns ArrayList!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getReactedUsers in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetIdMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("getId");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getId in class Post throws no exceptions!");
            }
            if (method.getReturnType() != int.class) {
                Assert.fail("Ensure that your method getId in class Post returns int!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getId in class Post is public!");
            }
            if (new Post("").getId() != 0) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getId in class Post that"
                    + " is public and returns int!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getId in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }

    @Test(timeout = 1000)
    public void testGetPScoreMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("getPScore");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getPScore in class Post throws no exceptions!");
            }
            if (method.getReturnType() != int.class) {
                Assert.fail("Ensure that your method getPScore in class Post returns int!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getPScore in class Post is public!");
            }
            if (new Post("").getPScore() != 0) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getPScore in class Post that"
                    + " is public and returns int!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getPScore in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetNScoreMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("getNScore");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getNScore in class Post throws no exceptions!");
            }
            if (method.getReturnType() != int.class) {
                Assert.fail("Ensure that your method getNScore in class Post returns int!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getNScore in class Post is public!");
            }
            if (new Post("").getNScore() != 0) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getNScore in class Post that"
                    + " is public and returns int!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getNScore in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetContentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("getContent");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getContent in class Post throws no exceptions!");
            }
            if (method.getReturnType() != String.class) {
                Assert.fail("Ensure that your method getContent in class Post returns String!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getContent in class Post is public!");
            }
            if (new Post("").getContent() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getContent in class Post that"
                    + " is public and returns String!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getContent in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetCommentsMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("getComments");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getComments in class Post throws no exceptions!");
            }
            if (method.getReturnType() != ArrayList.class) {
                Assert.fail("Ensure that your method getContent in class Post returns ArrayList!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getComments in class Post is public!");
            }
            if (new Post("").getComments() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getComments in class Post that"
                    + " is public and returns ArrayList!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getComments in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetUserMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("getUser");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getUser in class Post throws no exceptions!");
            }
            if (method.getReturnType() != User.class) {
                Assert.fail("Ensure that your method getUser in class Post returns User!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getUser in class Post is public!");
            }
            if (new Post("").getUser() != null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getUser in class Post that"
                    + " is public and returns User!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getUser in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetIdMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("setId", int.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setId in class Post throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setId in class Post returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setId in class Post is public!");
            }
            new Post("").setId(123);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setId in class Post that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setId in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetPScoreMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("setPScore", int.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setPScore in class Post throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setPScore in class Post returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setPScore in class Post is public!");
            }
            new Post("").setPScore(123);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setPScore in class Post that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setPScore in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetNScoreMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("setNScore", int.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setNScore in class Post throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setNScore in class Post returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setNScore in class Post is public!");
            }
            new Post("").setNScore(123);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setNScore in class Post that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setNScore in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetContentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("setContent", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setContent in class Post throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setContent in class Post returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setContent in class Post is public!");
            }
            new Post("").setContent("");
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setContent in class Post that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setContent in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetUserMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("setUser", User.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setUser in class Post throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setUser in class Post returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setUser in class Post is public!");
            }
            new Post("").setUser(new User("", ""));
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setUser in class Post that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setUser in class Post works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testAddReactedUserMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("addReactedUser", int.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method addReactedUser in class Post throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method addReactedUser in class Post returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method addReactedUser in class Post is public!");
            }
            new Post("").addReactedUser(123);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method addReactedUser in class Post that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method addReactedUser in class Post works with valid inputs!");
            e.printStackTrace();
        }
        try {
            Post temp = new Post("");
            temp.addReactedUser(0);
            if (!temp.getReactedUsers().contains(1)) throw new Exception();
            Assert.fail("Ensure that your method addReactedUser in class Post fails with invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test(timeout = 1000)
    public void testAddCommentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("addComment", Comment.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method addComment in class Post throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method addComment in class Post returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method addComment in class Post is public!");
            }
            new Post("").addComment(new Comment(null, null));
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method addComment in class Post that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method addComment in class Post works with valid inputs!");
            e.printStackTrace();
        }
        try {
            Post temp = new Post("");
            temp.addComment(new Comment(null, null));
            if (!temp.getReactedUsers().contains(new Comment(" ", null))) throw new Exception();
            Assert.fail("Ensure that your method addComment in class Post fails with invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test(timeout = 1000)
    public void testRemoveCommentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("removeComment", Comment.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method removeComment in class Post throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method removeComment in class Post returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method removeComment in class Post is public!");
            }
            new Post("").removeComment(new Comment(null, null));
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method removeComment in class Post that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method removeComment in class Post works with valid inputs!");
            e.printStackTrace();
        }
        try {
            Post temp = new Post("");
            temp.addComment(new Comment(null, null));
            temp.removeComment(new Comment(" ", null));
            if (!temp.getReactedUsers().contains(new Comment(" ", null))) throw new Exception();
            Assert.fail("Ensure that your method removeComment in class Comment fails with invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test(timeout = 1000)
    public void testFindCommentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("findComment", int.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method findComment in class Post throws no exceptions!");
            }
            if (method.getReturnType() != Comment.class) {
                Assert.fail("Ensure that your method findComment in class Post returns Comment!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method findComment in class Post is public!");
            }
            if (new Post("").findComment(0) != null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method findComment in class Post that"
                    + " is public and returns Comment!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method findComment in class Post works with valid inputs!");
            e.printStackTrace();
        }
        try {
            Post temp = new Post("");
            temp.addComment(new Comment(null, null));
            if (temp.findComment(0) != null) throw new Exception();
            Assert.fail("Ensure that your method findComment in class Post fails with invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test(timeout = 1000)
    public void testCompareToMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("compareTo", Post.class);
            if (method.getReturnType() != int.class) {
                Assert.fail("Ensure that your method compareTo in class Post returns int!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method compareTo in class Post is public!");
            }
            if (new Post("").compareTo(new Post("")) != 0) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method compareTo in class Post that"
                    + " is public and returns int!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method compareTo in class Post works with valid inputs!");
            e.printStackTrace();
        }
        try {
            new Post("").compareTo(null);
            Assert.fail("Ensure that your method compareTo in class Post fails with invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test(timeout = 1000)
    public void testEqualsMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Post.class.getDeclaredMethod("equals", Object.class);
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method equals in class Post returns boolean!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method equals in class Post is public!");
            }
            if (!new Post("").equals(new Post(""))) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method equals in class Post that"
                    + " is public and returns boolean!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method equals in class Post works with valid inputs!");
            e.printStackTrace();
        }
        try {
            if (!new Post("").equals("")) throw new Exception();
            Assert.fail("Ensure that your method equals in class Comment fails with invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
}
