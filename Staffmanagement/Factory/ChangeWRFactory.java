package Staffmanagement.Factory;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.Model.ChangeValue.ChangeWageRecord;

public class ChangeWRFactory implements ChangeFactory{
    @Override
    public ChangeAPI getChangeAPI() {
        return new ChangeWageRecord();
    }
}
