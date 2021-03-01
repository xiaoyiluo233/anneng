package com.yidu.ljj;

import java.util.Scanner;

/**
 * @author 刘佳佳
 * @version 1.0
 * @公司 一度教育
 * @date 2021/1/1 14:26
 */
public class test {


    public static void main(String[] args) {
        int yun=0;
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入寄货地址:");
        String ji=scanner.next();
        System.out.print("请输入收货地址:");
        String sho=scanner.next();
        System.out.print("请输入货物类别:");
        String producttype=scanner.next();
        System.out.print("请输入货物体重:");
        int pweight=scanner.nextInt();
        if(pweight==1){
            yun=8;
        }else if(pweight>1){
            yun=8+(pweight-1);
        }
        System.out.println("运费:"+yun);




    }

}
