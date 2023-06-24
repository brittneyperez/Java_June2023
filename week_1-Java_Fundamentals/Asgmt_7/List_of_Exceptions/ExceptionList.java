import java.util.ArrayList;

public class ExceptionList {
    
    public static void main(String[] args) {
        
        ArrayList<Object> myList = new ArrayList<Object>(); //? Create ArrayList
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        
        for (int i=0; i<myList.size(); i++) {
            //* Try to cast each element to an `Integer`
            // Integer castedValue = (Integer) myList.get(i); //! Exception: cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
            
            //* Use try/catch blocks to handle the exceptions
            try {
                Integer castedValue = (Integer) myList.get(i);
            } catch( ClassCastException e ) {
                System.out.println(e);
                /* Output:
                ! java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap') // "13"
                ! java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap') // "hello world"
                ! java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap') // "Goodbye World"
                ? It only did this 3 out of 4x bc 48 is an Integer while the others are Strings
                */
                // System.out.println(myList.get(i)); //? to see where the exceptions are being caught.
            }
            System.out.println("Finished!\n");
            /* Output:
            ! java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
            * Finished!
            
            ! java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
            *Finished!
            
            * Finished!
            
            ! java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
            * Finished!
            */
        }
    }
}
