package com.gennlife;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author liuzhen278
 * @title: ShuihuaXian
 * @projectName mytest-project
 * @description:
 * 编写一个添加两个数字A和B的函数。
 *
 * 无需从标准输入流中读取数据。这两个参数都是在函数中给出的aplusb，你的工作就是计算总和并返回它。
 *
 * 你是否在真实的采访中遇到过这个问题？
 * 澄清
 * a和b都是32-bit整数吗？
 *
 * 是。
 * 我可以使用位操作吗？
 *
 * 你当然可以。
 * 例
 * 例1：
 *
 * Input:  a = 1, b = 2
 * Output: 3
 * Explanation: return the result of a + b.
 * 例2：
 *
 * Input:  a = -1, b = 1
 * Output: 0
 * Explanation: return the result of a + b.
 * @date 2019/7/117:18
 */
public class ShuihuaXian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int b = scanner.nextInt();
            sum1(b);
        }

    }
    public static int sum(int a, int b){
        return a+b;
    }
    public static void sum1(int n){
        BigDecimal big = new BigDecimal(1);
        int count = 0;
        while(n>1){
            big = big.multiply(new BigDecimal(n)).setScale(0);
            n = n-1;
        }

        String s = big.toString();

        for (int i = s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '0'){
                count = count+1;
            }else{
                break;
            }
        }
        System.out.println(count);

    }
}
