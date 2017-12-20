package com.atguigu.crud.dao;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crud.bean.Goods;

public interface GoodsMapper {
	
	/**
	 * updateGoodsUseCAS:使用CAS(Compare and set)更新商品信息

	 * @param goods 商品对象
	 * @return 影响的行数
	 */
	int updateGoodsUseCAS(Goods goods);
	
	Goods getGoodsById(@Param("id")Integer id) ;
}
