import java.util.HashMap;

public class DriverForEqualsAndHashCode {
    public static void main(String[] args) {
        Points []arr = new Points[10];
        for(int i = 0; i < arr.length/2; i++){
            arr[i] = new Points(i*3+1,i*2+1);
        }
        for(int i = 0; i < arr.length/2; i++){
            arr[i+arr.length/2] = new Points(i*3+1,i*2+1);
        }
        HashMap<Points,Integer>fmap = new HashMap<>();
        for(Points p : arr){
            fmap.put(p, fmap.getOrDefault(p, 0)+1);
        }

        System.out.println(fmap);
    }
}
