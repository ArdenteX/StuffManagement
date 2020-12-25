package Staffmanagement.Factory;

import Staffmanagement.APIs.ChangeAPI;
import Staffmanagement.Model.ChangeValue.ChangeState;

public class ChangeStateFactory implements ChangeFactory {

    @Override
    public ChangeAPI getChangeAPI() {
        return new ChangeState();
    }
}
