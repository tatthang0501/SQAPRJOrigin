package ptit.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="monhockyhoc")
public class MonHocKyHoc implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @NotNull
    @JoinColumn(name="monhocid")
    @ManyToOne(targetEntity = MonHoc.class, cascade = CascadeType.ALL)
    private MonHoc mh;

    @NotNull
    @JoinColumn(name="kyhocid")
    @ManyToOne(targetEntity = KyHoc.class, cascade = CascadeType.ALL)
    private KyHoc kyhoc;
}
