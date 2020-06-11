package com.hm.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hm.common.exception.ServiceException;
import com.hm.sys.dao.BillDao;
import com.hm.sys.dao.GoodsconsumeDao;
import com.hm.sys.dao.RegisterDao;
import com.hm.sys.dao.RoomStateDao;
import com.hm.sys.entity.CollectBill;
import com.hm.sys.entity.Bill;
import com.hm.sys.service.BillService;

@Transactional(rollbackFor=Throwable.class,    //出现任何异常都回滚
timeout=30,      //设置超时时间,超时则回滚
isolation=Isolation.READ_COMMITTED,  //设置隔离级别
propagation=Propagation.REQUIRED)  //设置传播特性
@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillDao billDao;
	@Autowired
	private RoomStateDao roomstateDao;
	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private GoodsconsumeDao goodsconsumeDao;
	@Override
	public int saveObject(CollectBill collectBill) {
		//判断参数有效性
		if(collectBill==null)
			throw new IllegalArgumentException("没有消费信息");
		Integer roomNum = collectBill.getRoomNum();
		Bill bill = new Bill();
		bill.setSerialnumber(collectBill.getSerialnumber());
		bill.setRoomNum(roomNum);
		bill.setGuestName(collectBill.getGuestName());
		bill.setNeedmoney(collectBill.getNeedmoney());
		bill.setEmployee(collectBill.getEmployee());
		bill.setCheckin(collectBill.getIntime());
		bill.setCheckout(collectBill.getOuttime());
		System.out.println(bill);
		int row=0;
		try {
			row = billDao.insertObject(bill);
			roomstateDao.updateRoomState(roomNum);
			registerDao.updateRoomState(roomNum);
			goodsconsumeDao.updateConsumerState(roomNum);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("结账失败,请重新操作");
		}
		return row;
	}
}
