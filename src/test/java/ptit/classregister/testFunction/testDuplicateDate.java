package ptit.classregister.testFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ptit.models.LichHocView;
import ptit.web.CheckDuplicate;

//Test các chức năng của lớp CheckDuplicate
@SpringBootTest
public class testDuplicateDate {

    //Test phương thức lấy ra các lịch học bị trùng ngày học
    // Test với ít nhất 2 lớp học phần
    @Test
    public void testDuplicateDay(){
        // Chuẩn bị dữ liệu, có 2 lớp học phần cùng ngày học "2"
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        //Kíp
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();
        //Ngày
        ngay.add(2);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        //Ngày
        kip2.add(3);
        kip2.add(4);
        List<Integer> ngay2 = new ArrayList<Integer>();
        //Ngày
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);

        // Kiểm tra kết quả khi thực hiện phương thức
        ArrayList<LichHocView> rs = CheckDuplicate.checkTrungLapNgayHoc(listTest);
        //Kết quả trả về là mảng các id lịch học có ngày học bị trùng lặp
        assertEquals(1, rs.size());
    }

    //Test phương thức lấy ra các lịch học bị trùng ngày học
    // Test với ít nhất 2 lớp học phần
    @Test
    public void testNoDuplicateDay(){
        // Chuẩn bị dữ liệu, có 2 lớp học phần không trùng ngày học
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        //Kíp
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();

        // Ngày học
        ngay.add(3);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        kip2.add(3);
        kip2.add(4);
        List<Integer> ngay2 = new ArrayList<Integer>();
        // Ngày học
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);
        // Kiểm tra kết quả khi thực hiện phương thức
        ArrayList<LichHocView> rs = CheckDuplicate.checkTrungLapNgayHoc(listTest);
        //Kết quả trả về là mảng các id lịch học có ngày học bị trùng lặp
        assertEquals(0, rs.size());
    }


    //Test phương thức lấy ra các lịch học bị trùng ngày học
    // Test với ít nhất 2 lớp học phần
    @Test
    public void testDuplicateDay2(){
        // Chuẩn bị dữ liệu, có 2 lớp học phần cùng ngày học "2", 2 lớp học phần có cùng ngày học "3"
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();
        ngay.add(2);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        kip2.add(3);
        kip2.add(4);
        List<Integer> ngay2 = new ArrayList<Integer>();
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);

        LichHocView lvh3 = new LichHocView();
        lvh3.setId(3);
        lvh3.setTen("Nhập môn công nghệ phần mềm");
        lvh3.setSoTC(3);
        lvh3.setPhong("A2");
        lvh3.setNhomTH(1);
        lvh3.setSiSoToiDa(50);
        List<Integer>kip3 = new ArrayList<Integer>();
        kip3.add(1);
        kip3.add(2);
        List<Integer> ngay3 = new ArrayList<Integer>();
        ngay3.add(3);
        List<Integer> tuan3 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan3.add(i);
        lvh3.setKipHoc(kip3);
        lvh3.setTuanHoc(tuan3);
        lvh3.setNgayHoc(ngay3);
        lvh3.setDaDK(false);
        listTest.add(lvh3);

        LichHocView lvh4 = new LichHocView();
        lvh4.setId(4);
        lvh4.setTen("Nhập môn công nghệ phần mềm");
        lvh4.setSoTC(3);
        lvh4.setPhong("A2");
        lvh4.setNhomTH(1);
        lvh4.setSiSoToiDa(45);
        List<Integer>kip4 = new ArrayList<Integer>();
        kip4.add(3);
        kip4.add(4);
        List<Integer> ngay4 = new ArrayList<Integer>();
        ngay4.add(3);
        List<Integer> tuan4 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan4.add(i);
        lvh4.setKipHoc(kip4);
        lvh4.setTuanHoc(tuan4);
        lvh4.setNgayHoc(ngay4);
        lvh4.setDaDK(false);
        listTest.add(lvh4);
        // Kiểm tra kết quả khi thực hiện phương thức
        ArrayList<LichHocView> rs = CheckDuplicate.checkTrungLapNgayHoc(listTest);
        //Kết quả trả về là mảng các id lịch học có ngày học bị trùng lặp
        assertEquals(2, rs.size());
    }

    //Test phương thức kiểm tra trùng cả ngày học và kíp học

    //Test với 2 lịch học không trùng kíp học, trùng ngày học
    //Test với ít nhất 2 lớp học phần
    @Test
    public void testNoDuplicateShift(){
        // Chuẩn bị dữ liệu, có 2 lịch học không trùng kíp học
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        //Kíp học 1-2
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();

        // Ngày học
        ngay.add(3);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        //Kíp học 3-4
        kip2.add(3);
        kip2.add(4);
        List<Integer> ngay2 = new ArrayList<Integer>();
        // Ngày học
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);

        // Kiểm tra kết quả khi thực hiện phương thức
        boolean check = CheckDuplicate.checkTrungLapKipHoc(CheckDuplicate.checkTrungLapNgayHoc(listTest), listTest);
        //Kết quả trả về true là có trùng lặp
        assertEquals(false, check);
    }

    //Test với 4 lịch học không trùng kíp học, trùng ngày học
    //Test với ít nhất 2 lớp học phần
    @Test
    public void testNoDuplicateShift2(){
        // Chuẩn bị dữ liệu, có 2 lớp học phần cùng ngày học "2", 2 lớp học phần có cùng ngày học "3", có 2 cặp lịch trùng kíp học nhưng không trùng ngày học
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();
        ngay.add(2);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        kip2.add(3);
        kip2.add(4);
        List<Integer> ngay2 = new ArrayList<Integer>();
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);

        LichHocView lvh3 = new LichHocView();
        lvh3.setId(3);
        lvh3.setTen("Nhập môn công nghệ phần mềm");
        lvh3.setSoTC(3);
        lvh3.setPhong("A2");
        lvh3.setNhomTH(1);
        lvh3.setSiSoToiDa(50);
        List<Integer>kip3 = new ArrayList<Integer>();
        kip3.add(1);
        kip3.add(2);
        List<Integer> ngay3 = new ArrayList<Integer>();
        ngay3.add(3);
        List<Integer> tuan3 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan3.add(i);
        lvh3.setKipHoc(kip3);
        lvh3.setTuanHoc(tuan3);
        lvh3.setNgayHoc(ngay3);
        lvh3.setDaDK(false);
        listTest.add(lvh3);

        LichHocView lvh4 = new LichHocView();
        lvh4.setId(4);
        lvh4.setTen("Nhập môn công nghệ phần mềm");
        lvh4.setSoTC(3);
        lvh4.setPhong("A2");
        lvh4.setNhomTH(1);
        lvh4.setSiSoToiDa(45);
        List<Integer>kip4 = new ArrayList<Integer>();
        kip4.add(3);
        kip4.add(4);
        List<Integer> ngay4 = new ArrayList<Integer>();
        ngay4.add(3);
        List<Integer> tuan4 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan4.add(i);
        lvh4.setKipHoc(kip4);
        lvh4.setTuanHoc(tuan4);
        lvh4.setNgayHoc(ngay4);
        lvh4.setDaDK(false);
        listTest.add(lvh4);
        // Kiểm tra kết quả khi thực hiện phương thức
        boolean check = CheckDuplicate.checkTrungLapKipHoc(CheckDuplicate.checkTrungLapNgayHoc(listTest), listTest);
        //Kết quả trả về true là có trùng lặp
        assertEquals(false, check);
    }

    //Test với 4 lịch học trùng kíp học, trùng ngày học
    //Test với ít nhất 2 lớp học phần
    @Test
    public void testNoDuplicateShift3(){
        // Chuẩn bị dữ liệu, có 2 lớp học phần cùng ngày học "2", 2 lớp học phần có cùng ngày học "3", có 2 cặp lịch trùng kíp học và trùng ngày học
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();

        // Kíp học
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();
        //Ngày 
        ngay.add(2);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        // Kíp học
        kip2.add(1);
        kip2.add(2);
        List<Integer> ngay2 = new ArrayList<Integer>();
        // Ngày
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);

        LichHocView lvh3 = new LichHocView();
        lvh3.setId(3);
        lvh3.setTen("Nhập môn công nghệ phần mềm");
        lvh3.setSoTC(3);
        lvh3.setPhong("A2");
        lvh3.setNhomTH(1);
        lvh3.setSiSoToiDa(50);
        List<Integer>kip3 = new ArrayList<Integer>();
        //Kíp
        kip3.add(1);
        kip3.add(2);
        List<Integer> ngay3 = new ArrayList<Integer>();
        // Kíp học
        ngay3.add(3);
        List<Integer> tuan3 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan3.add(i);
        lvh3.setKipHoc(kip3);
        lvh3.setTuanHoc(tuan3);
        lvh3.setNgayHoc(ngay3);
        lvh3.setDaDK(false);
        listTest.add(lvh3);

        LichHocView lvh4 = new LichHocView();
        lvh4.setId(4);
        lvh4.setTen("Nhập môn công nghệ phần mềm");
        lvh4.setSoTC(3);
        lvh4.setPhong("A2");
        lvh4.setNhomTH(1);
        lvh4.setSiSoToiDa(45);
        List<Integer>kip4 = new ArrayList<Integer>();
        //Kíp
        kip4.add(3);
        kip4.add(4);
        List<Integer> ngay4 = new ArrayList<Integer>();
        //Ngày
        ngay4.add(3);
        List<Integer> tuan4 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan4.add(i);
        lvh4.setKipHoc(kip4);
        lvh4.setTuanHoc(tuan4);
        lvh4.setNgayHoc(ngay4);
        lvh4.setDaDK(false);
        listTest.add(lvh4);
        // Kiểm tra kết quả khi thực hiện phương thức
        boolean check = CheckDuplicate.checkTrungLapKipHoc(CheckDuplicate.checkTrungLapNgayHoc(listTest), listTest);
        //Kết quả trả về true là có trùng lặp
        assertEquals(true, check);
    }
}
