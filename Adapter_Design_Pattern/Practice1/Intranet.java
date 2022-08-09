
import java.util.List;
public class Intranet {
    private IphoneListSource source;

    Intranet(IphoneListSource source){
        this.source = source;
    }

    public void displayPhoneNumbers(){
        List<String> list = source.getPhoneNumbers();
        for(String num : list){
            System.out.println(num);
        }
    }
}
