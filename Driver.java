import java.util.*;
import java.io.*;
public class Driver{
  private static final int INCREASE = 0;
   private static final int DECREASE = 1;
   private static final int STANDARD = 2;
   private static final int SMALL_RANGE = 3;

   private static String name(int i){
     if(i==INCREASE)return "Increassing";
     if(i==DECREASE)return "Decreassing";
     if(i==STANDARD)return "Normal Random";
     if(i==SMALL_RANGE)return "Random with Few Values";
     return "Error categorizing array";

   }

   private static int create(int min, int max){
     return min + (int)(Math.random()*(max-min));
   }

   private static int[]makeArray(int size,int type){
     int[]ans =new int[size];
     if(type == STANDARD){
       for(int i = 0; i < size; i++){
         ans[i]= create(-1000000,1000000);
       }
     }
     else if(type == INCREASE){
       int current = -5 * size;
       for(int i = 0; i < size; i++){
         ans[i]= create(current,current + 10);
         current += 10;
       }
     }
     else if(type == DECREASE){
       int current = 5 * size;
       for(int i = 0; i < size; i++){
         ans[i]= create(current,current + 10);
         current -= 10;
       }
     }
     else if(type == SMALL_RANGE){
       for(int i = 0; i < size; i++){
         ans[i]= create(-5,5);
       }
     }
     else{
       ans = new int[0];//empty is default
     }
     return ans;
   }

   public static void main(String[]args){

     System.out.println(args[0]);
     System.out.println(args[1]);
     System.out.println(args[2]);
     if(args.length < 3)return;

     int size =  Integer.parseInt(args[0]);
     int type =   Integer.parseInt(args[1]);

     int [] start = makeArray(size,type);
     int [] result = Arrays.copyOf(start,start.length);
     Arrays.sort(result);

     long startTime = System.currentTimeMillis();
     if(Integer.parseInt(args[2])==0){
       Merge.mergesort(start);
     }
     else{
       Quick.quicksort(start);
     }
     long elapsedTime = System.currentTimeMillis() - startTime;
     if(Arrays.equals(start,result)){
       System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
     }else{
       System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
     }
   }
}
