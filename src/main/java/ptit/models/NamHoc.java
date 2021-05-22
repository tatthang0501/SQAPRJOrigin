package ptit.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="namhoc")
public class NamHoc implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name="id")
    private int id;
    @NotNull
    @Column(name="ten")
    private String ten;
    @NotNull
    @Column(name="mota")
    private String mota;
}
