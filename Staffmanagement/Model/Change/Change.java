package Staffmanagement.Model.Change;

import Staffmanagement.Factory.*;
import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.bean.Personal;

import java.util.LinkedList;

public class Change {
    public static void ChangeValue(LinkedList<Personal> list, String num, String newValue, String what){
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffInformation.txt";
        String path2 = "D:\\广商网课\\作业\\数据结构\\大作业\\Log.txt";
        LinkedList<Personal> de_list = StaffToLinkedList.FindStaffInformation(list);
        LinkedList<Personal> log_list = StaffToLinkedList.FindLog(list);
        switch (what){
            case "部门" :
                StaffToLinkedList.LinkedListChange(new ChangeDepartmentFactory(),num,newValue,list,path,de_list);
                StaffToLinkedList.LinkedListChange(new ChangeDRFactory(),num,newValue,list,path2,log_list);
                System.out.println("修改成功！");
                break;
            case "职位":
                StaffToLinkedList.LinkedListChange(new ChangePositionFactory(),num,newValue,list,path,de_list);
                StaffToLinkedList.LinkedListChange(new ChangePRFactory(),num,newValue,list,path2,log_list);
                System.out.println("修改成功！");
                break;
            case "任职状态" :
                StaffToLinkedList.LinkedListChange(new ChangeStateFactory(),num,newValue,list,path,de_list);
                System.out.println("修改成功！");
                break;
            case "薪水" :
                StaffToLinkedList.LinkedListChange(new ChangeWageFactory(),num,newValue,list,path,de_list);
                StaffToLinkedList.LinkedListChange(new ChangeWRFactory(),num,newValue,list,path2,log_list);
                System.out.println("修改成功！");
                break;
            default:
                System.out.println("请输入正确字符！！！");
                break;
        }
    }
}
