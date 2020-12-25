package Staffmanagement.Jurisdiction;

import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.Model.Check;
import Staffmanagement.Model.InquireInformation;
import Staffmanagement.Model.ShowChangeRecord;
import Staffmanagement.Model.sort.mergeSortX;
import Staffmanagement.bean.Personal;

import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;

public class Staff {

    String num;
    String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalInformation.txt";

    public Staff(LinkedList<Personal> list, String num) {
        System.out.println("欢迎！职员！！");
        this.num = num;
        realize(list);
    }

    private void menu() {
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","----------------");
        f.format("%5s %10s\n","|","1.信息查询管理");
        f.format("%5s %10s\n","|","2.考勤管理");
        f.format("%5s %10s\n","|","3.变更日志");
        f.format("%5s %10s\n","|","4.退出");
        f.format("%5s %10s\n","|","----------------");
    }
    private void inMenu(){
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","----------------");
        f.format("%5s %10s\n","|","1.查询个人信息");
        f.format("%5s %10s\n","|","2.退出");
        f.format("%5s %10s\n","|","----------------");
        System.out.println("请选择所需要的操作: ");
    }
    private void checkMenu(){
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","----------------");
        f.format("%5s %10s\n","|","1.打卡上班");
        f.format("%5s %10s\n","|","2.请假");
        f.format("%5s %10s\n","|","3.打卡下班");
        f.format("%5s %10s\n","|","4.个人考勤");
        f.format("%5s %10s\n","|","5.退出");
        f.format("%5s %10s\n","|","----------------");
        System.out.println("请选择所需要的操作: ");
    }
    private void recordMenu(){
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","----------------");
        f.format("%5s %10s\n","|","1.个人变更日志");
        f.format("%5s %10s\n","|","2.退出");
        f.format("%5s %10s\n","|","----------------");
    }
    void inquire(LinkedList<Personal> list){
        Scanner scan = new Scanner(System.in);
        int choose;
        while(true){
            inMenu();
            choose = scan.nextInt();
            if(choose == 2) break;
            if (choose == 1) {
                InquireInformation.inquirePersonal(list, num);
            }
        }
    }
    void check(LinkedList<Personal> list){
        checkMenu();
        Scanner scan = new Scanner(System.in);
        LinkedList<Personal> ck = StaffToLinkedList.FindCheckIn(list);
        int i = StaffToLinkedList.LinkedListFindInt(ck,num);
        String num_staff;
        String department;
        int choose;
        while(true){
            checkMenu();
            choose = scan.nextInt();
            if(choose == 5) break;
            switch (choose){
                case 1:
                    Check.checkIn(i,list);
                    break;
                case 2:
                    Check.leave(list,num);
                    break;
                case 3:
                    Check.offDuty(list,i);
                    break;
                case 4:
                    Check.CheckInquirePerson(list,num);
                    break;
            }
        }
    }
    void changeRecord(LinkedList<Personal> list){
        Scanner scan = new Scanner(System.in);
        int choose;
        while(true){
            recordMenu();
            choose = scan.nextInt();
            if(choose == 2) break;
            if (choose == 1) {
                ShowChangeRecord.showPersonChangeRecord(list, num);
            }
        }

    }
    void realize(LinkedList<Personal> list){
        Scanner scan = new Scanner(System.in);
        while(true){
            menu();
            System.out.println("请选择要进行的操作: ");
            int choose = scan.nextInt();
            if(choose == 4){
                System.out.println("程序退出，欢迎您再次使用！");
                break;
            }
            switch (choose){
                case 1:
                    inquire(list);
                    break;
                case 2:
                    check(list);
                    break;
                case 3:
                    changeRecord(list);
                    break;

            }
        }
    }

}


