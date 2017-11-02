/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.harvey.studio.alumni.common.consts.Consts;

/**
 * 基于数据库测试的基类.
 * @title DBBaseTestcase
 * @description 负责在测试启动前进行数据清理和初始化的工作.  
 * @author zw.han
 * @date 2017年1月1日
 * @version 1.0
 */
@ContextConfiguration("classpath:spring-ctx-alumni-business.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class DBBaseTestcase {
    @Before
    public void initData() throws Exception {
        Properties properties = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("alumni-business.properties");
        properties.load(is);
        String driver = properties.getProperty("cdse.business.datasource.jdbc.driver");
        String url = properties.getProperty("cdse.business.datasource.jdbc.url");
        String username = properties.getProperty("cdse.business.datasource.jdbc.username");
        String password = properties.getProperty("cdse.business.datasource.jdbc.password");
        Connection conn = null;
        Reader schemaReader = null;
        Reader initReader = null;
        Reader appendReader = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);

            ScriptRunner scriptRunner = new ScriptRunner(conn);
            // 初始化数据库并插入测试数据
            InputStream commonFileIs = this.getClass().getClassLoader().getResourceAsStream("db/init-test-common.sql");
            initReader = new InputStreamReader(commonFileIs, Consts.UTF8);
            scriptRunner.runScript(initReader);

            String custPath = this.getCustDataPath();
            if (StringUtils.isNoneBlank(custPath)) {
                InputStream appendFileIs = this.getClass().getClassLoader().getResourceAsStream("db/" + custPath);
                appendReader = new InputStreamReader(appendFileIs, Consts.UTF8);
                scriptRunner.runScript(appendReader);
            }
            conn.commit();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (schemaReader != null) {
                schemaReader.close();
            }
            if (initReader != null) {
                initReader.close();
            }
            if (appendReader != null) {
                appendReader.close();
            }
        }
    }

    /**
     * 获取初始化数据的sql文件路径，
     * 若子类有定制化初始化数据操作则可覆盖本方法.
     * @return
     */
    protected abstract String getCustDataPath();

}