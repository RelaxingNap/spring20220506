package org.zerock.mapper.ex01;

import org.apache.ibatis.annotations.Select;

public interface Ex01Mapper {
	
	@Select("SELECT 100")
	public int selectNumber();
	// class만드는거 부터 bean으로 만들어주는거까지 mybatis가 다 해줌
	
}
