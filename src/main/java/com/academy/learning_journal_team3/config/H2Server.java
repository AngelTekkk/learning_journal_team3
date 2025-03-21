//package com.academy.learning_journal_team3.config;
//
//import org.h2.tools.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.sql.SQLException;
//@Configuration
//public class H2Server {
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server h2TcpServer() throws SQLException {
//        return Server.createTcpServer("-tcp", "-tcpPort", "8043", "-tcpAllowOthers");
//    }
//}