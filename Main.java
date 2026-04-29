/*
Write a filter method that takes an array of any type as its input. As a second argument, the method should accept a class that implements the Filter interface, which contains a single method:
T apply(T o)
(parameterized).
The method must be implemented so that it returns a new array in which the apply function has been applied to each element.
*/


import java.util.*;

public class Main {
    public static void main(String[] args) {
      Integer ary[]={1,2,3,4};
      
      Filter<Integer> temp= new Filter<Integer>(){
        
        public Integer apply(Integer o) {
                return o * 2;
            }
      };
      
      Integer[] result = FilterClass.filter(ary, temp);
      for(int i: result)
      {
        System.out.println(i + " ");
      }

    }
}
