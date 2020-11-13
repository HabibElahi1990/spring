package mockito;

/**
 * Created by Habib, on 13/11/2020
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import springCore.mockitoServices.service.UserService;
import springCore.mockitoServices.service.impl.UserRuleService;
import springCore.mockitoServices.service.impl.UserServiceImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//use @RunWith(MockitoJUnitRunner.class) for helping to use methods and annotation mock
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    //use this annotation for inject inner dependency and should be new
    @InjectMocks
    UserService mockUserService = new UserServiceImpl();

    //use this annotation for mock dependency and should be new
    @Mock
    UserRuleService mockUserRuleService;

    //classes that mock by @Mock should be initial
    @Before
    public void InitialMock() {
        mockUserRuleService = new UserRuleService(mockUserService);
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
}
