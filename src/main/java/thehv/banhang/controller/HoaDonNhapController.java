package thehv.banhang.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import thehv.banhang.domains.HoaDonNhap;
import thehv.banhang.domains.HoaDonNhapCT;
import thehv.banhang.services.AppFilter;
import thehv.banhang.services.AppUtils;
import thehv.banhang.services.PageRes;

@RestController
@Log4j2
public class HoaDonNhapController extends ApiBaseController {

    @PostMapping("api/getListHoaDonNhap")
    public PageRes getListHoaDonNhap(@RequestBody AppFilter filter) {
        return banHangJdbc.getListHoaDonNhap(filter);
    }

    @PostMapping("api/createHoaDonNhap")
    public String createHoaDonNhap() {
        try {
            HoaDonNhap hoaDonNhap = new HoaDonNhap();
            hoaDonNhap.setMa(AppUtils.taoMaHoaDonNhap());
            hoaDonNhap.setNgayLapHoaDon(new Date());
            hoaDonNhapJpa.save(hoaDonNhap);
            return hoaDonNhap.getMa();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping("api/updateHoaDonNhap")
    public String updateHoaDonNhap(@RequestBody HoaDonNhap model) {
        try {
            hoaDonNhapJpa.save(model);
            return AppUtils.OK_RS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping("api/getHoaDonNhap")
    public HoaDonNhap getHoaDonNhap(@RequestParam String ma) {
        try {
            HoaDonNhap entity = hoaDonNhapJpa.getByMa(ma);
            return entity;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @PostMapping("api/getHoaDonNhapCT")
    public Object getHoaDonNhapCT(@RequestParam String ma) {
        return banHangJdbc.getHoaDonNhapCT(ma);
    }

    @PostMapping("api/addHoaDonNhapCT")
    public String addHoaDonNhapCT(@RequestBody HoaDonNhapCT model) {
        try {
            if (model.getMaMatHang() == null || model.getMaMatHang().isEmpty() || model.getSoLuong() == null
                    || model.getSoLuong() < 1 || model.getDonGia() == null || model.getDonGia() < 1) {
                return AppUtils.INVALID_RS;
            }
            hoaDonNhapCTJpa.save(model);
            return AppUtils.OK_RS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping("api/deleteHoaDonNhapCT")
    public String deleteHoaDonNhapCT(@RequestParam long id) {
        try {
            hoaDonNhapCTJpa.deleteById(id);
            return AppUtils.OK_RS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping(value = "api/deleteHoaDonNhap")
    public String deleteHoaDonNhap(@RequestParam String ma) {
        try {
            HoaDonNhap entity = hoaDonNhapJpa.getByMa(ma);
            if (banHangJdbc.cantDeleteHoaDonNhap(entity.getMa())) {
                hoaDonNhapJpa.delete(entity);
                return AppUtils.OK_RS;
            } else {
                return AppUtils.INVALID_RS;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }
}
