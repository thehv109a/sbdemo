package thehv.banhang.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import thehv.banhang.domains.HoaDonXuat;
import thehv.banhang.domains.HoaDonXuatCT;
import thehv.banhang.services.AppFilter;
import thehv.banhang.services.AppUtils;
import thehv.banhang.services.PageRes;

@RestController
@Log4j2
public class HoaDonXuatController extends ApiBaseController {

    @PostMapping("api/getListHoaDonXuat")
    public PageRes getListHoaDonXuat(@RequestBody AppFilter filter) {
        return banHangJdbc.getListHoaDonXuat(filter);
    }

    @PostMapping("api/createHoaDonXuat")
    public String createHoaDonXuat() {
        try {
            HoaDonXuat hoaDonXuat = new HoaDonXuat();
            hoaDonXuat.setMa(AppUtils.taoMaHoaDonXuat());
            hoaDonXuat.setNgayLapHoaDon(new Date());
            hoaDonXuatJpa.save(hoaDonXuat);
            return hoaDonXuat.getMa();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping("api/updateHoaDonXuat")
    public String updateHoaDonXuat(@RequestBody HoaDonXuat model) {
        try {
            hoaDonXuatJpa.save(model);
            return AppUtils.OK_RS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping("api/getHoaDonXuat")
    public HoaDonXuat getHoaDonXuat(@RequestParam String ma) {
        try {
            HoaDonXuat entity = hoaDonXuatJpa.getByMa(ma);
            return entity;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @PostMapping("api/getHoaDonXuatCT")
    public Object getHoaDonXuatCT(@RequestParam String ma) {
        return banHangJdbc.getHoaDonXuatCT(ma);
    }

    @PostMapping("api/addHoaDonXuatCT")
    public String addHoaDonXuatCT(@RequestBody HoaDonXuatCT model) {
        try {
            if (model.getMaMatHang() == null || model.getMaMatHang().isEmpty() || model.getSoLuong() == null
                    || model.getSoLuong() < 1 || model.getDonGia() == null || model.getDonGia() < 1) {
                return AppUtils.INVALID_RS;
            }
            hoaDonXuatCTJpa.save(model);
            return AppUtils.OK_RS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping("api/deleteHoaDonXuatCT")
    public String deleteHoaDonXuatCT(@RequestParam long id) {
        try {
            hoaDonXuatCTJpa.deleteById(id);
            return AppUtils.OK_RS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping(value = "api/deleteHoaDonXuat")
    public String deleteHoaDonXuat(@RequestParam String ma) {
        try {
            HoaDonXuat entity = hoaDonXuatJpa.getByMa(ma);
            if (banHangJdbc.cantDeleteHoaDonXuat(entity.getMa())) {
                hoaDonXuatJpa.delete(entity);
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