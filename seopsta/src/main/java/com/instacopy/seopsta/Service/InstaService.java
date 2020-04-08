package com.instacopy.seopsta.Service;

import com.instacopy.seopsta.DTO.BoardDTO;
import com.instacopy.seopsta.DTO.FollowerDTO;
import com.instacopy.seopsta.DTO.FollowingDTO;
import com.instacopy.seopsta.DTO.MemberDTO;
import com.instacopy.seopsta.Entity.FollowingEntity;
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
        memberDTO.setUsernick(memberDTO.getUserid());
        memberDTO.setUserprofileimg("defaultimage.png");
        repository.save(memberDTO.toEntity());
    }

    public boolean membercheck(MemberDTO memberDTO) throws Exception{
        InstaEntity instaEntity = repository.findByUseridEquals(memberDTO.getUserid());
        return encoder.matches(memberDTO.getUserpass(), instaEntity.getUserpass());
    }

    public void memberchange(MemberDTO memberDTO, String userid) throws Exception{
        Query query = new Query();
        Update update = new Update();
        Update update1 = new Update();
        query.addCriteria(Criteria.where("userid").is(userid));
        InstaEntity instaEntity = memberDTO.toEntity();
        update.set("userprofileimg",instaEntity.getUserprofileimg());
        mongoTemplate.updateFirst(query,update,InstaEntity.class);
        update1.set("usernick",instaEntity.getUsernick());
        mongoTemplate.updateMulti(query,update1,InstaEntity.class);
    }

    public InstaEntity eqaulUserid(String userid) throws Exception{
        InstaEntity instaEntity = repository.findByUseridEquals(userid);
        return instaEntity;
    }

    public void newpost(BoardDTO boardDTO) throws Exception{
        InstaEntity entity = repository.findByUseridEquals(boardDTO.getUserid());
        if(entity.getBoards() == null){
            boardDTO.setBoardid(1);
        }else{
            boardDTO.setBoardid(entity.boardsize() + 1);
        }
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("userid").is(boardDTO.getUserid()));
        update.push("boards",boardDTO.toEntity().getBoards());
        mongoTemplate.updateFirst(query, update, InstaEntity.class);
    }

    public InstaEntity boards(String userid) throws Exception{
        return repository.findByUseridEquals(userid);
    }

    public InstaEntity userfind(String id) throws Exception{
        return repository.findByUseridEqualsOrUsernickEquals(id, id);
    }

    public void following(FollowingDTO followingDTO, String myname) throws Exception{
        InstaEntity entity = repository.findByUseridEquals(followingDTO.getFollowingid());
        if(entity.getFollowings() == null){
            followingDTO.setFollowingnumber(1);
        }else{
            followingDTO.setFollowingnumber(entity.followingsize() + 1);
        }
        Query query = new Query();
        Query subquery = new Query();
        Update update = new Update();
        Update subupdate = new Update();
        query.addCriteria(Criteria.where("userid").is(myname));
        update.push("followings", followingDTO);
        mongoTemplate.updateFirst(query,update,InstaEntity.class);
        subquery.addCriteria(Criteria.where("userid").is(followingDTO.getFollowingid()));
        subupdate.push("followers",myname);
        mongoTemplate.updateMulti(subquery,subupdate,InstaEntity.class);
    }

    public void unfollow(FollowingDTO followingDTO, String myname){
        
    }

}
