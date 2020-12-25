package Staffmanagement.Model;

import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.IOOperation.LinkListOperation;
import Staffmanagement.bean.CheckIn;
import Staffmanagement.bean.Personal;

import java.nio.file.spi.FileSystemProvider;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 考勤模块
 * 考勤基本管理：调用时获取当前时间并于当天9：30比较判断是否出勤
 *             出勤则出勤属性增加一条时间反之同理
 * 请假管理：
 *             记录离开和返回的时间，如果超过两次则无法请假
 * 加班管理：
 * 打卡下班：
 * 考勤查询：
 * */
public class Check {
    //打卡上班
    public static boolean checkIn(int i, LinkedList<Personal> list){
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformation.txt";
        String path1 = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffCheckIn.txt";
        Date date = new Date();
        //数据转换 String->date date->String
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取具体日期
        Calendar cl = Calendar.getInstance();
        //将当前时间传入cl
        cl.setTime(date);

        //先用String制作日期
        String ymd = cl.get(Calendar.YEAR)+"-"+cl.get(Calendar.MONTH)+"-"+cl.get(Calendar.DAY_OF_MONTH)+" ";
        String now = ymd+cl.get(Calendar.HOUR_OF_DAY) +":"+ cl.get(Calendar.MINUTE)+":"+cl.get(Calendar.SECOND)+",";
        String checkIn = ymd+"09:30:00";

        try{
            //转化为date
            Date strDate1 = sd.parse(now);
            Date strDate2 = sd.parse(checkIn);
            //比较
            if(strDate2.compareTo(strDate1) > 0){
                System.out.println("出勤！");
                Objects.requireNonNull(StaffToLinkedList.FindCheckIn(list, list.get(i).getNum())).setAttendance(now);
                return true;
            }
            else{
                System.out.println("迟到！！");
                Objects.requireNonNull(StaffToLinkedList.FindCheckIn(list, list.get(i).getNum())).setLate(date.toString()+",");
                if(!Objects.requireNonNull(StaffToLinkedList.FindStaffInformation(list, list.get(i).getNum())).getExtra().equals("0")){
                    Objects.requireNonNull(StaffToLinkedList.FindStaffInformation(list, list.get(i).getNum()))
                            .setExtra(Objects.requireNonNull(StaffToLinkedList.FindStaffInformation(list, list.get(i).getNum())).getExtra()+ymd+"+100,");
                }
                else {
                    Objects.requireNonNull(StaffToLinkedList.FindStaffInformation(list, list.get(i).getNum())).setExtra(ymd+"+100,");
                }
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        LinkListOperation.changeTxt(StaffToLinkedList.FindCheckIn(list),path1);
        LinkListOperation.changeTxt(StaffToLinkedList.FindStaffInformation(list),path);
        return false;
    }

    //请假
    public static boolean leave(LinkedList<Personal> list,String num){
        Date date = new Date();
        Scanner scan = new Scanner(System.in);

        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffCheckIn.txt";

        Personal pe = StaffToLinkedList.FindCheckIn(list,num);
        assert pe != null;
        String[] check = pe.getLeave().split(",");

        if(check.length <= 2){
            System.out.println("请输入您的离开日期(yyyy-mm-dd)： ");
            String leaveTime = scan.next();
            System.out.println("请输入您的返回日期(yyyy-mm-dd)： ");
            String backTime = scan.next();

            String leave = leaveTime + "--->" + backTime+",";
            pe.setLeave(leave);
            LinkListOperation.changeTxt(StaffToLinkedList.FindCheckIn(list),path);
            System.out.println("请假成功，祝您生活愉快！");
            return true;
        }
        else {
            System.out.println("您的请假次数已满，不可再请假！");
            return  false;
        }

    }

    //打卡下班并判断是否为加班
    public static boolean offDuty(LinkedList<Personal> list,int i){
        String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformation.txt";
        String path1 = "D:\\广商网课\\作业\\数据结构\\大作业\\StaffCheckIn.txt";
        Date date = new Date();
        Personal ck = StaffToLinkedList.FindCheckIn(list,list.get(i).getNum());
        Personal staffImf = StaffToLinkedList.FindStaffInformation(list,list.get(i).getNum());
        //数据转换 String->date date->String
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取具体日期
        Calendar cl = Calendar.getInstance();
        //将当前时间传入cl
        cl.setTime(date);

        //先用String制作日期
        String ymd = cl.get(Calendar.YEAR)+"-"+cl.get(Calendar.MONTH)+"-"+cl.get(Calendar.DAY_OF_MONTH)+" ";
        String now = ymd+cl.get(Calendar.HOUR_OF_DAY) +":"+ cl.get(Calendar.MINUTE)+":"+cl.get(Calendar.SECOND)+",";
        String checkIn = ymd+"18:30:00";
        String checkOverTime = ymd+"22:00:00";

        try{
            Date strDate1 = sd.parse(now);
            Date strDate2 = sd.parse(checkIn);
            Date strDate3 = sd.parse(checkOverTime);
            if(strDate2.compareTo(strDate1) < 0){
                if(strDate3.compareTo(strDate1) < 0){
                    //Objects.requireNonNull(StaffToLinkedList.FindCheckIn(list, list.get(i).getNum())).setOverTime(now);
                    assert ck != null;
                    assert staffImf != null;
                    ck.setOverTime(ck.getOverTime() + date.toString());
                    if(!staffImf.getExtra().equals("0")){
                        Objects.requireNonNull(StaffToLinkedList.FindStaffInformation(list, list.get(i).getNum()))
                                .setExtra(Objects.requireNonNull(StaffToLinkedList.FindStaffInformation(list, list.get(i).getNum())).getExtra()+ymd+"+100,");
                    }
                    else {
                        Objects.requireNonNull(StaffToLinkedList.FindStaffInformation(list, list.get(i).getNum())).setExtra(ymd+"+100,");
                    }

                    System.out.println("您已到达加班阙值，已为您添加加班补贴！");
                }
                System.out.println("打卡成功，祝您下班愉快！");
                Objects.requireNonNull(StaffToLinkedList.FindCheckIn(list, list.get(i).getNum())).setOffDuty(now);
                return  true;
            }
            else{
                System.out.println("未到打卡时间，打卡失败！");
                return  false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        LinkListOperation.changeTxt(StaffToLinkedList.FindCheckIn(list),path1);
        LinkListOperation.changeTxt(StaffToLinkedList.FindStaffInformation(list),path);
        return false;
    }

    //考勤查询个人
    public static void CheckInquirePerson(LinkedList<Personal> list,String num){
        Personal pe = StaffToLinkedList.FindCheckIn(list,num);
        Formatter f = new Formatter(System.out);
        assert pe != null;
        f.format("%8s %10s %10s %10s\n","出勤","迟到","请假","加班");
        System.out.println("\t-----------------------------------------------------------------------------------");
        f.format("%8s %10s %10s %10s\n",pe.getAttendance(),pe.getLate(),pe.getLeave(),pe.getOverTime());
    }

    //考勤查询所有人
    public static void CheckInquireAll(LinkedList<Personal> list){
        Formatter f = new Formatter(System.out);
        f.format("%8s %10s %10s %10s %10s %10s\n","姓名","工号","出勤","迟到","请假","加班");
        LinkedList<Personal> PersonList = StaffToLinkedList.FindCheckIn(list);
        for(Personal pe : PersonList){
            f.format("%8s %10s %10s %10s %10s %10s\n",pe.getName(),pe.getNum(),pe.getAttendance(),pe.getLate(),pe.getLeave(),pe.getOverTime());
        }
    }

    public static void CheckInquireDepartment(LinkedList<Personal> list,String department){
        LinkedList<Personal> de = StaffToLinkedList.FindStaffInformation(list);
        LinkedList<Personal> PersonList = StaffToLinkedList.FindCheckIn(list);
        Formatter f = new Formatter(System.out);
        f.format("%8s %10s %10s %10s %10s %10s\n","姓名","工号","出勤","迟到","请假","加班");
        for(int i = 0;i<de.size();i++){
            if(de.get(i).getDepartment().equals(department)){
                f.format("%8s %10s %10s %10s %10s %10s\n",PersonList.get(i).getName(),PersonList.get(i).getNum(),
                        PersonList.get(i).getAttendance(),PersonList.get(i).getLate(),PersonList.get(i).getLeave(),PersonList.get(i).getOverTime());
            }
        }



    }
}
