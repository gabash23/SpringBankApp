package com.example.demo.currency;

//import org.apache.tomcat.util.codec.binary.Base64;
import java.util.Arrays;
import java.util.Base64;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table
public class Holder  {

    @SequenceGenerator(
            name = "holder_sequence",
            sequenceName = "holder_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "holder_sequence"
    )

    @Id
    private Long id;
    private Integer money;
    private String name;
    private String username;
    private byte[] password;

    public Holder() {
    }

    public Holder(Long id, Integer money, String name, String username, String password) {
        this.id = id;
        this.money = money;
        this.name = name;
        this.username = username;
        this.password = encode(password);
    }

    public Holder(Integer money, String name, String username, String password) {
        this.money = money;
        this.name = name;
        this.username = username;
        this.password = encode(password);
    }

    public byte[] encode(String str) {
        return Base64.getEncoder().encode(str.getBytes());
    }

    public String decode(byte[] bytes) {
        return new String(Base64.getDecoder().decode(bytes));
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Holder{" +
                "id=" + id +
                ", money=" + money +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
