public class Merge{
  public static toString(int[] arr){
    String toReturn = "";
    for(int i = 0;i < arr.length;i++){
      toReturn+=arr[i]+", ";
    }
    return toReturn
  }
  public int[] merger(int[] arr1, int[] arr2){
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
  }
  public static void main(String[] args){
    System.out.println(Merge.toString())
  }
}
