package oops;

public abstract class ClassOne {

    public void printSomething()
    {
        System.out.println("Hello in abstract class");
    }
}

//THIS WILL RUN
class InheritClassOne  {

    public static void main(String[] args)
    {

        // obj points to anonymous subclass
//        When you have added { } while creating the object in second class,
//        the compiler takes it as an anonymous class where { } denotes the body of the anonymous class.
        ClassOne obj = new ClassOne() {};

        // calls the implementation
        // provided by ClassOne
        obj.printSomething();
    }
}

//THIS WILL NOT RUN
class CreateClassOne {

    public static void main(String[] args)
    {
        // instance of abstract
        // class "ClassOne"
        // ERROR WILL COME -----------
//        ClassOne obj = new ClassOne();
    }
}