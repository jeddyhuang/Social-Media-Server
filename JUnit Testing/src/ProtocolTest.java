import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

/**
 * ProtocolTest
 * 
 * A class that tests Protocol
 */
public class ProtocolTest {
    private static boolean exists = true;
    
    @Test(timeout = 1000)
    public void testProtocolClass() {
        try {
            Class.forName("Protocol");
        } catch (ClassNotFoundException e) {
            exists = false;
            Assert.fail("Ensure that you have a class called `Protocol`");
        }
        Class<?> clazz = Protocol.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();
        
        Assert.assertTrue("Ensure that `Protocol` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `Protocol` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `Protocol` extends `Object`!", Object.class, superclass);
        Assert.assertEquals("Ensure that `Protocol` implements only 1 interface!", 1, superinterfaces.length);
        Assert.assertEquals("Ensure that `Protocol` implements Serializable!", Serializable.class, superinterfaces[0]);
    }
    
    @Test(timeout = 1000)
    public void testObjectField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Protocol.class.getDeclaredField("object");
            if (!field.getType().equals(Object.class)) {
                Assert.fail("Ensure that your field object in class Protocol is of type Object!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field object in class Protocol is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field object in class Protocol "
                    + "that is of type Object, is private and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testHeaderField() {
        Assume.assumeTrue(exists);
        try {
            Field field = Protocol.class.getDeclaredField("header");
            if (!field.getType().equals(String.class)) {
                Assert.fail("Ensure that your field header in class Protocol is of type String!");
            }
            if (field.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                Assert.fail("Ensure that your field header in class Protocol is private and final!");
            }
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that you have a field header in class Protocol "
                    + "that is of type String, is private and final!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testProtocolConstructor() {
        Assume.assumeTrue(exists);
        try {
            Constructor<Protocol> constructor = Protocol.class.getDeclaredConstructor(String.class, Object.class);
            if (constructor.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your constructor in class Protocol throws no exceptions!");
            }
            if (constructor.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your constructor in class Protocol is public!");
            }
            if (new Protocol("", null) == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure you have a constructor in class Protocol that is public,"
                    + " and takes 2 parameters - a String and a Object!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your constructor in class Protocol works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetObjectMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Protocol.class.getDeclaredMethod("getObject");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getObject in class Protocol throws no exceptions!");
            }
            if (method.getReturnType() != Object.class) {
                Assert.fail("Ensure that your method getObject in class Protocol returns Object!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getObject in class Protocol is public!");
            }
            if (new Protocol("", null).getObject() != null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getObject in class Protocol that"
                    + " is public and returns Object!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getObject in class Protocol works with valid inputs!");
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 1000)
    public void testGetHeaderMethod() {
        Assume.assumeTrue(exists);
        try {
            Method method = Protocol.class.getDeclaredMethod("getHeader");
            if (method.getExceptionTypes().length != 0) {
                Assert.fail("Ensure that your method getHeader in class Protocol throws no exceptions!");
            }
            if (method.getReturnType() != String.class) {
                Assert.fail("Ensure that your method getHeader in class Protocol returns String!");
            }
            if (method.getModifiers() != Modifier.PUBLIC) {
                Assert.fail("Ensure that your method getHeader in class Protocol is public!");
            }
            if (new Protocol("", null).getHeader() == null) throw new Exception();
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that you have a method getHeader in class Protocol that"
                    + " is public and returns String!");
            e.printStackTrace();
        } catch (Exception e) {
            Assert.fail("Ensure that your method getHeader in class Protocol works with valid inputs!");
            e.printStackTrace();
        }
    }
}
