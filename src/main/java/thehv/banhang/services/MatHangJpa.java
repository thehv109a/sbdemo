package thehv.banhang.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thehv.banhang.domains.MatHang;

@Repository
public interface MatHangJpa extends JpaRepository<MatHang, Long> {

    MatHang getByMa(String ma);

    MatHang getById(long id);
}