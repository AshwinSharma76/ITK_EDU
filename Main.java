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
