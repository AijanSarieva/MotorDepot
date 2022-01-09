package zeon.aizhan.service.driver;

import zeon.aizhan.dao.driver.DriverDao;

public class DriverServiceImpl implements DriverService {
    private final DriverDao dao;

    public DriverServiceImpl(DriverDao dao) {
        this.dao = dao;
    }
}
