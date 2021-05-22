
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
@Table(name="kiphoc")
public class KipHoc implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private int id;

    @Column(name="ten")
    private int ten;

    @Column(name="mota")
    private String mota;

    @JoinColumn(name="lichhocid")
    @ManyToOne
    private LichHoc lh;
}
