package indi.fanyun.bullscheduling.session;

import cn.hutool.cache.impl.TimedCache;
import indi.fanyun.bullscheduling.common.exceptions.MyBizException;
import indi.fanyun.bullscheduling.facade.info.EmployeeInfo;

import java.util.Objects;

/**
 * @author tshk
 * @date 2021-01-18 13:55
 */
public class EmployeeLocalSession implements EmployeeSessionBase {

    private TimedCache<String, EmployeeInfo> timedCache;

    private long timeout;
    /**
     * 毫秒
     * @param timeout
     */
    public EmployeeLocalSession(int timeout){
        this.timedCache=new TimedCache<>(timeout);
        this.timeout=timeout;
    }

    @Override
    public boolean registerSession(EmployeeInfo employeeInfo) {
        if(Objects.isNull(employeeInfo)){
            throw new MyBizException("注册session失败,登录信息不得为空");
        }
        timedCache.put(employeeInfo.getCode(),employeeInfo);
        return true;
    }

    @Override
    public boolean refresh(String key) {
        timedCache.get(key);
        return true;
    }

    @Override
    public boolean remove(String key) {
        timedCache.remove(key);
        return true;
    }

    @Override
    public boolean removeAll() {
        timedCache=new TimedCache<>(timeout);
        return true;
    }

    @Override
    public EmployeeInfo get(String key) {
        return timedCache.get(key);
    }
}
