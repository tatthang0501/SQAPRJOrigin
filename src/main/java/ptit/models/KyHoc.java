package ptit.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="kyhoc")
public class KyHoc implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name="id")
    private int id;

    @NotNull
    @JoinColumn(name="namhocid")
    @OneToOne(targetEntity = NamHoc.class, cascade = CascadeType.ALL)
    private NamHoc nh;

    @NotNull
    @JoinColumn(name="hockyid")
    @ManyToOne(targetEntity = HocKy.class, cascade = CascadeType.ALL)
    private HocKy hk;
}
