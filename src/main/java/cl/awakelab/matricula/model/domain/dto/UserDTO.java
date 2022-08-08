package cl.awakelab.matricula.model.domain.dto;

import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private boolean enabled;
    private List<RolDTO> rols;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<RolDTO> getRols() {
        return rols;
    }

    public void setRols(List<RolDTO> rols) {
        this.rols = rols;
    }
}
