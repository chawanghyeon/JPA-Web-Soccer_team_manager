package soccerteam.model.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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

public class PlayersDTO {

	private int pNumber;

	private String tName;

	private String pName;

	private int pAge;

	private String pPosition;
}
