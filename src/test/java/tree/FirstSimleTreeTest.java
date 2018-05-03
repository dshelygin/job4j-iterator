package tree;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;


/**
 * Created by dshelygin on 28.04.2018.
 */
public class FirstSimleTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        FirstSimleTree<Integer> tree = new FirstSimleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        FirstSimleTree<Integer> tree = new FirstSimleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

}