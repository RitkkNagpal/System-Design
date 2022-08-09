public class Singleton {
    private static Singleton inst;    

    private Singleton(){

    }

    public static Singleton getSingletonInstance(){
        if(inst == null){
            synchronized (Singleton.class){
                if(inst == null){
                    System.out.println("only once");
                    inst =  new Singleton();
                }
            }
        }

        return inst;
    }
}
