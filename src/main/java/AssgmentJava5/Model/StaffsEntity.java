package AssgmentJava5.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "staffs", schema = "assjava5", catalog = "")
public class StaffsEntity {
    @NotNull
    private int id;
    @NotNull
    private String name;
    private String gender;
    private String birthday;
    private String photo;
    private String email;
    private String phone;
    private String salary;
    private String notes;
    private int departld;
    private DepartsEntity departsEntity;

    @ManyToOne
    @JoinColumn(name = "departld")
    public DepartsEntity getDepartsEntity() {
        return departsEntity;
    }

    public void setDepartsEntity(DepartsEntity departsEntity) {
        this.departsEntity = departsEntity;
    }

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Gender", nullable = true, length = 45)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "Birthday", nullable = true, length = 45)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Photo", nullable = true, length = 45)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Salary", nullable = true, length = 45)
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = " Notes", nullable = true, length = 45)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "Departld", nullable = false)
    public int getDepartld() {
        return departld;
    }

    public void setDepartld(int departld) {
        this.departld = departld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffsEntity that = (StaffsEntity) o;
        return id == that.id &&
                departld == that.departld &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(salary, that.salary) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, birthday, photo, email, phone, salary, notes, departld);
    }
}
