package Staffmanagement.Factory;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.Model.ChangeValue.ChangePosition;

public class ChangePositionFactory implements ChangeFactory {
    @Override
    public ChangeAPI getChangeAPI() {
        return new ChangePosition();
    }
}
