package top.b0x0.sample.tracespringboot.logback.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.b0x0.sample.tracespringboot.logback.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanglinghan Created By 2022-08-29 11:31
 **/
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Map<String, Object> getUserInfo(int userId) {
        log.info("user.getUserInfo:{}", userId);
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("userId", userId);
        map.put("username", getUserCnName(userId));
        map.put("password", getUserPassword(userId));
        return map;
    }

    @Override
    public String getUserCnName(int userId) {
        String val = StringUtils.int2chineseNum(userId);
        log.info("user.getUserCnName:{} val:{}", userId, val);
        return val;
    }

    @Override
    public String getUserPassword(int userId) {
        log.info("user.getUserPassword:{} val:{}", userId, userId);
        return String.valueOf(userId);
    }
}
