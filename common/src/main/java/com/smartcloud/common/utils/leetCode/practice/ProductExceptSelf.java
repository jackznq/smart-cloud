package com.smartcloud.common.utils.leetCode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *      Product of Array Except Self
 *    给定的阵列Ñ整数其中Ñ > 1，
 *    nums，返回一个数组output，
 *    使得output[i]等于所有元素的乘积nums除nums[i]。
 *    解决它没有分裂和O（n）。
 *    例如，给定[1,2,3,4]，返回[24,12,8,6]。
 * Created by ddfhznq on 2017/11/20.
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        List<Integer> b =new ArrayList();
        b.add(2);
        b.add(28);
        b.add(4);
        b.add(5);
        b.add(8);
        b.add(9);
        List<Integer> result =productExceptSelf(b);
        System.out.println(result.toString());
    }
    public static List<Integer>productExceptSelf(List<Integer> nums){
        List<Integer> tempArray=new ArrayList<>(5);
        List<Integer> targetArray= new ArrayList<>();
        for (int i=0;i<nums.size();i++){
            tempArray.addAll(nums);
            tempArray.remove(i);
            targetArray.add(multy(tempArray));
            tempArray.clear();
        }
        return targetArray;
    }

    public static int multy(List<Integer> a){
         int result = 1;
        for (int i=0;i<a.size();i++){
            result = result*a.get(i);
        }
        return result;
    }
}
