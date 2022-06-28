package thehv.banhang.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import thehv.banhang.domains.MatHang;
import thehv.banhang.services.AppFilter;
import thehv.banhang.services.AppUtils;
import thehv.banhang.services.PageRes;

@RestController
@Log4j2
public class MatHangController extends ApiBaseController {

    @PostMapping("api/getListMatHang")
    public PageRes getListMatHang(@RequestBody AppFilter filter) {
        return banHangJdbc.getListMatHang(filter);
    }

    @PostMapping("api/getMatHang")
    public MatHang getMatHang(@RequestParam String ma) {
        try {
            MatHang matHang = matHangJpa.getByMa(ma);
            return matHang;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @PostMapping("api/getListMatHangDL")
    public List<Map<String, Object>> getListMatHangDL() {
        return banHangJdbc.getListMatHangDL();
    }

    @PostMapping(value = "api/saveMatHang")
    public String saveMatHang(@RequestBody MatHang model) {
        try {
            if (model.getMa() == null || model.getMa().isEmpty() || model.getMa().contains(" ")
                    || model.getMa().length() > 20
                    || (model.getId() == 0 && matHangJpa.getByMa(model.getMa()) != null)) {
                return AppUtils.INVALID_RS;
            }
            matHangJpa.save(model);
            return model.getMa();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping(value = "api/saveListTonDau")
    public String saveListTonDau(@RequestBody List<MatHang> model) {
        try {
            for (MatHang matHang : model) {
                Integer tonDau = matHang.getTonDau();
                matHang = matHangJpa.getByMa(matHang.getMa());
                matHang.setTonDau(tonDau);
                matHangJpa.save(matHang);
            }
            return AppUtils.OK_RS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping(value = "api/deleteMatHang")
    public String deleteMatHang(@RequestParam String ma) {
        try {
            MatHang entity = matHangJpa.getByMa(ma);
            if (banHangJdbc.cantDeleteMatHang(entity.getMa())) {
                matHangJpa.delete(entity);
                return AppUtils.OK_RS;
            } else {
                return AppUtils.INVALID_RS;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AppUtils.ERROR_RS;
        }
    }

    @PostMapping("api/getListXuatNhapTon")
    public PageRes getListXuatNhapTon(@RequestBody AppFilter filter) {
        return banHangJdbc.getListXuatNhapTon(filter);
    }

    @GetMapping("api/getListNhacc")
    public Object getListNhacc() {
        return banHangJdbc.getListNhacc();
    }
}