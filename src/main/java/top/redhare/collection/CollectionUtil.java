package top.redhare.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 17-5-24.
 */
public class CollectionUtil {

    public static <T> List<List<T>> group(List<T> list, int limit) {
        if (null == list || list.isEmpty()) {
            throw new NullPointerException("empty collection");
        }
        if (limit < 1) {
            throw new IllegalArgumentException("limit less than 1");
        }
        List<List<T>> result = new ArrayList<>();
        int i = 0;
        int rest = limit;
        int size = list.size();
        while (size > limit) {
            List<T> temp = list.subList(i * limit, i * limit + rest);
            result.add(temp);
            i++;
            size -= limit;
        }
        rest = size;
        List<T> end = list.subList(i * limit, i * limit + rest);
        result.add(end);
        return result;
    }
}
