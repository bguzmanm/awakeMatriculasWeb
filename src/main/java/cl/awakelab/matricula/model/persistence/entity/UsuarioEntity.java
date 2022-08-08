package cl.awakelab.matricula.model.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usuario")
public class UsuarioEntity {
    @Id
    @Column(length = 50)
    private String username;
    @Column(length = 100)
    private String password;
    private Boolean enable;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="roles_usuario",
        joinColumns = @JoinColumn(name="username", referencedColumnName = "username"),
        inverseJoinColumns = @JoinColumn(name="rol_id", referencedColumnName = "rol_id"))
    private List<RolEntity> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<RolEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RolEntity> roles) {
        this.roles = roles;
    }
}
