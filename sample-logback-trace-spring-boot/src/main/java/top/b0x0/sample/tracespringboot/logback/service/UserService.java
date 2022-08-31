package top.b0x0.sample.tracespringboot.logback.service;

import java.util.Map;

/**
 * @author tanglinghan Created By 2022-08-29 11:30
 **/
public interface UserService {
    Map<String, Object> getUserInfo(int userId);

    String getUserCnName(int userId);
    String getUserPassword(int userId);
}
