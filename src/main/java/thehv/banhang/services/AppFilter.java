package thehv.banhang.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppFilter {
    private String ma;
    private String ten;
    private String fromDate;
    private String toDate;
    private long page = 1;
    private long pageSize = 5;
    private String sort;
}