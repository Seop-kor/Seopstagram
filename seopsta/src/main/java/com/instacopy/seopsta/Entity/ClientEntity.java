package com.instacopy.seopsta.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Document(collection = "client")
public class ClientEntity {
    @Id
    private String id;
    private char[] userid;
    private String token;


    @Builder
    public ClientEntity(String id, char[] userid, String token){
        this.id = id;
        this.userid = userid;
        this.token = token;
    }
}
