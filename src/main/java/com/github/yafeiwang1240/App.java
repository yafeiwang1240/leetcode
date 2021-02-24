package com.github.yafeiwang1240;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Hello world!
 */
public class App
{
    public static void main( String[] args ) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, UnsupportedEncodingException {
        byte[] bytes = new byte[]{50, 0, -1, 28, -24};
        String isoString = new String(bytes);
        byte[] isoBytes = isoString.getBytes();
        System.out.print(bytes.length == isoBytes.length);
    }

    public static void test() throws NoSuchMethodException {
        Method method = App.class.getMethod("swap", Integer.class, Integer.class);
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter.getName());
        }
        App app = new App();
        NewA newA = app.getNewA(1);
        System.out.println(newA.toString());
    }

    public NewA getNewA(int a) {
        return new NewA(a) {
            private int val = a;
            @Override
            public String toString() {
                return "val = " + val;
            }
        };
    }

    public NewA getPrintNewA(int a) {
        class PrintNewA extends NewA {

            private int val = a;

            public PrintNewA(int a) {
                super(a);
            }

            @Override
            public String toString() {
                return "val = " + val;
            }
        };
        return new PrintNewA(a);
    }

    public abstract class NewA {
        public NewA(int a) {
        }
    }

    public static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        if (a == null || b == null) return;
//        Integer temp = new Integer(a.intValue());
        int temp = a.intValue();
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(a, b);
        field.set(b, temp);
    }

}
