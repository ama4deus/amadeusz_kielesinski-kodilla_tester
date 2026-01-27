package com.kodilla.abstracts.homework;

public class Teacher extends Job {
    @Override
    public double salary(){
        return 7000.0;
    }
    @Override
    public String responsibilities(){
        return "Teaching students.";
    }
}




//package com.kodilla.abstracts.homework;
//
//public class Postman extends Job {
//    @Override
//    public double salary() {
//        return 4500.0;
//    }
//
//    @Override
//    public String responsibilities() {
//        return "Delivering letters.";
//    }
//
//}
