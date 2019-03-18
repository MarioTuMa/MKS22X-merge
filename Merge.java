import java.util.*;
import java.io.*;
public class Merge{
  public static String toString(int[] arr){
    String toReturn = "";
    for(int i = 0;i < arr.length;i++){
      toReturn+=arr[i]+", ";
    }
    return toReturn;
  }
  public static int[] merger(int[] arr1, int[] arr2, int[] data){

    int arr1Counter = 0;
    int arr2Counter = 0;
    for(int i = 0; i<arr1.length+arr2.length;i++){
      if(arr1Counter > arr1.length - 1){
        data[i]=arr2[arr2Counter];
      }
      else if(arr2Counter > arr2.length - 1){
        data[i]=arr1[arr1Counter];
      }
      else{
        if(arr1[arr1Counter]>arr2[arr2Counter]){
          data[i]=arr2[arr2Counter];
          arr2Counter++;
        }
        else{
          data[i]=arr1[arr1Counter];
          arr1Counter++;
        }
      }
    }
    return data;
  }
  public static int[] merger(int[] arr1, int[] arr2){
    int[] toReturn = new int[arr1.length+arr2.length];
    int arr1Counter = 0;
    int arr2Counter = 0;
    for(int i = 0; i<arr1.length+arr2.length;i++){
      if(arr1Counter > arr1.length - 1){
        toReturn[i]=arr2[arr2Counter];
      }
      else if(arr2Counter > arr2.length - 1){
        toReturn[i]=arr1[arr1Counter];
      }
      else{
        if(arr1[arr1Counter]>arr2[arr2Counter]){
          toReturn[i]=arr2[arr2Counter];
          arr2Counter++;
        }
        else{
          toReturn[i]=arr1[arr1Counter];
          arr1Counter++;
        }
      }
    }
    return toReturn;
  }

  public static void mergesort(int[]data){
    if(data.length == 1){
      return;
    }
    int mid = data.length / 2;
    merger(mergesort(Arrays.copyOfRange(data, 0, mid),true),mergesort(Arrays.copyOfRange(data, mid, data.length),true),data);
    System.out.println(toString(data));
  }
  public static int[] mergesort(int[]data,boolean t){
    if(data.length == 1){
      return data;
    }
    int mid = data.length / 2;
    return merger(mergesort(Arrays.copyOfRange(data, 0, mid),true),mergesort(Arrays.copyOfRange(data, mid, data.length),true));
  }
  public static void main(String[] args){
    int[] arr1= {3,6,7,8,9,11,134};
    int[] arr2= {1,5,6,8,10,11,134,160,1545};
    int size = 100;
    int[] arr3 = new int[size];
    Random r = new Random();
    for(int i = 0; i < size; i ++){
      arr3[i] = r.nextInt();
    }
    System.out.println(Merge.toString(Merge.merger(arr1,arr2)));
    final long startTime = System.nanoTime();

    Merge.mergesort(arr3);
    final long duration = System.nanoTime() - startTime;
    System.out.println(duration/1000000000.0);
    System.out.println(Merge.toString(arr3));
  }
}
