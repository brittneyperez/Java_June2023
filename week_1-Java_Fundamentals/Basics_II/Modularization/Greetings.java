import java.util.Date;

class Greetings {
    // * In a file like this, we want to group related methods together for the sake of organization
    
    public String getCurrentDate() {
        Date date = new Date(); // see TestGreetings for structure of this line of code
        return "Current Date is " + date;
    }
    
    public String greetInEnglish(String name) {
        return "Hello, " + name + ".";
    }
    
    public String greetInMandarin(String name) {
        return "你好，" + name + "。";
    }
}
