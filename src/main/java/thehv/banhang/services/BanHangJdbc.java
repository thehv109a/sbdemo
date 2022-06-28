package thehv.banhang.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BanHangJdbc {
    @Autowired
    
    JdbcTemplate jdbcTemplate;

    public Object getListNhacc() {
        String sql = "SELECT * FROM NHACC LIMIT 100";
        return jdbcTemplate.queryForList(sql);
    }

    public PageRes getListMatHang(AppFilter filter) {
        String sql = "SELECT * FROM MAT_HANG WHERE TEN LIKE ? AND MA LIKE ? ORDER BY ID DESC LIMIT ? OFFSET ?";
        List<Object> params = new ArrayList<>();
        params.add(filter.getTen() == null ? "%%" : "%" + filter.getTen() + "%");
        params.add(filter.getMa() == null ? "%%" : "%" + filter.getMa() + "%");
        params.add(filter.getPageSize());
        params.add(filter.getPageSize() * (filter.getPage() - 1));
        return new PageRes(jdbcTemplate, sql, params);
    }

    public List<Map<String, Object>> getListMatHangDL() {
        String sql = "SELECT X.MA AS VALUE, CONCAT(X.MA,', ', X.TEN) AS TEXT FROM MAT_HANG X";
        return jdbcTemplate.queryForList(sql);
    }

    public boolean cantDeleteHoaDonNhap(String ma) {
        String sql = "SELECT ID FROM HOA_DON_NHAPCT WHERE MA_HOA_DON_NHAP = ? LIMIT 1";
        return jdbcTemplate.queryForList(sql, ma).size() == 0 ? true : false;
    }

    public boolean cantDeleteHoaDonXuat(String ma) {
        String sql = "SELECT ID FROM HOA_DON_XUAT_CT WHERE MA_HOA_DON_XUAT = ? LIMIT 1";
        return jdbcTemplate.queryForList(sql, ma).size() == 0 ? true : false;
    }

    public boolean cantDeleteMatHang(String ma) {
        String sql = "(SELECT ID FROM HOA_DON_NHAPCT WHERE MAMAT_HANG = ? LIMIT 1) UNION ALL(SELECT ID FROM HOA_DON_XUAT_CT WHERE MAMAT_HANG = ? LIMIT 1)";
        return jdbcTemplate.queryForList(sql, ma, ma).size() == 0 ? true : false;
    }

    public PageRes getListHoaDonNhap(AppFilter filter) {
        String sql = "SELECT ID, MA, NGUOI_GIAO, DIA_CHI, DATE_FORMAT(NGAY_LAP_HOA_DON,'%D-%M-%Y') AS NGAY_LAP_HOA_DON FROM HOA_DON_NHAP WHERE MA LIKE ? AND NGAY_LAP_HOA_DON >= ? AND NGAY_LAP_HOA_DON < ? ORDER BY ID DESC LIMIT ? OFFSET ?";
        List<Object> params = new ArrayList<>();
        params.add(filter.getMa() == null ? "%%" : "%" + filter.getMa() + "%");
        params.add(filter.getFromDate() == null ? "2020-01-01" : filter.getFromDate());
        params.add(filter.getToDate() == null ? "2050-01-01" : filter.getToDate());
        params.add(filter.getPageSize());
        params.add(filter.getPageSize() * (filter.getPage() - 1));
        return new PageRes(jdbcTemplate, sql, params);
    }

    public PageRes getListHoaDonXuat(AppFilter filter) {
        String sql = "SELECT ID, MA, NGUOI_NHAN, DIA_CHI, DATE_FORMAT(NGAY_LAP_HOA_DON,'%D-%M-%Y') AS NGAY_LAP_HOA_DON FROM HOA_DON_XUAT WHERE MA LIKE ? AND NGAY_LAP_HOA_DON >= ? AND NGAY_LAP_HOA_DON < ? ORDER BY ID DESC LIMIT ? OFFSET ?";
        List<Object> params = new ArrayList<>();
        params.add(filter.getMa() == null ? "%%" : "%" + filter.getMa() + "%");
        params.add(filter.getFromDate() == null ? "2020-01-01" : filter.getFromDate());
        params.add(filter.getToDate() == null ? "2050-01-01" : filter.getToDate());
        params.add(filter.getPageSize());
        params.add(filter.getPageSize() * (filter.getPage() - 1));
        return new PageRes(jdbcTemplate, sql, params);
    }

    public Object getHoaDonNhapCT(String ma) {
        String sql = "(SELECT NULL AS ID, NULL AS MA, NULL AS TEN, NULL AS DONVITINH, SUM(X.SOLUONG) AS SOLUONG, NULL AS DONGIA, SUM(X.SOLUONG * X.DONGIA) AS THANHTIEN FROM HOA_DON_NHAPCT X WHERE X.MA_HOA_DON_NHAP = ?) UNION ALL (SELECT X.ID, Y.MA, Y.TEN, Y.DONVITINH, X.SOLUONG, X.DONGIA, X.SOLUONG * X.DONGIA AS THANHTIEN FROM HOA_DON_NHAPCT X LEFT JOIN MAT_HANG Y ON Y.MA = X.MAMAT_HANG WHERE X.MA_HOA_DON_NHAP= ? ORDER BY X.ID DESC)";
        return jdbcTemplate.queryForList(sql, ma, ma);
    }

    public Object getHoaDonXuatCT(String ma) {
        String sql = "(SELECT NULL AS ID, NULL AS MA, NULL AS TEN, NULL AS DONVITINH, SUM(X.SOLUONG) AS SOLUONG, NULL AS DONGIA, SUM(X.SOLUONG * X.DONGIA) AS THANHTIEN FROM HOA_DON_XUAT_CT X WHERE X.MA_HOA_DON_XUAT = ?) UNION ALL (SELECT X.ID, Y.MA, Y.TEN, Y.DONVITINH, X.SOLUONG, X.DONGIA, X.SOLUONG * X.DONGIA AS THANHTIEN FROM HOA_DON_XUAT_CT X LEFT JOIN MAT_HANG Y ON Y.MA = X.MAMAT_HANG WHERE X.MA_HOA_DON_XUAT= ? ORDER BY X.ID DESC)";
        return jdbcTemplate.queryForList(sql, ma, ma);
    }

    public PageRes getListXuatNhapTon(AppFilter filter) {
        String sql = "SELECT X.MA, X.TEN, X.TON_DAU, Y.TONG_NHAP, Z.TONG_XUAT,(X.TON_DAU + COALESCE(Y.TONG_NHAP, 0) - COALESCE(Z.TONG_XUAT, 0)) AS TONCUOI FROM MAT_HANG X LEFT JOIN ( SELECT X.MAMAT_HANG, SUM(X.SOLUONG) AS TONG_NHAP FROM HOA_DON_NHAPCT X JOIN HOA_DON_NHAP Y ON X.MA_HOA_DON_NHAP = Y.MA  WHERE X.MAMAT_HANG LIKE ? AND Y.NGAY_LAP_HOA_DON >= ? AND Y.NGAY_LAP_HOA_DON < ? GROUP BY X.MAMAT_HANG) Y ON X.MA = Y.MAMAT_HANG LEFT JOIN ( SELECT X.MAMAT_HANG, SUM(X.SOLUONG) AS TONG_XUAT FROM HOA_DON_XUAT_CT X JOIN HOA_DON_XUAT Y ON X.MA_HOA_DON_XUAT = Y.MA WHERE X.MAMAT_HANG LIKE ? AND Y.NGAY_LAP_HOA_DON >= ? AND Y.NGAY_LAP_HOA_DON < ? GROUP BY X.MAMAT_HANG ) Z ON X.MA = Z.MAMAT_HANG WHERE X.MA LIKE ? ORDER BY X.MA LIMIT ? OFFSET ?";

        Object[] params = new Object[9];
        params[0] = params[3] = params[6] = filter.getMa() == null ? "%%" : "%" + filter.getMa() + "%";
        params[1] = params[4] = filter.getFromDate() == null ? "2020-01-01" : filter.getFromDate();
        params[2] = params[5] = filter.getFromDate() == null ? "2050-01-01" : filter.getToDate();
        params[7] = filter.getPageSize();
        params[8] = filter.getPageSize() * (filter.getPage() - 1);
        return new PageRes(jdbcTemplate, sql, new ArrayList<>(Arrays.asList(params)));
    }
}