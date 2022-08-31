package top.b0x0.sample.tracespringboot.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.b0x0.sample.tracespringboot.logback.common.ResultVo;
import top.b0x0.sample.tracespringboot.logback.service.UserService;
import top.b0x0.sample.tracespringboot.logback.utils.ValidUtils;
import top.b0x0.log.trace.aop.TraceId;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author tanglinghan Created By 2022-08-11 14:56
 **/
@RestController
@RequestMapping("/test")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    @GetMapping("/validMap")
    public ResultVo validMapTest(Map<String, Object> param) {
        ValidUtils.validMapValNotNull(param, "policyNo");
        return ResultVo.ok();
    }

    @TraceId
    @GetMapping("/getUserInfo")
    public ResultVo getUserInfo(int userId) {
        log.info("TestController.getUserInfo userId:{}", userId);
        return ResultVo.ok(userService.getUserInfo(userId));
    }
}
