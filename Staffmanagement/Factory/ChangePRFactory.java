package Staffmanagement.Factory;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.Model.ChangeValue.ChangePositionRecord;

public class ChangePRFactory implements ChangeFactory{
    @Override
    public ChangeAPI getChangeAPI() {
        return new ChangePositionRecord();
    }
}
