package ex01.sam02.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCalc {
	private int num1;
	private int num2;
	private int add_result;
	
	public int result() {	
		return num1+num2;
	}

}
