package algorithms.string;

import com.ymy.algorithms.statistics.Fibonacci;
import com.ymy.algorithms.statistics.GetKthNumber;
import com.ymy.algorithms.statistics.Pow;
import com.ymy.algorithms.string.LCP;
import com.ymy.algorithms.string.LCS;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 跟字符串的算法测试用例
 * Created by yemengying on 16/3/28.
 */
public class StringTest {

    private static Logger logger = LoggerFactory.getLogger(StringTest.class);

    /**
     * 求两个字符串的最长公共子序列
     */
    @Test
    public void lcsTest(){
        String x = "bdcaba";
        String y = "abcbdab";
        int length = LCS.getLCSLength(x,y);
        logger.info("最长公共子序列长度:{}",length);
        LCS.reconstruct(x.length(),y.length());
    }

    /**
     * 求字符串数组中字符串的最长公共前缀
     */
    @Test
    public void lcpTest(){
        String[] arr = {"ba","b","bc"};
        String prefix = LCP.longestCommonPrefix(arr);
        logger.info("最长公共前缀是:{}", "".equals(prefix) ? "没有公共前缀":prefix);
    }


}
