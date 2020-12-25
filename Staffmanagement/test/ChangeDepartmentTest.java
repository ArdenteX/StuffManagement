package Staffmanagement.test;

import Staffmanagement.Model.ChangeValue.ChangeDepartment;
import Staffmanagement.FileToBeanToList.Operation;
import Staffmanagement.bean.Personal;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class ChangeDepartmentTest {
    String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformation.txt";
    LinkedList<Personal> list = new LinkedList<>();
    ChangeDepartment cd = new ChangeDepartment();
    Operation op = new Operation();
    @Test
    void change() {
        cd.change(list,"2012","技术");
        System.out.println("OK!!");
    }

    @Test
    void testChange() {
    }
}