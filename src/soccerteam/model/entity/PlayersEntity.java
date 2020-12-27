package soccerteam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class PlayersEntity {

	@Id
	@Column(name = "p_number")
	private int pNumber;

	@Column(name = "t_name")
//	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "probonoId")
	@NotNull
	private String tName;

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