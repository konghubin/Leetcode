import java.util.*;

public class T2178_maximumEvenSplit {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        if(finalSum % 2 == 1){
            return list;
        }
        if(finalSum == 2 || finalSum == 4){
            list.add(finalSum);
            return list;
        }
        long i = 1;
        long data = 0;
        while(4 * i + 2 + data < finalSum){
            data = data + 2 * i;
            list.add(2 * i);
            i++;
        }
        if(4 * i + 2 + data == finalSum){
            list.add(2 * i);
            list.add(2 * i + 2);
        }else{
            list.add(finalSum - data);
        }
        return list;
    }

    //------------------------------------------------------
    public List<Long> titleMaximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1)
            return new ArrayList();
        List<Long> r = new ArrayList();
        int left = 2, right = (int)Math.sqrt(finalSum) << 1, limit = left;
        while (left <= right) {
            int mid = (left + right >> 2) << 1;
            if ((long)(mid + 2) * mid <= finalSum * 4) {
                limit = mid;
                left = mid + 2;
            } else
                right = mid - 2;
        }
        for (long i=2; i<limit; i+=2)
            r.add(i);
        r.add(finalSum - ((long)(limit - 2) * limit >> 2));
        return r;
    }
}
