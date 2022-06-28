package thehv.banhang.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thehv.banhang.domains.HoaDonNhap;

@Repository
public interface HoaDonNhapJpa extends JpaRepository<HoaDonNhap, Long> {
    HoaDonNhap getByMa(String ma);
}