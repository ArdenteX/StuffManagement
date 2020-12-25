package Staffmanagement.Model;

import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.bean.Personal;

import java.util.Formatter;
import java.util.LinkedList;

public class InquireInformation {
    public static void inquireAll(LinkedList<Personal> list){
        Formatter f = new Formatter(System.out);
        f.format("%8s %10s %10s %10s %8s %10s %10s %10s %10s\n","工号","姓名","职位","任职状态","部门","电话","工资","出勤","缺勤");
        System.out.println("\t--------------------------------------------------------------------------------------------------");
        LinkedList<Personal> ckList = StaffToLinkedList.FindCheckIn(list);
        LinkedList<Personal> deList = StaffToLinkedList.FindStaffInformation(list);

        for(int i = 0;i < deList.size();i++){
            f.format("%10s %10s %10s %10s %10s %15s %10s %10s %10s\n",deList.get(i).getNum(),deList.get(i).getName(),deList.get(i).getPosition(),
                    deList.get(i).getState(),deList.get(i).getDepartment(),deList.get(i).getTel(),deList.get(i).getWage(),ckList.get(i).getAttendance(),ckList.get(i).getLate());
        }
    }

    public static void inquireDepartment(LinkedList<Personal> list,String department){
        try{
            Formatter f = new Formatter(System.out);
            LinkedList<Personal> deList = StaffToLinkedList.FindStaffInformation(list);
            System.out.println("\t\t"+department+"部");
            f.format("%8s %10s %10s %10s %8s %10s %10s\n","工号","姓名","职位","任职状态","部门","电话","工资");
            System.out.println("\t-----------------------------------------------------------------------------------");
            for(Personal pe : deList){
                if(pe.getDepartment().equals(department)){
                    f.format("%10s %10s %10s %10s %10s %15s %10s\n",pe.getNum(),pe.getName(),pe.getPosition(),pe.getState(),pe.getDepartment(),pe.getTel(),pe.getWage());
                }
            }
        }catch (Exception e){
            System.out.println("请输入正确部门名！！");
        }
    }

    public static void inquirePersonal(LinkedList<Personal> list, String num){
        Formatter f = new Formatter(System.out);
        Personal pe3 = StaffToLinkedList.FindStaffInformation(list,num);
        assert pe3 != null;

        f.format("%8s %10s %10s %10s %8s %10s %10s\n","工号","姓名","职位","任职状态","部门","电话","工资");
        System.out.println("\t-----------------------------------------------------------------------------------");
        f.format("%10s %10s %10s %10s %10s %15s %10s\n",pe3.getNum(),pe3.getName(),pe3.getPosition(),pe3.getState(),pe3.getDepartment(),pe3.getTel(),pe3.getWage());

    }
}
