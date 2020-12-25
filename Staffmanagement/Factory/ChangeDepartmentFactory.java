package Staffmanagement.Factory;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.Model.ChangeValue.ChangeDepartment;

public class ChangeDepartmentFactory implements ChangeFactory {
    @Override
    public ChangeAPI getChangeAPI() {
        return new ChangeDepartment();
    }
}
