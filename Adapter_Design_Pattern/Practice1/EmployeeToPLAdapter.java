
import java.util.*;
public class EmployeeToPLAdapter implements IphoneListSource{
    private EmployeeDetails ed;

    public EmployeeToPLAdapter(EmployeeDetails ed){
        this.ed = ed;
    }
    public List<String> getPhoneNumbers(){
        List<String> employees = this.ed.GetEmployees();

        List<String> phoneNumbers = new ArrayList<>();
        for(String emp : employees){
            String phoneNumber = emp.split("-")[3];
            phoneNumbers.add(phoneNumber);
        }
        return phoneNumbers;
    }
}
