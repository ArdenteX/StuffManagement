package Staffmanagement.Model.Change;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.Factory.ChangeFactory;
import Staffmanagement.bean.Personal;
import Staffmanagement.bean.StaffInformation;

import java.util.LinkedList;

public class ChangeConsumer {
    public static void changeConsumer(ChangeFactory cf, String num,
                                      String newValue, LinkedList<Personal> pe){
        ChangeAPI ca = cf.getChangeAPI();
        ca.change(pe,num,newValue);
    }
}
