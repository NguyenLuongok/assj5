package AssgmentJava5.Model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "assjava5", catalog = "")
public class UsersEntity {
    @NotNull(message = "not null")
    private String username;

    @NotBlank(message = "not null")
    @Length(min = 3,max = 20)
    private String password;

    @NotBlank(message = "not null")
    private String fullname;

    @Id
    @Column(name = "Username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Fullname", nullable = true, length = 45)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(fullname, that.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, fullname);
    }
}
