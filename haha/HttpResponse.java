package me.ele.mercurius.sso.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HttpResponse<E> {
	
	@JsonIgnore
	private int statusCode = 200;
	private int code;
	private String msg;
	private E data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	public HttpResponse() {
		super();
	}

	public HttpResponse(int code, String msg, E data, int statusCode) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.statusCode = statusCode;
	}

	public static <E> HttpResponse<E> success(E data) {
		return new HttpResponse<E>(200, messageMap.get(200), data, 200);
	}
	
	public static <E> HttpResponse<E> create(int code, Integer statusCode) {
		return new HttpResponse<E>(code, messageMap.get(code) == null ? "" : messageMap.get(code), null, statusCode == null ? 200 : statusCode);
	}
	
	public static <E> HttpResponse<E> create(E data, int code, Integer statusCode) {
		return new HttpResponse<E>(code, messageMap.get(code) == null ? "" : messageMap.get(code), data, statusCode == null ? 200 : statusCode);
	}
	
	public static <E> HttpResponse<E> create(int code, String message, Integer statusCode) {
		return new HttpResponse<E>(code, message, null, statusCode == null ? 200 : statusCode);
	}
	
	public static <E> HttpResponse<E> create(int code, E data, String message, Integer statusCode) {
		return new HttpResponse<E>(code, message, data, statusCode == null ? 200 : statusCode);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	@JsonIgnore
	public boolean isSuccess() {
		return this.code == 200;
	}

	public static final Map<Integer, String> messageMap = new HashMap<>();//NOSONAR

	static {
		messageMap.put(200, "Success");
		messageMap.put(201, "Created");

		messageMap.put(251, "Auto create user success");
		messageMap.put(252, "Missing fields in restaurant");
		messageMap.put(253, "User has no restaurant");

		messageMap.put(401, "Unauthorized");
		messageMap.put(403, "Forbidden");
		messageMap.put(404, "Not Found");

		messageMap.put(420, "Missing fields in User-Agent");
		messageMap.put(421, "下线商品不能设置为橱窗商品");
		messageMap.put(422, "橱窗商品不能超过4个");
		messageMap.put(423, "橱窗商品必须要有图片");
		messageMap.put(424, "已经设为橱窗商品");
		messageMap.put(425, "已经取消设置橱窗商品");
		messageMap.put(426, "User has no password");
		messageMap.put(427, "团购锁定状态");
		messageMap.put(433, "Invalid coordinate");
		messageMap.put(434, "No group purchase item");
		messageMap.put(435, "Group purchase item already exists");
		messageMap.put(436, "Invalid invitation code");
		messageMap.put(437, "Timestamp wrong");
		messageMap.put(438, "Group purchase item not found");
		messageMap.put(439, "Query limit out of range");
		messageMap.put(440, "Business area not found");
		messageMap.put(441, "The order is not authorized");
		messageMap.put(442, "User cannot have both supplier and Restaurant");
		messageMap.put(443, "Get OpenID Failed");
		messageMap.put(444, "The user is not authorized for this restaurant");
		messageMap.put(445, "The user is not authorized for this supplier");
		messageMap.put(446, "Order Status Not Allowed");
		messageMap.put(447, "User has no mobile");
		messageMap.put(448, "Restaurant has already been registered with invite code");
		messageMap.put(449, "User is not authorized for this product");
		messageMap.put(450, "App Name Not Found");
		messageMap.put(451, "Invalid Mobile");
		messageMap.put(452, "Cart is not multi cart");
		messageMap.put(453, "Invalid arguments! Need param `mobile` or `register_mobile`");
		messageMap.put(454, "Invalid arguments! Need param `zone_id` or `lat & lng`");
		messageMap.put(455, "Invalid arguments!");
		messageMap.put(470, "Captcha Opt Too Frequently");
		messageMap.put(471, "Captcha Seesion Not Found");
		messageMap.put(472, "Captcha Error");
		messageMap.put(477, "Not Allowed To Recommend");
		messageMap.put(478, "Password Not Found");
		messageMap.put(479, "Carrier Not Found");
		messageMap.put(480, "Invalid Password");
		messageMap.put(481, "User Not Found");
		messageMap.put(482, "Verify Code Wrong or Expired");
		messageMap.put(483, "User Already Existed");
		messageMap.put(484, "Invalid Ticket");
		messageMap.put(485, "Invalid Geo Zone Id");
		messageMap.put(486, "订单未找到");
		messageMap.put(487, "Supplier Not Found");
		messageMap.put(488, "Cart Not Found");
		messageMap.put(489, "Restaurant Not Found");
		messageMap.put(490, "Total Price Less Than Delivery Price Limit");
		messageMap.put(491, "SMS Template Error");
		messageMap.put(492, "App ID Wrong");
		messageMap.put(493, "Wechat Error");
		messageMap.put(494, "Product Not Found");
		messageMap.put(495, "Duplicated Mobile");
		messageMap.put(496, "Cannot apply more than 5 product for one group purchase activity");
		messageMap.put(497, "User cannot have more than one restaurant");
		messageMap.put(498, "No business area in zone");
		messageMap.put(499, "Zone id must be an array of int");

		messageMap.put(4101, "invalid mail address");
		messageMap.put(4102, "暂不支持跨城市下单，请检查购买商品");

		messageMap.put(500, "Server Error");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
