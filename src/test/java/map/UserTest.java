package map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by dshelygin on 23.04.2018.
 */
public class UserTest {
final static Logger logger = Logger.getLogger(UserTest.class);
HashMap<User,String> local = new HashMap<>();

@Before
public void initialization() {
    local.put(new User("Vasya", 0, new GregorianCalendar(2014, 12, 21)),
                        "Vaysa" );
    local.put(new User("Vasya", 0, new GregorianCalendar(2014, 12, 21)),
            "Vaysa" );
    int tmp =1;
    local.get(new User("Vasya", 0, new GregorianCalendar(2014, 12, 21)));



}

//задание 2
@Test
public void task2() {
     logger.info(local);

    }
}