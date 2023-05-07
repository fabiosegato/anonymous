package br.com.spring.anonymous.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CTR_AJ_TASK_GROUP_ITENS")
public class TaskGroupItens {
	
	@Id
	@Column(name = "CONF_ID")
	@NotNull @NotEmpty
	private String confId;
	
	@Column(name = "TASK_GROUP")
	private String taskGroup;
	
	@Column(name = "TASK_ORDER")
	private String taskOrder;
	
	@Column(name = "FLAG_EXEC")
	private String flagExec;
	
	@Column(name = "JOB_UPD_TAB_PRMT")
	private String updateTabParameter;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "CONF_ID")
	private Conf conf;

	public String getConfId() {
		return this.confId;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

	public String getTaskGroup() {
		return this.taskGroup;
	}

	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	public String getTaskOrder() {
		return this.taskOrder;
	}

	public void setTaskOrder(String taskOrder) {
		this.taskOrder = taskOrder;
	}

	public String getFlagExec() {
		return this.flagExec;
	}

	public void setFlagExec(String flagExec) {
		this.flagExec = flagExec;
	}

	public String getUpdateTabParameter() {
		return this.updateTabParameter;
	}

	public void setUpdateTabParameter(String updateTabParameter) {
		this.updateTabParameter = updateTabParameter;
	}

	public Conf getConf() {
		return this.conf;
	}

	public void setConf(Conf conf) {
		this.conf = conf;
	}
	
	

}
