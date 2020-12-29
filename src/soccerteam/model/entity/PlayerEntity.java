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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity(name = "players")
@Table(name = "players")
public class PlayerEntity {

	@Id
	@Column(name = "p_number")
	private int pNumber;

	@NotNull
	@ManyToOne(targetEntity=TeamEntity.class)
	@JoinColumn(name = "t_name")
	private TeamEntity team;

	@Column(name = "p_name")
	@NotNull
	private String pName;

	@Column(name = "p_age")
	@NotNull
	private int pAge;

	@Column(name = "p_position")
	@NotNull
	private String pPosition;
}
