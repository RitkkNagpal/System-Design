
public class Test {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getSingletonInstance();
        Singleton s2 = Singleton.getSingletonInstance();
        if(s1 == s2){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }    
}