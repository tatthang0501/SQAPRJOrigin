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
@Table(name="diachi")
public class DiaChi implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name="id")
    private int id;
    
    @NotNull
    @Column(name="sonha")
    private String sonha;
    @NotNull
    @Column(name="toanha")
    private String toanha;
    @NotNull
    @Column(name="xompho")
    private String xompho;
    @NotNull
    @Column(name="phuongxa")
    private String phuongxa;
    @NotNull
    @Column(name="quanhuyen")
    private String quanhuyen;
    @NotNull
    @Column(name="tinhthanh")
    private String tinhthanh;
}

