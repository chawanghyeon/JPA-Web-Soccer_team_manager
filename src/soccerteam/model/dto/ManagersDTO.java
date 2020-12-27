package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ManagersDTO {
	
	private int m_number;
	private String t_name;
	private String userid;
	private String m_name;
	private String m_age;
	private String m_position;

	
	
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagersDTO [m_number=");
		builder.append(m_number);
		builder.append(", t_name=");
		builder.append(t_name);
		builder.append(", userid=");
		builder.append(userid);
		builder.append(", m_name=");
		builder.append(m_name);
		builder.append(", m_age=");
		builder.append(m_age);
		builder.append(", m_position=");
		builder.append(m_position);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
