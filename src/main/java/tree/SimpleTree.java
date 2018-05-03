package tree;


import java.util.Optional;
/**
 * Created by dshelygin on 28.04.2018.
 */
public interface SimpleTree <E extends Comparable<E>> extends Iterable<E> {
	/**
	 * Добавить элемент child в parent.
	 * Parent может иметь список child.
	 *
	 * @param parent parent.
	 * @param child  child.
	 * @return test
	 */
	boolean add(E parent, E child);

	Optional<Node<E>> findBy(E value);
}
