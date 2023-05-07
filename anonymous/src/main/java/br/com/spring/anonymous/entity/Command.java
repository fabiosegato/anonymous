package br.com.spring.anonymous.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name = "CTR_AJ_COMMANDS")
public class Command {

	@Id
	@Column(name="ID")
	private String confId;
	
	@Column(name="CMD_GROUP")
	private String GroupName;
	
	@Column(name = "CMD_ORDER")
	private int order;
	
	@Column(name = "DSC")
	private String desc;
	
	@Column(name = "COMMAND")
	@Lob
	private String command;
	
	@Column(name = "AJ_TYPE")
	private String type;
	
	@Column(name = "ATB_01")
	private String Attirbute1;
	
	@Column(name = "ATB_02")
	private String Attirbute2;
	
	@Column(name = "ATB_03")
	private String Attirbute3;
	
	@Column(name = "ATB_04")
	private String Attirbute4;
	
	@Column(name = "ATB_05")
	private String Attirbute5;
	
	@Column(name = "STATUS")
	private String status = "A";

	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getConfId() {
		return confId;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

	public String getGroupName() {
		return GroupName;
	}

	public void setGroupName(String groupName) {
		GroupName = groupName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getDescription() {
		return desc;
	}

	public void setDescription(String description) {
		desc = description;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttirbute1() {
		return Attirbute1;
	}

	public void setAttirbute1(String attirbute1) {
		Attirbute1 = attirbute1;
	}

	public String getAttirbute2() {
		return Attirbute2;
	}

	public void setAttirbute2(String attirbute2) {
		Attirbute2 = attirbute2;
	}

	public String getAttirbute3() {
		return Attirbute3;
	}

	public void setAttirbute3(String attirbute3) {
		Attirbute3 = attirbute3;
	}

	public String getAttirbute4() {
		return Attirbute4;
	}

	public void setAttirbute4(String attirbute4) {
		Attirbute4 = attirbute4;
	}

	public String getAttirbute5() {
		return Attirbute5;
	}

	public void setAttirbute5(String attirbute5) {
		Attirbute5 = attirbute5;
	}
	
}
