package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soccerteam.model.entity.ManagersEntity;
import soccerteam.model.entity.TeamEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ManagersDTO {
	
	private int mNumber;
	private String tName;
    private String mName;
	private int mAge;
	private String mPosition;

	
	
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagersDTO [m_number=");
		builder.append(mNumber);
		builder.append(", t_name=");
		builder.append(tName);
		builder.append(", m_name=");
		builder.append(mName);
		builder.append(", m_age=");
		builder.append(mAge);
		builder.append(", m_position=");
		builder.append(mPosition);
		builder.append("]");
		return builder.toString();
	}






	public ManagersEntity toEntity(TeamEntity team) {
		
		return ManagersEntity.builder().mNumber(mNumber).team(team).mName(mName).mAge(mAge).mPosition(mPosition).build();
	}
	
	
	

}
