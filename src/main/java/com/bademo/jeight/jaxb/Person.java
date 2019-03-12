package com.bademo.jeight.jaxb;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description Xml对象
 * @Author Bin.Liu
 * @Date 2018/10/19 13:22
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Person {

    private String firstName;
    private String lastName;
    private Integer postalCode;
    private String city;
    private LocalDateTime date;
    private List<String> listString;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<String> getListString() {
        return listString;
    }

    @XmlElementWrapper(name="email_mqs_string_list")
    @XmlElement(name ="mqs_string")
    public void setListString(List<String> listString) {
        this.listString = listString;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", date=" + date +
                ", listString=" + listString +
                '}';
    }
}
