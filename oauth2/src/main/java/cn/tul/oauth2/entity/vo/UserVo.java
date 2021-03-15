package cn.tul.oauth2.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

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
