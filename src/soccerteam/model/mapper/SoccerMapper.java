package soccerteam.model.mapper;
 
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import soccerteam.model.dto.LoginDTO;
import soccerteam.model.dto.ManagerDTO;
import soccerteam.model.dto.MedicalStaffDTO;
import soccerteam.model.dto.PlayerDTO;
import soccerteam.model.dto.TeamDTO;
import soccerteam.model.dto.TrainerDTO;
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
    ManagerEntity toLoginEntity(ManagerDTO managerDTO);
    
    @Mapping(expression="java(team.getTName)", target="tName")
    ManagerDTO toLoginDTO(ManagerEntity managerEntity);
    
    //medical
    MedicalStaffEntity toMedicalStaffEntity(MedicalStaffDTO medicalStaffDTO);
    
    @Mapping(expression="java(team.getTName)", target="tName")
    MedicalStaffDTO toMedicalStaffDTO(MedicalStaffEntity medicalStaffEntity);
    
    //player
    PlayerEntity toPlayerEntity(PlayerDTO playerDTO);
    
    @Mapping(expression="java(team.getTName)", target="tName")
    PlayerDTO toPlayerDTO(PlayerEntity playerEntity);
    
    //trainer
    TrainerEntity toTrainerEntity(TrainerDTO TrainerDTO);
    
    @Mapping(expression="java(team.getTName)", target="tName")
    TrainerDTO toTrainerDTO(TrainerEntity trainerEntity);
}