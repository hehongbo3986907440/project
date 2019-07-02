package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IMybaitsService;
import com.example.demo.vo.ImageDO;
import com.example.demo.vo.Users;

@RestController
@RequestMapping("/mybatis")
public class MybaitsController {
	@Autowired
	private IMybaitsService mybatisService;
	@RequestMapping("/users")
	public List<Users> users(){
		return mybatisService.getUsers();
	}
	
	@RequestMapping("/imageData")
	public List<ImageDO> imageData(){

		List<ImageDO> imageDatas = new ArrayList<ImageDO>();
		ImageDO image = new ImageDO();
		image.setId(0);
		image.setTitle("mdkadmad");
		image.setUrl("http://pic1.16pic.com/00/16/46/16pic_1646508_b.jpg");
		image.setDesrc("就打击打击的就ok佛开，口服抗。，可大颗大颗大大的数据库大大肯德基啊");
		imageDatas.add(image);
		
		ImageDO image1 = new ImageDO();
		image1.setId(1);
		image1.setTitle("mdkadmad");
		image1.setUrl("http://img.zcool.cn/community/01b078574706206ac72525ae0beaed.jpg@2o.jpg");
		image1.setDesrc("就打击打击的就ok佛开，口服抗。，可大颗大颗大大的数据库大大肯德基啊");
		imageDatas.add(image1);
		
		ImageDO image2 = new ImageDO();
		image2.setId(2);
		image2.setTitle("mdkadmad");
		image2.setUrl("http://pic38.nipic.com/20140212/17942401_101320663138_2.jpg");
		image2.setDesrc("就打击打击的就ok佛开，口服抗。，可大颗大颗大大的数据库大大肯德基啊");
		imageDatas.add(image2);
		
		ImageDO image3 = new ImageDO();
		image3.setId(3);
		image3.setTitle("mdkadmad");
		image3.setUrl("http://img2.3lian.com/2014/f4/140/d/72.jpg");
		image3.setDesrc("就打击打击的就ok佛开，口服抗。，可大颗大颗大大的数据库大大肯德基啊");
		imageDatas.add(image3);
		
		ImageDO image6 = new ImageDO();
		image6.setId(6);
		image6.setTitle("mdkadmad");
		image6.setUrl("http://img2.imgtn.bdimg.com/it/u=3230999856,2515271928&fm=26&gp=0.jpg");
		image6.setDesrc("就打击打击的就ok佛开，口服抗。，可大颗大颗大大的数据库大大肯德基啊");
		imageDatas.add(image6);
		
		
		ImageDO image4 = new ImageDO();
		image4.setId(4);
		image4.setTitle("mdkadmad");
		image4.setUrl("http://pic2.16pic.com/00/17/06/16pic_1706842_b.jpg");
		image4.setDesrc("就打击打击的就ok佛开，口服抗。，可大颗大颗大大的数据库大大肯德基啊");
		imageDatas.add(image4);
		
		
		ImageDO image5 = new ImageDO();
		image5.setId(3);
		image5.setTitle("mdkadmad");
		image5.setUrl("http://img1.cache.hxsd.com/hxsdmy/gallery/2013/01/87/81/91/03/08/134035862/12737_4_026a.jpg");
		image5.setDesrc("就打击打击的就ok佛开，口服抗。，可大颗大颗大大的数据库大大肯德基啊");
		imageDatas.add(image5);
		
		return imageDatas;
	}
}
