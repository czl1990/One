package com.hm.sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.util.Serialnumber;
import com.hm.sys.dao.BillDao;
import com.hm.sys.dao.GoodsconsumeDao;
import com.hm.sys.dao.RegisterDao;
import com.hm.sys.entity.CollectBill;
import com.hm.sys.entity.goodsconsume;
import com.hm.sys.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService{

	@Autowired
	private BillDao billDao;
	@Autowired
	private GoodsconsumeDao goodsconsumeDao;
	@Autowired
	private RegisterDao registerDao;
	
	@Override
	public CollectBill findObjects(Integer roomNum) {
		//判断参数有效性
		if(roomNum==null)
			throw new IllegalArgumentException("没有指定房间号");
		//新建一个allBill对象用来存储点击收银查看时要显示的信息
		CollectBill collectBill = new CollectBill();
		//往对象中添加收银员工(等设置了权限管理后要修改成登陆用户的名字)
		collectBill.setEmployee("李白");
		//获取住店客户的一些基本信息并存在map中
		List<Map<Object, Object>> findBillObjects = 
				registerDao.findRegisterObjects(roomNum);
		//遍历list集合,并把客户的基本信息存储在allBill对象中
		for (Map<Object, Object> map : findBillObjects) {
			collectBill.setRoomNum(roomNum);  //房号
			collectBill.setGuestName((String)map.get("guestName"));//客户名
			collectBill.setIntime((Date)map.get("intime"));//住店时间
			collectBill.setOuttime((Date)map.get("outtime"));//离店时间
			collectBill.setEarnest((Integer)map.get("earnest"));//定金
			collectBill.setLivemoney((Integer)map.get("livemoney"));//房费总金额
	} 
		//基于房号获取房内总消费记录
		List<goodsconsume> findgoodsconsume =
				goodsconsumeDao.findgoodsconsume(roomNum);
		//迭代获取房内消费的总金额并  暂时存在 needmoney(最终要支付总金额)中,不想重新创建新变量
		int needmoney=0;
		for (goodsconsume goodsconsume : findgoodsconsume) {
			needmoney +=
					 (goodsconsume.getGoodsmoney());
		}
		//先把needmoney暂时存在allBill中
		collectBill.setNeedmoney(needmoney); 
		//用  房间总租金+房内消费-定金 获取实际最终要支付金额
		needmoney=collectBill.getLivemoney()+
				collectBill.getNeedmoney()-collectBill.getEarnest();
		//把实际要支付金额存入allBill中,覆盖原来的
		collectBill.setNeedmoney(needmoney); 
		System.out.println(needmoney); 
		//把房内消费记录详细信息存入allBill中
		collectBill.setGoodsconsume(findgoodsconsume); 
		//使用工具类获取流水号
		String serialnumber = 
				Serialnumber.newSerialnumber(billDao.findSerialnumber());
		//往allBill中存入流水号
		collectBill.setSerialnumber(serialnumber); 
		System.out.println("测试:"+collectBill);
		//返回allBill
		return collectBill;
	}
}
