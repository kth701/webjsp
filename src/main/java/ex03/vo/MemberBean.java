package ex03.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberBean {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
}
