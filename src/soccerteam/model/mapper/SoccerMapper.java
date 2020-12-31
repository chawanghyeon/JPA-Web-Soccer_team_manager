package soccerteam.model.mapper;
 
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import soccerteam.model.dto.LoginDTO;
import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.dto.TeamDTO;
import soccerteam.model.entity.LoginEntity;
import soccerteam.model.entity.ManagerEntity;
import soccerteam.model.entity.MedicalStaffEntity;
import soccerteam.model.entity.PlayerEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.entity.TrainerEntity;
 
@Mapper // 1
public interface SoccerMapper {
    SoccerMapper INSTANCE = Mappers.getMapper(SoccerMapper.class);
 
    //login
    LoginEntity toLoginEntity(LoginDTO loginDTO);
    
    @Mapping(target = "list", ignore = true)
    LoginDTO toLoginDTO(LoginEntity loginEntity);
    
    //team
    TeamEntity toTeamEntity(TeamDTO teamDTO);
    
    @Mapping(expression="java(login.getUserID)", target="userID")
    TeamDTO toTeamDTO(TeamEntity teamEntity);
    
    //manager
    ManagerEntity toLoginEntity(PeopleDTO managerDTO);
    
    @Mapping(expression="java(team.getTName)", target="tName")
    PeopleDTO toPeopleDTO(ManagerEntity managerEntity);
    
    //medical
    MedicalStaffEntity toMedicalStaffEntity(PeopleDTO medicalStaffDTO);
    
    @Mapping(expression="java(team.getTName)", target="tName")
    PeopleDTO toMedicalStaffDTO(MedicalStaffEntity medicalStaffEntity);
    
    //player
    PlayerEntity toPlayerEntity(PeopleDTO playerDTO);
    
    @Mapping(expression="java(team.getTName)", target="tName")
    PeopleDTO toPlayerDTO(PlayerEntity playerEntity);
    
    //trainer
    TrainerEntity toTrainerEntity(PeopleDTO TrainerDTO);
    
    @Mapping(expression="java(team.getTName)", target="tName")
    PeopleDTO toTrainerDTO(TrainerEntity trainerEntity);
}