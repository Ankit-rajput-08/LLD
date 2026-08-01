package solid.lsp.employee;

public class FullTimeEmployee extends LeaveEligibility{
    public FullTimeEmployee(String name, Double salary, int leaveLeft) {
        super.name = name;
        super.salary = salary;
        this.leaveLeft = leaveLeft;
    }

}
