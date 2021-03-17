package cn.tul.oauth2.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <br>
 *
 * @author cuijing
 * @className UserDTO
 * @date 2021-03-14 16:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserVo {
    private String id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;

}
