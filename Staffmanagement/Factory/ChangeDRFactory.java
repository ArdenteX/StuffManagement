package Staffmanagement.Factory;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.Model.ChangeValue.ChangeDepartmentRecord;

public class ChangeDRFactory implements ChangeFactory{
    @Override
    public ChangeAPI getChangeAPI() {
        return new ChangeDepartmentRecord();
    }
}
