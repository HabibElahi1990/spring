package spring.mockitoServices.service.impl;

import org.springframework.stereotype.Service;
import spring.mockitoServices.model.User;
import spring.mockitoServices.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Habib, on 13/11/2020
 */
@Service
public class UserServiceImpl implements UserService {

    final static List<User> userList = new ArrayList<User>() {{
        add(new User(1L, "admin", "admin"));
        add(new User(2L, "programmer", "programmer"));
        add(new User(3L, "tester", "tester"));
    }};

    @Override
    public String getUserName(Long userId) {
        final String[] userName = {""};
        Optional<User> user = userList.stream().filter(n -> n.getId().equals(userId)).findFirst();
        user.ifPresent(n -> userName[0] = n.getUserName());
        return userName[0];

    }
}
