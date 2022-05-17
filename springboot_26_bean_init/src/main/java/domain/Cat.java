package domain;

import org.springframework.stereotype.Component;

//@Component("Tom")
public class Cat {

    public Cat(){
    }

    private Integer age;

    public Cat(Integer age){
        this.age=age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }
}
