package com.kh.myprj.web.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data		//getter,setter,toString,equals,hashcode메소드 생성
@AllArgsConstructor //모든 멤버를 매개변수로 가지는 생성자 생성. 이게 생성됨으로써 디폴트생성자는 안생기겠지?
@NoArgsConstructor  //그렇다면 이렇게 매개변수를 가지지 않는(디폴트생성자;기본생성자)도 만들어주면 되지~
public class JsonResult<T> {

	private String rtcd;
	private String rtmsg;
	private T data;
}
