package cn.tul.oauth2.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * <br>
 * 用户处理类
 *
 * @author cuijing
 * @className SecurityUserVo
 * @date 2021-03-14 16:42
 */
public class SecurityUserVo implements UserDetails {

    public SecurityUserVo(UserVo user) {
        if (user != null) {
            BeanUtils.copyProperties(user, this);
        }
    }

    public SecurityUserVo() {
    }

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户id
     */
    private String id;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        cn.tul.oauth2.entity.vo.UserVo user = (cn.tul.oauth2.entity.vo.UserVo) o;
        return Objects.equals(password, user.getPassword());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<SimpleGrantedAuthority>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    public String getId() {
        return id;
    }

}
