package Staffmanagement.Model.ChangeValue;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.bean.Personal;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class ChangeOutTime{
    public static boolean change(LinkedList<Personal> list, String num) {
        Date date = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        String ymd = cl.get(Calendar.YEAR)+"-"+cl.get(Calendar.MONTH)+"-"+cl.get(Calendar.DAY_OF_MONTH)+" ";
        Personal pe = StaffToLinkedList.FindLog(list,num);
        assert pe != null;
        pe.setOutTime(ymd);
        return true;
    }
}
