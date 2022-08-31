package top.b0x0.sample.tracespringboot.logback.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tanglinghan Created By 2022-07-15 10:20
 **/
public class ValidUtils {

    public static void validMultipartFile(MultipartFile multipartFile) {
        if (multipartFile == null) {
            throw new IllegalStateException("上传文件为空!");
        }
        if (multipartFile.isEmpty()) {
            throw new IllegalStateException("上传文件为空!");
        }
        String originalFilename = multipartFile.getOriginalFilename();
        if (StringUtils.isBlank(originalFilename)) {
            throw new IllegalStateException("文件名称为空!");
        }
    }

    /**
     * @param multipartFile /
     * @return eg: .pdf
     */
    public static String getMultipartFileSuffix(MultipartFile multipartFile) {
        validMultipartFile(multipartFile);
        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename == null) {
            throw new IllegalStateException("文件名称为空!");
        }
        return originalFilename.substring(originalFilename.lastIndexOf("."));
    }

    public static String getMultipartFileName(MultipartFile multipartFile) {
        validMultipartFile(multipartFile);
        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename == null) {
            throw new IllegalStateException("文件名称为空!");
        }
        return originalFilename;
    }

    public static void validMap(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("map is empty!");
        }
    }

    /**
     * map参数校验
     *
     * @param map           需要校验的map
     * @param needCheckKeys 需要校验不为空的key
     */
    public static void validMapValNotNull(Map<String, Object> map, String... needCheckKeys) {
        validMap(map);

        if (needCheckKeys == null) {
            return;
        }
        List<String> msgList = new ArrayList<>();
        for (String key : needCheckKeys) {
            Object val = map.get(key);
            if (val == null || StringUtils.isBlank(val.toString())) {
                msgList.add(key + " is empty");
            }
        }
        String joinMsg = String.join(",", msgList);
        if (joinMsg.length() > 0) {
            throw new IllegalArgumentException(joinMsg);
        }
    }

    public static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static <T> T checkNotNull(T obj, String errorMsg) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(errorMsg));
        }
        return obj;
    }
}
