package com.bademo.lambdasinaction.chap10;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Person {

    private Optional<Car> car;

}
