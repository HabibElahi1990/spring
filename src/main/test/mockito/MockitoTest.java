package mockito;

/**
 * Created by Habib, on 13/11/2020
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import springCore.mockitoServices.service.UserService;
import springCore.mockitoServices.service.impl.UserRuleService;
import springCore.mockitoServices.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

//use @RunWith(MockitoJUnitRunner.class) for helping to use methods and annotation mock
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    //use this annotation for inject inner dependency and should be new
    @InjectMocks
    UserService mockUserService = new UserServiceImpl();

    //use this annotation for mock dependency and should be new
    @Mock
    UserRuleService mockUserRuleService;
    //We can use Mockito Spy to partial mock an object. When we spy on an object, the real methods are being called unless it’s stubbed.
    @Spy
    List<String> spyList = new ArrayList<>();

    //classes that mock by @Mock should be initial
    @Before
    public void InitialMock() {
        MockitoAnnotations.initMocks(this);
        mockUserRuleService = new UserRuleService(mockUserService);
    }

    //this test show return multi values
    @Test
    public void analyseListMock() {
        List list = mock(List.class);
        when(list.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, list.size());
        assertEquals(3, list.size());

        when(list.get(0)).thenReturn("test1");
        assertEquals("test1", list.get(0));

        //anyInt() is a argument matcher
        when(list.get(anyInt())).thenReturn("test2");
        assertEquals("test2", list.get(1));
        assertEquals("test2", list.get(2));

        /*
        by thenThrow can return exception
         */
        when(list.get(4)).thenThrow(new RuntimeException());
        assertEquals("test2", list.get(4));

    }

    @Test
    public void getRoleWithoutMockito() {
        UserService userService = new UserServiceImpl();
        UserRuleService userRuleService = new UserRuleService(userService);
        List<String> userRule = userRuleService.getUserRule(3L);
        assertEquals(2, userRule.size());
    }

    @Test
    public void getRoleWithMockito() {
        UserService userService = mock(UserService.class);
//        because use anyLong() , all items return "tester"
        //there are a syntax that is functionality same to when and it is stub -> stub().toReturn()
        // stub and mock both are face classes
        // a stub example -> a database connection that allows you to mimic any scenario without having a real database.
        // a mock example ->a class that sends emails or sends data to another external service to examined that.
        when(userService.getUserName(anyLong())).thenReturn("tester");
        UserRuleService userRuleService = new UserRuleService(userService);
        List<String> userRule = userRuleService.getUserRule(3L);
        assertEquals(2, userRule.size());
        userRule = userRuleService.getUserRule(1L);
        assertEquals(2, userRule.size());
    }

    @Test
    public void getRoleWithAnnotationMockito() {
        List<String> userRule = mockUserRuleService.getUserRule(3L);
        assertEquals(2, userRule.size());
    }

    /*
    bddMockito is very similar to mockito
     */
    @Test
    public void bddMockitoTest() {
        List list = mock(List.class);
        given(list.get(0)).willReturn("test1");
        assertEquals("test1", list.get(0));

        given(list.get(1)).willReturn("test2");
        assertThat(list.get(1), is("test2"));
    }

    /* spy in mockito*/

    @Test
    public void mockSpy() {
        spyList.add("A");
        spyList.add("B");
        assertEquals("A", spyList.get(0));

        when(spyList.size()).thenReturn(10);
        assertEquals(10, spyList.size());
    }

    /*
    when we use mock we have a fake class
    bot we use spy we have a real object from class
    in order to in below example after add item in integerMockList , it,s size in 0
    but after add item in integerSpyList, it,s size in 1
     */
    @Test
    public void deferenceMockAndSpy() {

        List integerMockList = mock(List.class);
        integerMockList.add(1);
        verify(integerMockList,atLeast(1)).add(1);
        assertEquals(0,integerMockList.size());

        List integerSpyList = spy(new ArrayList());
        integerSpyList.add(1);
        //below line is error because after verify
        //Expected :arrayList.add("test");
        //Actual   :arrayList.add(1);
        //verify(integerSpyList).add("test");
        assertEquals(1, integerSpyList.size());
    }

}
