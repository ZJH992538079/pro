<?
基于SpringCloud的宠物信息服务平台

	用户模块( 难度系数:★★★★ 完成状态:半完成状态,可供其他模块使用){
		1.登录:可以通过登录名/手机号/邮箱号/关联的其他登录帐号(如QQ)
		2.注册:可以通过手机号或邮箱号等注册,如果帐号已经存在则需要提示登录老帐号或找回密码,也可以使用当前帐号继续朱旭
		3.首次使用地三方帐号登录时需要提示用户绑定老用户或者手机邮箱等
	}

	商品模块( 难度系数:★★★★★★){
		需求:
			1.商家可以选择相关分类并发布商品
				#系统提前预设尽可能齐全的分类,但要提供增加分类的入口
				#如果商家添加相关分类后需要通过审核,审核通过的分类可以供其他商家使用
			2.已经发布的商品提供上下架功能
			3.统计商品的展现次数和点击次数
	}
		
	文件空间模块( 难度系数:★★★★){
		需求:
			1.所有文件(大部分是图片)均使用腾讯云对象存储(可以是其他)来保存静态资源
			2.需要统计图片的引用情况(站内引用)
			3.可以使用网页来进行图片的上传,并查看该用户的所以文件
			4.用户删除文件时需要检查站内图片的引用数量,如果引用数量不为0时提示用户是否进行强制删除(删除后,如果其他地方还引用该图片或文件就会出现404错误)
			5.用户上传文件时:
				1).判断该文件在服务器是否已经存在,如果已经存在则不重复上传
				2).链接为用户id
	}
	
	商品搜索
		#需要进行关键字拆分....
		#将搜索后的商品进行相关排序
		
		
	评论模块
		评价表(evaluation)
			评价id(evaluation_id) 商品id(goods_id) 用户id(user_id) 评价内容(evaluation_content) 评分(1-5)(evaluation_grade)
		商家回复表(shop_reply)
			回复id(shop_reply_id) 店铺ID(store_id) 评价id() 评价内容(shop_reply_content)
	
	
	订单模块( 难度系数:★★)
		需求:
			1.购物车功能
			2.生成订单
		
		购物车表(shopping_cart)
			id(shopping_cart_id) 用户id(user_id) 商品Id(goods_id) 商品数量(goods_number) 时间(shopping_cart_time)
			
		订单表(order)
			订单号(order_number) 用户ID(user_id) 收货地址id(Shipping_address_id) 商品项[{商品Id(goods_id),商品数量(goods_number),单价(goods_unit_price),快照(snapshot)}]  订单状态(order_state) 物流(logistics) 备注(note) 时间(order_time)
	
	
	支付模块(模拟)
		#提供相关接口(支付,收货,退款等),操作结果返回给调用方,调用方无需关系具体实现流程
		#用户付款时,先将用户支付成功的钱计入平台总帐户(用户帐号-X元 平台账户+X元),此时生成用户的订单号
		#用户确认收货时,将平台总帐户的X元转入商家帐号,此时生成商家的订单号
		总金额(total_amount)
		用户id(user_id) 余额(rest_amount)
		流水号(serial_number) 订单号(order_number) 总额() 备注(note) 用户ID(user_id) 时间(date) 类型(clazz)
	
	商户后台管理模块( 难度系数:★★★)
		#店铺信息修改
		#商品管理
		#订单管理
	
	平台后台管理模块( 难度系数:★★★★)(暂时不做)

				
				
	客户模块( 难度系数:★★★★)(暂时不做){
		需求:
			1.实时通讯
			2.发送消息是需要向商家展示客服正在咨询的商品
	}
	
	#所有数据能通过ajax请求就尽量不要直接写进页面中
	首页( 难度系数:★★★)
	商品详情页
		#功能如下
		大图轮播展示
		标题
		价格(原价和折扣价)
		评论
		详情
		
	购物车页
		#功能如下
		可增加相关商品的数量
		可删除商品
		可同时购买部分商品
		
	订单列表页
		订单详情
		
	商户后台
		订单列表页,将订单进行分类(可接受订单,发货......)
		商品列表(可对商品进行编辑/上下架等)
		发布新商品(大图:1—5张, 标题:最多20个字, 商品属性: 多种商品属性, 详细描述)
	

	权重模块(暂时不做)
		#影响权重的因素: 评分(评论模块),销量,统计点击率,售后服务.....


		
数据库信息:
	host: sql.laeni.cn
	user: pro
	password: pro