package thehv.banhang.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class HoaDonNhapCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    private String maHoaDonNhap;

    private String maMatHang;

    private Integer soLuong;

    private Long donGia;

    private String ghiChu;
}