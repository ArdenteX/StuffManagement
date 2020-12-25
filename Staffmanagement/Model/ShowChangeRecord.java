package Staffmanagement.Model;

import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.bean.Personal;

import java.util.LinkedList;


public class ShowChangeRecord {
    //显示所有人的变更记录
    public static void showAllChangeRecord(LinkedList<Personal> list){
        LinkedList<Personal> LogList = StaffToLinkedList.FindLog(list);
        System.out.println("\t工号\t\t\t姓名\t\t入职时间\t\t离职时间\t\t工资记录\t\t部门调整记录\t\t职位调整");
        for(Personal pe : LogList){
            System.out.println("\t"+pe.getNum()+"\t\t"+pe.getName()
                    +"\t\t"+pe.getInTime()+"\t\t"+pe.getOutTime()+"\t\t"+pe.getWageRecord()
                    +"\t\t"+pe.getDepartmentRecord()+"\t\t\t"+pe.getPositionRecord());
        }
    }
    //显示个人的变更记录
    public static void showPersonChangeRecord(LinkedList<Personal> list,String num){
        Personal pe = StaffToLinkedList.FindLog(list,num);
        System.out.println("\t工号\t\t\t姓名\t\t入职时间\t\t离职时间\t\t工资记录\t\t部门调整记录\t\t职位调整");
        assert pe != null;
        System.out.println("\t"+pe.getNum()+"\t\t"+pe.getName()
                +"\t\t"+pe.getInTime()+"\t\t"+pe.getOutTime()+"\t\t"+pe.getWageRecord()
                +"\t\t"+pe.getDepartmentRecord()+"\t\t\t"+pe.getPositionRecord());
    }
    public static void showDeChangeRecord(LinkedList<Personal> list,String num){
        LinkedList<Personal> pe = StaffToLinkedList.FindLog(list);
        LinkedList<Personal> pe1 = StaffToLinkedList.FindStaffInformation(list);
        System.out.println("\t工号\t\t\t姓名\t\t入职时间\t\t离职时间\t\t工资记录\t\t部门调整记录\t\t职位调整");
        for(int i = 0;i < pe1.size();i++){
            if(pe1.get(i).getDepartment().equals(num)){
                System.out.println("\t"+pe.get(i).getNum()+"\t\t"+pe.get(i).getName()
                        +"\t\t"+pe.get(i).getInTime()+"\t\t"+pe.get(i).getOutTime()+"\t\t"+pe.get(i).getWageRecord()
                        +"\t\t"+pe.get(i).getDepartmentRecord()+"\t\t\t"+pe.get(i).getPositionRecord());
            }
        }
    }
}
