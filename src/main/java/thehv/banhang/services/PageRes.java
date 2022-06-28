package thehv.banhang.services;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@Data
@NoArgsConstructor
public class PageRes {
    private Object content;
    private long totalPages;
    private long totalElements;
    private long numberOfElements;
    private long page;
    private long pageSize;

    public PageRes(JdbcTemplate jdbcTemplate, String sql, List<Object> params) {
        this.content = jdbcTemplate.queryForList(sql, params.toArray());
        this.pageSize = (long) params.get(params.size() - 2);
        String tmp = sql.toLowerCase();
        int iFrom = tmp.indexOf(" FROM");
        int iLimit = tmp.indexOf(" LIMIT ");
        sql = "SELECT COUNT(1) AS TOTALELEMENTS FROM " + sql.substring(iFrom + 5, iLimit);
        params.remove(params.size() - 1);
        params.remove(params.size() - 1);
        this.totalPages = (long) Math.ceil(
                ((long) jdbcTemplate.queryForMap(sql, params.toArray()).get("TOTALELEMENTS") / (double) this.pageSize));
    }
}