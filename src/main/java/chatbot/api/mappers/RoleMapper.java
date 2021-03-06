package chatbot.api.mappers;

import chatbot.api.role.domain.RoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface RoleMapper {

    // 허브유저 레코드 저장
    void save(RoleDTO hubUser);


    // heqSeq 와 userSeq 데이터를 인자로 받음
    // -> 추가하려는 사용자가 이미 해당 허브를 사용하고 있는지 조회
    RoleDTO getRoleInfo(@Param("hubId") Long hubId, @Param("userId") Long userId);


    // hubSeq를 가지고 hubUser 삭제
    void deleteAllRoleByAdmin(RoleDTO role);


    // 역할1 : 일반 유저 스스로 허브 권한 삭제
    // 역할2 : admin 유저가 일반 유저를 삭제
    void deleteRoleUser(RoleDTO role);

    void deleteRoleWithHubId(@Param("hubId") Long hubId);


    // 특정 허브에 대한 권한을 가진 유저들에 대한 정보를 get
    ArrayList<RoleDTO> getRolesInfoByHubId(Long hubId);
}
