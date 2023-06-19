public class Test {
    public static void main(String[] args) {
        
        Human human1 = new Human("万叶");
        System.out.println("你好，我叫" + human1.name + "。");
        System.out.println("我是"+ human1.age +"岁。我住在"+ human1.location +"。");
        human1.regulateTemperature();
        
        Human human2 = new Human("万葉", 21, "稲妻");
        System.out.printf("こんにちは、%sと言います、%s歳です。私の故郷%sです。\n", human2.name, human2.age, human2.location);
        
    }
}
