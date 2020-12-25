package Staffmanagement.IOOperation;

import Staffmanagement.bean.Personal;
import Staffmanagement.bean.StaffInformation;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * 测试完毕
 * */
public class LinkListOperation {
    public static void ListToTxtAdd(Personal pe){
        String path1 = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffInformation.txt";
        String path2 = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformation.txt";
        String path3 = "D:\\广商网课\\作业\\数据结构\\大作业\\Log.txt";
        String path4 = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffCheckIn.txt";
        String path5 = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformationForever.txt";
        Date date = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        String ymd = cl.get(Calendar.YEAR)+"-"+cl.get(Calendar.MONTH)+"-"+cl.get(Calendar.DAY_OF_MONTH)+" ";
        String inputPersonal = pe.getNum()+" "+pe.getName()+" "+pe.getTel()+";";
        String input = pe.getPosition()+" "+pe.getState()
                +" "+pe.getDepartment()+" "+pe.getWage()+";";
        String Initialize = ymd+"0 0 0 0;";
        String Initialize1 = ymd+" "+"0"+" "+pe.getWage()+" "+pe.getDepartment()+" "+pe.getPosition()+";\r\n";
        FileOperation.fileWrite(path1,input);
        FileOperation.fileWrite(path2,inputPersonal);
        FileOperation.fileWrite(path3,Initialize1);
        FileOperation.fileWrite(path4,Initialize);
        FileOperation.fileWrite(path5,inputPersonal);
    }
    //简单粗暴的覆盖法，应对小型的数据还可以，但是用到大型都是用数据库了，所以没什么不可以的

    public static void changeTxt(LinkedList<Personal> list,String path){
        String input = "";
        String input1 = list.get(0).getPosition() + " " + list.get(0).getState()
                + " " + list.get(0).getDepartment()
                + " "+ list.get(0).getWage() +" "
                +list.get(0).getExtra()+" " +list.get(0).getAttendance()
                +" "+list.get(0).getOverTime()+" "+list.get(0).getLeave()+" "
                +list.get(0).getLate()+" "+list.get(0).getOffDuty()+" "
                +list.get(0).getInTime()+" "+list.get(0).getOutTime()+" "+list.get(0).getWageRecord()+" "+
                list.get(0).getDepartmentRecord()+" "+list.get(0).getPositionRecord();
        for(String ss : input1.split(" ")){
            if(!ss.equals("null")){
                input += ss + " ";
            }
        }
        input += ";\r\n";
        FileOperation.fileWriteCover(path,input);

        for(int i = 1;i<list.size();i++){
            String inputI = "";
            String input2 = list.get(i).getPosition() + " " + list.get(i).getState()
                    + " " + list.get(i).getDepartment()
                    + " "+ list.get(i).getWage() +" "
                    +list.get(i).getExtra()+" " +list.get(i).getAttendance()
                    +" "+list.get(i).getOverTime()+" "+list.get(i).getLeave()+" "
                    +list.get(i).getLate()+" "+list.get(i).getOffDuty()+" "
                    +list.get(i).getInTime()+" "+list.get(i).getOutTime()+" "+list.get(i).getWageRecord()+" "+
                    list.get(i).getDepartmentRecord()+" "+list.get(i).getPositionRecord();
            for(String ss : input2.split(" ")){
                if(!ss.equals("null")){
                    inputI += ss + " ";
                }
            }
            inputI += ";\r\n";
            FileOperation.fileWrite(path,inputI);
        }

    }
    public static void changeTxtPer(LinkedList<Personal> list){
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformation.txt";
        String input = "";
        String input1 = list.get(0).getNum()+" "+list.get(0).getName()+" "+list.get(0).getTel();
        for(String ss : input1.split(" ")){
            if(!ss.equals("null")){
                input += ss + " ";
            }
        }
        input += ";\r\n";
        FileOperation.fileWriteCover(path,input);

        for(int i = 1;i<list.size();i++){
            String inputI = "";
            String input2 = list.get(i).getNum()+" "+list.get(i).getName()+" "+list.get(i).getTel();
            for(String ss : input2.split(" ")){
                if(!ss.equals("null")){
                    inputI += ss + " ";
                }
            }
            inputI += ";\r\n";
            FileOperation.fileWrite(path,inputI);
        }
    }

}
