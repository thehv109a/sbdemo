package thehv.banhang.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thehv.banhang.domains.HoaDonXuat;

@Repository
public interface HoaDonXuatJpa extends JpaRepository<HoaDonXuat, Long> {
    HoaDonXuat getByMa(String ma);
}