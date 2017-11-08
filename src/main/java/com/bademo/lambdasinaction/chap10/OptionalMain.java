package com.bademo.lambdasinaction.chap10;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }

    /**
     * error
     * @param args
     */
   /* public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getCar) //getCar return Optional<Car> Object
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optInsurance -> optInsurance.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(toSet());
     }*/

    public static void main(String[] args) {
        Person person = new Person();
        Car car = new Car();
        Insurance insurance = new Insurance();
        insurance.setName("安邦保险");
        car.setInsurance(Optional.ofNullable(insurance));
        person.setCar(Optional.ofNullable(car));
        System.out.println(getCarInsuranceName(Optional.ofNullable(person)));
        //insurance = null;
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        System.out.println(optInsurance.map(Insurance::getName).orElse("novalue"));
    }
}
