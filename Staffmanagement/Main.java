package Staffmanagement;

import Staffmanagement.FileToBeanToList.Operation;
import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.Jurisdiction.DMange;
import Staffmanagement.Jurisdiction.Staff;
import Staffmanagement.Login.Login;
import Staffmanagement.bean.Personal;
import Staffmanagement.Jurisdiction.Root;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author 许泓涛、邓文健、吴子乐
 * @date 2020-11-30
 * 职员管理系统：用户登录-权限管理-分权限展现内容
 * */
public class Main {

    public static void main(String[] args){
        LinkedList<Personal> list = new LinkedList<>();
        Login lo = new Login();
        Operation op = new Operation();
        op.fileToCheckIn(list);
        op.fileToLog(list);
        op.fileToStaffInformation(list);
        String num = lo.login(list);
        switch (Objects.requireNonNull(StaffToLinkedList.FindStaffInformation(list, num)).getPosition()){
                case "经理" :
                    new Root(list,num);
                    break;
                case "主管" :
                    new DMange(list,num);
                    break;
                case "职员" :
                    new Staff(list,num);
                    break;
                default:
                    System.out.println("您无权限进入管理系统！！");
                    break;
            }
        }
    }
