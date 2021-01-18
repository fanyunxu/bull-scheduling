package indi.fanyun.bullscheduling.session;

import indi.fanyun.bullscheduling.facade.info.EmployeeInfo;

/**
 * @author tshk
 * @date 2021-01-18 13:56
 */
public interface EmployeeSessionBase {

    /**
     * 注册session
     * @return
     */
    boolean registerSession(EmployeeInfo employeeInfo);

    /**
     * 刷新session
     */
    boolean refresh(String key);

    /**
     * 删除session
     */
    boolean remove(String key);
    /**
     * 删除所有session
     */
    boolean removeAll();
}
