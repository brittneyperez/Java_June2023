class Methods {
    public static void main(String[] args) {
        // ? Method = like a function; a block of code that is executed whenver it is called upon
        
        // * Example 1
        String name = "Bri";
        int age = 22;
        hello(name, age); // this calls the method
        
        // * Example 2
        int x = 3;
        int y = 4;
        // we can do this despite being a local variable (meaning being within this set of {})
        // but since we're defining a new variable, its ok to do this
        int z = add(x,y);
        System.out.println("The sum is: "+z);
        
        /* We can also write like this: 
            System.out.println(add(x,y));
            ! Don't define add(x,y)
        */
    }
    // we need a matching param: "DataType variable"; doesn't necessarily have to be called the same name.
    static void hello(String name, int age) { // this is a method; needs to be defined as "static void methodName"
        System.out.println("你好！ 我是"+name+"。");
        System.out.println("我年龄是"+age+"岁。");
    }
    
    // To do Ex2, we need to set a return type, in this case int since that's what we're returning
    // returnType functionName() {}
    static int add(int x, int y) {
        // Whenever we have a return type, we need a return statement:
        int z = x+y;
        return z;
    }
}