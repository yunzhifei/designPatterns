package test;


import com.entity.Student;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @Before
    public void init() {
        System.out.println("\"before\" = " + "before");
    }

    @org.junit.Test
    public void test() {
        Student student = new Student();
        student.setAge(1);
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        student.setAr(a);
        System.out.println("student.toString() = " + student.toString());
        System.out.println("student.getAge() = " + student.getAge());
    }

    @After
    public void after() {
        System.out.println("\"after\" = " + "after");
    }
}
