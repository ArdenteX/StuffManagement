package Staffmanagement.Model.sort;

import Staffmanagement.bean.Personal;

import java.util.Arrays;
import java.util.Arrays.*;
import java.util.Formatter;
import java.util.regex.Pattern;

/**
 * 合并排序*/
public class mergeSortX{
    private static void mergeSort(Personal[] Original){
        if(Original == null){
            throw new NullPointerException();
        }
        if(Original.length > 1){
            int mid = Original.length / 2;
            Personal[] PartL = Arrays.copyOfRange(Original,0,mid);
            Personal[] PartR = Arrays.copyOfRange(Original,mid,Original.length);
            mergeSort(PartL);
            mergeSort(PartR);
            Sort(PartL,PartR,Original);
        }
    }
    private static void Sort(Personal[] L,Personal[] R,Personal[] Original){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < L.length && j < R.length ){
            if(Integer.parseInt(L[i].getWage()) < Integer.parseInt(R[j].getWage())){
                Original[k] = L[i];
                i++;
                k++;
            }
            else{
                Original[k] = R[j];
                j++;
                k++;
            }
        }
        while(k < Original.length && i < L.length){
            Original[k] = L[i];
            i++;
            k++;
        }
        while(k < Original.length && j < R.length){
            Original[k] = R[j];
            j++;
            k++;
        }
    }
    public static void print(Personal[] Original){
        mergeSort(Original);
        Formatter f = new Formatter(System.out);
        System.out.println("合并排序结果为");
        f.format("%8s %10s %10s %10s %8s %10s %10s\n","工号","姓名","职位","任职状态","部门","电话","工资");
        System.out.println("\t-----------------------------------------------------------------------------------");
        for(Personal i : Original){
            f.format("%10s %10s %10s %10s %10s %15s %10s\n",i.getNum(),i.getName(),i.getPosition(),i.getState(),i.getDepartment(),i.getTel(),i.getWage());

        }
    }
    public static void printDe(Personal[] Original,String de){
        mergeSort(Original);
        Formatter f = new Formatter(System.out);
        System.out.println("合并排序结果为");
        f.format("%8s %10s %10s %10s %8s %10s %10s\n","工号","姓名","职位","任职状态","部门","电话","工资");
        System.out.println("\t-----------------------------------------------------------------------------------");
        for(Personal i : Original){
            if(i.getDepartment().equals(de)){
                f.format("%10s %10s %10s %10s %10s %15s %10s\n",i.getNum(),i.getName(),i.getPosition(),i.getState(),i.getDepartment(),i.getTel(),i.getWage());
            }
        }
    }
}

