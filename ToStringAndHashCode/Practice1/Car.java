public class Car {
    String name;
    int speed;
    int price;

    Car(String name, int speed, int price){
        this.name = name;
        this.speed = speed;
        this.price=  price;
    }

    @Override
    public String toString(){
        return "[" + this.name + " " + this.speed + " " + this.price + "]";
    }
}
