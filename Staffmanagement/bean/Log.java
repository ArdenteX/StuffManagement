package Staffmanagement.bean;

public class Log extends Personal{
    private String inTime; //入职时间
    private String outTime; //离职时间
    private String wageRecord; //工资记录
    private String departmentRecord; //部门调整记录
    private String positionRecord;  //职位记录

    public Log(Personal pe,String inTime,String outTime,String wageRecord,
               String departmentRecord,String positionRecord){
        super(pe.getNum(),pe.getName(),pe.getTel());
        this.inTime = inTime;
        this.outTime = outTime;
        this.wageRecord = wageRecord;
        this.departmentRecord = departmentRecord;
        this.positionRecord = positionRecord;
    }

    public String getDepartmentRecord() {
        return departmentRecord;
    }

    public String getInTime() {
        return inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public String getPositionRecord() {
        return positionRecord;
    }

    public String getWageRecord() {
        return wageRecord;
    }

    public void setDepartmentRecord(String departmentRecord) {
        this.departmentRecord = departmentRecord;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public void setPositionRecord(String positionRecord) {
        this.positionRecord = positionRecord;
    }

    public void setWageRecord(String wageRecord) {
        this.wageRecord = wageRecord;
    }
}
