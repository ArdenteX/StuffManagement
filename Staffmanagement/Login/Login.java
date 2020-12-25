package Staffmanagement.Login;

import Staffmanagement.FileToBeanToList.StaffToLinkedList;
import Staffmanagement.bean.Personal;

import java.util.LinkedList;
import java.util.Scanner;

public class Login {
    //登录
    public String login(LinkedList<Personal> list){
        Scanner scan = new Scanner(System.in);
        PersonalLogin per = new PersonalLogin();

        while(true){
            System.out.println("欢迎使用职员管理系统！");
            String num;
            String password;

                System.out.println("请输入工号: ");
                num = scan.next();

                System.out.println("请输入密码: ");
                password = scan.next();

                //账号密码正确且链表中可以查询到此人
                if(per.Login(num,password) && StaffToLinkedList.LinkedListFindBoolean(list,num)){
                    System.out.println("登陆成功");
                    return num;
                    }
                else{
                    System.out.println("账号或密码输入错误，请仔细检查！");
                }


        }

    }
}
