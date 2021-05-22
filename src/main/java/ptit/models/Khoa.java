package ptit.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="khoa")
public class Khoa implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private int id;

    @Column(name="ten")
    private String ten;
    @Column(name="mota")
    private String mota;

    @OneToMany(mappedBy = "khoa",  cascade = CascadeType.ALL)
    private List<BoMon> boMon;
}
