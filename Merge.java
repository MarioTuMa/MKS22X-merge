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
        arr2Counter++;
      }
      else if(arr2Counter > arr2.length - 1){
        data[i]=arr1[arr1Counter];
        arr1Counter++;
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
        arr2Counter++;
      }
      else if(arr2Counter > arr2.length - 1){
        toReturn[i]=arr1[arr1Counter];
        arr1Counter++;
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
    //System.out.println(toString(data));
  }
  public static int[] insertsort(int[] data){
    for(int i = 1; i < data.length; i ++){
      int j = Integer.valueOf(i);
      int temp = data[j];
      while(j>0 && data[j]<data[j-1]){
        data[j] = data[j-1];
        data[j-1] = temp;
        j--;
      }
    }
    //System.out.println(toString(data));
    return data;
  }
  public static int[] mergesort(int[]data,boolean t){
    if(data.length < 8){
      return insertsort(data);
    }
    int mid = data.length / 2;
    //System.out.println(toString(data));
    return merger(mergesort(Arrays.copyOfRange(data, 0, mid),true),mergesort(Arrays.copyOfRange(data, mid, data.length),true));
  }
  // public static void main(String[] args){
  //   int[] arr1= {1,2,3,4,5,6,7,8};
  //   int[] arr2= {9,10,11,12,13,14,15,16}; //,5,6,8,10,11,134,160,1545};
  //   int size = 32;
  //   int[] arr3 = new int[size];
  //   Random r = new Random();
  //   for(int i = 0; i < size; i ++){
  //     arr3[i] = i * i;
  //   }
  //   int[] compArr = Arrays.copyOfRange(arr3, 0,size);
  //   System.out.println(Merge.toString(Merge.merger(arr1,arr2)));
  //   final long startTime = System.nanoTime();
  //
  //   Merge.mergesort(arr3);
  //   final long duration = System.nanoTime() - startTime;
  //   final long compStart = System.nanoTime();
  //
  //   Arrays.sort(compArr);
  //   final long compduration = System.nanoTime() - compStart;
  //   System.out.println(duration);
  //   System.out.println(compduration);
  //   double ratio = (double)duration/(double)compduration;
  //   System.out.println(ratio);
  //   System.out.println(Merge.toString(arr3));
  // }
}
