
package model;

public class User {
    private String username, password, nickName;
    private int score, age;

    public User() {
    }

    public User(String username, String password, String nickName, int score, int age) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.score = score;
        this.age = age;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String nickName, int age) {
        this.nickName = nickName;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
