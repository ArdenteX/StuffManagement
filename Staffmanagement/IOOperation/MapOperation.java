package Staffmanagement.IOOperation;

import java.util.HashMap;
import java.util.Map;

public class MapOperation {
    //从txt中读取数据并返回一个Map传递给程序以进行用户登录
    public static HashMap<String,String> txtToMap(String path){
        try{
            HashMap<String,String> map = new HashMap<>();
            String flag = FileOperation.fileRead(path);
            assert flag != null;
            String[] txt = flag.split(";");

            for(String str : txt){
                if(!str.equals(" ")){
                    String[] sp = str.split(":");
                    map.put(sp[0],sp[1]);
                }
            }
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    /**
     * 未修改
     * 应改成：添加和修改两个方法*/
    public static void mapToTxt(Map<String,String> map, String path){
        String str = "";
        int count = 0;
        for(String key : map.keySet()){
            if(count == 0){
                str = key + ":" + map.get(key) + ";\r\n";
                FileOperation.fileWriteCover(path,str);
                count++;
                continue;
            }
            str = key + ":" + map.get(key) + ";\r\n";
            FileOperation.fileWrite(path,str);
        }

    }
    public static void mapToTxtAdd(String path,String key,String value){
        String str = key + ":" + value + ";\r\n";
        FileOperation.fileWrite(path,str);
    }

}
