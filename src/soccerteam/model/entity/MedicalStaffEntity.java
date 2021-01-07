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

@Entity(name = "medical_staff")
@Table(name = "medical_staff")
public class MedicalStaffEntity {
	@Id
	@Column(name = "d_number")
	private int number;

	@NotNull
	@ManyToOne(targetEntity = TeamEntity.class)
	@JoinColumn(name = "t_name")
	private TeamEntity team;

	@Column(name = "d_name")
	@NotNull
	private String name;

	@Column(name = "d_age")
	@NotNull
	private int age;

	@Column(name = "d_position")
	@NotNull
	private String position;
}
