package com.king.io.serializable;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Person implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;
}