package Staffmanagement.test;

import Staffmanagement.FileToBeanToList.Operation;
import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.IOOperation.LinkListOperation;
import Staffmanagement.Jurisdiction.Root;
import Staffmanagement.Model.Check;
import Staffmanagement.Model.ShowChangeRecord;
import Staffmanagement.bean.Personal;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class LinkListOperationTest {
    String num = "2012";    //工号
    String name = "xht";    //姓名
    String position = "主管";    //职位
    String state = "在职";   //状态
    String department = "财务";  //部门
    String tel = "178545";
    String wage = "100000";   //  工资
    String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformation.txt";
    LinkedList<Personal> list = new LinkedList<>();


    @Test
    void listToTxtAdd() {

    }

    @Test
    void changeTxt() {
        Operation op = new Operation();
        LinkedList<Personal> list = new LinkedList<>();
        op.fileToPersonal();
        op.fileToCheckIn(list);
        op.fileToStaffInformation(list);
        op.fileToLog(list);

    }
}