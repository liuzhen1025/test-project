package com.gennlife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzhen278
 * @title: SubCollecion
 * @projectName mytest-project
 * @description: https://www.lintcode.cn/problem/subsets/description
 * @date 2019/7/1520:04
 */
public class SubCollecion {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subList = new ArrayList<>(nums.length);
        List<Integer> all = new ArrayList<>(nums.length);
        subList.add(new ArrayList<Integer>());
        if(nums == null || nums.length<1){
            return subList;
        }
        int k = 0;

        loop:
        for (int i = k; i<nums.length;i++) {
            List<Integer> sub = new ArrayList<>();
            List<Integer> single = new ArrayList<>(1);
            single.add(nums[i]);
            subList.add(single);
            all.add(nums[k]);
            sub.add(nums[i]);
            for (int m = i+1; m<nums.length;m++) {
                sub.add(nums[m]);
            }
            subList.add(sub);
            k++;
            continue loop;
        }
        subList.add(all);
        return subList;
    }

    public static void main(String[] args) {
        SubCollecion collecion = new SubCollecion();
        int[] ints = new int[3];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;

        System.out.println(collecion.subsets(ints));
    }
}
