/*
Practical Assignment – Collection – count of elements
Write a method that takes an array of elements as input and returns a 
Map where the keys are the elements themselves, and the values represent
how many times each element occurs.
*/

import java.util.*;

public class CollectionCountMainClass {

  public static <T> Map<T,Integer> changeToMap(T[] array)
  {
    Map<T,Integer> map= new HashMap();
    
    for(T i:array)
    {
      if(map.containsKey(i))
      {
        map.put(i,map.get(i) + 1);
      }
      else
      {
          map.put(i, 1);

      }
    }
    
    return map;
    
  }
  
  public static void main(String gg[])
  {
     Integer[] arr = {1, 2, 2, 3, 1, 4, 2};

        Map<Integer, Integer> result = CollectionCountMainClass.changeToMap(arr);

        System.out.println(result);
  }

}
