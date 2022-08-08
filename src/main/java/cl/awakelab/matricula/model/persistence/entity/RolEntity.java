package cl.awakelab.matricula.model.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="rol")
public class RolEntity {
    @Id
    @Column(name="rol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolId;
    @Column(name = "rol_name", length = 50)
    private String rolName;

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }
}
