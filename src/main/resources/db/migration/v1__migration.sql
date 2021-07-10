
CREATE TABLE lm_schedule_manager(scheduler_name VARCHAR(30) PRIMARY KEY NOT NULL,
lock_end_time TIMESTAMP(3) NOT NULL,
lock_start_time TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
locked_node VARCHAR(50) NOT NULL) engine=InnoDB default charset=utf8;