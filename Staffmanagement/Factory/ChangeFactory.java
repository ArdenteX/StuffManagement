package Staffmanagement.Factory;

import Staffmanagement.APIs.ChangeAPI;

import java.util.Date;

/**
 * 工厂设计模式*/
public interface ChangeFactory {
    ChangeAPI getChangeAPI();
}
