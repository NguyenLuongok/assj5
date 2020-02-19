package AssgmentJava5.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "records", schema = "assjava5", catalog = "")
public class RecordsEntity {
    private int id;
    private Byte type;
    private String reason;
    private String date;
    private Integer staffid;
    private StaffsEntity staffsEntity;

    @ManyToOne
    @JoinColumn(name="staffid")
    public StaffsEntity getStaffsEntity() {
        return staffsEntity;
    }

    public void setStaffsEntity(StaffsEntity staffsEntity) {
        this.staffsEntity = staffsEntity;
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
    @Column(name = "Type", nullable = true)
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Reason", nullable = true, length = 45)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "Date", nullable = true, length = 45)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Staffid", nullable = true)
    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordsEntity that = (RecordsEntity) o;
        return id == that.id &&
                Objects.equals(type, that.type) &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(date, that.date) &&
                Objects.equals(staffid, that.staffid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, reason, date, staffid);
    }
}
