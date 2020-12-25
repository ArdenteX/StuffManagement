package Staffmanagement.bean;
//父bean
public class Personal {
    private String num;    //工号
    private String name;    //姓名
    private String tel;


    public Personal(String num, String name, String tel){
        this.num = num;
        this.name = name;
        this.tel = tel;
    }



    public String getNum(){
        return num;
    }

    public void setNum(String num){
        this.num = num;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAttendance() {return "null";}

    public void setAttendance(String attendance){}

    public String getLate(){return "null";}

    public void setLate(String late){}

    public String getLeave(){return "null";}

    public String getOverTime(){return  "null";}

    public void setLeave(String leave){}

    public void setOverTime(String overTime){}

    public void setPosition(String position){}

    public String getPosition(){return  "null";}

    public void setState(String state) {}


    public String getState() {
        return "null";
    }


    public void setDepartment(String department) { }


    public String getDepartment() { return "null";}


    public void setWage(String wage) { }


    public String getWage() {
        return "null";
    }

    public String getDepartmentRecord() {
        return "null";
    }

    public String getInTime() {
        return "null";
    }

    public String getOutTime() {
        return "null";
    }

    public String getPositionRecord() {
        return "null";
    }

    public String getWageRecord() {
        return "null";
    }

    public void setDepartmentRecord(String departmentRecord) {}

    public void setInTime(String inTime) {}

    public void setOutTime(String outTime) {}

    public void setPositionRecord(String positionRecord) {}

    public void setWageRecord(String wageRecord) {}

    public String getOffDuty() {return "null";}

    public void setOffDuty(String offDuty) {}

    public String getExtra() {return "null"; }

    public void setExtra(String extra) {}
}
