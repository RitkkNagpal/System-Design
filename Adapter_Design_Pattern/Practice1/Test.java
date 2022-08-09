
public class Test {
    public static void main(String[] args) {
        EmployeeDetails ed = new EmployeeDetails();
        EmployeeToPLAdapter src = new EmployeeToPLAdapter(ed);
        Intranet intra = new Intranet(src);
        intra.displayPhoneNumbers();
    }
}
