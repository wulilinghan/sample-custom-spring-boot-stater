package top.b0x0.sample.tracespringboot.logback.utils.validator.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果DevelopmentGroup组失败，则ProductGroup组不会再校验
 *
 * @author Mark sunlightcs@gmail.com
 */
@GroupSequence({DevelopmentGroup.class,ProductGroup.class})
public interface ComposiGroup {
}
