package Pojo_classes_automation_framework;

import com.poiji.annotation.ExcelCellName;

public record logincred(
		@ExcelCellName("Username")
		String username, 
		
		@ExcelCellName("Password")
		String password) {

}