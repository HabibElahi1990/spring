package spring.mockitoServices.service.impl;

import org.springframework.stereotype.Service;
import spring.mockitoServices.model.UserRule;
import spring.mockitoServices.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Habib, on 13/11/2020
 */
@Service
public class UserRuleService {
     public static List<UserRule> userRuleList = new ArrayList<UserRule>() {
        {
            add(new UserRule(1L, "manager", "admin"));
            add(new UserRule(2L, "programmer", "programmer"));
            add(new UserRule(3L, "QA", "tester"));
            add(new UserRule(4L, "QC", "tester"));
        }
    };
    final UserService userService;

    public UserRuleService(UserService userService) {
        this.userService = userService;
    }

    public List<String> getUserRule(Long userId) {
        String userName = userService.getUserName(userId);
        List<String> ruleNameList = new ArrayList<>();
        userRuleList.stream()
                .filter(n -> n.getUserName().equals(userName))
                .forEach(n -> ruleNameList.add(n.getRule()));

        return ruleNameList;

    }

}
