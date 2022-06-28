package thehv.banhang.models;

import java.util.ArrayList;
import lombok.Data;
import thehv.banhang.domains.HoaDonXuat;
import thehv.banhang.domains.HoaDonXuatCT;

@Data
public class HoaDonXuatModel {
    HoaDonXuat hoaDonXuat;
    ArrayList<HoaDonXuatCT> hoaDonXuatCTs;
}
