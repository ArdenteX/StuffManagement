package Staffmanagement.Factory;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.Model.ChangeValue.ChangeWage;

public class ChangeWageFactory implements ChangeFactory{
    @Override
    public ChangeAPI getChangeAPI() {
        return new ChangeWage();
    }
}
