package Staffmanagement.Login;

import Staffmanagement.IOOperation.MapOperation;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * 个人账户密码用map来实现*/
public class PersonalLogin {
    /**此地后要换成跟txt交互的 不能是 new HashMap<></>*/
    String path = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalLogin.txt";
    String MapPath = "D:\\广商网课\\作业\\数据结构\\大作业\\PersonalLogin.txt";
    HashMap<String,String> per_map_name = MapOperation.txtToMap(path);

    public void add(String num,String password){
        per_map_name.put(num,password);
        MapOperation.mapToTxtAdd(path,num,password);
    }

    //or tel
    //登录实现
    boolean Login(String name,String password){
        for(Map.Entry<String,String> m : per_map_name.entrySet()){
            if(m.getKey().equals(name)){
                if(m.getValue().equals(password)) return true;
            }
        }
        return false;
    }
    public void ChangeValue(String key,String newValue){
        for(Map.Entry<String,String> m : per_map_name.entrySet()){
            if(m.getKey().equals(key)){
                per_map_name.put(key, newValue);
                MapOperation.mapToTxt(per_map_name,MapPath);
                System.out.println("修改成功");
                break;

            }
        }

    }

}
