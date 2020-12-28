package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soccerteam.model.entity.LoginEntity;
import soccerteam.model.entity.TeamEntity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TeamDTO {

	private String tName;
	private String userID;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TeamDTO [t_name=");
		builder.append(tName);
		builder.append(", userid=");
		builder.append(userID);
		builder.append("]");
		return builder.toString();
	}

	public TeamEntity toEntity(LoginEntity logins) {
		
		return TeamEntity.builder().tName(tName).logins(logins).build();
	}
	
}
