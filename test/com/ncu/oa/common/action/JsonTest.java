package com.ncu.oa.common.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ncu.oa.common.entity.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class JsonTest {
	//测试json数组
	@Test
	public void jsonParse() {
		String arr = new String("[{\"0\":true,\"dpId\":2,\"dpName\":\"平台研发部\",\"users\":[]},{\"0\":true,\"dpId\":3,\"dpName\":\"产品设计部\",\"users\":[]}]");
		JSONArray myarr = (JSONArray) JSONArray.parse(arr);
		for (int i = 0; i < myarr.size(); i++) {
			JSONObject object = (JSONObject) myarr.get(i);
			System.out.println(object);
			System.out.println(object.getInteger("dpId"));
		}
//		JSONObject jsonObject = JSON.parseObject(arr);
//		Integer integer = jsonObject.getInteger("dpId");
//		System.out.println(integer);
	}
	
	
}	
