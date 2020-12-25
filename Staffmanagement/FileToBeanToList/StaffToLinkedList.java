package Staffmanagement.FileToBeanToList;

import Staffmanagement.Model.Change.Change;
import Staffmanagement.Model.Change.ChangeConsumer;
import Staffmanagement.Factory.ChangeFactory;
import Staffmanagement.IOOperation.LinkListOperation;
import Staffmanagement.Model.ChangeValue.ChangeOutTime;
import Staffmanagement.bean.CheckIn;
import Staffmanagement.bean.Log;
import Staffmanagement.bean.Personal;
import Staffmanagement.bean.StaffInformation;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * bean到链表的交互于链表的基本操作*/
public class StaffToLinkedList {
    //所有bean的初始化都需要经过这个方法
    public void ToLinkedList(LinkedList<Personal> list, Personal e){
        list.add(e);

    }
    //增
    public static void LinkedListAdd(LinkedList<Personal> list, StaffInformation e){
        Date date = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        //初始化操作
        String ymd = cl.get(Calendar.YEAR)+"-"+cl.get(Calendar.MONTH)+"-"+cl.get(Calendar.DAY_OF_MONTH)+" ";
        Personal pe = new Personal(e.getNum(),e.getName(),e.getTel());
        list.add(e);
        list.add(new CheckIn(pe,"1","0","0","0","0"));
        list.add(new Log(pe,ymd,"0",e.getWage(),e.getDepartment(),e.getPosition()));
        LinkListOperation.ListToTxtAdd(e);
    }
    //在链表修改值后直接覆盖文档
    //工厂设计模式的最终实现
    public static void LinkedListChange(ChangeFactory cf, String num, String newValue,
                                        LinkedList<Personal> pe, String path,LinkedList<Personal> small){
        ChangeConsumer.changeConsumer(cf,num,newValue,pe);
        LinkListOperation.changeTxt(small,path);


    }
    //先在链表删除后直接覆盖到文档中
    public static void LinkedListDelete(LinkedList<Personal> list,String num){
        String path1 = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffInformation.txt";
        String path2 = "D:\\广商网课\\作业\\数据结构\\大作业\\Log.txt";
        Personal pe2 = StaffToLinkedList.FindStaffInformation(list,num);
        list.remove(pe2);
        ChangeOutTime.change(list,num);

        LinkListOperation.changeTxt(StaffToLinkedList.FindStaffInformation(list),path1);
        LinkListOperation.changeTxtPer(StaffToLinkedList.FindStaffInformation(list));
        LinkListOperation.changeTxt(StaffToLinkedList.FindLog(list),path2);
        System.out.println("删除成功！！");

    }
    //查找是否存在
    public static boolean LinkedListFindBoolean(LinkedList<Personal> list,String num){
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getNum().equals(num)){
                return true;
            }
        }
        return false;
    }
    //查找是否存在此部门
    public static boolean LinkedListFindBooleanD(LinkedList<Personal> list,String num){
        LinkedList<Personal> pe = FindStaffInformation(list);
        for(Personal pe1 : pe){
            if(pe1.getDepartment().equals(num)){
                return true;
            }
        }
        return false;
    }
    //返回工号所在的索引值
    public static int LinkedListFindInt(LinkedList<Personal> list,String num){
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getNum().equals(num)){
                return i;
            }
        }
        return -1;
    }
    //查找此工号的职员bean并返回一个personal类型的对象
    public static Personal FindStaffInformation(LinkedList<Personal> list,String num){
        for(Personal pe : list){
            if(pe.getNum().equals(num) && !pe.getDepartment().equals("null")){
                return pe;
            }
        }
        return null;
    }

    //返回一个由主表中所有职员bean组成的子链表
    public static LinkedList<Personal> FindStaffInformation(LinkedList<Personal> list){
        LinkedList<Personal> SmallList = new LinkedList<>();
        for(Personal pe : list){
            if(!pe.getDepartment().equals("null")){
                SmallList.add(pe);
            }
        }
        return SmallList;
    }
    public static Personal FindCheckIn(LinkedList<Personal> list,String num){
        for(Personal pe : list){
            if(pe.getNum().equals(num) && !pe.getAttendance().equals("null")){
                return pe;
            }
        }
        return null;
    }
    public static LinkedList<Personal> FindCheckIn(LinkedList<Personal> list){
        LinkedList<Personal> SmallList = new LinkedList<>();
        for(Personal pe : list){
            if(!pe.getAttendance().equals("null")){
                SmallList.add(pe);
            }
        }
        return SmallList;
    }
    public static Personal FindLog(LinkedList<Personal> list,String num){
        for(Personal pe : list){
            if(pe.getNum().equals(num) && !pe.getDepartmentRecord().equals("null")){
                return pe;
            }
        }
        return null;
    }
    public static LinkedList<Personal> FindLog(LinkedList<Personal> list){
        LinkedList<Personal> SmallList = new LinkedList<>();
        for(Personal pe : list){
            if(!pe.getDepartmentRecord().equals("null")){
                SmallList.add(pe);
            }
        }
        return SmallList;
    }
    public static Personal FindPersonal(LinkedList<Personal> list,String num){
        for(Personal pe : list){
            if(pe.getNum().equals(num) && pe.getAttendance().equals("null") && pe.getDepartment().equals("null") && pe.getPositionRecord().equals("null")){
                return pe;
            }
        }
        return null;
    }
    public static LinkedList<Personal> FindPersonal(LinkedList<Personal> list){
        LinkedList<Personal> SmallList = new LinkedList<>();
        for(Personal pe : list){
            if(!pe.getAttendance().equals("null") && !pe.getDepartment().equals("null") && !pe.getPositionRecord().equals("null")){
                SmallList.add(pe);
            }
        }
        return SmallList;
    }
}
