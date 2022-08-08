public class User {
    String userName;
    String password;
    String securityAnswer;
    Boolean business;

    public User(String userName, String password, String answer, Boolean business) {
        this.userName = userName;
        this.password = password;
        securityAnswer = answer;
        this.business = business;
    }

    public User(String userName, Boolean business){
        this.userName = userName;
        this.business = business;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public Boolean getBusiness() {
        return business;
    }
}
