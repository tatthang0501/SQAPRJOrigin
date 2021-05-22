package ptit.models;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class LichHocView implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String ten;
    private int soTC;
    private String phong;
    private int nhomTH;
    private int siSoToiDa;
    private List<Integer> ngayHoc;
    private List<Integer> kipHoc;
    private List<Integer> tuanHoc;
    private boolean daDK = false;

}
