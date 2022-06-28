package thehv.banhang.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thehv.banhang.domains.HoaDonNhapCT;

@Repository
public interface HoaDonNhapCTJpa extends JpaRepository<HoaDonNhapCT, Long> {
    ArrayList<HoaDonNhapCT> getByMaHoaDonNhap(String ma);
}