package thehv.banhang.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thehv.banhang.domains.HoaDonXuatCT;

@Repository
public interface HoaDonXuatCTJpa extends JpaRepository<HoaDonXuatCT, Long> {
    ArrayList<HoaDonXuatCT> getByMaHoaDonXuat(String ma);
}