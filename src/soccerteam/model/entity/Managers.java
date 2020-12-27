package soccerteam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Managers {
	
	
	@Id
	@Column
	private int m_number;
	
	@Column
	private String t_name;
	
	@Column
	private String userid;
	
	@Column
	private String m_name;
	
	@Column
	private String m_age;
	
	@Column
	private String m_position;

	
	
	
	

	

}
