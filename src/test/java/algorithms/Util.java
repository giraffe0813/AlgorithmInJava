package algorithms;

public class Util {

    /**
     * 打印数组中的元素
     * @param arr
     */
    public static void print(int[] arr) {
        if(arr == null) {
            System.out.println("null");
        }else{
            for(int item : arr){
                System.out.println(item);
            }
        }
    }
}
