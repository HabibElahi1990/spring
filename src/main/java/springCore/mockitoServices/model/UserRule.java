package springCore.mockitoServices.model;

/**
 * Created by Habib, on 13/11/2020
 */
public class UserRule {

    private Long id;
    private String rule;
    private String userName;

    public UserRule() {
    }

    public UserRule(Long id, String rule, String userName) {
        this.id = id;
        this.rule = rule;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
