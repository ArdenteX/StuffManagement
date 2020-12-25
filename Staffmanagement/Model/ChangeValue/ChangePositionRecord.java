package Staffmanagement.Model.ChangeValue;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.bean.Personal;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class ChangePositionRecord implements ChangeAPI {
    @Override
    public boolean change(LinkedList<Personal> list, String num, String newValue) {
        Date date = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        String ymd = cl.get(Calendar.YEAR)+"-"+cl.get(Calendar.MONTH)+"-"+cl.get(Calendar.DAY_OF_MONTH)+" ";
        Personal pe = StaffToLinkedList.FindLog(list,num);
        String a = "->"+ymd+newValue;
        assert pe!=null;
        if(pe.getPositionRecord().equals("null")){
            pe.setPositionRecord(newValue);
        }
        else{
            pe.setPositionRecord(pe.getPositionRecord()+a);
        }
        return true;
    }
}
