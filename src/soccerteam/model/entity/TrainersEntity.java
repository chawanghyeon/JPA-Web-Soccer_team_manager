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

@Entity(name = "trainers")
@Table(name = "trainers")
public class TrainersEntity {

	@Id
	@Column(name = "tr_number")
	private int trNumber;

	@Column(name = "t_name")
	@ManyToOne(targetEntity = TeamEntity.class)
	@JoinColumn(name = "t_name")
	@NotNull
	private TeamEntity tName;

	@Column(name = "tr_name")
	@NotNull
	private String trName;

	@Column(name = "tr_age")
	@NotNull
	private int trAge;

	@Column(name = "tr_position")
	@NotNull
	private String trPosition;
}
