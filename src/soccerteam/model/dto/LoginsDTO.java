package soccerteam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginsDTO {
	
	
	private String userid;
	private String userpw;

	
	
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginsDTO [userid=");
		builder.append(userid);
		builder.append(", userpw=");
		builder.append(userpw);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}