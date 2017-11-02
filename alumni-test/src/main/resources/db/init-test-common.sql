-- -----------------------------------------------------
-- Table `tb_person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_person` ;

CREATE TABLE IF NOT EXISTS `tb_person` (
  `id` BIGINT NOT NULL COMMENT '主键',
  `student_no` VARCHAR(64) NULL COMMENT '学号',
  `name` VARCHAR(64) NOT NULL COMMENT '姓名',
  `city` VARCHAR(64) NULL COMMENT '城市',
  `area` VARCHAR(255) NULL COMMENT '区县',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  INDEX `IDX_PERSON_NAME` (`name`))
ENGINE = InnoDB
default charset=utf8;


-- -----------------------------------------------------
-- Table `tb_contact_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_contact_info` ;

CREATE TABLE IF NOT EXISTS `tb_contact_info` (
  `id` BIGINT NOT NULL COMMENT '主键',
  `person_id` BIGINT NOT NULL COMMENT 'person id',
  `type` TINYINT NOT NULL COMMENT '联系方式类型,1:手机号,2:qq号,3:微信,4:邮箱',
  `content` VARCHAR(64) NOT NULL COMMENT '联系方式内容',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  INDEX `IDX_CONCT_PERSON` (`person_id`))
ENGINE = InnoDB
default charset=utf8;


-- -----------------------------------------------------
-- Table `tb_clazz`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_clazz` ;
CREATE TABLE IF NOT EXISTS `tb_clazz` (
  `id` BIGINT NOT NULL COMMENT '主键',
  `clazz_name` VARCHAR(64) NOT NULL COMMENT '班级名',
  `creator` BIGINT NOT NULL COMMENT '创建者id',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
default charset=utf8;


-- -----------------------------------------------------
-- Table `tb_person_clazz_rel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_person_clazz_rel`;

CREATE TABLE IF NOT EXISTS `tb_person_clazz_rel` (
  `id` BIGINT NOT NULL COMMENT '主键',
  `person_id` BIGINT NOT NULL COMMENT 'person id',
  `clazz_id` BIGINT NOT NULL COMMENT '班级id',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `IDX_UNIQ_PER_CLAZZ` (`person_id`, `clazz_id`),
  INDEX `FK_PER_CLAZZ_REL_CLAZZ_idx` (`clazz_id`))
ENGINE = InnoDB
default charset=utf8;