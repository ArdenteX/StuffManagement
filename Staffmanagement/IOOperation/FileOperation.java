package Staffmanagement.IOOperation;

import java.io.*;

public class FileOperation {
    public static String fileRead(String path){
        File file = new File(path);
        if(file.isFile() && file.exists()){
            try{
                //文件读取三件套
                FileInputStream fileinputstream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileinputstream);
                BufferedReader br = new BufferedReader(inputStreamReader);

                StringBuffer sb = new StringBuffer();
                String txt = null;
                while((txt = br.readLine()) != null){
                    sb.append(txt);
                }
                return sb.toString();
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
    public static void fileWrite(String path,String in){
        File file = new File(path);
        FileOutputStream fileOutputStream;
        try{
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            if(file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(in.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void fileWriteCover(String path,String in){
        File file = new File(path);
        FileOutputStream fileOutputStream;
        try{
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            if(file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(in.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
