package Staffmanagement.APIs;

import Staffmanagement.bean.Personal;
import Staffmanagement.bean.StaffInformation;

import java.util.LinkedList;

public interface ChangeAPI{
    boolean change(LinkedList<Personal> list, String num, String newValue);
}

