package com.siwei.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.json.ToJson;

@ToJson
@Table("s_user_order")
public class Order {
	
	@Column("ID")
	private int rid;
	
	private String name;
	
	@Column("O_TYPE")
	private String type;
	
	public final int getRid() {
		return rid;
	}
	public final void setRid(int rid) {
		this.rid = rid;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getType() {
		return type;
	}
	public final void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Order [rid=" + rid + ", name=" + name + ", type=" + type + "]";
	}
}
