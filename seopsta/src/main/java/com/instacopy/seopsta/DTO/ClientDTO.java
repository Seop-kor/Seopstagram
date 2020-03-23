package com.instacopy.seopsta.DTO;

import com.instacopy.seopsta.Entity.ClientEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| clientno | int         | NO   | PRI | NULL    | auto_increment |
| userid   | varchar(15) | NO   |     | NULL    |                |
| token    | text        | NO   |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
 */

@Data
@NoArgsConstructor
@ToString
public class ClientDTO {
    private String id;
    private char[] userid;
    private String token;

    public ClientEntity toEntity(){
        ClientEntity clientEntity = ClientEntity.builder().id(id).userid(userid).token(token).build();
        return clientEntity;
    }

    @Builder
    public ClientDTO(String id, char[] userid, String token){
        this.id = id;
        this.userid = userid;
        this.token = token;
    }
}
