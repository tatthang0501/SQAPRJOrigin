package ptit.models;

import java.io.Serializable;

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
@Table(name="monhoc")
public class MonHoc implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @NotNull
    @Column(name="ten")
    private String ten;
    @NotNull
    @Column(name="sotc")
    private int soTC;
    @NotNull
    @Column(name="mota")
    private String mota;

    @ManyToOne
    @JoinColumn(name="bomonid")
    private BoMon boMon;
}
