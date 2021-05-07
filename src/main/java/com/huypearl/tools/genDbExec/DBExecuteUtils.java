package com.huypearl.tools.genDbExec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.huypearl.tools.genDbExec.dto.ConnectionDto;

public class DBExecuteUtils {

    public static String readDBInformation(ConnectionDto connectionDto) throws Exception {
        StringBuilder sb = new StringBuilder();
        Connection conn = DriverManager.getConnection(connectionDto.getUrl(), connectionDto.getUsername(),
                connectionDto.getPassword());
        String sql = "SELECT * FROM students";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        ResultSetMetaData rsMeta = result.getMetaData();

        int numberOfColumns = rsMeta.getColumnCount();
        for (int i = 1; i <= numberOfColumns; i++) {
            String type = rsMeta.getColumnTypeName(i);
            String name = rsMeta.getColumnName(i);
            int pre = rsMeta.getPrecision(i);
            int scale = rsMeta.getScale(i);
            sb.append("name: " + name + "\n");
            sb.append("type: " + type + "\n");
            sb.append("pre: " + pre + "\n");
            sb.append("scale: " + scale + "\n");
            sb.append("====================" + "\n");
        }
        
        return sb.toString();
    }
}
