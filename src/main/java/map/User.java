package map;

import java.util.Calendar;

/**
 * Created by dshelygin on 23.04.2018.
 */
public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }
/*
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
*/
}


/** задание 2
 *    карта содержит два объекта, так как по умолчанию, это разные объекты.
 *    equals смотрит на ссылку на объект.
 *    hash - превращает ссылку в индекс
 *
 *
 */

/** задание 3
 *    объекты находятся в коллекции, находящейся в ячейке массива, к которой относится hash
 *
 *
 */

/** задание 4
 * внесение и извлечение объектов будет работать нормально, так как значения ключей сравниваются только, если совпали
 * hash
 *
 */

/** задание 5
 *    в карте находится один объект т.к hash и значение ключа совпали
 *
 *
 */

/** задание 6
 *    Коллизия - это когда hash ключей совпадает, но объекты не эквивалентны.
 *    в этом случае объект добавляетс в подколлекцию, извлекается отуда при совадении hash и ключа
 *
 *
 */
/** задание 7
 *    Основной критерий hash функции - минимальное число коллизий. Алгоритмы могут быть разные
 *    пример: последовательно берем поля, участвеющие в формировании хэщ функции. для числовых полей берем значение
 *    как есть, для остальных используем фунацию объекта hashCode. При переходе на след. параметр, предыдущий результат
 *    умножаем на простое целое число (например, 37) и прибавляем hasCode параметра.
 *
 *
*/
