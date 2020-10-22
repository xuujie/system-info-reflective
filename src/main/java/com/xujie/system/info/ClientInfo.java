package com.xujie.system.info;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity(name = "CLIENT_INFO")
public class ClientInfo {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "CLIENT_INFO_ID")
    private String clientInfoId;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_IP")
    private String clientIp;

    @Column(name = "ACCESS_TIME")
    private Timestamp accessTime;
}
