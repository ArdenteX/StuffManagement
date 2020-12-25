package Staffmanagement.bean;

public class CheckIn extends Personal{
    private String attendance; //出勤
    private String overTime;    //加班
    private String leave;       //请假
    private String late;    //迟到
    private String offDuty;  //打卡下班
    public CheckIn(Personal pe,String attendance,String late,String overTime,String leave,String offDuty){
        super(pe.getNum(),pe.getName(),pe.getTel());

        this.overTime = overTime;
        this.leave = leave;
        this.attendance = attendance;
        this.late = late;
        this.offDuty = offDuty;
    }

    public String getAttendance(){
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public String getLeave() {
        return leave;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setLeave(String leave) {
        this.leave = leave;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getOffDuty() {
        return offDuty;
    }

    public void setOffDuty(String offDuty) {
        this.offDuty = offDuty;
    }
}
