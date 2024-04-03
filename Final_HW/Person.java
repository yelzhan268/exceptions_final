package Final_HW;

public class Person {
    String secondName;
    String firstName;
    String surName;
    String birthDay;
    int phone;
    String gender;

    public Person(String secondName, String firstName, String surName, String birthDay, int phone, String gender) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.surName = surName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>", secondName, firstName, surName, birthDay, phone, gender);
    }
}
