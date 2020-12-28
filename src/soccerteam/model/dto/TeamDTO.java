package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soccerteam.model.entity.LoginsEntity;
import soccerteam.model.entity.TeamEntity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TeamDTO {

	private String tName;
	private String userId;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TeamDTO [t_name=");
		builder.append(tName);
		builder.append(", userid=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}

	public TeamEntity toEntity(LoginsEntity logins) {
		
		return TeamEntity.builder().tName(tName).logins(logins).build();
	}
	
}
