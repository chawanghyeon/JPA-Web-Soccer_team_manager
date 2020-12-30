package soccerteam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity(name = "managers")
@Table(name = "managers")
public class ManagerEntity {

	@Id
	@Column(name = "m_number")
	private int number;

	@NotNull
	@ManyToOne(targetEntity=TeamEntity.class)
	@JoinColumn(name = "t_name")
	private TeamEntity team;

	@Column(name = "m_name")
	@NotNull
	private String name;

	@Column(name = "m_age")
	@NotNull
	private int age;

	@Column(name = "m_position")
	@NotNull
	private String position;

}
