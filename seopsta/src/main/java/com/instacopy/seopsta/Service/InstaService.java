package com.instacopy.seopsta.Service;

import com.instacopy.seopsta.DTO.BoardDTO;
import com.instacopy.seopsta.DTO.MemberDTO;
import com.instacopy.seopsta.Entity.InstaEntity;
import com.instacopy.seopsta.Repository.InstaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log
public class InstaService {
    private InstaRepository repository;
    private MongoTemplate mongoTemplate;
    private BCryptPasswordEncoder encoder;

    public boolean check(String id) throws Exception{
        int member = repository.countByUseridEquals(id);
        if(member == 0){
            return true;
        }
        return false;
    }

    public void register(MemberDTO memberDTO) throws Exception{
        memberDTO.setUserpass(encoder.encode(memberDTO.getUserpass()));
        memberDTO.setUsernick(memberDTO.getUserid().toString());
        memberDTO.setUserprofileimg("/imgs/defaultimage.png");
        repository.save(memberDTO.toEntity());
    }

    public boolean membercheck(MemberDTO memberDTO) throws Exception{
        InstaEntity instaEntity = repository.findByUseridEquals(memberDTO.getUserid());
        return encoder.matches(memberDTO.getUserpass(), instaEntity.getUserpass());
    }

    public InstaEntity eqaulUserid(String userid) throws Exception{
        InstaEntity instaEntity = repository.findByUseridEquals(userid);
        return instaEntity;
    }

    public void newpost(BoardDTO boardDTO) throws Exception{
        InstaEntity entity = repository.findByUsernickEquals(boardDTO.getUsernick());
        if(entity.getBoards() == null){
            boardDTO.setBoardid(1);
        }else{
            boardDTO.setBoardid(entity.boardsize() + 1);
        }
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("usernick").is(boardDTO.toEntity().getUsernick()));
        update.push("boards",boardDTO.toEntity().getBoards());
        mongoTemplate.updateFirst(query, update, InstaEntity.class);
    }

    public InstaEntity boards(String userid) throws Exception{
        return repository.findByUseridEquals(userid);
    }

    public InstaEntity userfind(String id) throws Exception{
        return repository.findByUseridEqualsOrUsernickEquals(id, id);
    }

}
