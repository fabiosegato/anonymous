package br.com.spring.anonymous.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CTR_AJ_TASK_GROUP")
public class TaskGroup {

	@Id
	@Column(name = "TASK_GROUP")
	@NotNull @NotEmpty
	private String taskName;

	@Column(name = "DSC")
	private String desc;

	@Column(name = "STATUS", nullable = false)
	private String status = "A";

	@Column(name = "AJ_START")
	@Temporal(TemporalType.DATE)
	private Date dateStart;

	@Column(name = "AJ_END")
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "TASK_GROUP")
    private List<TaskGroupItens> groupItens;

	public TaskGroup() throws ParseException {
		this.dateStart = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010");
		this.dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2025");
		this.status = "A";
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String Desc) {
		this.desc = Desc;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String TaskName) {
		this.taskName = TaskName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String Status) {
		this.status = Status;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date DateStart) {
		this.dateStart = DateStart;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date DateEnd) {
		this.dateEnd = DateEnd;
	}

	public List<TaskGroupItens> getGroupItens() {
		return groupItens;
	}

	public void setGroupItens(List<TaskGroupItens> groupItens) {
		this.groupItens = groupItens;
	}

}
