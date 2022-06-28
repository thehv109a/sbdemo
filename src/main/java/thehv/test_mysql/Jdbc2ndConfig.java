// package thehv.test_mysql;

// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.core.JdbcTemplate;

// @Configuration
// public class Jdbc2ndConfig {
//     private static final String PREFIX = "db2nd.datasource";
//     private static final String DATASOURCE_NAME = "datasource" + PREFIX;
//     public static final String TEMPLATE_NAME = "template" + PREFIX;

//     @ConfigurationProperties(prefix = PREFIX)
//     @Bean(name = DATASOURCE_NAME)
//     public DataSource DataSource2() {
//         return DataSourceBuilder.create().build();
//     }

//     @Bean(name = TEMPLATE_NAME)
//     public JdbcTemplate JdbcTemplate2(@Qualifier(DATASOURCE_NAME) DataSource dataSource) {
//         return new JdbcTemplate(dataSource);
//     }
// }