package list;

import java.util.Iterator;

/**
 * Created by dshelygin on 19.04.2018.
 */
public class CircleTester {
    public Boolean ifCircled(SimpleLinkedList<?>  tList) {
        int expectedSize = tList.getSize();
        int realSize = 0;
        Iterator<?> it = tList.iterator();
        while (it.hasNext()) {
            realSize++;
            it.next();
            if (realSize > expectedSize) return true;
        }
        return false;
    }
}
