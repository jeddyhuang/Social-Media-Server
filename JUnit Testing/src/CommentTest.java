import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * CommentTest
 * 
 * A class that tests Comment
 */
public class CommentTest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testCommentClass() {
        try {
            Class.forName("Comment");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `Comment`");
        }
        Class<?> clazz = Comment.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `Comment` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `Comment` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `Comment` extends `Object`!", Object.class, superclass);
        Assert.assertEquals("Ensure that `Comment` implements only 1 interface!", 1, superinterfaces.length);
        Assert.assertEquals("Ensure that `Comment` implements Serializable!", Serializable.class, superinterfaces[0]);
    }
    
    @Test(timeout = 1000)
    public void testSerialVersionUIDField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Comment.class.getDeclaredField("serialVersionUID");
            if (!field.getType().equals(long.class)) {
                Assert.fail("Ensure that your field serialVersionUID in class Comment is of type long!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL) {
                Assert.fail("Ensure that your field serialVersionUID in class Comment is private, static, and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field serialVersionUID in class Comment "
                    + "that is of type long, is private, is static, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testDateField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Comment.class.getDeclaredField("date");
            if (!field.getType().equals(LocalDateTime.class)) {
                Assert.fail("Ensure that your field date in class Comment is of type LocalDateTime!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field date in class Comment is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field date in class Comment "
                    + "that is of type LocalDateTime, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testParentPostField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Comment.class.getDeclaredField("parentPost");
            if (!field.getType().equals(Post.class)) {
                Assert.fail("Ensure that your field parentPost in class Comment is of type Post!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field parentPost in class Comment is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field parentPost in class Comment "
                    + "that is of type Post, is private, and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testUserField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Comment.class.getDeclaredField("user");
            if (!field.getType().equals(User.class)) {
                Assert.fail("Ensure that your field user in class Comment is of type User!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field user in class Comment is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field user in class Comment "
                    + "that is of type User and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testCommentField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Comment.class.getDeclaredField("comment");
            if (!field.getType().equals(String.class)) {
                Assert.fail("Ensure that your field comment in class Comment is of type String!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field comment in class Comment is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field comment in class Comment "
                    + "that is of type String and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testIdField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Comment.class.getDeclaredField("id");
            if (!field.getType().equals(int.class)) {
                Assert.fail("Ensure that your field id in class Comment is of type int!");
            }
            if (field.getModifiers() != Modifier.PRIVATE) {
                Assert.fail("Ensure that your field id in class Comment is private!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field id in class Comment "
                    + "that is of type int and private!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testCommentConstructor() {
        Assume.assumeTrue(exists);
        try {
            Constructor<Comment> constructor = Comment.class.getDeclaredConstructor(String.class, Post.class);
            if (constructor.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your constructor in class Comment throws no exceptions!");
            }
            if (constructor.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your constructor in class Comment is public!");
            }
            if (new Comment("", null) == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure you have a constructor in class Comment that is public,"
                    + " and takes 2 parameters - a String and a Post!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your constructor in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetParentPostMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("getParentPost");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getParentPost in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != Post.class) {
                Assert.fail("Ensure that your method getParentPost in class Comment returns Post!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getParentPost in class Comment is public!");
            }
            if (new Comment("", null).getParentPost() != null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getParentPost in class Comment that"
                    + " is public and returns Post!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getParentPost in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetDateTimeMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("getDateTime");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getDateTime in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != LocalDateTime.class) {
                Assert.fail("Ensure that your method getDateTime in class Comment returns LocalDateTime!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getDateTime in class Comment is public!");
            }
            if (new Comment("", null).getDateTime() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getDateTime in class Comment that"
                    + " is public and returns LocalDateTime!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getDateTime in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetUserMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("getUser");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getUser in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != User.class) {
                Assert.fail("Ensure that your method getUser in class Comment returns User!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getUser in class Comment is public!");
            }
            if (new Comment("", null).getUser() != null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getUser in class Comment that"
                    + " is public and returns User!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getUser in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetCommentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("getComment");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getComment in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != String.class) {
                Assert.fail("Ensure that your method getComment in class Comment returns String!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getComment in class Comment is public!");
            }
            if (new Comment("", null).getComment() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getComment in class Comment that"
                    + " is public and returns String!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getComment in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetIdMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("getId");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getId in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != int.class) {
                Assert.fail("Ensure that your method getId in class Comment returns int!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getId in class Comment is public!");
            }
            if (new Comment("", null).getId() != 0) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getId in class Comment that"
                    + " is public and returns int!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getId in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetUserMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("setUser", User.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setUser in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setUser in class Comment returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setUser in class Comment is public!");
            }
            new Comment("", null).setUser(new User("", ""));
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setUser in class Comment that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setUser in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetCommentMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("setComment", String.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setComment in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setComment in class Comment returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setComment in class Comment is public!");
            }
            new Comment("", null).setComment("");
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setComment in class Comment that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setComment in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testSetIdMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("setId", int.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method setId in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != void.class) {
                Assert.fail("Ensure that your method setId in class Comment returns nothing (void)!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method setId in class Comment is public!");
            }
            new Comment("", null).setId(123);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method setId in class Comment that"
                    + " is public and returns nothing (void)!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method setId in class Comment works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testEqualsMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Comment.class.getDeclaredMethod("equals", Object.class);
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method equals in class Comment throws no exceptions!");
            }
            if (method.getReturnType() != boolean.class) {
                Assert.fail("Ensure that your method equals in class Comment returns boolean!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method equals in class Comment is public!");
            }
            if (!new Comment("", null).equals(new Comment("", null))) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method equals in class Comment that"
                    + " is public and returns boolean!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method equals in class Comment works with valid inputs!");
            e.printStackTrace();
        }
        try {
            if (!new Comment("", null).equals("")) throw new Exception();
            Assert.fail("Ensure that your method equals in class Comment fails with invalid inputs!");
        } catch (Exception e) {
            return;
        }
    }
}
