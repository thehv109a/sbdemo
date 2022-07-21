package thehv.banhang.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class HoaDonNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    private String ma;

    private String nguoiGiao;

    private String diaChi;

    private String ghiChu;

    private Long tongTien;

    @JsonFormat(pattern = "yyyy-MM-dd")

    private Date ngayLapHoaDon;

    private String trangThai;
}