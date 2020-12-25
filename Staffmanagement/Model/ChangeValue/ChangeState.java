package Staffmanagement.Model.ChangeValue;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.bean.Personal;

import java.util.LinkedList;

public class ChangeState implements ChangeAPI {
    public boolean change(LinkedList<Personal> list, String num, String newValue) {
        LinkedList<Personal> peList = StaffToLinkedList.FindStaffInformation(list);
        for(Personal pe : peList){
            if(pe.getNum().equals(num)){
                pe.setState(newValue);
                return true;
            }
        }
        return false;
    }
}
