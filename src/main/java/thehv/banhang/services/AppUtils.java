package thehv.banhang.services;

public class AppUtils {
    public static final String OK_RS = "OK";
    public static final String ERROR_RS = "ERROR";
    public static final String INVALID_RS = "INVALID";

    public static String closureMysql(String param) {
        return "'" + param + "'";
    }

    public static String taoMaHoaDonNhap() {
        return "HDN_" + System.currentTimeMillis();
    }

    public static String taoMaHoaDonXuat() {
        return "HDX_" + System.currentTimeMillis();
    }
}