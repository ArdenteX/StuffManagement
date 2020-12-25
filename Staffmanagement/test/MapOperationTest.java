package Staffmanagement.test;

import Staffmanagement.FileToBeanToList.Operation;
import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.Login.PersonalLogin;
import Staffmanagement.Model.sort.mergeSortX;
import Staffmanagement.bean.CheckIn;
import Staffmanagement.bean.Personal;

import java.util.Arrays;
import java.util.LinkedList;

class MapOperationTest {
    String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalLogin.txt";

    @org.junit.jupiter.api.Test
    void txtToMap() {
        LinkedList<Personal> list = new LinkedList<>();
        Operation op = new Operation();
        op.fileToStaffInformation(list);
        op.fileToCheckIn(list);
        op.fileToLog(list);
        LinkedList<Personal> de_list = StaffToLinkedList.FindStaffInformation(list);
        Personal[] Original = new Personal[de_list.size()];
        for(int i = 0;i < de_list.size();i++){
            Original[i] = de_list.get(i);
        }
        mergeSortX.print(Original);
    }

    @org.junit.jupiter.api.Test
    void mapToTxt() {
        LinkedList<Personal> list = new LinkedList<>();
        Operation op = new Operation();
        op.fileToStaffInformation(list);
        op.fileToCheckIn(list);
        op.fileToLog(list);
        LinkedList<Personal> de_list = StaffToLinkedList.FindStaffInformation(list);
        Personal[] Original = new Personal[de_list.size()];
        for (int i = 0; i < de_list.size(); i++) {
            Original[i] = de_list.get(i);
        }
        mergeSortX.printDe(Original, "财管");
    }
}