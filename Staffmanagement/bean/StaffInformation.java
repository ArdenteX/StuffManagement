package Staffmanagement.bean;

public class StaffInformation extends Personal {
    private String position;    //职位
    private String state;   //状态
    private String department;  //部门
    private String wage;   //  工资
    private String extra;

    public StaffInformation(Personal pe,String position, String state,String department,String wage,String extra){
        super(pe.getNum(),pe.getName(),pe.getTel());

        this.position = position;
        this.state = state;
        this.department = department;
        this.wage = wage;
        this.extra = extra;

    }


    public void setPosition(String position) {
        this.position = position;
    }


    public String getPosition() {
        return position;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getState() {
        return state;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public String getDepartment() {
        return department;
    }


    public void setWage(String wage) {
        this.wage = wage;
    }


    public String getWage() {
        return wage;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
