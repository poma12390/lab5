package lab5.common;

import java.time.ZonedDateTime;

public class Person {
    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public float getHeight() {
        return height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }


    private java.time.ZonedDateTime birthday; //Поле не может быть null
    private float height; //Значение поля должно быть больше 0
    private Float weight; //Поле не может быть null, Значение поля должно быть больше 0
}
