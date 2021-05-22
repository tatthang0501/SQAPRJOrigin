package ptit.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import ptit.models.LichHocView;

public class CheckDuplicate {
    public static ArrayList<LichHocView> checkTrungLapNgayHoc(ArrayList<LichHocView> list) {
        ArrayList<LichHocView> listNgayTrung = new ArrayList<LichHocView>();
        Set tempSet = new HashSet();
        for (LichHocView lhv : list) {
            if (!tempSet.add(lhv.getNgayHoc())) {
                listNgayTrung.add(lhv);
            }
        }
        return listNgayTrung;
    }

    public static boolean checkTrungLapKipHoc(ArrayList<LichHocView> listNgayTrung, ArrayList<LichHocView> listDK) {
        for(LichHocView lhv : listNgayTrung){
            listDK.remove(lhv);
        }
        Map<Integer, List<Integer>> mapListNgayTrung = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> mapKhongTrung = new HashMap<Integer, List<Integer>>();

        for (LichHocView lh : listDK) {
            mapKhongTrung.put(lh.getNgayHoc().get(0), lh.getKipHoc());
        }
        for (LichHocView lh : listNgayTrung) {
            mapListNgayTrung.put(lh.getNgayHoc().get(0), lh.getKipHoc());
        }
        for (Entry<Integer, List<Integer>> map : mapListNgayTrung.entrySet()) {
            if(mapKhongTrung.containsKey(map.getKey()) && mapKhongTrung.containsValue(map.getValue())){
                return true;
            }
        }
        return false;
    }
}
