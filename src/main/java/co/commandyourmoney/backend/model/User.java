package co.commandyourmoney.backend.model;

import java.time.YearMonth;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class User {
	
	@Id
	@Setter(AccessLevel.NONE)
	private String id;
	
	private String email;
	
	private YearMonth currentMonth;
}
