package solid.lsp.employee;

public class LeaveEligibility extends Employee{
    int leaveLeft;

    public int getLeaveLeft(){return leaveLeft;}
    public void applyForLeave(){leaveLeft--;}
}
