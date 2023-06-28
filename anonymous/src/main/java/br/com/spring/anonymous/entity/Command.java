package br.com.spring.anonymous.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name = "CTR_AJ_COMMANDS")
public class Command {
	
	
	
	public Command(String id, String cmdGroup, Integer cmdOrder, String dsc, String command, String ajType,
			String atb01, String atb02, String atb03, String atb04, String atb05, String status) {
		this.id = id;
		this.cmdGroup = cmdGroup;
		this.cmdOrder = cmdOrder;
		this.dsc = dsc;
		this.command = command;
		this.ajType = ajType;
		this.atb01 = atb01;
		this.atb02 = atb02;
		this.atb03 = atb03;
		this.atb04 = atb04;
		this.atb05 = atb05;
		this.status = status;
	}

	public Command () {};
	
	
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="CMD_GROUP")
	private String cmdGroup;
	
	@Column(name = "CMD_ORDER")
	private Integer cmdOrder;
	
	@Column(name = "DSC")
	private String dsc;
	
	@Column(name = "COMMAND")
	@Lob
	private String command;
	
	@Column(name = "AJ_TYPE")
	private String ajType;
	
	@Column(name = "ATB_01")
	private String atb01;
	
	@Column(name = "ATB_02")
	private String atb02;
	
	@Column(name = "ATB_03")
	private String atb03;
	
	@Column(name = "ATB_04")
	private String atb04;
	
	@Column(name = "ATB_05")
	private String atb05;
	
	@Column(name = "STATUS")
	private String status = "A";
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCmdGroup() {
		return cmdGroup;
	}

	public void setCmdGroup(String cmdGroup) {
		this.cmdGroup = cmdGroup;
	}

	public Integer getCmdOrder() {
		return cmdOrder;
	}

	public void setCmdOrder(Integer cmdOrder) {
		this.cmdOrder = cmdOrder;
	}

	public String getDsc() {
		return this.dsc;
	}

	public void setDesc(String dsc) {
		this.dsc = dsc;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getAjType() {
		return ajType;
	}

	public void setAjType(String ajType) {
		this.ajType = ajType;
	}

	public String getAtb01() {
		return atb01;
	}

	public void setAtb01(String atb01) {
		this.atb01 = atb01;
	}

	public String getAtb02() {
		return atb02;
	}

	public void setAtb02(String atb02) {
		this.atb02 = atb02;
	}

	public String getAtb03() {
		return atb03;
	}

	public void setAtb03(String atb03) {
		this.atb03 = atb03;
	}

	public String getAtb04() {
		return atb04;
	}

	public void setAtb04(String atb04) {
		this.atb04 = atb04;
	}

	public String getAtb05() {
		return atb05;
	}

	public void setAtb05(String atb05) {
		this.atb05 = atb05;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

		
}
