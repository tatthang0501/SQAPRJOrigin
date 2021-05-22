package ptit.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="lophocphan")
public class LopHocPhan implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private int id;

    @NotNull
    @Column(name="ten")
    private String ten;
    @NotNull
    @Column(name="sisotoida")
    private int sisotoida;
    @NotNull
    @Column(name="mota")
    private String mota;
    @NotNull
    @JoinColumn(name="monhockyhocid")
    @ManyToOne(targetEntity = MonHocKyHoc.class, cascade = CascadeType.ALL)
    private MonHocKyHoc mhkh;
}
