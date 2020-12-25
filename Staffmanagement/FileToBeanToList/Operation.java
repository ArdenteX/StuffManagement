package Staffmanagement.FileToBeanToList;

import Staffmanagement.bean.CheckIn;
import Staffmanagement.bean.Log;
import Staffmanagement.bean.Personal;
import Staffmanagement.bean.StaffInformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//文件操作类
/**
 * 实现了文件于bean之间的交互，为下一步bean于链表之间的交互打好基础*/
public class Operation {
    StaffToLinkedList st = new StaffToLinkedList();
    /**
     * @param path 文件地址*/
    public String[] fileTo(String path){
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            String str = "";
            while ((line = bufferedReader.readLine()) != null) {
                str += line;
            }
            return str.split(";");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void fileToStaffInformation(LinkedList<Personal> list){

        ArrayList<Personal> save = fileToPersonal();
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffInformation.txt";
        String[] strLen = fileTo(path);
        String[] spilt;
        int count = 0;
        for(String ss : strLen){
            spilt = ss.split(" ");
            st.ToLinkedList(list,new StaffInformation(save.get(count),spilt[0],spilt[1],spilt[2],spilt[3],spilt[4]));
            count++;
        }
    }
    public void fileToCheckIn(LinkedList<Personal> list){
        ArrayList<Personal> save = fileToPersonalForever();
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffCheckIn.txt";
        String[] strLen = fileTo(path);
        String[] spilt;
        int count = 0;
        for(String ss : strLen){
            spilt = ss.split(" ");
            st.ToLinkedList(list,new CheckIn(save.get(count),spilt[0],spilt[1],spilt[2],spilt[3],spilt[4]));
            count++;
        }
    }
    public void fileToLog(LinkedList<Personal> list){
        ArrayList<Personal> save = fileToPersonalForever();
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\Log.txt";
        String[] strLen = fileTo(path);
        String[] spilt;
        int count = 0;
        for(String ss : strLen){
            spilt = ss.split(" ");
            st.ToLinkedList(list,new Log(save.get(count),spilt[0],spilt[1],spilt[2],spilt[3],spilt[4]));
            count++;
        }
    }
    public  ArrayList<Personal> fileToPersonal(){
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformation.txt";
        String[] strLen = fileTo(path);
        String[] spilt;
        ArrayList<Personal> al = new ArrayList<>();
        for(String ss : strLen){
            spilt = ss.split(" ");
            al.add(new Personal(spilt[0],spilt[1],spilt[2]));
        }
        return al;
    }
    public  ArrayList<Personal> fileToPersonalForever(){
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformationForever.txt";
        String[] strLen = fileTo(path);
        String[] spilt;
        ArrayList<Personal> al = new ArrayList<>();
        for(String ss : strLen){
            spilt = ss.split(" ");
            al.add(new Personal(spilt[0],spilt[1],spilt[2]));
        }
        return al;
    }


}
