package com.Pets.Search.mapper;
import java.util.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.Pets.Search.dto.PersonInfo;

@Repository
@Mapper
public interface Person {
	
	/*---완벽한 문자로 조회---*/
	public List<PersonInfo> cp_word(Map<String, Object> info);
	
	/*--조회 문자에 'ㄱ'이 포함된 경우--*/
	public List<PersonInfo> cp_word_eng_second(Map<String, Object> info);
	
	/*--완벽한 문자 + 초성('ㄱ' 포함 된 경우)--*/
	public List<PersonInfo> cpword_cho_second(Map<String, Object> info);
	
	/*--완벽한 문자 + 초성('ㄱ' 포함 안된 경우)--*/
	public List<PersonInfo> cpword_cho(Map<String, Object> info);
	
	/*--초성으로만 검색(second_eng 없음)--*/
	public List<PersonInfo> onlychosung(Map<String, Object> info);
	
	/*--초성으로만 검색(second_eng 있음)--*/
	public List<PersonInfo> onlychosung_second(Map<String, Object> info);
	
	/*--모음으로만 검색--*/
	public List<PersonInfo> onlyjung(Map<String, Object> info);
	
	/*--단어+중성으로만 검색--*/
	public List<PersonInfo> cpwordtojung(Map<String, Object> info);
	
	/*--전체 이니셜로 검색--*/
	public List<PersonInfo> SearchInitial(Map<String, Object> info);
	
	/*--맞 팔로워 이니셜로 검색--*/
	public List<PersonInfo> MatList_initial(Map<String, Object> info);
	
	/*--맞 팔로워 초성 검색--*/
	public List<PersonInfo> MatList_chosung(Map<String, Object> info);



}
