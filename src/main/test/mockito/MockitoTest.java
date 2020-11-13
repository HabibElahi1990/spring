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

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    @InjectMocks
    UserService mockUserService = new UserServiceImpl();

    @Mock
    UserRuleService mockUserRuleService;

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
