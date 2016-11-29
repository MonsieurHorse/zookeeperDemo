package com.common.zookeeper;

import org.junit.*;
import org.junit.Test;

/**
 * Created by MHorse on 2016/6/29.
 */
public class StudentTest {
    Student student = new Student();

    @Test
    public void testPrint(){
        student.setId("id");
        student.setName("@@@@@@@@@@@@@@@@@@@@");
        System.out.println("student: " + student.toString());
    }
}
