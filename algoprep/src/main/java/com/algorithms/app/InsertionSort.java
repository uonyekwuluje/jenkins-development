package com.algorithms.app;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class InsertionSort{
   public void sort(){
      try {
       int[] nums = {6,5,3,11,8,7,2,1,9,4,13,12};
       //int[] nums = {6,5,3,1,8,7,2,4};
       System.out.println("Unsorted Array => "+Arrays.toString(nums));

       for (int x = 1; x<= nums.length - 1; x++){
       int curr = nums[x];
          for (int y = x; y> 0; y--){
              TimeUnit.SECONDS.sleep(1); 
              if (nums[y-1] > nums[y]){
                 nums[y] = nums[y-1];
                 nums[y-1] = curr;
              }
          }
          System.out.println("Sorted Array Pass ["+x+"] => "+Arrays.toString(nums));
       }
       System.out.println("Sorted Array => "+Arrays.toString(nums));
    } catch (InterruptedException e) {
           System.err.format("IOException: %s%n", e);
    }
   }
}
