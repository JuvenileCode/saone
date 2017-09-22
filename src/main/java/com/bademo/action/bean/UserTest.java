package com.bademo.action.bean;

import java.util.List;

/**
 * Created by
 *
 * @author Bin.l
 * @date 2017/9/22 23:46
 */
public class UserTest {
    private String username;
    private String password;
    private String email;
    private Integer age;
    private Family family;
    private List<Family> familyList;

    public static class Family{
        private String address;
        private Boolean have;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Boolean getHave() {
            return have;
        }

        public void setHave(Boolean have) {
            this.have = have;
        }

        @Override
        public String toString() {
            return "Family{" +
                    "address='" + address + '\'' +
                    ", have=" + have +
                    '}';
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", family=" + family +
                ", familyList=" + familyList +
                '}';
    }
}
