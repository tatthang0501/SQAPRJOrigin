package ptit.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class MonHocKyHocView implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String ten;
    private int soTC;
    private String mota;
}
