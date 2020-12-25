package Staffmanagement.Jurisdiction;

import Staffmanagement.FileToBeanToList.Operation;
import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.Login.PersonalLogin;
import Staffmanagement.Model.Check;
import Staffmanagement.Model.InquireInformation;
import Staffmanagement.Model.ShowChangeRecord;
import Staffmanagement.Model.sort.mergeSortX;
import Staffmanagement.bean.Personal;
import Staffmanagement.bean.StaffInformation;

import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;

import static Staffmanagement.Model.Change.Change.ChangeValue;
import static Staffmanagement.Model.InquireInformation.*;

public class Root{
    String num;
    public Root(LinkedList<Personal> list, String num){
        System.out.println("Welcome！ SuperManger！");
        this.num = num;
        realize(list);
    }
    private void menu() {
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","----------------");
        f.format("%5s %10s\n","|","1.信息查询管理");
        f.format("%5s %10s\n","|","2.考勤管理");
        f.format("%5s %10s\n","|","3.修改管理");
        f.format("%5s %10s\n","|","4.变更日志");
        f.format("%5s %10s\n","|","5.退出");
        f.format("%5s %10s\n","|","----------------");
    }
    private void inMenu(){
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","----------------");
        f.format("%5s %10s\n","|","1.查询所有人信息");
        f.format("%5s %10s\n","|","2.查询个人信息");
        f.format("%5s %10s\n","|","3.查询员工信息");
        f.format("%5s %10s\n","|","4.按部门查询信息");
        f.format("%5s %10s\n","|","5.按工资排序查询");
        f.format("%5s %10s\n","|","6.按工资排序查询(部门)");
        f.format("%5s %10s\n","|","7.退出");
        f.format("%5s %10s\n","|","----------------");
        System.out.println("请选择所需要的操作: ");
    }
    private void changeMenu(){
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","-------------------");
        f.format("%5s %10s\n","|","1.修改密码");
        f.format("%5s %10s\n","|","2.更改员工所属部门");
        f.format("%5s %10s\n","|","3.更改员工职位");
        f.format("%5s %10s\n","|","4.更改员工任职状态");
        f.format("%5s %10s\n","|","5.更改员工薪资");
        f.format("%5s %10s\n","|","6.添加员工");
        f.format("%5s %10s\n","|","7.开除员工");
        f.format("%5s %10s\n","|","8.退出");
        f.format("%5s %10s\n","|","-------------------");
        System.out.println("请选择所需要的操作: ");
    }
    private void checkMenu(){
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","----------------");
        f.format("%5s %10s\n","|","1.打卡上班");
        f.format("%5s %10s\n","|","2.请假");
        f.format("%5s %10s\n","|","3.打卡下班");
        f.format("%5s %10s\n","|","4.个人考勤");
        f.format("%5s %10s\n","|","5.所有员工考勤");
        f.format("%5s %10s\n","|","6.员工考勤");
        f.format("%5s %10s\n","|","7.部门考勤");
        f.format("%5s %10s\n","|","8.退出");
        f.format("%5s %10s\n","|","----------------");
        System.out.println("请选择所需要的操作: ");
    }
    private void recordMenu(){
        Formatter f = new Formatter(System.out);
        f.format("%5s %10s\n","|","----------------");
        f.format("%5s %10s\n","|","1.个人变更日志");
        f.format("%5s %10s\n","|","2.员工变更日志");
        f.format("%5s %10s\n","|","3.部门员工变更日志");
        f.format("%5s %10s\n","|","4.所有人变更日志");
        f.format("%5s %10s\n","|","5.退出");
        f.format("%5s %10s\n","|","----------------");

    }
    void inquire(LinkedList<Personal> list){
        Scanner scan = new Scanner(System.in);
        int choose;
        while(true){
            inMenu();
            choose = scan.nextInt();
            if(choose == 7) break;
            switch (choose){
                case 1:
                    InquireInformation.inquireAll(list);
                    break;
                case 2:
                    InquireInformation.inquirePersonal(list,num);
                    break;
                case 3:
                    System.out.println("请输入员工的工号： ");
                    String num_staff = scan.next();
                    if(!StaffToLinkedList.LinkedListFindBoolean(list,num_staff)){
                        System.out.println("查无此员工！");
                        break;
                    }
                    InquireInformation.inquirePersonal(list,num_staff);
                    break;
                case 4:
                    System.out.println("请输入想要查询的部门： ");
                    String department = scan.next();
                    InquireInformation.inquireDepartment(list,department);
                    break;
                case 5:
                    LinkedList<Personal> de_list = StaffToLinkedList.FindStaffInformation(list);
                    Personal[] Original = new Personal[de_list.size()];
                    for(int i = 0;i < de_list.size();i++){
                        Original[i] = de_list.get(i);
                    }
                    mergeSortX.print(Original);
                    break;
                case 6:
                    System.out.println("请输入需要查询的部门： ");
                    String de = scan.next();
                    LinkedList<Personal> dm_list = StaffToLinkedList.FindStaffInformation(list);
                    Personal[] OriginalD = new Personal[dm_list.size()];
                    for (int i = 0; i < dm_list.size(); i++) {
                        OriginalD[i] = dm_list.get(i);
                    }
                    mergeSortX.printDe(OriginalD, de);
                    break;

            }
        }
    }
    void changeManage(LinkedList<Personal> list){
        changeMenu();
        Scanner scan = new Scanner(System.in);
        PersonalLogin pl = new PersonalLogin();
        int choose;
        LinkedList<Personal> pe = StaffToLinkedList.FindStaffInformation(list);
        String numS;
        String newValue;
        while(true) {
            changeMenu();
            choose = scan.nextInt();
            if(choose == 8){
                break;
            }
            switch (choose) {
                case 1:
                    System.out.println("请输入新密码： ");
                    String neValue = scan.next();
                    pl.ChangeValue(num,neValue);
                    break;
                case 2:
                    System.out.println("请输入需要修改的员工的工号： ");
                    numS = scan.next();
                    if (!StaffToLinkedList.LinkedListFindBoolean(pe,numS)){
                        System.out.println("查无此员工！！");
                        break;
                    }

                    System.out.println("请输入新值： ");
                    newValue = scan.next();
                    ChangeValue(list,numS,newValue,"部门");
                    break;
                case 3:

                    System.out.println("请输入需要修改的员工的工号： ");
                    numS = scan.next();
                    if (!StaffToLinkedList.LinkedListFindBoolean(pe,numS)){
                        System.out.println("查无此员工！！");
                        break;
                    }

                    System.out.println("请输入新值： ");
                    newValue = scan.next();
                    ChangeValue(list,numS,newValue,"职位");
                    break;
                case 4:
                    System.out.println("请输入需要修改的员工的工号： ");
                    numS = scan.next();
                    if (!StaffToLinkedList.LinkedListFindBoolean(pe,numS)){
                        System.out.println("查无此员工！！");
                        break;
                    }

                    System.out.println("请输入新值： ");
                    newValue = scan.next();
                    ChangeValue(list,numS,newValue,"任职状态");
                    break;
                case 5:
                    System.out.println("请输入需要修改的员工的工号： ");
                    numS = scan.next();
                    if (!StaffToLinkedList.LinkedListFindBoolean(pe,numS)){
                        System.out.println("查无此员工！！");
                        break;
                    }

                    System.out.println("请输入新值： ");
                    newValue = scan.next();
                    ChangeValue(list,numS,newValue,"薪水");
                    break;
                case 6:
                    String numAdd;    //工号
                    String name;    //姓名
                    String position;    //职位
                    String state;   //状态
                    String departmentAdd;  //部门
                    String tel;
                    String wage;   //  工资
                    String password;
                    System.out.println("请输入工号： ");
                    numAdd = scan.next();
                    System.out.println("请输入姓名： ");
                    name = scan.next();
                    System.out.println("请输入职位： ");
                    position = scan.next();
                    System.out.println("请输入在职状态");
                    state = scan.next();
                    System.out.println("请输入部门： ");
                    departmentAdd = scan.next();
                    System.out.println("请输入电话号码： ");
                    tel = scan.next();
                    System.out.println("请输入工资： ");
                    wage = scan.next();
                    System.out.println("请输入账号密码： ");
                    password = scan.next();
                    Personal pe1 = new Personal(numAdd,name,tel);
                    StaffToLinkedList.LinkedListAdd(list,new StaffInformation(pe1,position,state,departmentAdd,wage,"1"));
                    pl.add(numAdd,password);
                    System.out.println("创建成功！！");
                    break;
                case 7:
                    String delete;
                    System.out.println("请输入被开除员工工号： ");
                    delete = scan.next();
                    if (!StaffToLinkedList.LinkedListFindBoolean(list,delete)){
                        System.out.println("查无此员工！！");
                        break;
                    }
                    StaffToLinkedList.LinkedListDelete(list,delete);
                    break;
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
            if(choose == 8) break;
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
                case 5:
                    Check.CheckInquireAll(list);
                    break;
                case 6:
                    System.out.println("请输入需要查询的员工的员工号： ");
                    num_staff = scan.next();
                    if(StaffToLinkedList.LinkedListFindBoolean(list,num_staff)){
                        Check.CheckInquirePerson(ck,num_staff);
                    }
                    else System.out.println("查无此员工号！");
                    break;
                case 7:
                    System.out.println("请输入需要查询的部门号： ");
                    department = scan.next();
                    if(StaffToLinkedList.LinkedListFindBooleanD(list,department)){
                        Check.CheckInquireDepartment(list,department);
                    }
                    else System.out.println("请输入正确部门！");

            }
        }
    }
    void changeRecord(LinkedList<Personal> list){
        Scanner scan = new Scanner(System.in);
        int choose;
        while(true){
            recordMenu();
            choose = scan.nextInt();
            if(choose == 5) break;
            switch (choose){
                case 1:
                    ShowChangeRecord.showPersonChangeRecord(list,num);
                    break;
                case 2:
                    System.out.println("请输入员工工号： ");
                    String num_Staff = scan.next();
                    if(StaffToLinkedList.LinkedListFindBoolean(list,num_Staff)){
                        ShowChangeRecord.showPersonChangeRecord(list,num_Staff);
                    }
                    else {
                        System.out.println("查无此员工！！");
                    }

                    break;
                case 3:
                    System.out.println("请输入需要查询的部门： ");
                    String department = scan.next();
                    if(StaffToLinkedList.LinkedListFindBooleanD(list,department)){
                        ShowChangeRecord.showDeChangeRecord(list,department);
                    }
                    else System.out.println("请输入正确的部门！");
                    break;
                case 4:
                    ShowChangeRecord.showAllChangeRecord(list);
                    break;
            }
        }

    }
    void realize(LinkedList<Personal> list){
        Scanner scan = new Scanner(System.in);
        while(true){
            menu();
            System.out.println("请选择要进行的操作: ");
            int choose = scan.nextInt();
            if(choose == 5){
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
                    changeManage(list);
                    break;
                case 4:
                    changeRecord(list);
                    break;
                default:
                    System.out.println("请输入正确数字！");
                    break;

            }
        }
    }

}
