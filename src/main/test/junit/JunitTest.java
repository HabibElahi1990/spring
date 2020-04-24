package junit;

import org.junit.*;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class JunitTest {
    /*
    @BeforeClass: onceExecutedBeforeAll
    @Before: executedBeforeEach
    @Test: EmptyArrayList
    @After: executedAfterEach
    @Before: executedBeforeEach
    @Test: OneItemArrayList
    @After: executedAfterEach
    @AfterClass: onceExecutedAfterAll
     */

    private ArrayList testList;

    // execute before from all test
    @BeforeClass
    public static void onceExecutedBeforeAll() {
        System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }

    // execute after from all test
    @AfterClass
    public static void onceExecutedAfterAll() {
        System.out.println("@AfterClass: onceExecutedAfterAll");
    }

    // execute before from each test
    @Before
    public void executedBeforeEach() {
        testList = new ArrayList();
        System.out.println("@Before: executedBeforeEach");
    }

    // execute before from each test
    @After
    public void executedAfterEach() {
        testList.clear();
        System.out.println("@After: executedAfterEach");
    }

    // execute test
    @Test
    public void EmptyCollection() {
        System.out.println("@Test: EmptyArrayList");

    }

    // execute  test
    @Test
    public void OneItemCollection() {
        testList.add("oneItem");
        System.out.println("@Test: OneItemArrayList");
    }

    // ignore execute method in test
    @Ignore
    public void executionIgnored() {
        System.out.println("@Ignore: This execution is ignored");
    }

    @Test
    public void assertTest(){
        String obj1 = "Habib";
        String obj2 = "Habib";
        String obj3 = "Elahi";
        String obj4 = "Elahi";
        String obj5 = null;
        int var1 = 1;
        int var2 = 2;
        int[] arithmetic1 = { 1, 2, 3 };
        int[] arithmetic2 = { 1, 2, 3 };

        assertEquals(obj1, obj2);// check obj1 equals obj2

        assertSame(obj3, obj4);//check type of obj3,obj4 are equals

        assertNotSame(obj2, obj4);//check type of obj3,obj4 are not equals

        assertNotNull(obj1);//check  obj1 is not null

        assertNull(obj5);//check  obj1 is  null

        assertTrue(var1 < var2);//check condition between  var1 ,var2 was true
        assertArrayEquals(arithmetic1, arithmetic2);//check arithmetic1 array  equals arithmetic2 array
    }
}
