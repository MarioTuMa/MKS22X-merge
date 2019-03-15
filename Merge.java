public class Merge{
  public static String toString(int[] arr){
    String toReturn = "";
    for(int i = 0;i < arr.length;i++){
      toReturn+=arr[i]+", ";
    }
    return toReturn;
  }
  public static int[] merger(int[] arr1, int[] arr2){
    int[] toReturn = new int[arr1.length+arr2.length];
    int arr1Counter = 0;
    int arr2Counter = 0;
    for(int i = 0; i<arr1.length+arr2.length;i++){
      if(arr1[arr1Counter]>arr2[arr2Counter]){
        toReturn[i]=arr2[arr2Counter];
        arr2Counter++;
      }
      else{
        toReturn[i]=arr1[arr1Counter];
        arr1Counter++;
      }
    }
    return toReturn;
  }
  public static void main(String[] args){
    int[] arr1= {3,6,7,8,9,11,134};
    int[] arr2= {1,5,6,8,10,11,134,160,1545};
    System.out.println(Merge.toString(Merge.merger(arr1,arr2)));
  }
}
