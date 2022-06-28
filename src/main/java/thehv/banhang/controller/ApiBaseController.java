package thehv.banhang.controller;

import org.springframework.beans.factory.annotation.Autowired;

import thehv.banhang.services.BanHangJdbc;
import thehv.banhang.services.HoaDonNhapCTJpa;
import thehv.banhang.services.HoaDonNhapJpa;
import thehv.banhang.services.HoaDonXuatCTJpa;
import thehv.banhang.services.HoaDonXuatJpa;
import thehv.banhang.services.MatHangJpa;

public class ApiBaseController {
    @Autowired
    BanHangJdbc banHangJdbc;

    @Autowired
    HoaDonNhapJpa hoaDonNhapJpa;

    @Autowired
    HoaDonNhapCTJpa hoaDonNhapCTJpa;

    @Autowired
    HoaDonXuatJpa hoaDonXuatJpa;

    @Autowired
    HoaDonXuatCTJpa hoaDonXuatCTJpa;

    @Autowired
    MatHangJpa matHangJpa;
}
