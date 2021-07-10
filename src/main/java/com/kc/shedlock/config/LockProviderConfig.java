package com.kc.shedlock.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class LockProviderConfig {
    @Bean
    public LockProvider lockProvider(DataSource dataSource) throws UnknownHostException {
        return new JdbcTemplateLockProvider(JdbcTemplateLockProvider.Configuration.builder()
                .withTableName("lm_schedule_manager")
                .withColumnNames(new JdbcTemplateLockProvider.ColumnNames("scheduler_name", "lock_end_time", "lock_start_time", "locked_node"))
                .withJdbcTemplate(new JdbcTemplate(dataSource))
                .withLockedByValue(InetAddress.getLocalHost().getHostName())
                .build());
    }
}