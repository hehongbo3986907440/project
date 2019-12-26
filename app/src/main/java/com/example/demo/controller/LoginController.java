package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.util.RSAUtils;
import com.example.demo.vo.ResultBean;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

	private Map<String,RSAPrivateKey> dataBase = new HashMap<>();//模拟数据库，存储私钥
	
	@RequestMapping("/index")
	public String showUser(Model model) {
		// 跳转视图
		return "login";
	}
	/**
	 *
	 * @Title: generateRSAKey
	 * @Description: 生成公钥和私钥
	 * @param username
	 * @return
	 * @date 2018年2月5日 下午4:25:05
	 * @author p7
	 */
	@RequestMapping(value = "/{username}")
	@ResponseBody
	public ResultBean generateRSAKey(@PathVariable String username) throws Exception{

		try {
			// 获取公钥和私钥
			HashMap<String, Object> keys = RSAUtils.getKeys();
			RSAPublicKey publicKey = (RSAPublicKey) keys.get("public");
			RSAPrivateKey privateKey = (RSAPrivateKey) keys.get("private");
			// 保存私钥到 redis，也可以保存到数据库
//			boolean res = redisService.set(username, privateKey);
			dataBase.put(username,privateKey);
			boolean res = true;
			if (!res) {
				throw new Exception("redis 保存失败");
			}
			// 将公钥传到前端
			Map<String,String> map = new HashMap<String,String>();
			// 注意返回modulus和exponent以16为基数的BigInteger的字符串表示形式
			map.put("modulus", publicKey.getModulus().toString(16));
			map.put("exponent", publicKey.getPublicExponent().toString(16));

			return new ResultBean(map);
		} catch (NoSuchAlgorithmException e) {
			return new ResultBean(0, e.getMessage());
		} catch (Exception e) {
			return new ResultBean(0, e.getMessage());
		}
	}

	/**
	 *
	 * @Title: checkRSAKey
	 * @Description: 验证密码
	 * @param username
	 * @param password
	 * @return
	 * @date 2018年2月5日 下午4:25:43
	 * @author p7
	 */
	@GetMapping(value = "/{username}/{password}")
	@ResponseBody
	public ResultBean checkRSAKey(@PathVariable String username, @PathVariable String password) {
//		Object object = redisService.get(username);
		Object object = dataBase.get(username);
		try {
			// 解密
			String decryptByPrivateKey = RSAUtils.decryptByPrivateKey(password, (RSAPrivateKey) object);
			return new ResultBean(decryptByPrivateKey);
		} catch (Exception e) {
			return new ResultBean(0, "解密失败");
		}
	}
}
