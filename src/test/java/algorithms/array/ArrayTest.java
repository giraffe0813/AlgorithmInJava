package algorithms.array;

import algorithms.Util;
import com.ymy.algorithms.arrayAndlist.MergeKSortedArrays;
import com.ymy.algorithms.arrayAndlist.MergeKSortedList;
import com.ymy.algorithms.arrayAndlist.SearchInsertPosition;
import com.ymy.algorithms.arrayAndlist.SearchRotateSortedArray;
import org.junit.Test;

/**
 * Created by yemengying on 16/4/12.
 */
public class ArrayTest {


    @Test
    public void mergeKArray(){
        int[][] A = new int[5][];
        A[0] = new int[] { 1, 5, 8, 9 };
        A[1] = new int[] { 2, 3, 7, 10 };
        A[2] = new int[] { 4, 6, 11, 15 };
        A[3] = new int[] { 9, 14, 16, 19 };
        A[4] = new int[] { 2, 4, 6, 9 };

        MergeKSortedArrays m = new MergeKSortedArrays();
        int[] result = m.merge(A);
        Util.print(result);

    }

    @Test
    public void searchInRotateArray(){
        SearchRotateSortedArray s = new SearchRotateSortedArray();
        int[] arr = new int[]{3,1};
        s.search(arr,3);
    }


    @Test
    public void searchInsertPosition(){
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] arr = new int[]{1,3};
        int position = searchInsertPosition.searchInsert(arr,2);
    }
}
