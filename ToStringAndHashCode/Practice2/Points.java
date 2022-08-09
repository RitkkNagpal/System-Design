
public class Points {
    int x;
    int y;

    Points(){}
    
    Points(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public int hashCode(){
        return this.x + this.y;
    }

    @Override
    public boolean equals(Object obj){
        Points other = (Points)obj;
        return (this.x == other.x && this.y == other.y);
    }
}
