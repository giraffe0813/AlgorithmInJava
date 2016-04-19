package algorithms;

import java.util.Arrays;

public class Util {

    /**
     * 打印数组中的元素
     * @param arr
     */
    public static void print(int[] arr) {
        if(arr == null) {
            System.out.println("null");
        }else{
            System.out.println(Arrays.toString(arr));
        }
    }
}
