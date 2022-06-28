// package thehv.test_mysql;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class JdbcTestController {
//     @Autowired
//     @Qualifier(Jdbc2ndConfig.TEMPLATE_NAME)
//     JdbcTemplate jdbcTemplate;

//     @GetMapping("/testJdbc")
//     public Object testJdbc() {
//         return jdbcTemplate.queryForList(
//                 "SELECT  x.TABLE_NAME ,x.ENGINE ,x.TABLE_ROWS ,round(((x.DATA_LENGTH + x.INDEX_LENGTH)/1024/1024),2) SIZE_MB FROM information_schema.TABLES x WHERE x.table_schema = 'mysql';");
//     }
// }