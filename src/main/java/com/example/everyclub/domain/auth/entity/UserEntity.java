package com.example.everyclub.domain.auth.entity;

import com.example.everyclub.global.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter // Entity 클래스에서는 X, DTO 만들어서 해주자.
@Table(name="User")
@NoArgsConstructor // 기본 생성자 자동으로 추가
public class UserEntity extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", unique = true)
    private Long userId;

    @Column(name = "userEmail", length = 100, unique = true)
    private String userEmail;  // Entity 에서는 _(언더바) 금지. 오류 발생 가능성 있음

    @Column(name = "snsId", length = 100)
    private String snsId;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "userName", length = 100)
    private String userName;

    @Column(name = "userPhone", length = 20)
    private String userPhone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder // 빌더 자동 생성
    public UserEntity(Long id, String email, String name, String phone, Role role, String snsId, String password) {
        this.userId = id;
        this.userName = name;
        this.userEmail = email;
        this.userPhone = phone;
        this.userPassword = password;
        this.role = role;
        this.snsId = snsId;
    }

    public UserEntity updateSnsLogin() {
        return this;
    }

    public String getRoleValue() {
        return this.role.getValue();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(role.toString()));
        return roles;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
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
}
