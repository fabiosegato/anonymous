package br.com.spring.anonymous.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import br.com.spring.anonymous.entity.id.CtrSettingsId;

@Entity
@IdClass(CtrSettingsId.class)
@Table(name = "CTR_SETTINGS")
public class CtrSettings {
	
	@Id
	@Column(name="PROCESS")
	private String process; 
	
	@Column(name="GROUP")
	private String group; 
	
	@Id
	@Column(name="KEY")
	private String key;
	
	@Column(name="VALUE")
	private String value;	
	
	@Id
	@Column(name="GROUP_VALUE")
	private String groupValue;
	
	@Column(name="ORDER_ID")
	private Integer orderId; 

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getGroupValue() {
		return groupValue;
	}

	public void setGroupValue(String groupValue) {
		this.groupValue = groupValue;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}




	
	
}
